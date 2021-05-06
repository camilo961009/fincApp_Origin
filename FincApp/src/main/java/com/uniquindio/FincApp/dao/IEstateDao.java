package com.uniquindio.FincApp.dao;

import org.springframework.data.repository.CrudRepository;

import com.uniquindio.FincApp.model.Estate;

public interface IEstateDao extends CrudRepository<Estate, Long>{

}
