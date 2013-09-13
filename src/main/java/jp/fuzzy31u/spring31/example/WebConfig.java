package jp.fuzzy31u.spring31.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
// @ImportResource({"classpath:/spring/*.xml"})
@ComponentScan(basePackages = "jp.fuzzy31u.spring31.example")
@MapperScan("jp.fuzzy31u.spring31.example.entity.dao")
@EnableWebMvc
@EnableTransactionManagement
public class WebConfig {

}
