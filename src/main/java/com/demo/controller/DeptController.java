package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DeptController {
	
	@RequestMapping(value="/tree",method=RequestMethod.POST)
	public String treeView() {
		return "treeview";
	}
}
