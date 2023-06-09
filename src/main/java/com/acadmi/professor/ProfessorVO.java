package com.acadmi.professor;

import java.sql.Date;
import java.util.List;

import com.acadmi.department.DepartmentVO;
import com.acadmi.member.MemberVO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfessorVO extends MemberVO{
	private Integer deptNum;
	private String name;
	private String professorRoom;
	private String phone;
	private Date birth;
	private String address;
	private String addressDetail;
	private Integer status;
}
	