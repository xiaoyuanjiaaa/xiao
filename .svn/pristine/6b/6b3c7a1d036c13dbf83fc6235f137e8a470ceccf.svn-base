<#assign className = table.className>   
<#assign classNameFirstLower = className?uncap_first>   
<#assign classNameLowerCase = className?lower_case>   
<#assign pkJavaType = table.idColumn.javaType>   

package ${basepackage}.service;

import java.util.List;

import ${basepackage}.model.${className};
import ${basepackage}.common.page.Page;
import ${basepackage}.common.page.PageData;

public interface I${className}Service {
	
	public PageData getList(${className} ${classNameFirstLower}, Page page,String sortColumns);
	
	public Long getCount(${className} ${classNameFirstLower});

	public ${className} getById(Integer id);
	
	public void insert(${className} ${classNameFirstLower});
	
	public void update(${className} ${classNameFirstLower});
	
	public void delete(Integer id);
	
}
