package com.acadmi.chat;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.acadmi.util.Pagination;

@SpringBootTest
@Rollback(true)
public class chatDAOTest {
	
	@Autowired
	private ChatDAO chatDAO;
	
//	@Test
//	public void getChatListTest() throws Exception {
//		
//		Pagination pagination = new Pagination();
//		pagination.setUsername("20200002");
//		List<ChatRoomVO> ar = chatDAO.getChatRoomList(pagination);
//		assertNotEquals(0, ar);
//		
//	}

}
