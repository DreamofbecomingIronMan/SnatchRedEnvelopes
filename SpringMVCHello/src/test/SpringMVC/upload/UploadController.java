package test.SpringMVC.upload;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Controller
@RequestMapping("/springmvcupload")
public class UploadController {
	
	/*
     * 采用file.Transto 来保存上传的文件
     */
	@RequestMapping("/fileUpload")
	public String fileUpload(@RequestParam("file") CommonsMultipartFile file)throws IOException{
		long startTime=System.currentTimeMillis();
		System.out.println("filename:"+file.getOriginalFilename());
		String path="D:/MyEclipse CI/Workspaces/SpringMVCHello/WebRoot/upload/"+new Date().getTime()+file.getOriginalFilename();
		
		File newFile=new File(path);
		 //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
		file.transferTo(newFile);
		long endTime=System.currentTimeMillis();
		System.out.println("方法一运行时间："+String.valueOf(endTime-startTime)+"ms");
		return "index";
	}
	
	/*
     *采用spring提供的上传文件的方法
     */
	@RequestMapping("/springUpload")
	public String springUpload(HttpServletRequest request)throws IllegalStateException,IOException{
		long startTime=System.currentTimeMillis();
		//将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
		CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
				request.getSession().getServletContext());
		//检查form中是否有enctype="multipart/form-data"
		if(multipartResolver.isMultipart(request)){
			//将request变成多部分request
			MultipartHttpServletRequest multipartHttpServletRequest=(MultipartHttpServletRequest)request;
			//获取multiRequest 中所有的文件名
			Iterator<String> iterator=multipartHttpServletRequest.getFileNames();
			while (iterator.hasNext()) {
				//一次遍历所有文件
				MultipartFile file=multipartHttpServletRequest.getFile(iterator.next().toString());
				if(file!=null){
					String path="D:/MyEclipse CI/Workspaces/SpringMVCHello/WebRoot/upload/"+new Date().getTime()+file.getOriginalFilename();
					//上传
					file.transferTo(new File(path));
				}
			}
		}
		long endTime=System.currentTimeMillis();
		System.out.println("方法一运行时间："+String.valueOf(endTime-startTime)+"ms");
		return "index";
	}
}
