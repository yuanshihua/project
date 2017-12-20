package com.demo.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.demo.domain.User;
import com.demo.dto.UserDto;
import com.demo.repository.UserRepository;

/**
 * 类名称：UserService 类描述： 对用户信息进行增删改查 创建人：yuanshihua 创建时间：2017年12月8日 下午4:09:19
 * 
 * @version
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * 
	 * @Description: 传入一个user对象，如果存在此user，将user对象插入数据库中。否则编辑user的信息
	 * @return String
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
		@author yuanshihua
	 * @date 2017年12月8日
	 */
	public String modifyUser(UserDto uDto) throws IllegalAccessException, InvocationTargetException {
		User u = new User();
		BeanUtils.copyProperties(uDto, u);
		Calendar date = Calendar.getInstance();
		if (u.getId() != null) {
			if (userRepository.findOne(u.getId()) != null) {
				u.setActive(1);
				u.setUpdateTime(date.getTime());
				// UserDetails userDetails = (UserDetails)
				// SecurityContextHolder.getContext().getAuthentication()
				// .getPrincipal();
				// String updator = userDetails.getUsername();
				// u.setUpdator(updator);
				u.setUpdator("updator");
			} else {
				// UserDetails userDetails = (UserDetails)
				// SecurityContextHolder.getContext().getAuthentication()
				// .getPrincipal();
				// u.setCreator(userDetails.getUsername());
				u.setCreateTime(date.getTime());
				u.setCreator("creator");
				u.setActive(1);
			}
		} else {// id不存在时
			String id = UUID.randomUUID().toString().replace("-", "");
			System.out.println(id);
			u.setId(id);
			// UserDetails userDetails = (UserDetails)
			// SecurityContextHolder.getContext().getAuthentication()
			// .getPrincipal();
			// u.setCreator(userDetails.getUsername());
			u.setCreateTime(date.getTime());
			u.setActive(1);
		}
		userRepository.saveAndFlush(u);
		return "success";
	}

	/**
	 * 
	 * @Description: 传入主键-id，根据id删除记录
	 * @param id
	 * @return String
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws @author
	 *             yuanshihua
	 * @date 2017年12月8日
	 */
	public String deleteUser(String id) throws IllegalAccessException, InvocationTargetException {
		UserDto uDto = new UserDto();
		uDto.setId(id);
		User u = new User();
		BeanUtils.copyProperties(uDto, u);
		u = userRepository.findOne(u.getId());
		u.setActive(0);
		userRepository.saveAndFlush(u);
		return "success";
	}

	/**
	 * 
	 * // * @Description: 用户列表查询
	 * 
	 * @param page
	 * @param pageSize
	 * @param orderMaps
	 * @param filters
	 * @return Map
	 * @throws @author
	 *             yuanshihua
	 * @date 2017年12月11日
	 */
	public Map getUserPage(Map searchParameters) {
		Map map = new HashMap();
		int page = 0;
		int pageSize = 10;
		Page<User> pageContent;
		if (searchParameters != null && searchParameters.size() > 0 && searchParameters.get("page") != null) {
			page = Integer.parseInt(searchParameters.get("page").toString()) - 1;
		}
		if (searchParameters != null && searchParameters.size() > 0 && searchParameters.get("pageSize") != null) {
			pageSize = Integer.parseInt(searchParameters.get("pageSize").toString());
		}
		if (pageSize < 1)
			pageSize = 1;
		if (pageSize > 100)
			pageSize = 100;
		List<Map> orderMaps = (List<Map>) searchParameters.get("sort");
		List<Order> orders = new ArrayList<Order>();
		if (orderMaps != null) {
			for (Map m : orderMaps) {
				if (m.get("field") == null)
					continue;
				String field = m.get("field").toString();
				if (!StringUtils.isEmpty(field)) {
					String dir = m.get("dir").toString();
					if ("DESC".equalsIgnoreCase(dir)) {
						orders.add(new Order(Direction.DESC, field));
					} else {
						orders.add(new Order(Direction.ASC, field));
					}
				}
			}
		}
		PageRequest pageable;
		if (orders.size() > 0) {
			pageable = new PageRequest(page, pageSize, new Sort(orders));
		} else {
			Sort s = new Sort(Direction.ASC, "id");
			pageable = new PageRequest(page, pageSize, s);
		}
		Map filter = (Map) searchParameters.get("filter");
		List<Map> filters = (List<Map>) filter.get("filters");
		if (filters != null) {
			Specification<User> spec = new Specification<User>() {
				@Override
				public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					List<Predicate> pl = new ArrayList<Predicate>();
					// for (String key : filters.keySet()) {
					// String value = (String) filters.get(key);
					// if ("enabled".equalsIgnoreCase(key)) {
					// if ("true".equalsIgnoreCase(value)) {
					// pl.add(cb.equal(root.get(key), true));
					// } else if ("false".equalsIgnoreCase(value)) {
					// pl.add(cb.equal(root.get(key), false));
					// }
					// } else if ("code".equalsIgnoreCase(key)) {
					// if (value.length() > 0)
					// pl.add(cb.like(root.<String>get(key), value + "%"));
					// } else if ("name".equalsIgnoreCase(key)) {
					// if (value.length() > 0)
					// pl.add(cb.like(root.get(key), value));
					// }
					// }
					for (Map map2 : filters) {
						Set<String> entrySet = map2.keySet();
						for (String key : entrySet) {
							String value = (String) map2.get(key);
							if (!"field".equalsIgnoreCase(key)) {
								if ("value".equalsIgnoreCase(key)) {
									if (value.length() > 0) {
										pl.add(cb.like(root.<String>get(key), value + "%"));
									}
								}
//								if ("age".equalsIgnoreCase(key)) {
//									if (value.length() > 0) {
//										pl.add(cb.equal(root.get(key), true));
//									}
//								}
							}
						}
					}
					return cb.and(pl.toArray(new Predicate[0]));
				}
			};
			pageContent = userRepository.findAll(spec, pageable);
		} else {
			pageContent = userRepository.findAll(pageable);
		}
		map.put("total", pageContent.getTotalElements());
		map.put("users", accountPage2Dto(pageContent));
		return map;
	}

	/**
	 * 
	 * @Description: 将查询到的users数据转化成userDto再存List中
	 * @param pageContent
	 * @return List<UserDto>
	 * @throws @author
	 *             yuanshihua
	 * @date 2017年12月11日
	 */
	public List<UserDto> accountPage2Dto(Page<User> pageContent) {
		List<User> content = pageContent.getContent();
		List<UserDto> userDtos = new ArrayList<UserDto>();
		for (User user : content) {
			UserDto userDto = toDto(user);
			userDtos.add(userDto);
		}
		return userDtos;
	}

	/**
	 * 
	 * @Description:User转化为Dto的方法
	 * @param user
	 * @return UserDto
	 * @throws @author
	 *             yuanshihua
	 * @date 2017年12月11日
	 */
	public UserDto toDto(User user) {
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(user, userDto);
		return userDto;
	}

}
