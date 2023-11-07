package com.my.board.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableTransactionManagement
@Slf4j
@PropertySource("classpath:/db.properties")
public class MyApplicationContext {
	@Value("${spring.datasource.hikari.driver-class-name}")
	private String hikariDriverClassName;
	
	@Autowired
	Environment env;
	
/*
	@Bean
	public HikariConfig hikariConfig() {
		HikariConfig config = new HikariConfig();
		//로그를 찍어주는 DriverSpy 사용하기
//		config.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy"); //oracle.jdbc.OracleDriver
		config.setDriverClassName(hikariDriverClassName);
		
		config.setJdbcUrl("jdbc:log4jdbc:oracle:thin:@localhost:1521:xe");
//		config.setUsername("hr");
		config.setUsername(env.getProperty("spring.datasource.hikari.username"));
		config.setPassword("hr");
		config.setMinimumIdle(3);
		return config;
	}
*/
	
	@Bean
	@ConfigurationProperties("spring.datasource.hikari")
	public HikariConfig hikariConfig() {
		HikariConfig config = new HikariConfig();
		return config;
	}
	
	@Bean
	public HikariDataSource dataSourceHikari() {
		return new HikariDataSource(hikariConfig());
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
		ssfb.setDataSource(dataSourceHikari());
		Resource resource = new ClassPathResource("mybatis-config.xml");
		ssfb.setConfigLocation(resource);
		return (SqlSessionFactory)ssfb.getObject();
	}
	
	@Bean
	public DataSourceTransactionManager transactionManager() {
		DataSourceTransactionManager tx = new DataSourceTransactionManager();
		tx.setDataSource(dataSourceHikari());
		return tx;
		
	}
}
