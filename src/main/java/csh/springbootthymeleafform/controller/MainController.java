package csh.springbootthymeleafform.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import csh.springbootthymeleafform.entity.User;
import csh.springbootthymeleafform.service.RegisterService;

@Controller
public class MainController {
	
	@Autowired 
	RegisterService registerService;
	
	@GetMapping("/register")
	private ModelAndView showForm(ModelAndView modelAndView) {
		return registerService.getRegistrationPage(modelAndView);
	}
	
	@PostMapping("/register")
	private ModelAndView submit(@Valid User user, BindingResult bindingResult, ModelAndView modelAndView) {
		return registerService.getSubmissionPage(user, bindingResult, modelAndView);
	}

}
