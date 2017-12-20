package com.demo.service;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.domain.Employee;
import com.demo.dto.EmployeeDto;
import com.demo.repository.EmpRepository;

@Service
public class EmpService {
	@Autowired
	private EmpRepository empRepository;
	
	/**
	 * 
	 * @Description: 对员工信息进行新增操作  
	 * @throws
	 * @author yuanshihua
	 * @date 2017年12月18日
	 */
	public String insertEmp(EmployeeDto empDto) {
		String id = UUID.randomUUID().toString().replace("-", "");
		empDto.setId(id);
		empDto.setState("1");;
		Employee emp = new Employee();
		BeanUtils.copyProperties(empDto, emp);
		empRepository.save(emp);
		return "ok";
	}
	
	/**
	 * 
	 * @Description: 对员工信息进行修改
	 * @return String  
	 * @throws
	 * @author yuanshihua
	 * @date 2017年12月18日
	 */
	public String modifyEmp(EmployeeDto empDto) {
		Employee emp = new Employee();
		BeanUtils.copyProperties(empDto, emp);
		emp = empRepository.findOne(emp.getId());
		empRepository.save(emp);
		return "ok";
	}
	
	/**
	 * 
	 * @Description: 对员工信息进行删除
	 * @return EmployeeDto  
	 * @throws
	 * @author yuanshihua
	 * @date 2017年12月18日
	 */
	public EmployeeDto deleteEmp(String id) {
		Employee employee = empRepository.findOne(id);
		employee.setState("0");
		empRepository.save(employee);
		EmployeeDto empDto = new EmployeeDto();
		BeanUtils.copyProperties(employee, empDto);
		return empDto;
	}
	
	
}
