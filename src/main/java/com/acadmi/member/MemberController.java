package com.acadmi.member;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.acadmi.administrator.AdministratorService;
import com.acadmi.administrator.AdministratorVO;
import com.acadmi.department.DepartmentVO;
import com.acadmi.professor.ProfessorVO;
import com.acadmi.student.StudentService;
import com.acadmi.student.StudentVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member/*")
public class MemberController {

//	Member
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("login")
	public ModelAndView getLogin(HttpSession session) throws Exception{
		 ModelAndView mv = new ModelAndView();
	     
		 MemberVO memberVO = new MemberVO();
		 
	     Object object = session.getAttribute("SPRING_SECURITY_CONTEXT");
	      
	     if(object == null) {
	        mv.setViewName("member/login");
	     } 
	     else {
	        mv.setViewName("redirect:/");
	     } 

	     return mv;
	}
	   
	   @GetMapping("findPw")
		public ModelAndView getFindPw(MemberVO memberVO) throws Exception {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("member/findPw");
			return mv;
		}
	   
	   @PostMapping("findPw")
		public ModelAndView getFindPw(@Valid MemberVO memberVO, BindingResult bindingResult) throws Exception{
			ModelAndView mv = new ModelAndView();
			boolean check = memberService.getFindPw(memberVO, bindingResult);
			if(check) {
				mv.setViewName("member/findPw");
				return mv;
			}
			mv.setViewName("member/findPwEmailCheck");
			return mv;
		}
	   
	   @GetMapping("firstEmail")
		public ModelAndView getFirstEmail(MemberVO memberVO) throws Exception {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("member/firstEmail");
			return mv;
		}
	   
	   @PostMapping("firstEmail")
		public ModelAndView getFirstEmail(@Valid MemberVO memberVO, BindingResult bindingResult) throws Exception{
			ModelAndView mv = new ModelAndView();
			boolean check = memberService.getFirstEmail(memberVO, bindingResult);
			if(check) {
				mv.setViewName("member/firstEmail");
				return mv;
			}
			mv.setViewName("member/firstEmailCheck");
			return mv;
		}
	   
	   @PostMapping("fileDelete")
	   public ModelAndView setFileDelete(MemberFilesVO memberFilesVO) throws Exception{
		   ModelAndView mv = new ModelAndView();
		   
		   int result = memberService.setFileDelete(memberFilesVO);
		   
		   mv.addObject("result", result);
		   mv.setViewName("member/fileDelete");
		   
		   return mv;
	   }
	   

//	   ========================================멤버 권한에 따른 마이페이지========================================
	   
	   @GetMapping("studentPage")
	   public ModelAndView getStudent(StudentVO studentVO) throws Exception {
	      ModelAndView mv = new ModelAndView();
	      
	      DepartmentVO departmentVO =  memberService.getStudent(studentVO);
	     
	      mv.addObject("departmentVO", departmentVO);
		  mv.setViewName("member/studentPage");
		     
		  return mv;
	   }
	   
	   @GetMapping("professorPage")
	   public ModelAndView getProfessor(ProfessorVO professorVO) throws Exception {
		   ModelAndView mv = new ModelAndView();
		     
		   DepartmentVO departmentVO =  memberService.getProfessor(professorVO);
		   
		   mv.addObject("departmentVO", departmentVO);
		   mv.setViewName("member/professorPage");
	      
	      return mv;
	   }
	   
	   @GetMapping("administratorPage")
	   public ModelAndView getAdministrator(AdministratorVO administratorVO) throws Exception {
		   ModelAndView mv = new ModelAndView();
		     
		   DepartmentVO departmentVO =  memberService.getAdministrator(administratorVO);
		   
		   mv.addObject("departmentVO", departmentVO);
		   mv.setViewName("member/administratorPage");
	      
	      return mv;
	   }
	   
	   
//	   ==================================studentUpdate==================================
	   
	   
	   @GetMapping("studentUpdate")
	   public ModelAndView getStudentUpdate(StudentVO studentVO) throws Exception {
	       ModelAndView mv = new ModelAndView();

	       DepartmentVO departmentVO = memberService.getStudent(studentVO);
	       
	       mv.addObject("departmentVO", departmentVO);
	       mv.setViewName("member/studentUpdate");

	       return mv;
	   }

	   @PostMapping("studentUpdate")
	   public ModelAndView setStudentUpdate(String username, StudentVO studentVO, ModelAndView mv, MultipartFile addfiles, MemberVO memberVO) throws Exception {
	       
	       int result = memberService.setStudentUpdate(studentVO, addfiles, memberVO);
	       
	       mv.setViewName("redirect:./studentPage?username=" + username);

	       return mv;
	   }


	   
//	   ==================================professorUpdate==================================
	   
	   @GetMapping("professorUpdate")
	   public ModelAndView setProfessorUpdate(ProfessorVO professorVO) throws Exception {
		   ModelAndView mv = new ModelAndView();
		     
		   DepartmentVO departmentVO =  memberService.getProfessor(professorVO);
		   
		   mv.addObject("departmentVO", departmentVO);
		   mv.setViewName("member/professorUpdate");
	      
	      return mv;
	   }
	   
	   @PostMapping("professorUpdate")
	   public ModelAndView setProfessorUpdate(String username, ProfessorVO professorVO, ModelAndView mv, MultipartFile addfiles, MemberVO memberVO) throws Exception {
		     
		   int result = memberService.setProfessorUpdate(professorVO, addfiles, memberVO);
		   
	       mv.setViewName("redirect:./professorPage?username=" + username);
	      
	      return mv;
	   }
	   
	   
//	   ==================================administratorUpdate==================================
	   
	   
	   @GetMapping("administratorUpdate")
	   public ModelAndView setAdministratorUpdate(AdministratorVO administratorVO) throws Exception {
		   ModelAndView mv = new ModelAndView();
		     
		   DepartmentVO departmentVO =  memberService.getAdministrator(administratorVO);
		   
		   mv.addObject("departmentVO", departmentVO);
		   mv.setViewName("member/administratorUpdate");
	      
	      return mv;
	   }
	   
	   @PostMapping("administratorUpdate")
	   public ModelAndView setAdministratorUpdate(String username, AdministratorVO administratorVO, ModelAndView mv, MultipartFile addfiles, MemberVO memberVO) throws Exception {
		     
	       int result = memberService.setAdministratorUpdate(administratorVO, addfiles, memberVO);

	       mv.setViewName("redirect:./administratorPage?username=" + username);
	      
	      return mv;
	   }
	   
}
