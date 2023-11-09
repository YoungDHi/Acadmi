package com.acadmi.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.acadmi.student.StudentVO;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
class MemberTest {
	@Autowired
	private PasswordEncoder passwordEncoder;
	
//	@Autowired
//	private MemberDAO memberDAO;
//	
//	@Test
//	void setStudentUpdate() throws Exception {
//		log.info("Update Test");
//		
//		StudentVO studentVO = new StudentVO();
//		
//		int result=memberDAO.setStudentUpdate(studentVO);
//		
//		assertEquals(1,result);
//		
//		
//	}
	
	

//	@Test
//	void test() {
//		String result = passwordEncoder.encode("yang1234");
//		System.out.println("result {}" + result);
//	}

}
