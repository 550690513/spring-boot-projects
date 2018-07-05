package com.cheung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Spring Boot文件上传
 *
 * @author Cheung
 */
// @Controller
@RestController// 表示该类下的所有方法的返回值,都会自动做json格式转换(方法上不再需要添加@ResponseBody注解了,相当于@Controller注解+@ResponseBody注解的组合体)
public class FileUploadController {


	@RequestMapping("/fileUploadController")
	public Map<String, Object> fileUpload(MultipartFile filename) throws IOException {
		HashMap<String, Object> map = new HashMap<String, Object>();

		System.out.println(filename.getOriginalFilename());
		filename.transferTo(new File("e:/" + filename.getOriginalFilename()));
		map.put("msg", "ok");
		return map;
	}

}
