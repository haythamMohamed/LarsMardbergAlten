package com.vehicle.tracking.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "db.config")
public class DataBasePropertiesHolder {
	
	private String driverClassName ;
	private String url ;
	private String userName ;
	private String password ;
	private int minPoolSize ;
	private int maxPoolSize ;
	private long maxIdleTime ;
	private String dialect ;
	private boolean showSql ;
	
}
