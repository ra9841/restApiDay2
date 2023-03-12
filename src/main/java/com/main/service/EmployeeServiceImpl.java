package com.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.main.dao.MagicDaoRunner;
import com.main.dto.EmployeeDto;
import com.main.entity.EmployeeEntity;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	MagicDaoRunner magicDaoRunner;

	//for show all
	@Override
	public List<EmployeeDto> show() {
		List<EmployeeEntity>employeeEntity=magicDaoRunner.findAll();
		List<EmployeeDto>employeeDtoList=new ArrayList<>();//blank
		
		for(EmployeeEntity employee:employeeEntity) {
			EmployeeDto employeeDto=new EmployeeDto();//blank
			BeanUtils.copyProperties(employee, employeeDto);
			employeeDtoList.add(employeeDto);
		}
		return employeeDtoList;
	}

	//for registration
	@Override
	public void register(EmployeeDto employeeDto) {
		EmployeeEntity employeeEntity=new EmployeeEntity();
		BeanUtils.copyProperties(employeeDto, employeeEntity);
	           magicDaoRunner.save(employeeEntity);
	}

	//for fetching data with help of primarykey
	@Override
	public EmployeeDto fetchRecord(int employeeId) {
		 Optional<EmployeeEntity>existEmployee=magicDaoRunner.findById(employeeId);
		 if(existEmployee.isPresent()) {
			 EmployeeEntity employeeEntity=existEmployee.get();
			 EmployeeDto employeeDto=new EmployeeDto();//blank
			 BeanUtils.copyProperties(employeeEntity, employeeDto);
			 return employeeDto;
		 }
		return null;
	}

	//for delete a record
	@Override
	public void deleteRecord(int employeeId) {
		magicDaoRunner.deleteById(employeeId);
		
	}

	//for updating employeeName
	@Override
	public EmployeeDto updateEmployeeName(int employeeId,String employeeName) {
		Optional<EmployeeEntity>optional=magicDaoRunner.findById(employeeId);
		if(optional.isPresent()) {
			EmployeeEntity employeeEntity=optional.get();
			employeeEntity.setEmployeeName(employeeName);//will save on db
			 EmployeeDto employeeDto=new EmployeeDto();//blank
			 BeanUtils.copyProperties(employeeEntity, employeeDto);
			 return employeeDto;
		}
		
		return null;
	}

}
