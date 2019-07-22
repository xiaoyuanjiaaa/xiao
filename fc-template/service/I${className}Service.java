<#assign className = table.className>   
<#assign classNameFirstLower = className?uncap_first>   
<#assign classNameLowerCase = className?lower_case>   
<#assign pkJavaType = table.idColumn.javaType>   
package ${basepackage}.service;

import java.util.Map;

import com.fc.common.service.IService;
import ${basepackage}.entity.${className};
/**
 * <p>Title: ${className}</p>
 * <p>Description: <#if table.remarks?exists && table.remarks != '' && table.remarks != 'null'>${table.remarks}</#if> Service 接口</p>
 * @author ${author}
 * @date <#if now??>${now?string('yyyy-MM-dd HH:mm:ss')}</#if>
 */
public interface I${className}Service extends IService<${className}>{
	
	/**插入数据*/
	Map<String, Object> insertSelective(${className} obj);
}
