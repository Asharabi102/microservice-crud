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
import com.avows.crud.dao.UserDao;
import com.avows.crud.model.Account;
import com.avows.crud.model.User;

/**
 * @author ashar Nov 26, 2019
 */
@RestController
@RequestMapping(value = "/users")
public class UserRestController {

	@Autowired
	private UserDao userDao;

	@Autowired
	private AccountDao accountDao;

	@GetMapping("/{id}")
	public User getUser(@PathVariable("id") Long id) {
		User user = userDao.findById(id).get();
		if (user != null) {
			List<Account> accountList = accountDao.getAccountsByEmail(user.getEmail());
			user.setAccounts(accountList);
		}

		return user;
	}

	@PostMapping
	public User add(@RequestBody User user) {
		return userDao.save(user);
	}

	@PutMapping
	public User update(@RequestBody User user) {
		return userDao.save(user);
	}

	@PatchMapping
	public User patch(@RequestBody User user) {
		return userDao.save(user);
	}

	@DeleteMapping
	public void delete(@RequestBody User user) {
		userDao.delete(user);
	}

	@GetMapping
	public List<User> getAllUsers() {
		List<User> userList = userDao.findAll();
		if (userList != null && !userList.isEmpty()) {
			for (User user : userList) {
				List<Account> accountList = accountDao.getAccountsByEmail(user.getEmail());
				user.setAccounts(accountList);
			}
		}
		return userList;
	}

}
