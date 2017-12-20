package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.App;
import com.demo.domain.Department;
import com.demo.dto.DepartmentDto;
import com.demo.dto.EmployeeDto;
import com.demo.service.DeptService;
import com.demo.service.EmpService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=App.class)
public class DeptTest {
	@Autowired
	private DeptService service;
	
	/**
	 * 
	 * @Description: 新增测试 
	 * @throws
	 * @author yuanshihua
	 * @date 2017年12月18日
	 */
	@Test
	public void testInsert() {
		DepartmentDto deptDto = new DepartmentDto();
		DepartmentDto deptD = new DepartmentDto();
		deptD.setId("003");
		deptDto.setDepartment(deptD);
		deptDto.setDeptDesc("智慧城市与云服务");
		deptDto.setDeptName("智慧城市与云服务");
	}
	
}
