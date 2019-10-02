//package com.isoft.security.config;
//
//import java.util.Arrays;
//import java.util.Collections;
//
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cache.concurrent.ConcurrentMapCache;
//import org.springframework.cache.support.SimpleCacheManager;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.support.ResourceBundleMessageSource;
//import org.springframework.http.client.BufferingClientHttpRequestFactory;
//import org.springframework.http.client.ClientHttpRequestFactory;
//import org.springframework.http.client.SimpleClientHttpRequestFactory;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.client.RestTemplate;
//
////import com.gitlabapi.utils.RequestResponseLoggingInterceptor;
//
//
//@Configuration
//@EnableAsync
//public class Config  {
//
//	@Bean
//	public ResourceBundleMessageSource messageSource() {
//		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
//		String[] baseNames = new String[] { "messages" };
//		source.setBasenames(baseNames);
//		source.setCacheSeconds(60 * 30);
//		source.setUseCodeAsDefaultMessage(true);
//		return source;
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//		return passwordEncoder;
//	}
//
////	 @Bean
////	    public RestTemplate restTemplate() {
////
////	    	ClientHttpRequestFactory factory = new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory());
////
////	    	RestTemplate restTemplate = new RestTemplate(factory);
////
////	    	restTemplate.setInterceptors(Collections.singletonList(new RequestResponseLoggingInterceptor()));
////
////	        return restTemplate;
////	    }
//
//
//
//
//	@Bean
//    public CacheManager cacheManager() {
//        // configure and return an implementation of Spring's CacheManager SPI
//        SimpleCacheManager cacheManager = new SimpleCacheManager();
//        cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("gituser")));
//        return cacheManager;
//    }
//
//
//}
