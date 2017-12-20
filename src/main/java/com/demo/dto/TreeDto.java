package com.demo.dto;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.FetchType;

import com.demo.domain.Department;

import lombok.Data;

@Data
public class TreeDto {
	private String text;
	private String href;
	@Basic(fetch=FetchType.EAGER)
	private List<TreeDto> nodes;
}
