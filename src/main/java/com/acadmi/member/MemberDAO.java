package com.acadmi.member;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.acadmi.administrator.AdministratorVO;
import com.acadmi.college.CollegeVO;
import com.acadmi.department.DepartmentVO;
import com.acadmi.professor.ProfessorVO;
import com.acadmi.student.StudentVO;

@Mapper
public interface MemberDAO {

//	Member
	public MemberVO getLogin(MemberVO memberVO) throws Exception;
	public int setLogout(MemberVO memberVO) throws Exception;
	public int setRoleAdd(Map<String, Object> map) throws Exception;
	public MemberVO getFindPw(MemberVO memberVO) throws Exception;
	public int setPwUpdate(MemberVO memberVO) throws Exception;
	public MemberVO getFirstEmail(MemberVO memberVO) throws Exception;
	public int setEnabledUpdate(MemberVO memberVO) throws Exception;
	
	public MemberFilesVO getFileDetail(MemberFilesVO memberFilesVO) throws Exception;
	public int setFileAdd(MemberFilesVO memberFilesVO) throws Exception;
	public int setFileUpdate(MemberFilesVO memberFilesVO) throws Exception;
	public int setFileDelete(MemberFilesVO memberFilesVO) throws Exception;
	
	public String getName(Map<String, String> map) throws Exception;
	
//	========================================================================================
	
	public DepartmentVO getStudent(StudentVO studentVO) throws Exception;
	public DepartmentVO getProfessor(ProfessorVO professorVO) throws Exception;
	public DepartmentVO getAdministrator(AdministratorVO administratorVO) throws Exception;
	
//	=========================================================================================
	
	public int setStudentUpdate(MemberVO memberVO) throws Exception;
	public int setProfessorUpdate(MemberVO memberVO) throws Exception;
	public int setAdministratorUpdate(MemberVO memberVO) throws Exception;

}
