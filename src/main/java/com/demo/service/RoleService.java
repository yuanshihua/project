package com.demo.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.demo.domain.Role;
import com.demo.domain.User;
import com.demo.dto.RoleDto;
import com.demo.repository.RoleRepository;

/**
 * 
 * 类名称：RoleService 类描述： 对角色进行增删改查 创建人：yuanshihua 创建时间：2017年12月11日 下午12:42:57
 * 
 * @version
 */
@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;

	/**
	 * @Description: 删除角色
	 * @param id
	 * @return String
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws @author
	 *             yuanshihua
	 * @date 2017年12月8日
	 */
	public String deleteRole(String id) throws IllegalAccessException, InvocationTargetException {
		RoleDto rDto = new RoleDto();
		//rDto.setId(id);
		Role r = new Role();
		BeanUtils.copyProperties(rDto, r);
		r = roleRepository.findOne(r.getId());
		r.setActive(0);
		roleRepository.saveAndFlush(r);
		return "success";
	}

	/**
	 * 
	 * @Description: 新增角色信息，如果角色已经存在则修改指定角色的信息
	 * @return String
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @author yuanshihua
	 * @date 2017年12月8日
	 */
	public String modifyRole(RoleDto r) throws IllegalAccessException, InvocationTargetException {
		Role role = new Role();
		BeanUtils.copyProperties(r, role);
		Calendar date = Calendar.getInstance();
		if (role.getId() != null) {
			if (roleRepository.findOne(role.getId()) != null) {
				// UserDetails userDetails =
				// (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				// role.setUpdator(userDetails.getUsername());
				role.setUpdateTime(date.getTime());
				role.setActive(1);
			} else {
				role.setCreateTime(date.getTime());
				role.setActive(1);
				// UserDetails userDetail = (UserDetails)
				// SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				// role.setCreator(userDetail.getUsername());
			}
		} else {
			String id = UUID.randomUUID().toString().replace("-", "");
			role.setId(id);
			role.setCreateTime(date.getTime());
			role.setActive(1);
			// UserDetails userDetail = (UserDetails)
			// SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			// role.setCreator(userDetail.getUsername());
		}
		roleRepository.saveAndFlush(role);
		return "success";
	}

	
}
