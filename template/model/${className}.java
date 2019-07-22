<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.model;

import com.fc.distribute.common.DateTimeUtils;

public class ${className}{
	
	
	<#list table.columns as column>
	private ${column.javaType} ${column.columnNameLower};
	</#list>

	//----时间处理----
	<#list table.columns as column>
	<#if column.isDateTimeColumn>
	//设置时间
	public String get${column.columnName}String() {
		return DateTimeUtils.getStringFromTime(get${column.columnName}(), DateTimeUtils.FORMAT_DATE_TIME);
	}
	public void set${column.columnName}String(String value) {
		set${column.columnName}(DateTimeUtils.getTimeFromString(value, DateTimeUtils.FORMAT_DATE_TIME));
	}
	//用于时间搜索的开始日期
	private String ${column.columnNameLower}Begin;
	
	public void set${column.columnName}Begin(String ${column.columnNameLower}){
		this.${column.columnNameLower}Begin=${column.columnNameLower};
	}
	
	public String get${column.columnName}Begin() {
		return this.${column.columnNameLower}Begin;
	}
	
	//用于时间搜索的结束日期
    private String ${column.columnNameLower}End;
	
	public void set${column.columnName}End(String ${column.columnNameLower}End){
		this.${column.columnNameLower}End=${column.columnNameLower}End;
	}
	
	public String get${column.columnName}End() {
		return this.${column.columnNameLower}End;
	}
	//时间处理结束
	
	</#if>	
	public void set${column.columnName}(${column.javaType} ${column.columnNameLower}) {
		this.${column.columnNameLower} = ${column.columnNameLower};
	}
	
	public ${column.javaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}
    </#list>
    
}



