//package com.isoft.security.config;
//
//
//import javax.servlet.http.HttpServletRequest;
//import javax.validation.Valid;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.LockedException;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import com.isoft.security.config.ApplicationException;
//
//
//@Controller
//@RequestMapping("/")
//public class MainWebController {
//
//	private Logger logger = LoggerFactory.getLogger(this.getClass());
//
////	@Autowired
////	RegistrationService regService;
//
//	@GetMapping
//	String getDefault() {
//		return "redirect:/secure/dashboard";
//	}
//
//
//	@GetMapping("/secure/dashboard")
//	String getDashboard() {
//		return "secure/dashboard";
//	}
//
//
//	@GetMapping("/register/{regKey}")
//	String register(@PathVariable String regKey,RedirectAttributes redirectAttributes, Model model) {
//		String response = "";
////		try {
////			response = regService.register(regKey);
////		} catch (ApplicationException e) {
////			logger.warn("Error registering ", regKey, e);
////			model.addAttribute("error", e.getMessage());
////			return "login";
////		}
//		redirectAttributes.addFlashAttribute("message", response);
//		return "redirect:/login";
//	}
//
//
////	@GetMapping("/register")
////	String signUp(Model model){
////		RegistrationInfo info = new RegistrationInfo();
////		model.addAttribute("info",info);
////		return "register";
////	}
//
////	@RequestMapping(value = "/register", method = RequestMethod.POST)
////	String newRegistration(@ModelAttribute("info") @Valid RegistrationInfo info, BindingResult result,RedirectAttributes redirectAttributes,  Model model) {
////		if (result.hasErrors()) {
////			logger.warn("Error occurred creating RegistrationInfo{}", result.toString());
////			return "register";
////
////		}
////		String response = "";
////		try {
////			response = regService.register(info);
////		} catch (ApplicationException e) {
////			logger.warn("Error registering ", info, e);
////			result.reject(e.getMessage());
////			// model.addAttribute("error", e.getMessage());
////		}
////		redirectAttributes.addFlashAttribute("message", response);
////		return "redirect:/register";
////	}
//
//	@RequestMapping("/login")
//	public ModelAndView login(
//			@RequestParam(value = "error", required = false) String error,
//			HttpServletRequest request) {
//
//		ModelAndView model = new ModelAndView();
//		if (error != null) {
//			model.addObject("error",
//					getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
//		}
//
//		model.setViewName("login");
//
//		return model;
//
//	}
//
//	//customize the error message
//	private String getErrorMessage(HttpServletRequest request, String key){
//
//		Exception exception =
//				(Exception) request.getSession().getAttribute(key);
//
//		String error = "";
//		if (exception instanceof BadCredentialsException) {
//			error = "Invalid username or password!";
//		}else if(exception instanceof LockedException) {
//			error =  "Invalid username or password!";
//		}else{
//			error = "Invalid username or password!";
//		}
//
//		return error;
//	}
//
//
//}
//
