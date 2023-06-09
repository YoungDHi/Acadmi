package com.acadmi.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.acadmi.board.BoardVO;
import com.acadmi.lecture.LectureVO;
import com.acadmi.notification.NotificationService;
import com.acadmi.notification.NotificationVO;
import com.acadmi.util.FileVO;
import com.acadmi.util.Pagination;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/notice/*")
@Slf4j
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private NotificationService notificationService;
	
	@ModelAttribute("board")
	public String getBoardName() {
		return "notice";
	}
	
	@GetMapping("list")
	public ModelAndView getList(Pagination pagination) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		List<BoardVO> ar = noticeService.getList(pagination);
		
		mv.addObject("list", ar);
		mv.setViewName("board/list");
		
		return mv;
	}
	
	@GetMapping("importantList")
	public ModelAndView getImportantList(NoticeVO noticeVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		List<BoardVO> ar = noticeService.getImportantList(noticeVO);
		
		mv.addObject("importantList", ar);
		mv.setViewName("board/importantList");
		
		return mv;
	}
	
	@GetMapping("add")
	public ModelAndView setInsert(NoticeVO noticeVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("board/add");
		
		return mv;
	}
	
	@PostMapping("add")
	public ModelAndView setInsert(NoticeVO noticeVO, MultipartFile [] addfiles) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		int result = noticeService.setInsert(noticeVO, addfiles);
		mv.setViewName("redirect:./list");
		
		if(noticeVO.getImportant() == null) {
			return mv;
		} else if(noticeVO.getImportant() == 1) {
			
		}
		
		return mv;
	}
	
	@GetMapping("detail")
	public ModelAndView getDetail(NoticeVO noticeVO, NotificationVO notificationVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		noticeVO = (NoticeVO)noticeService.getDetail(noticeVO);
		
		int result = noticeService.setNoticeHit(noticeVO);
		
		if(notificationVO.getNotificationNum() != null) {
			result = notificationService.setDelete(notificationVO);
		}
		
		mv.addObject("boardVO", noticeVO);
		mv.setViewName("board/detail");
		
		
		return mv;
	}
	
	@GetMapping("fileDown")
	public ModelAndView getFileDown(FileVO fileVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		fileVO = noticeService.getFileDetail(fileVO);
		
		mv.addObject("fileVO", fileVO);
		mv.setViewName("fileManager");
		
		return mv;
	}
	
	@GetMapping("update")
	public ModelAndView setUpdate(NoticeVO noticeVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		noticeVO = (NoticeVO)noticeService.getDetail(noticeVO);
		
		mv.addObject("dto", noticeVO);
		mv.setViewName("board/update");
		
		return mv;
	}
	
	@PostMapping("update")
	public ModelAndView setUpdate(ModelAndView mv, NoticeVO noticeVO, MultipartFile [] addfiles) throws Exception {
		
		int result = noticeService.setUpdate(noticeVO, addfiles);
		
		mv.setViewName("redirect:./list");
		
		return mv;
	}
	
	@GetMapping("delete")
	public ModelAndView setDelete(BoardVO boardVO, NotificationVO notificationVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		int result = noticeService.setDelete(boardVO);
		
		result = notificationService.setBoardNotificationDelete(notificationVO);
		
		
		mv.setViewName("redirect:./list");
		
		return mv;
	}
	
	@PostMapping("boardFileDelete")
	public ModelAndView setBoardFileDelete(FileVO fileVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		int result = noticeService.setBoardFileDelete(fileVO);
		
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		
		return mv;
	}
	
	//홈 공지사항 목록
	@GetMapping("homeNotice")
	public ModelAndView getHomeNoticeList(Pagination pagination, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		pagination.setPerPage(5L);
		List<BoardVO> ar = noticeService.getList(pagination);
		
		mv.addObject("list", ar);
		mv.setViewName("professor/homeNotice");
		return mv;
	}
	
	//홈 학생 공지사항 목록
	@GetMapping("homeStudentNotice")
	public ModelAndView getNoticeList(Pagination pagination, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		pagination.setPerPage(5L);
		List<BoardVO> ar = noticeService.getList(pagination);
		
		mv.addObject("list", ar);
		mv.setViewName("student/homeNotice");
		return mv;
	}
	
	
	
	//홈 중요 공지사항 목록
	@GetMapping("homeImportant")
	public ModelAndView getHomeImportantList(NoticeVO noticeVO, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		noticeVO.setImportant(1L);
		List<BoardVO> ar = noticeService.getImportantList(noticeVO);
		mv.addObject("list", ar);
		mv.setViewName("professor/homeImportant");
		return mv;
	}

}
