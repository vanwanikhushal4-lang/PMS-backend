package com.velox.itsm.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.velox.itsm.ATM.ApplicationPropertyReader;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.velox.itsm.config" })
@PropertySource(value = { "classpath:application.properties" })
public class HibernateConfiguration {

	@Autowired
	private Environment environment;

	// mapping entity class for table creation
	@Bean
	@Primary
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		boolean singleton = sessionFactory.isSingleton();
//		System.out.println("QQQQQQQQQQQQQQQQQQQQQQQQQ"+singleton);
		sessionFactory.setPackagesToScan(new String[] { "com.velox.itsm.model" });
		sessionFactory.setHibernateProperties(hibernateProperties());
		setProperties();
		return sessionFactory;
	}
	

	// database authentication
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
		dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
		return dataSource;
	}
	
//	@Bean
//	public LocalSessionFactoryBean sessionFactoryCM() {
//		LocalSessionFactoryBean sessionFactoryCM = new LocalSessionFactoryBean();
//		sessionFactoryCM.setDataSource(dataSourceass());
//		sessionFactoryCM.setPackagesToScan(new String[] { "com.velox.itsm.model.ChangeManagement" });
//		sessionFactoryCM.setHibernateProperties(hibernateProperties());
//		setProperties();
//		return sessionFactoryCM;
//	}

	// database authentication
//	@Bean
//	public DataSource dataSourceass() {
//		DriverManagerDataSource dataSourceass = new DriverManagerDataSource();
//		dataSourceass.setDriverClassName(environment.getRequiredProperty("cm.jdbc.driverClassName"));
//		dataSourceass.setUrl(environment.getRequiredProperty("cm.jdbc.url"));
//		dataSourceass.setUsername(environment.getRequiredProperty("cm.jdbc.username"));
//		dataSourceass.setPassword(environment.getRequiredProperty("cm.jdbc.password"));
//		return dataSourceass;
//	}
////////////////////HW_ASSET START//////////
//@Bean
//
//public LocalSessionFactoryBean sessionFactoryITAsset() {
//LocalSessionFactoryBean sessionFactoryITAsset = new LocalSessionFactoryBean();
//sessionFactoryITAsset.setDataSource(dataSourceasit());
//sessionFactoryITAsset.setPackagesToScan(new String[] { "com.velox.itsm.model.ItAsset" });
//sessionFactoryITAsset.setHibernateProperties(hibernateProperties());
//setProperties();
//return sessionFactoryITAsset;
//}

//database authentication
//@Bean
//public DataSource dataSourceasit() {
//DriverManagerDataSource dataSourceasit = new DriverManagerDataSource();
//dataSourceasit.setDriverClassName(environment.getRequiredProperty("ita.jdbc.driverClassName"));
//dataSourceasit.setUrl(environment.getRequiredProperty("ita.jdbc.url"));
//dataSourceasit.setUsername(environment.getRequiredProperty("ita.jdbc.username"));
//dataSourceasit.setPassword(environment.getRequiredProperty("ita.jdbc.password"));
//return dataSourceasit;
//}
////////////////////HW_ASSET END//////////


////////////////////////////////CLOUD CONNECTION START/////////////////////
//@Bean
//
//public LocalSessionFactoryBean sessionFactoryPROJECLAIMS() {
//LocalSessionFactoryBean sessionFactoryPROJECLAIMS = new LocalSessionFactoryBean();
//sessionFactoryPROJECLAIMS.setDataSource(dataSourcePROJECLAIMS());
//sessionFactoryPROJECLAIMS.setPackagesToScan(new String[] { "com.velox.itsm.model.Prana" });
//sessionFactoryPROJECLAIMS.setHibernateProperties(hibernateProperties());
//setProperties();
//return sessionFactoryPROJECLAIMS;
//}
//
////database authentication
//@Bean
//public DataSource dataSourcePROJECLAIMS() {
//DriverManagerDataSource dataSourcePROJECLAIMS = new DriverManagerDataSource();
//dataSourcePROJECLAIMS.setDriverClassName(environment.getRequiredProperty("PE.jdbc.driverClassName"));
//dataSourcePROJECLAIMS.setUrl(environment.getRequiredProperty("PE.jdbc.url"));
//dataSourcePROJECLAIMS.setUsername(environment.getRequiredProperty("PE.jdbc.username"));
//dataSourcePROJECLAIMS.setPassword(environment.getRequiredProperty("PE.jdbc.password"));
////System.out.println("DATA SOURCE"+dataSourcePROJECLAIMS.toString());
//return dataSourcePROJECLAIMS;
//
//}
//private Properties fourthProperties() {
//	Properties properties = hibernateProperties();
//	// hibernate property
//	properties.put("PE.hibernate.dialect", environment.getRequiredProperty("PE.hibernate.dialect"));
//
//	return properties;
//}
//@Bean
//@Autowired
//@Qualifier("sessionFactoryPROJECLAIMS")
//public HibernateTransactionManager transactionMangerproj_eclaims(SessionFactory s) {
//	HibernateTransactionManager txManager = new HibernateTransactionManager();
//	txManager.setSessionFactory(s);
//	return txManager;
//
//}
//////////////////////////////////CLOUD CONNECTION END///////////////////////
	private Properties hibernateProperties() {
		Properties properties = new Properties();
		// hibernate property
		properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("spring.jpa.hibernate.ddl-auto"));
		properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));

		// connection pooling by cp
		properties.put("hibernate.c3p0.min_size", environment.getRequiredProperty("hibernate.c3p0.min_size"));
		properties.put("hibernate.c3p0.max_size", environment.getRequiredProperty("hibernate.c3p0.max_size"));
		properties.put("hibernate.c3p0.timeout", environment.getRequiredProperty("hibernate.c3p0.timeout"));
		properties.put("hibernate.c3p0.max_statements",
				environment.getRequiredProperty("hibernate.c3p0.max_statements"));
		properties.put("hibernate.c3p0.idle_test_period",
				environment.getRequiredProperty("hibernate.c3p0.idle_test_period"));

		return properties;
	}

	private Properties firstProperties() {
		Properties properties = hibernateProperties();
		// hibernate property
		properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));		

		return properties;
	}
	
	private Properties secondProperties() {
		Properties properties = hibernateProperties();
		// hibernate property
		properties.put("hibernate.dialect", environment.getRequiredProperty("cm.jdbc.hibernate.dialect"));		

		return properties;
	}
	private Properties thirdProperties() {
		Properties properties = hibernateProperties();
		// hibernate property
		properties.put("hibernate.dialect", environment.getRequiredProperty("ita.jdbc.hibernate.dialect"));		

		return properties;
	}
	
	
	
	@Bean
	@Primary
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory s) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(s);
		return txManager;
	}
	
//	@Bean
//	@Autowired
//	@Qualifier("sessionFactoryCM")
//	public HibernateTransactionManager transactionManagerass(SessionFactory s) {
//		HibernateTransactionManager txManager = new HibernateTransactionManager();
//		txManager.setSessionFactory(s);
//		return txManager;
//	}
//	@Bean
//	@Autowired
//	@Qualifier("sessionFactoryITAsset")
//	public HibernateTransactionManager transactionMangerItAsset(SessionFactory s)
//	{
//		HibernateTransactionManager txManager=new HibernateTransactionManager();
//		txManager.setSessionFactory(s);
//		return txManager;
//		
//	}
	
	@Bean
	public String setProperties() {

		System.out.println("inside setProperties####");

		ApplicationPropertyReader.QR_Code_Path = environment.getRequiredProperty("QR_Code_Path");

//		TCPPort.ATS_SERVER=environment.getRequiredProperty("ATS_SERVER");
//		TCPPort.ORC_IP=environment.getRequiredProperty("PARAMETER");
//		TCPPort.OS_PORT=environment.getRequiredProperty("OPERATING_SYSTEM");
//		TCPPort.FILE_PULL=environment.getRequiredProperty("FILE_PULL");
//		TCPPort.FILE_PUSH=environment.getRequiredProperty("FILE_PUSH");
		// TCPPort.ORC_IP=Integer.parseInt(environment.getRequiredProperty("ORC_IP"));
		// TCPPort.OS_PORT=Integer.parseInt(environment.getRequiredProperty("OS_PORT"));
		// TCPPort.FILE_PULL=Integer.parseInt(environment.getRequiredProperty("FILE_PULL"));
		// TCPPort.var_tcpPort=Integer.parseInt(environment.getRequiredProperty("var_tcpPort"));
		// TCPPort.patch_port=Integer.parseInt(environment.getRequiredProperty("patch_port"));
		return null;
	}
}
