package com.cheung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 使用 SpringLoader 进行项目的热部署
 *
 * springloader缺点:热部署只针对class文件生效,静态页面修改不生效
 *
 *
 * 方式一：以 maven 插件方式使用 SpringLoader
 *      1.在 pom 文件中添加插件配置
 *      <build>
 * 	    	<plugins>
 * 	    		<plugin>
 * 	    			<groupId>org.springframework.boot</groupId>
 * 	    			<artifactId>spring-boot-maven-plugin</artifactId>
 * 	    		    <!-- springloader 插件 -->
 * 	    			<dependencies>
 * 	    				<dependency>
 * 	    					<groupId>org.springframework</groupId>
 * 	    					<artifactId>springloaded</artifactId>
 * 	    					<version>1.2.5.RELEASE</version>
 * 	    				</dependency>
 * 	    			</dependencies>
 * 	    		</plugin>
 * 	    	</plugins>
 * 	    </build>
 * 	    2.注意:
 * 	        2.1 如果使用idea开发,还需要配置idea的参数(https://www.jianshu.com/p/4d8aa6dfd103)
 * 	        2.2 必须使用maven命令(mvn spring-boot:run)的方式来启动项目,插件才能启动;
 * 	        2.3 这种方式的缺点是 Springloader 热部署程序是在系统后台以进程的形式来运行,需要手动关闭该进程(java.exe)才可以结束掉该插件的端口占用.
 * 	方式二：在项目中直接使用springloaded.jar包
 *
 *      1.在项目启动前,配置vm options参数:
 *          -javaagent:F:\develop\ideaProjects_myDemos\spring-boot-projects\spring-boot-springloader\lib\springloaded-1.2.5.RELEASE.jar -noverify
 *      2.注意:上面的参数中,springloaded.jar包位置须根据实际情况配置正确
 *
 * @author Cheung
 */
@Controller
public class UserController {

	@RequestMapping("show")
	public String showPage() {
		System.out.println("show hello...");
		return "index";
	}


}
