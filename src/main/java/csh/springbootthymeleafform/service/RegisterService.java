package csh.springbootthymeleafform.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import csh.springbootthymeleafform.dao.DaoRepository;
import csh.springbootthymeleafform.entity.User;

@Service
public class RegisterService {

	@Autowired
	DaoRepository daoRepository;

	public ModelAndView getRegistrationPage(ModelAndView modelAndView) {
		modelAndView.setViewName("register_form");
		modelAndView.addObject("user", new User());
		modelAndView.addObject("professionList", RegisterService.getProfessionList());

		return modelAndView;
	}

	public ModelAndView getSubmissionPage(User user, BindingResult bindingResult, ModelAndView modelAndView) {
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("register_form");
			modelAndView.addObject("user", user);
			modelAndView.addObject("professionList", RegisterService.getProfessionList());
			return modelAndView;
		} else {
			daoRepository.save(user);
			modelAndView.addObject("user", user);
			modelAndView.setViewName("success_form");
			return modelAndView;
		}
	}

	private static List<String> getProfessionList() {
		return Arrays.asList("Software Engineer", "Architect", "Data Scientist", "Quality Assuarence Engineer",
				"DevOps Engineer", "Business Analyst", "Network Engineer");
	}

}
