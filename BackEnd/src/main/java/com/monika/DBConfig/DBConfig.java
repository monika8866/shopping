package com.monika.DBConfig;

import java.util.Properties;

import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"com.monika"})
@EnableTransactionManagement

public class DBConfig {


		// Change the below based on the DBMS you choose
		private final static String DATABASE_URL = " jdbc:h2:tcp://localhost/~/project1";
		private final static String DATABASE_DRIVER = "org.h2.Driver";
		private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
		private final static String DATABASE_USERNAME = "sa";
		private final static String DATABASE_PASSWORD = "123";
		
		// dataSource bean will be available
		@Bean(name="dataSource")
		public DataSource getDataSource() {
			
			DriverManagerDataSource dataSource= new DriverManagerDataSource();
			
			// Providing the database connection information
			dataSource.setDriverClassName(DATABASE_DRIVER);
			dataSource.setUrl(DATABASE_URL);
			dataSource.setUsername(DATABASE_USERNAME);
			dataSource.setPassword(DATABASE_PASSWORD);
					
			
			return dataSource;
			
		}
		
		// sessionFactory bean will be available
		
		@Bean(name="sessionFactory")
		public SessionFactory getSessionFactory(DataSource dataSource) {
			
			LocalSessionFactoryBuilder lsfb= new LocalSessionFactoryBuilder(dataSource);
			
			lsfb.addProperties(getHibernateProperties());
			lsfb.scanPackages("com.monika");
			
			return lsfb.buildSessionFactory();
			
		}

		
		
		// All the hibernate properties will be returned in this method	
		private Properties getHibernateProperties() {
			
			Properties prop = new Properties();
			
			
			prop.put("hibernate.dialect", DATABASE_DIALECT);		
			prop.put("hibernate.show_sql", "true");
			prop.put("hibernate.format_sql", "true");
			
			prop.put("hibernate.hbm2ddl.auto", "update"); //CREATE-DROP,UPDATE,VALIDATE
			
			
			return prop;
		}
		
		// transactionManager bean
		@Bean
		public HibernateTransactionManager getTM(SessionFactory sessionFactory) {
			
			return new HibernateTransactionManager(sessionFactory);
		}
		
		
	}
