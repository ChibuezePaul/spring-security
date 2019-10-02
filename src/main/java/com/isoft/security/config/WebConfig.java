package com.isoft.security.config;

import com.isoft.security.user.UserController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

/**
 * Created by mac on 29/09/2019.
 */
public class WebConfig implements WebMvcConfigurer {
	
	@Override
	public void addInterceptors ( InterceptorRegistry registry ) {
		registry.addInterceptor(new UserController ());
//	    registry.addInterceptor(localeChangeInterceptor());
	
	}
	
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		String[] baseNames = new String[] { "messages" };
		source.setBasenames(baseNames);
		source.setCacheSeconds(60 * 30);
		source.setUseCodeAsDefaultMessage(true);
		return source;
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver ();
		localeResolver.setDefaultLocale( Locale.US);
		return localeResolver;
	}
	
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor ();
		localeChangeInterceptor.setParamName("lang");
		return localeChangeInterceptor;
	}
}
