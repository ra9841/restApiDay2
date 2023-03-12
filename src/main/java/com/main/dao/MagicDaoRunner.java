package com.main.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.EmployeeEntity;



public interface MagicDaoRunner extends JpaRepository<EmployeeEntity,Integer>{

	

}
