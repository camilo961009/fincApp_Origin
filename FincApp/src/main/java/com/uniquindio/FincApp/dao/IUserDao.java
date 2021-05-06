package com.uniquindio.FincApp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uniquindio.FincApp.model.User;

@Repository
public interface IUserDao extends CrudRepository<User, Long>{

}
