package com.uniquindio.FincApp.dao;

import org.springframework.data.repository.CrudRepository;

import com.uniquindio.FincApp.model.Employee;

public interface IEmployeeDao extends CrudRepository<Employee, Long>{

}
