package com.avows.crud.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avows.crud.dao.AccountDao;
import com.avows.crud.model.Account;

/**
 * @author ashar Nov 26, 2019
 */
@RestController
@RequestMapping(value = "/accounts")
public class AccountRestController {

	@Autowired
	private AccountDao accountDao;

	@GetMapping("/{id}")
	public Account getAccount(@PathVariable("id") Long id) {
		return accountDao.findById(id).get();
	}

	@PostMapping
	public Account add(@RequestBody Account account) {
		return accountDao.save(account);
	}

	@PutMapping
	public Account update(@RequestBody Account account) {
		return accountDao.save(account);
	}

	@PatchMapping
	public Account patch(@RequestBody Account account) {
		return accountDao.save(account);
	}

	@DeleteMapping
	public void delete(@RequestBody Account account) {
		accountDao.delete(account);
	}

	@GetMapping
	public List<Account> getAllAccounts() {
		return accountDao.findAll();
	}

}
