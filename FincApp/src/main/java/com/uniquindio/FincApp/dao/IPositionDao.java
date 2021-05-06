package com.uniquindio.FincApp.dao;

import org.springframework.data.repository.CrudRepository;

import com.uniquindio.FincApp.model.Position;

public interface IPositionDao extends CrudRepository<Position, Long>{

}
