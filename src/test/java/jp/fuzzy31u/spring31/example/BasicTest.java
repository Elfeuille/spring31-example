package jp.fuzzy31u.spring31.example;

import static org.junit.Assert.assertEquals;
import jp.fuzzy31u.spring31.example.service.UserService;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BasicTestConfig.class})
public class BasicTest {

	@Autowired
	UserService service;

	// @Bean
	@Test
	public void testBeanDefinition() throws Exception {
		assertEquals("kamiya", service.getUserName());
	}

	// @Profile
	@Test
	public void testSetSystemProperty() {
		System.setProperty("spring.profiles.active", "dev");

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(DataSourceDev.class, DataSourceProduct.class);
		context.refresh();

		BasicDataSource dataSource = context.getBean("dataSource", BasicDataSource.class);
		assertEquals("dev_user", dataSource.getUsername());

		context.close();
	}

	@Test
	public void testSetEnvironmentActiveProfile() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles("dev");
		context.register(DataSourceDev.class, DataSourceProduct.class);
		context.refresh();

		BasicDataSource dataSource = context.getBean("dataSource", BasicDataSource.class);
		assertEquals("dev_user", dataSource.getUsername());

		context.close();
	}

}
