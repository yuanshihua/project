package com.demo.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.domain.Menu;
import com.demo.dto.MenuDto;
import com.demo.repository.MenuRepository;

@Service
public class MenuService {
	
	@Autowired
	private MenuRepository menuRepository;
	
	/**
	 * @Description: 如果该数据不存在就新增，存在就修改
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException String  
	 * @author yuanshihua
	 * @date 2017年12月10日
	 */
	public String modify(MenuDto menuDto) throws IllegalAccessException, InvocationTargetException {
		Menu menu = new Menu();
		BeanUtils.copyProperties(menuDto, menu);
		Calendar date = Calendar.getInstance();
//		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(menu.getId()!=null) {
			if(menuRepository.findOne(menu.getId())!=null) {
				menu.setUpdateTime(date.getTime());
				menu.setUpdator("updator");
				menu.setActive(1);
//			menu.setUpdator(userDetails.getUsername());
			}else {
				menu.setCreateTime(date.getTime());
//				menu.setCreator(userDetails.getUsername());
				menu.setCreator("creator");
				menu.setActive(1);
			}
		}else {
			String id = UUID.randomUUID().toString().replace("-", "");
			menu.setId(id);
			menu.setCreateTime(date.getTime());
//			menu.setCreator(userDetails.getUsername());
			menu.setCreator("creator");
			menu.setActive(1);
		}
		menuRepository.saveAndFlush(menu);
		return "success";
	}
		
	/**
	 * 
	 * @Description: 对指定id的数据进行逻辑删除
	 * @param id
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException String  
	 * @throws
	 * @author yuanshihua
	 * @date 2017年12月10日
	 */
	public String delete(String id) throws IllegalAccessException, InvocationTargetException {
		MenuDto menuDto = new MenuDto();
		menuDto.setId(id);
		Menu menu = new Menu();
		BeanUtils.copyProperties(menuDto, menu);
		menu = menuRepository.findOne(menu.getId());
		menu.setActive(0);
		menuRepository.saveAndFlush(menu);
		return "success";
	}
}
