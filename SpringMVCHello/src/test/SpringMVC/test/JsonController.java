package test.SpringMVC.test;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import test.SpringMVC.model.User;

@Controller
@RequestMapping("/json")
public class JsonController {

	@ResponseBody
	@RequestMapping("/user")
	public User get(){
		User user=new User();
		user.setId(1);
		user.setName("jayjay");
        user.setBirth(new Date());
        return user;
	}
}
