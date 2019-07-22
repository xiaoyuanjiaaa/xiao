<#assign className = table.className>   
<#assign classNameFirstLower = className?uncap_first>   
<#assign classNameLowerCase = className?lower_case>   
<#assign pkJavaType = table.idColumn.javaType>   

package ${basepackage}.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ${basepackage}.common.page.Page;
import ${basepackage}.model.${className};

public interface I${className}Dao {
	
    public List<${className}> getList(@Param("${classNameFirstLower}") ${className} ${classNameFirstLower},@Param("page") Page page,@Param("sortColumns") String sortColumns);
    
    public Long getCount(@Param("${classNameFirstLower}") ${className} ${classNameFirstLower});
    
    public ${className} getById(Integer id);
    
    public void insert(${className} ${classNameFirstLower});
    
    public void update(${className} ${classNameFirstLower});
	
	public void delete(Integer id);
    
}