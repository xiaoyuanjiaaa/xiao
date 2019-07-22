<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.entity;

import java.io.Serializable;
<#list table.columns as column><#if column.javaType='BigDecimal'>import java.math.BigDecimal;<#break></#if></#list>

/**
 * <p>Table: ${className}</p>
 * <p>Description: <#if table.remarks?exists && table.remarks != '' && table.remarks != 'null'>${table.remarks}</#if></p>
 * @author ${author}
 * @date <#if now??>${now?string('yyyy-MM-dd HH:mm:ss')}</#if>
 */
public class ${className} implements Serializable{

	private static final long serialVersionUID = 1L;
	
	<#list table.columns as column>
	private ${column.javaType} ${column.javaName}; // ${column.remarks}
	</#list>

	<#list table.columns as column>
	<#if column.isDateTimeColumn>
	//----时间处理----
	
	//设置时间
	public String get${column.javaName?cap_first}String() {
		return DateTimeUtils.getStringFromTime(get${column.javaName?cap_first}(), DateTimeUtils.FORMAT_DATE_TIME);
	}
	public void set${column.javaName?cap_first}String(String value) {
		set${column.javaName?cap_first}(DateTimeUtils.getTimeFromString(value, DateTimeUtils.FORMAT_DATE_TIME));
	}
	//用于时间搜索的开始日期
	private String {column.javaName}_begin;
	
	public void set${column.javaName?cap_first}_end(String {column.javaName}_begin){
		this.${column.javaName}_end={column.javaName}_begin;
	}
	
	public String get${column.javaName?cap_first}_begin() {
		return this.${column.javaName}_begin;
	}
	
	//用于时间搜索的结束日期
    private String {column.javaName}_end;
	
	public void set${column.javaName?cap_first}_end(String {column.javaName}_end){
		this.${column.javaName}_end={column.javaName}_end
	}
	
	public String get${column.javaName?cap_first}_end() {
		return this.${column.javaName}_end;
	}
	//时间处理结束
	
	</#if>	
	public void set${column.javaName?cap_first}(${column.javaType} ${column.javaName}) {
		this.${column.javaName} = ${column.javaName};
	}
	
	public ${column.javaType} get${column.javaName?cap_first}() {
		return this.${column.javaName};
	}
    </#list>

    @Override
    public String toString () {
    	return "${className}{" + 
			<#list table.columns as column>
	    	"<#if column_index!=0>, </#if>${column.javaName}=" + ${column.javaName} + 
	    	</#list>
	    	"}";
    }
}