package jp.fuzzy31u.spring31.example;

import jp.fuzzy31u.spring31.example.service.UserService;
import jp.fuzzy31u.spring31.example.service.UserServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "jp.fuzzy31u.spring31.example.service")
// @MapperScan("jp.fuzzy31u.spring31.example.entity.dao")
// @EnableTransactionManagement
public class TestConfig {
	// BeanDefinition
	@Bean
	public UserService userService() {
		return new UserServiceImpl();
	}
}