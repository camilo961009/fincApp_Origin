package com.uniquindio.FincApp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uniquindio.FincApp.model.Cultivation;

public interface ICultivationDao extends CrudRepository<Cultivation, Long>{

}
