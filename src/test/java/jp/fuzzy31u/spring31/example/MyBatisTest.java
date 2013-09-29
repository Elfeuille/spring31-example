package jp.fuzzy31u.spring31.example;

import java.sql.SQLException;

import javax.sql.DataSource;

import jp.fuzzy31u.spring31.example.service.BankAccountService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyBatisTestConfig.class})
@Transactional
@TransactionConfiguration
public class MyBatisTest {

	@Autowired
	DataSource dataSource;

	@Autowired
	BankAccountService service;

	@Test
	public void testMyBatisIntegration() throws SQLException {
		dataSource.getConnection();

		Assert.assertNotNull(service.getAccount(1));
	}
}
