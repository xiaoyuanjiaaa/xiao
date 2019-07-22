<#assign className = table.className>   
<#assign classNameFirstLower = className?uncap_first>   
<#assign classNameLowerCase = className?lower_case>   
<#assign pkJavaType = table.idColumn.javaType> 
package ${basepackage}.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ${basepackage}.dao.mybatis.I${className}Dao;
import ${basepackage}.service.I${className}Service;
import ${basepackage}.model.${className};
import ${basepackage}.common.page.Page;
import ${basepackage}.common.page.PageData;

@Service
public class ${className}ServiceImp implements I${className}Service{
	
	@Autowired
	private I${className}Dao ${classNameFirstLower}Dao;

	public PageData getList(${className} ${classNameFirstLower}, Page page,String sortColumns) {
		if(page!=null){
			Long totalRecord=${classNameFirstLower}Dao.getCount(${classNameFirstLower});
			page.setTotalRow(totalRecord);
		}
		return new PageData(${classNameFirstLower}Dao.getList(${classNameFirstLower}, page,sortColumns),page);
	}

	public ${className} getById(Integer id) {
		return ${classNameFirstLower}Dao.getById(id);
	}
	
	public Long getCount(${className} ${classNameFirstLower}){
		return ${classNameFirstLower}Dao.getCount(${classNameFirstLower});
	}
	
	public void insert(${className} ${classNameFirstLower}){
		${classNameFirstLower}Dao.insert(${classNameFirstLower});
	}
	
	public void update(${className} ${classNameFirstLower}){
		${classNameFirstLower}Dao.update(${classNameFirstLower});
	}
	
	public void delete(Integer id){
		${classNameFirstLower}Dao.delete(id);
	}
}
