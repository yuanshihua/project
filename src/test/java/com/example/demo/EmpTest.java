package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.App;
import com.demo.dto.EmployeeDto;
import com.demo.service.EmpService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=App.class)
public class EmpTest {
	@Autowired
	private EmpService service;
	
	/**
	 * 
	 * @Description: 新增测试 
	 * @author yuanshihua
	 * @date 2017年12月18日
	 */
	@Test
	public void testInsert() {
		EmployeeDto empDto = new EmployeeDto();
		empDto.setEmpName("李四");
		empDto.setLoginName("lisi");
		service.insertEmp(empDto);
	}
	
	/**
	 * 
	 * @Description: 修改测试 
	 * @throws
	 * @author yuanshihua
	 * @date 2017年12月18日
	 */
	@Test
	public void testModify() {
		EmployeeDto empDto = new EmployeeDto();
		empDto.setId("f7ddba4bfa564a779b63ddc4a57bfa76");
		empDto.setEmpName("王二");
		empDto.setLoginName("wanger");
		service.modifyEmp(empDto);
	}
	
	/**
	 * @Description: 测试删除  
	 * @throws
	 * @author yuanshihua
	 * @date 2017年12月18日
	 */
	@Test
	public void testDelete() {
		String id = "f7ddba4bfa564a779b63ddc4a57bfa76";
		EmployeeDto empDto = service.deleteEmp(id);
		System.out.println(empDto);
	}
}
