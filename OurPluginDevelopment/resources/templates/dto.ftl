<#import "/commons/utils.ftl" as u>
<#assign class_name_cap = class.name?cap_first>
<#assign class_name = class.name?uncap_first>
<#assign class_dto = class_name + "Dto">
<#assign class_dto_cap = class_name_cap + "Dto">
<@u.gen_template_metadata template_name=(.current_template_name) author=user class_name = class_name_cap/>

package ${class_package};

<#list importedPackages as type>
import ${type.typePackage}.${type.name};
</#list>

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;

@Data
@Builder
@NoArgsConstructor 
@AllArgsConstructor
public class ${class_dto_cap} {

<#list properties as property>
  <#if entity_properties[property.type.name]??>
       <#if property.upper == -1>
           <#-- @ManyToMany -->
    ${property.visibility} List<${property.type.name}Dto> ${property.name};                    
       <#else>
           <#-- @ManyToOne or @OneToOne -->
    ${property.visibility} ${property.type.name}Dto ${property.name};               
       </#if>
   <#else>
    ${property.visibility} ${property.type.name} ${property.name};                     
   </#if>     
</#list>
	
}

<@u.block_end />