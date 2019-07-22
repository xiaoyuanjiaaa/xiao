package com.fc.protocol.server.demo.persistance.mybatis.plugin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.bind.PropertyException;

import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.executor.ExecutorException;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.springframework.util.StringUtils;

import com.fc.protocol.server.demo.persistance.mybatis.Page;
import com.fc.protocol.server.demo.persistance.mybatis.PageQuery;
import com.fc.protocol.server.demo.util.ReflectHelper;
import com.fc.protocol.server.demo.util.StringHelper;




/**
 * <p>Title: IMapper</p>
 * <p>Description: </p>
 * <p>Company: </p> 
 * @author wanghw
 * @date 2016年3月21日
 */
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class,Integer.class}) })
public class PagePlugin implements Interceptor {

	private static String dialect = ""; // 数据库方言
	private static String pageSqlId = ""; // mapper.xml中需要拦截的ID(正则匹配)，分页

	public Object intercept(Invocation ivk) throws Throwable {
		if (ivk.getTarget() instanceof StatementHandler) {
			StatementHandler statementHandler = (StatementHandler) ivk.getTarget();
			MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
			// 分离代理对象链(由于目标类可能被多个拦截器拦截，从而形成多次代理，通过下面的两次循环  可以分离出最原始的的目标类)  
			while (metaStatementHandler.hasGetter("h")) {
				Object object = metaStatementHandler.getValue("h");
				metaStatementHandler = SystemMetaObject.forObject(object);
			}
			// 分离最后一个代理对象的目标类  
			while (metaStatementHandler.hasGetter("target")) {
				Object object = metaStatementHandler.getValue("target");
				metaStatementHandler = SystemMetaObject.forObject(object);
			}
			MappedStatement mappedStatement = (MappedStatement) metaStatementHandler
					.getValue("delegate.mappedStatement");

			// 拦截需要分页的SQL
			if (mappedStatement.getId().matches(pageSqlId)) {
				BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
				;
				// 分页SQL<select>中parameterType属性对应的实体参数，即Mapper接口中执行分页方法的参数,该参数不得为空
				Object parameterObject = boundSql.getParameterObject();
				if (parameterObject == null) {
					throw new NullPointerException("parameterObject尚未实例化！");
				} else {
					Page page = ((PageQuery) parameterObject).getPage();
					if (page == null) {
						page = new Page();
					}
					String sql = boundSql.getSql();
					if (page.isShowTotal()) {
						Connection connection = (Connection) ivk.getArgs()[0];
						// 记录统计
						int index = sql.toLowerCase().indexOf(" from ");
						//String countSql = "select count(0) " + sql.substring(index);
						String countSql = "select count(0) from (" + sql + ") tmp_count";
						PreparedStatement countStmt = connection.prepareStatement(countSql);

						DefaultParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement,
								parameterObject, boundSql);
						parameterHandler.setParameters(countStmt);

						ResultSet rs = countStmt.executeQuery();
						int count = 0;
						if (rs.next()) {
							count = rs.getInt(1);
						}
						rs.close();
						countStmt.close();

						// 参数就是Page实体
						if (parameterObject instanceof PageQuery) {
							page.setTotalResult(count);
						} else if (parameterObject instanceof Map) {
							Map<String, Object> map = (Map<String, Object>) parameterObject;
							page = (Page) map.get("page");
							page.setTotalResult(count);
						} else {
							ReflectHelper.setProperty(parameterObject, "page", page);
						}
					}
					String pageSql = generatePageSql(sql, page);
					// 将分页sql语句反射回BoundSql
					ReflectHelper.setProperty(boundSql, "sql", pageSql);
				}
			}
		}
		return ivk.proceed();
	}

	/**
	 * 根据数据库方言，生成特定的分页sql
	 * 
	 * ＠param sql
	 * ＠param page
	 * ＠return
	 */
	private String generatePageSql(String sql, Page page) {
		if (page != null && (dialect != null || !dialect.equals(""))) {
			if (!StringUtils.isEmpty(page.getSidx())) {
				String[] names = page.getSidx().split(",");
				String[] sorts = page.getSord().split(",");
				for (int i = 0; i < names.length; i++) {
					if (i == 0) {
						sql += " order by " + StringHelper.camelToUnderline(names[i]) + " " + sorts[i];
					} else {
						sql += "," + names[i] + " " + sorts[i];
					}
				}
			}
			StringBuffer pageSql = new StringBuffer();
			if ("mysql".equals(dialect)) {
				pageSql.append(sql);
				pageSql.append(" limit " + page.getCurrentResult() + "," + page.getRows());
			}
			return pageSql.toString();
		} else {
			return sql;
		}
	}

	@Override
	public Object plugin(Object arg0) {
		return Plugin.wrap(arg0, this);
	}

	@Override
	public void setProperties(Properties p) {
		dialect = p.getProperty("dialect");
		if (dialect == null || dialect.equals("")) {
			try {
				throw new PropertyException("dialect property is not found!");
			} catch (PropertyException e) {
				e.printStackTrace();
			}
		}
		pageSqlId = p.getProperty("pageSqlId");
		if (dialect == null || dialect.equals("")) {
			try {
				throw new PropertyException("pageSqlId property is not found!");
			} catch (PropertyException e) {
				e.printStackTrace();
			}
		}
	}

}
