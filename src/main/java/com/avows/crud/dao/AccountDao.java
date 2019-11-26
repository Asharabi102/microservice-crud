package com.avows.crud.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.avows.crud.model.Account;

/**
 * @author ashar
 * Nov 25, 2019
 */
public interface AccountDao extends JpaRepository<Account, Long> {
	
	@Query(value= "SELECT * FROM avows.account a where a.email = :email", nativeQuery = true)
	public List<Account> getAccountsByEmail(@Param("email") String email);

}
