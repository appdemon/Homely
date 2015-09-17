package com.homely.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.api.LoginService;
import com.spring.model.Hello;


@Controller
public class HelloController {
//	@RequestMapping(value="/welcome",method=RequestMethod.GET)
//	public ModelAndView helloWorld(@RequestParam("user")String name)
//	{
//		System.out.println("Inside helloworld()");
//		ModelAndView model =new ModelAndView("hello");
//		model.addObject("msg",name);
//		return model;
//	}
	@Autowired
	private LoginService loginService;
	private boolean check=false;
	@RequestMapping(value="/welcome",method=RequestMethod.GET)
	public ModelAndView helloWorld(@ModelAttribute("hello")Hello hello)
	{
		System.out.println("Inside helloworld()");
		check=loginService.loginCheck(hello);
		ModelAndView model=new ModelAndView();
		if(check){
		 model =new ModelAndView("hello");
		model.addObject("msg",hello.getUser());

		}else{
			 model =new ModelAndView("redirect:index");
			model.addObject("msg","Not a valid user");

         }
		return model;
	}

}
