package com.acadmi.notification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.acadmi.administrator.AdministratorVO;
import com.acadmi.member.MemberVO;

@SpringBootTest
public class NotificationDAOTest {

	@Autowired
	private NotificationDAO notificationDAO;
	
//	@Test
//	void getList() throws Exception {
//		
//		List<NotificationVO> ar = notificationDAO.getList();
//		assertNotEquals(0, ar.size());
//		
//	}
//	
//	@Test
//	void setNotification() throws Exception {
//		NotificationVO notificationVO = new NotificationVO();
//		
//		notificationVO.setNotificationMsg("dsdsds");
//		notificationVO.setNotificationKind(1);
//		int result = notificationDAO.setNotification(notificationVO);
//		assertNotEquals(0, result);
//	}
	
//	@Test
//	void getMemberList() throws Exception {
//		List<MemberVO> ar = notificationDAO.getMemberList();
//		assertEquals(9, ar.size());
//		
//	}
//	
//	@Test
//	void getAdministratorList() throws Exception {
//		MemberVO memberVO = new MemberVO();
//		memberVO.setCategory(1);
//		List<AdministratorVO> ar = notificationDAO.getAdministratorList(admi);
//		assertEquals(3, ar.size());
//		
//	}

	
}
