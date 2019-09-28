package com.vehicle.tracking.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DatabaseConfiguration {

	@Autowired
	DataBasePropertiesHolder dataBasePropertiesHolder;

	@Bean
	public HikariDataSource initHikariDS() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(dataBasePropertiesHolder.getUrl());
		config.setDriverClassName(dataBasePropertiesHolder.getDriverClassName());
		config.setUsername(dataBasePropertiesHolder.getUserName());
		config.setPassword(dataBasePropertiesHolder.getPassword());
		config.setIdleTimeout(dataBasePropertiesHolder.getMaxIdleTime());
		config.setMinimumIdle(dataBasePropertiesHolder.getMinPoolSize());
		config.setMaximumPoolSize(dataBasePropertiesHolder.getMaxPoolSize());
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		return new HikariDataSource(config);
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(initHikariDS());
		em.setPackagesToScan("com.vehicle.tracking.model");

		Properties properties = new Properties();
		properties.put("hibernate.dialect", dataBasePropertiesHolder.getDialect());
		properties.put("hibernate.show_sql", dataBasePropertiesHolder.isShowSql());
		properties.put("hibernate.format_sql", true);
		properties.put("hibernate.bytecode.use_reflection_optimizer", true);
		properties.put("hibernate.hbm2ddl.auto", "create-drop");

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(properties);

		return em;
	}

}
