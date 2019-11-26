package com.avows.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avows.crud.model.User;

/**
 * @author ashar
 * Nov 25, 2019
 */
public interface UserDao extends JpaRepository<User, Long> {

}
