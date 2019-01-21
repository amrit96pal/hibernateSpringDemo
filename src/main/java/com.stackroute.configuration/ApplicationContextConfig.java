package com.stackroute.configuration;


import com.stackroute.model.UserInformation;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class ApplicationContextConfig {


    @Bean
    @Autowired
    public DataSource getDataSource(){
        BasicDataSource basicDataSource= new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/login");
        basicDataSource.setUsername("amrit");
        basicDataSource.setPassword("root");
        return basicDataSource;
    }



    @Bean
    @Autowired
    public LocalSessionFactoryBean getSessionFactory(DataSource basicDataSource) throws IOException {
        LocalSessionFactoryBean sessionfactory= new LocalSessionFactoryBean();
        sessionfactory.setDataSource(basicDataSource);
        Properties proper= new Properties();
        proper.put("hibernate.show_sql", "true");
        proper.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        proper.put("hibernate.hbm2ddl.auto", "update");
        sessionfactory.setAnnotatedClasses(UserInformation.class);
        sessionfactory.setHibernateProperties(proper);
        sessionfactory.afterPropertiesSet();
        return sessionfactory;
    }


    @Bean
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){

        HibernateTransactionManager hibernateTransactionManager= new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(sessionFactory);
        return hibernateTransactionManager;
    }
}
