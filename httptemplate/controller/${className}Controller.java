package ${basepackage}.controller;

import java.util.Map;





import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ${basepackage}.service.http.I${className}Service;

@Controller
@RequestMapping("/${classNameLowerCase}")
public class ${className}Controller {
	@Autowired
	private I${className}Service ${classNameFirstLower}Service;
	
	<#list propertiesNoList as method>
	@ResponseBody
	@RequestMapping(value = "${method.className}", method = {RequestMethod.GET,RequestMethod.POST})
    public Map ${method.className}(Model model,@RequestParam Map form){
    	Map data=${classNameFirstLower}Service.${method.className}(form);
    	return data;
    }
    
    </#list>
     
    <#list propertiesEndList as method>
    @ResponseBody
	@RequestMapping(value = "${method.className}", method = {RequestMethod.GET,RequestMethod.POST})
    public Map ${method.className}(Model model,@RequestParam Map form){
    	Map data=${classNameFirstLower}Service.${method.className}(form);
    	return data;
    }
    
    </#list>

}
