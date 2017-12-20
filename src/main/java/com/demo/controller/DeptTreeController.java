package com.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.demo.domain.Employee;
import com.demo.service.DeptService;
import com.demo.service.DeptService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class DeptTreeController {

	@Autowired
	DeptService deptService;
	@Autowired
	ObjectMapper om;

	@RequestMapping("/deptTree")
	public String deptTree() {
		return "dept_tree";
	}

	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String treeView() {
		return "home";
	}

	@RequestMapping("/getData")
	@ResponseBody
	public String getData() {
		List<String> trees = new ArrayList<>();
		String data = "";
		try {
			data = deptService.findDeptTree("ddc6c2a6b6834cb1966678b516d2e7ff");
			trees.add(data);
			trees.add(deptService.findDeptTree("684ee37dbc564ee1b176dfcb845adfa3"));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return trees.toString();
	}

	@RequestMapping("/getEmps")
	@ResponseBody
	public String getEmps(String id) throws JsonProcessingException {
		List<Employee> list = deptService.findById(id);
		return om.writeValueAsString(list);
	}

}
