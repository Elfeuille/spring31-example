package jp.fuzzy31u.spring31.example;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "jp.fuzzy31u.spring31.example.service")
@MapperScan("jp.fuzzy31u.spring31.example.entity.dao")
@EnableTransactionManagement
public class MyBatisTestConfig {

	// @Autowired
	// private DataSource dataSource;

	// DataSources for Test
	@Bean
	public TransactionAwareDataSourceProxy testDataSource() {
		return new TransactionAwareDataSourceProxy(basicDataSource());
	}

	@Bean(destroyMethod = "close")
	public DataSource basicDataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		basicDataSource.setUrl("jdbc:mysql://localhost:3306/crowdsourcing_test");
		basicDataSource.setUsername("root");
		basicDataSource.setPassword("");
		return basicDataSource;
	}

	// SessionFactory
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(basicDataSource());
		return sessionFactory.getObject();
	}

	// Transaction
	@Bean
	public PlatformTransactionManager transactionManager() throws ClassNotFoundException {
		return new DataSourceTransactionManager(basicDataSource());
	}

}