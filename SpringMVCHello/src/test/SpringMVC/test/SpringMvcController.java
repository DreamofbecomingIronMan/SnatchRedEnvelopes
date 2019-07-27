package test.SpringMVC.test;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import test.SpringMVC.model.Person;

@Controller
@RequestMapping("/SpringMvc")
public class SpringMvcController {
	
	@RequestMapping("/hello")
	public String hello(){
		return "index";
	}

	//自动匹配参数
	@RequestMapping("/person")
	public String toPerson(String name,Integer age) {
		System.out.println(name+" "+age);
		return "index";
	}
	
	//自动装箱
	@RequestMapping("/person1")
    public String toPerson(Person p){
        System.out.println(p.getName()+" "+p.getAge());
        return "index";
    }
	
	//使用InitBinder来处理Date类型的参数
	@RequestMapping("/date")
    public String date(Date date){
        System.out.println(date);
        return "index";
    }
	
	@InitBinder
    public void initBinder(ServletRequestDataBinder binder){
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),
                true));
    }
	
	//向前台传递参数,前台可在Request域中取到"p"
	@RequestMapping("/show")
    public String showPerson(Map<String,Object> map){
        Person p =new Person();
        map.put("p", p);
        p.setAge(20);
        p.setName("jayjay");
        return "index";
    }
	
	//使用Ajax调用
	@RequestMapping("/getPerson")
    public void getPerson(String name,PrintWriter pw){
		System.out.println(name);
        pw.write("hello,"+name);        
    }
    @RequestMapping("/name")
    public String sayHello(){
        return "name";
    }
    
	//redirect 
    @RequestMapping("/redirect")
    public String redirect(){
        return "redirect:hello";
    }
}
