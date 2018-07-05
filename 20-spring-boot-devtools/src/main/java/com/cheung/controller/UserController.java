package com.cheung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 使用 spring-boot-devtools 进行项目的热部署(重新部署的方式)
 *  1.添加devtools依赖
 *      <dependency>
 * 			<groupId>org.springframework.boot</groupId>
 * 			<artifactId>spring-boot-devtools</artifactId>
 * 			<optional>true</optional>
 * 		</dependency>
 *  2.修改maven插件的配置
 *      <build>
 * 	    	<plugins>
 * 	    		<plugin>
 * 	    			<groupId>org.springframework.boot</groupId>
 * 	    			<artifactId>spring-boot-maven-plugin</artifactId>
 * 	    			<configuration>
 * 	    				<fork>true</fork><!-- 注意:如果没有该项配置，可能devtools不会起作用，即应用不会restart(本人idea开发环境不配置这个就不生效) -->
 * 	    			</configuration>
 * 	    		</plugin>
 * 	    	</plugins>
 * 	    </build>
 *
 *
 * SpringLoader 与 DevTools 的区别：
 *  1.SpringLoader使用的是热部署的方式
 *    DevTools使用的是重新部署的方式    (本质区别)
 *  2.SpringLoader不支持静态页面的修改热部署
 *
 * @author Cheung
 */
@Controller
public class UserController {

	@RequestMapping("show")
	public String showPage() {
		System.out.println("show hello...2");
		return "index";
	}

}
