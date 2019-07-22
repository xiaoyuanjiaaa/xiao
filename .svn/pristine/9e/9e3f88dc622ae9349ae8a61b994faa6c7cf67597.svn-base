<#assign className = table.className>   
<#assign classNameFirstLower = className?uncap_first>   
<#assign classNameLowerCase = className?lower_case>   
<#assign pkJavaType = table.idColumn.javaType>   
package ${basepackage}.dao;

import org.apache.ibatis.annotations.Mapper;

import com.fc.common.plugin.mybatis.IMapper;

import ${basepackage}.entity.${className};
/**
 * <p>Title: ${className}</p>
 * <p>Description: <#if table.remarks?exists && table.remarks != '' && table.remarks != 'null'>${table.remarks}</#if> DAO层</p>
 * @author ${author}
 * @date <#if now??>${now?string('yyyy-MM-dd HH:mm:ss')}</#if>
 */
@Mapper
public interface I${className}Dao extends IMapper<${className}>{
	/**插入数据*/
	int insertSelective(${className} obj);
}