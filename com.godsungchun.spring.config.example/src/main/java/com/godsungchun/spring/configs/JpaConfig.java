package com.godsungchun.spring.configs;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import java.util.Properties;

/**
 * JpaConfig.
 *
 * Created by Dream on 2016-12-12.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.godsungchun.spring.repositories")
@PropertySources(value = {@PropertySource("classpath:properties/db.properties")})
public class JpaConfig {
	@Autowired
	private Environment environment;
	
	@Bean(name = "jpaDataSource", destroyMethod = "close")
	public BasicDataSource jpaDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		
		dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
		dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
		
		return dataSource;
	}
	
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		
		vendorAdapter.setDatabase(Database.MYSQL);
		vendorAdapter.setGenerateDdl(true);
		vendorAdapter.setShowSql(true);
		
		entityManagerFactoryBean.setDataSource(jpaDataSource());
		entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
		entityManagerFactoryBean.setPackagesToScan("com.godsungchun.spring.entities");
		entityManagerFactoryBean.setJpaProperties(jpaProperties());
		entityManagerFactoryBean.afterPropertiesSet();
		
		return entityManagerFactoryBean.getObject();
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory());
		
		return transactionManager;
	}
	
	private Properties jpaProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		properties.put("hibernate.show_sql", true);
		
		return properties;
	}
}
