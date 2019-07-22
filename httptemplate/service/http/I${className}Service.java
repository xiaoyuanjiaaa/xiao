package ${basepackage}.service.http;

import java.util.Map;

public interface I${className}Service {
	
	<#list propertiesNoList as method>  
    public Map ${method.className}(Map<String, String> params);
    
    </#list>
    <#list propertiesEndList as method>  
    public Map ${method.className}(Map<String, String> params);
    
    </#list>
	
}
