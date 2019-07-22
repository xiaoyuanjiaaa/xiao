package ${basepackage}.dao.http.impl;

import java.util.List;

import java.util.Map;
import com.fc.common.util.HttpClientUtil;

import org.springframework.stereotype.Component;

import ${basepackage}.dao.http.I${className}Dao;


@Component
public class ${className}Dao implements I${className}Dao {
	
	<#list propertiesNoList as method>  
    public Map ${method.className}(String url,
			Map<String, String> params) throws Exception{  
        return HttpClientUtil.sendPostReplyJson(url,params);
    }
    
    </#list>
    
    <#list propertiesEndList as method>  
    public Map ${method.className}(String url,
			Map<String, String> params) throws Exception{  
        return HttpClientUtil.sendPostReplyJson(url,params);
    }
    
    </#list>
    
}