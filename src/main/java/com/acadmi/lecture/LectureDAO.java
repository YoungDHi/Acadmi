package com.acadmi.lecture;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.acadmi.college.CollegeVO;
import com.acadmi.department.DepartmentVO;
import com.acadmi.period.PeriodVO;
import com.acadmi.student.StudentVO;
import com.acadmi.syllabus.ClassVO;
import com.acadmi.syllabus.SyllabusVO;

@Mapper
public interface LectureDAO {

	//메인 강의 목록
	public List<LectureVO> getMainLectureList(LectureVO lectureVO) throws Exception;
	//강의 목록
	public List<LectureVO> getLectureList(LectureVO lectureVO) throws Exception;
	//단과대학 목록
	public List<CollegeVO> getCollegeList(CollegeVO collegeVO) throws Exception;
	//학과 목록
	public List<DepartmentVO> getDepartmentList(DepartmentVO departmentVO) throws Exception;
	//기간 목록
	public List<PeriodVO> getSemesterList(PeriodVO periodVO) throws Exception;
	
	//강의 정보
	public LectureVO getLectureDetail(LectureVO lectureVO) throws Exception;
	//교수 정보
	public LectureVO getLectureProfessor(LectureVO lectureVO) throws Exception;
	//참여자 정보
	public List<StudentVO> getLectureAttendee(LectureVO lectureVO) throws Exception;
	//계획서 정보
	public LectureVO getSyllabusDetail(LectureVO lectureVO) throws Exception;
	public List<ClassVO> getSyllabusClass(LectureVO lectureVO) throws Exception;
	
	//강의
	public int setLectureAdd(LectureVO lectureVO) throws Exception;
	public int setTemporaryAdd(LectureVO lectureVO) throws Exception;
	public int setLectureUpdate(LectureVO lectureVO) throws Exception;
	public int setTemporaryUpdate(LectureVO lectureVO) throws Exception;
	public int setLectureDelete(LectureVO lectureVO) throws Exception;
	
	//계획서
	public int getSyllabusExists(LectureVO lectureVO) throws Exception;
	public int setSyllabusAdd(SyllabusVO syllabusVO) throws Exception;
	public int setClassAdd(ClassVO classVO) throws Exception;
	public int setSyllabusUpdate(SyllabusVO syllabusVO) throws Exception;
	public int setClassUpdate(ClassVO classVO) throws Exception;
	

	
	
	
	
	
}