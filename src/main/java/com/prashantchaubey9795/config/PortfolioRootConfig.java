package com.prashantchaubey9795.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

/**
 * Beans which would be accessible to whole project
 * Create by: Prashant Chaubey
 */
@ComponentScan
@EnableJpaRepositories(value = "com.prashantchaubey9795.repositories")
public class PortfolioRootConfig {

    /**
     * Convert Jpa and Jpa implementation specific exception messages to Spring specific.
     *
     * @return
     */
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslationPostProcessor() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    /**
     * Genearte a Entity manager factory bean.
     *
     * @param dataSource       - it will contain details of database.
     * @param jpaVendorAdapter - it will contain details of the Jpa implementor.
     * @return
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
        emfb.setDataSource(dataSource);
        emfb.setJpaVendorAdapter(jpaVendorAdapter);
        emfb.setPackagesToScan("com.prashantchaubey9795.entities");
        return emfb;
    }

    /**
     * Details of the database.
     *
     * @return
     */
    @Bean
    @Profile("local")
    public DataSource dataSourceLocal() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/portfolio");
        dataSource.setUsername("postgres");
        dataSource.setPassword("password");
        dataSource.setDriverClassName("org.postgresql.Driver");
        return dataSource;
    }

    /**
     * Details of the database.
     *
     * @return
     */
    @Bean
    @Profile("prod")
    public DataSource dataSourceProd() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/portfolio");
        dataSource.setUsername("pc");
        dataSource.setPassword("9451379336");
        dataSource.setDriverClassName("org.postgresql.Driver");
        return dataSource;
    }

    /**
     * Details of the Jpa Implementation.
     *
     * @return
     */
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabase(Database.POSTGRESQL);
        jpaVendorAdapter.setShowSql(false);
        jpaVendorAdapter.setGenerateDdl(true);
        jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
        return jpaVendorAdapter;
    }

    /**
     * for @Transactional to work
     *
     * @param dataSource
     * @return
     */
    @Bean
    public JpaTransactionManager transactionManager(DataSource dataSource) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }

}
