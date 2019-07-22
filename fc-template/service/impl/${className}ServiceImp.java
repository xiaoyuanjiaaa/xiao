<#assign className = table.className>   
<#assign classNameFirstLower = className?uncap_first>   
<#assign classNameLowerCase = className?lower_case>   
<#assign pkJavaType = table.idColumn.javaType> 
package ${basepackage}.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fc.common.plugin.mybatis.IMapper;
import com.fc.common.service.impl.ServiceImpl;
import com.fc.member.store.user.entity.StoreRewardLog;

import ${basepackage}.dao.I${className}Dao;
import ${basepackage}.service.I${className}Service;
import ${basepackage}.entity.${className};
/**
 * <p>Title: ${className}</p>
 * <p>Description: <#if table.remarks?exists && table.remarks != '' && table.remarks != 'null'>${table.remarks}</#if> Service 层</p>
 * @author ${author}
 * @date <#if now??>${now?string('yyyy-MM-dd HH:mm:ss')}</#if>
 */
@Service("${className?uncap_first}Service")
public class ${className}ServiceImp extends ServiceImpl<${className}> implements I${className}Service{
	private static Logger log = LoggerFactory.getLogger(${className}ServiceImp.class);
	@Autowired
	private I${className}Dao ${className?uncap_first}Dao;
	
	@Override
	protected IMapper<${className}> getDao() {
		return ${className?uncap_first}Dao;
	}
	/**
	 * 插入数据
	 * @return
	 */
	@Override
	public Map<String, Object> insertSelective(${className} obj) {
		Map<String, Object> map=new HashMap<>();
		${className} ${className} =new ${className}();
		BeanUtils.copyProperties(obj, ${className});
		log.info("${className}:"+${className});
		if(${className?uncap_first}Dao.insertSelective(${className})==1) {
			 map.put("id", ${className}.getId());
			 log.info("map:-----------"+map);
		}else {
			return null;
		}
		return map;
	}
}
