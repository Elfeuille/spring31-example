package jp.fuzzy31u.spring31.example.service;

import jp.fuzzy31u.spring31.example.entity.dao.BankAccountDao;
import jp.fuzzy31u.spring31.example.entity.dto.BankAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	BankAccountDao bankAccountDao;

	public BankAccount getAccount(int id) {
		return new BankAccount();
	}

}
