<div class="catnav">
    <ul>
         <#list catalogues as root>
           <li>
             <a href="javascript:;">${root.cataloguename!''}</a><i></i><#-- 第一级 -->
              <#if root.childrens?? && root.childrens?size gt 0 >
             <div class="subnav">
                    <dl>
                     <#assign secondChild=root.childrens>
                         <#if secondChild?? && secondChild?size gt 0 >  
                             <#list secondChild as secondNode>
                                  <dt><a href="/catnav/${secondNode.sid!''}.html">${secondNode.cataloguename!''}</a></dt><#-- 第二级 -->
                                    <#assign thirdChild=secondNode.childrens>
                                       <#if thirdChild?? && thirdChild?size gt 0 >  
                                      <dd>
                                      <#list thirdChild as thirdChildNode>
                                         <a href="/catnav/${thirdChildNode.sid!''}.html">${thirdChildNode.cataloguename!''}</a><#-- 第三级，最多只输出三级菜单 -->
                                       </#list>
                                      </dd>
                                    </#if>  
                             </#list>
                          </#if>
                    </dl>   
             </div>
            </#if>
           </li>
        </#list>
    </ul>
</div>