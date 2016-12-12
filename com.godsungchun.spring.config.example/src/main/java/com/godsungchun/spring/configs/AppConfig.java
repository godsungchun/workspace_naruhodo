package com.godsungchun.spring.configs;

import org.springframework.context.annotation.*;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;

/**
 * AppConfig.
 *
 * Created by Dream on 2016-12-12.
 */
@Configuration
@ComponentScan(
		basePackages = "com.godsungchun.spring",
		excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)
)
@PropertySources(value = {@PropertySource("classpath:properties/db.properties")})
public class AppConfig {
	@Bean(name = "messageSource")
	public ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

		messageSource.setBasenames("classpath:properties/env");
		messageSource.setDefaultEncoding("UTF-8");

		return messageSource;
	}

}
