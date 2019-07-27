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
     * ����file.Transto �������ϴ����ļ�
     */
	@RequestMapping("/fileUpload")
	public String fileUpload(@RequestParam("file") CommonsMultipartFile file)throws IOException{
		long startTime=System.currentTimeMillis();
		System.out.println("filename:"+file.getOriginalFilename());
		String path="D:/MyEclipse CI/Workspaces/SpringMVCHello/WebRoot/upload/"+new Date().getTime()+file.getOriginalFilename();
		
		File newFile=new File(path);
		 //ͨ��CommonsMultipartFile�ķ���ֱ��д�ļ���ע�����ʱ��
		file.transferTo(newFile);
		long endTime=System.currentTimeMillis();
		System.out.println("����һ����ʱ�䣺"+String.valueOf(endTime-startTime)+"ms");
		return "index";
	}
	
	/*
     *����spring�ṩ���ϴ��ļ��ķ���
     */
	@RequestMapping("/springUpload")
	public String springUpload(HttpServletRequest request)throws IllegalStateException,IOException{
		long startTime=System.currentTimeMillis();
		//����ǰ�����ĳ�ʼ����  CommonsMutipartResolver ���ಿ�ֽ�������
		CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
				request.getSession().getServletContext());
		//���form���Ƿ���enctype="multipart/form-data"
		if(multipartResolver.isMultipart(request)){
			//��request��ɶಿ��request
			MultipartHttpServletRequest multipartHttpServletRequest=(MultipartHttpServletRequest)request;
			//��ȡmultiRequest �����е��ļ���
			Iterator<String> iterator=multipartHttpServletRequest.getFileNames();
			while (iterator.hasNext()) {
				//һ�α��������ļ�
				MultipartFile file=multipartHttpServletRequest.getFile(iterator.next().toString());
				if(file!=null){
					String path="D:/MyEclipse CI/Workspaces/SpringMVCHello/WebRoot/upload/"+new Date().getTime()+file.getOriginalFilename();
					//�ϴ�
					file.transferTo(new File(path));
				}
			}
		}
		long endTime=System.currentTimeMillis();
		System.out.println("����һ����ʱ�䣺"+String.valueOf(endTime-startTime)+"ms");
		return "index";
	}
}
