package ${basepackage}.dao.http;

import java.util.Map;

public interface I${className}Dao {
	
	<#list propertiesNoList as method>  
    public Map ${method.className}(String url,
			Map<String, String> params) throws Exception;
    
    </#list>
    
    <#list propertiesEndList as method>  
    public Map ${method.className}(String url,
			Map<String, String> params) throws Exception;
    
    </#list>
    
}