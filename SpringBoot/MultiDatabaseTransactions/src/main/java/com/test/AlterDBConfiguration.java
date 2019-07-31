package com.test;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class AlterDBConfiguration {

	@Value("${hibernate.alter.datasource.driver}")
	private String DRIVER_SOURCE;

	@Value("${hibernate.alter.datasource.url}")
	private String DB_URL;

	@Value("${hibernate.alter.datasource.user}")
	private String USER_NAME;

	@Value("${hibernate.alter.datasource.password}")
	private String PASSWORD;

	@Value("${hibernate.alter.dialect}")
	private String HIBERNATE_DIALECT;

	@Value("${hibernate.alter.hbm2ddl}")
	private String HBM2DDL;

	@Value("${hibernate.alter.show_sql}")
	private String SHOW_SQL;
	
	@Value("${hibernate.alter.packagesToScan}")
	private String PACKAGES_TO_SCAN;

	@Bean(name = "alterSessionFactory")
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(PACKAGES_TO_SCAN);
		Properties properties = new Properties();
		properties.put("hibernate.dialect", HIBERNATE_DIALECT);
		properties.put("hibernate.hbm2ddl.auto", HBM2DDL);
		properties.put("hibernate.show_sql", SHOW_SQL);
		sessionFactory.setHibernateProperties(properties);

		return sessionFactory;
	}

	@Bean(name = "alterDataSource")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		// driver
		dataSource.setDriverClassName(DRIVER_SOURCE);
		// URL
		dataSource.setUrl(DB_URL);
		// user
		dataSource.setUsername(USER_NAME);
		// password
		dataSource.setPassword(PASSWORD);

		return dataSource;
	}

	@Bean(name = "alterTransactionMgr")
	public HibernateTransactionManager transactionManager() {

		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory().getObject());

		return txManager;
	}
}
