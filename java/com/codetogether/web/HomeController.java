package com.codetogether.web;

import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codetogether.auth.SnsDTO;
import com.codetogether.auth.SnsLogin;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Inject
	private SnsDTO naverSns;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		logger.info("Welcome home!");

		SnsLogin naverLogin = new SnsLogin(naverSns);
		model.addAttribute("naver_url", naverLogin.getNaverAuthURL());

		return "/statics/index";

	}

}
