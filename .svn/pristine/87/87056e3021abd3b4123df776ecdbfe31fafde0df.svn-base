
<#assign className = table.className>   
<#assign classNameFirstLower = className?uncap_first>   
<#assign classNameLowerCase = className?lower_case>   
<#assign pkJavaType = table.idColumn.javaType>   

package ${basepackage}.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ${basepackage}.service.I${className}Service;
import ${basepackage}.model.${className};
import ${basepackage}.common.page.Page;
import ${basepackage}.common.page.PageData;

@Controller
@RequestMapping("/${classNameLowerCase}")
public class ${className}Controller {
	@Autowired
	private I${className}Service ${classNameFirstLower}Service;
	

	@RequestMapping(value = "list", method = {RequestMethod.GET,RequestMethod.POST})
	public String list(Model model, ${className} ${classNameFirstLower}, Page page,String sortColumns) {
		PageData pageData = ${classNameFirstLower}Service.getList(${classNameFirstLower}, page, sortColumns);
		model.addAttribute("page", pageData);
		model.addAttribute("${classNameFirstLower}", ${classNameFirstLower});
		return "/${classNameLowerCase}/index";
	}

	@RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
	public String get${className}(Model model, @PathVariable Integer id) {
		model.addAttribute("${classNameFirstLower}",
				${classNameFirstLower}Service.getById(id));
		return "/${classNameLowerCase}/detail";
	}
	
	@RequestMapping(value = "edit/{id}", method = {RequestMethod.GET,RequestMethod.POST})
	public String edit${className}(Model model, @PathVariable Integer id) {
		model.addAttribute("${classNameFirstLower}",
				${classNameFirstLower}Service.getById(id));
		return "/${classNameLowerCase}/edit";
	}
	
	@RequestMapping(value = "add", method = {RequestMethod.GET,RequestMethod.POST})
	public String add${className}(Model model, @PathVariable Integer id) {
		return "/${classNameLowerCase}/add";
	}
	
	@RequestMapping(value = "insert", method = {RequestMethod.GET,RequestMethod.POST})
	public String insert${className}(Model model, ${className} ${classNameFirstLower}) {
		${classNameFirstLower}Service.insert(${classNameFirstLower});
		return "/${classNameLowerCase}/insert";
	}
	
	@RequestMapping(value = "update", method = {RequestMethod.GET,RequestMethod.POST})
	public String update${className}(Model model, ${className} ${classNameFirstLower}) {
		${classNameFirstLower}Service.update(${classNameFirstLower});
		return "/${classNameLowerCase}/update";
	}
	
	@RequestMapping(value = "delete/{id}", method = {RequestMethod.GET,RequestMethod.POST})
	public String delete${className}(Model model, @PathVariable Integer id) {
		${classNameFirstLower}Service.delete(id);
		return "/${classNameLowerCase}/delete";
	}

}
