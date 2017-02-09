package com.godsungchun.mongodb.example.configs;

import org.springframework.context.annotation.*;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import java.util.Properties;

/**
 * Created by Dream on 2016-06-18.
 */
@Configuration
@ComponentScan(basePackages = "com.godsungchun.mongodb.example",
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
