package com.acadmi.member;

import java.security.SecureRandom;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.acadmi.administrator.AdministratorDAO;
import com.acadmi.administrator.AdministratorVO;
import com.acadmi.department.DepartmentVO;
import com.acadmi.professor.ProfessorVO;
import com.acadmi.student.StudentVO;
import com.acadmi.util.FileManager;
import com.acadmi.util.FileVO;
import com.acadmi.util.MailManager;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional(rollbackFor = Exception.class)
public class MemberService implements UserDetailsService{
	
//	Member
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Value("${app.upload.member}")
	private String path;
	
	@Autowired
	private MailManager mailManager;
	
	@Autowired
	private FileManager fileManager;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public MemberVO getLogin(MemberVO memberVO) throws Exception{
		return memberDAO.getLogin(memberVO);
	}
	
	public int setLogout(MemberVO memberVO) throws Exception{
		return memberDAO.setLogout(memberVO);
	}
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
	
		MemberVO memberVO = new MemberVO();
		MemberFilesVO memberFilesVO = new MemberFilesVO();
		memberVO.setUsername(username);
		
		try {
			memberVO = memberDAO.getLogin(memberVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return memberVO;
	}
	
	public boolean getFindPw(MemberVO memberVO, BindingResult bindingResult) throws Exception {
		boolean result = false;
		
		result = bindingResult.hasErrors();
		
		if(memberDAO.getFindPw(memberVO) != null) {
			String charaters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
			SecureRandom random = new SecureRandom();
			StringBuffer sb = new StringBuffer(6);
			for(int i = 0;i<6;i++) {
				sb.append(charaters.charAt(random.nextInt(charaters.length())));
			}
			String password = sb.toString();
			mailManager.send(memberVO.getEmail(), "임시 비밀번호 발급", "임시비밀번호는 " + password + "입니다." + " 다시 로그인 시도하세요.");
			memberVO.setPassword(passwordEncoder.encode(password));
			memberDAO.setPwUpdate(memberVO);

		} else {
			bindingResult.rejectValue("email", "member.username.email");
			result = true;
		}
		
		return result;
		
	}
	
	public boolean getFirstEmail(MemberVO memberVO, BindingResult bindingResult) throws Exception {
		boolean result = false;
		
		result = bindingResult.hasErrors();

		if(!memberVO.isEnabled()) {
			
			String link = "http://localhost/member/login";
			String emailCheck = "<html><body><p>링크를 클릭하세요: <a href=\"" + link + "\">최초 이메일 인증</a></p></body></html>";
			
			
			mailManager.send(memberVO.getEmail(), "이메일 인증", "이메일 인증을 완료하려면 다음 링크를 클릭하세요: " + emailCheck);
			
			memberVO.setEnabled(true);
			memberDAO.setEnabledUpdate(memberVO);

		} else {
			bindingResult.rejectValue("email", "member.username.email");
			result = true;		
		}
		
		return result;
	}
	
	public int setFileDelete(MemberFilesVO memberFilesVO) throws Exception{
		return memberDAO.setFileDelete(memberFilesVO);
	}
	
	
//	======================================================================================================================
	
	public DepartmentVO getStudent(StudentVO studentVO) throws Exception {
		
		return memberDAO.getStudent(studentVO);
	}
	
	public DepartmentVO getProfessor(ProfessorVO professorVO) throws Exception {
		
		return memberDAO.getProfessor(professorVO);
	}

	public DepartmentVO getAdministrator(AdministratorVO administratorVO) throws Exception {
	
		return memberDAO.getAdministrator(administratorVO);
	}
	
	
//	======================================================================================================================
	
	
	public int setStudentUpdate(StudentVO studentVO, MultipartFile multipartFile, MemberVO memberVO) throws Exception{
		int result = memberDAO.setStudentUpdate(studentVO);
			
		if(memberVO.getPassword() != null && memberVO.getPassword().length() > 0) {
			memberVO.setPassword(passwordEncoder.encode(memberVO.getPassword()));
			memberDAO.setPwUpdate(memberVO);
			
		}
		
			if(multipartFile != null) {
				String fileName = fileManager.saveFile(path, multipartFile);
				MemberFilesVO memberFilesVO = new MemberFilesVO();
				memberFilesVO.setUsername(studentVO.getUsername());
				memberFilesVO = memberDAO.getFileDetail(memberFilesVO);
			
				
				if(memberFilesVO == null) {
					memberFilesVO = new MemberFilesVO();
					memberFilesVO.setUsername(studentVO.getUsername());
					memberFilesVO.setFileName(fileName);
					memberFilesVO.setOriName(multipartFile.getOriginalFilename());
					result = memberDAO.setFileAdd(memberFilesVO);	
				}
				else {
					memberFilesVO.setUsername(studentVO.getUsername());
					memberFilesVO.setFileName(fileName);
					memberFilesVO.setOriName(multipartFile.getOriginalFilename());
					result = memberDAO.setFileUpdate(memberFilesVO);
				}
			}
			
		return result;		
		    
	}
	
	public int setProfessorUpdate(ProfessorVO professorVO, MultipartFile multipartFile, MemberVO memberVO) throws Exception{
		int result = memberDAO.setProfessorUpdate(professorVO);
		
		if(memberVO.getPassword() != null && memberVO.getPassword().length() > 0) {
			memberVO.setPassword(passwordEncoder.encode(memberVO.getPassword()));
			memberDAO.setPwUpdate(memberVO);
		}
		
			if(multipartFile != null) {
				String fileName = fileManager.saveFile(path, multipartFile);
				MemberFilesVO memberFilesVO = new MemberFilesVO();
				memberFilesVO.setUsername(professorVO.getUsername());
				memberFilesVO = memberDAO.getFileDetail(memberFilesVO);
			
				
				if(memberFilesVO == null) {
					memberFilesVO = new MemberFilesVO();
					memberFilesVO.setUsername(professorVO.getUsername());
					memberFilesVO.setFileName(fileName);
					memberFilesVO.setOriName(multipartFile.getOriginalFilename());
					result = memberDAO.setFileAdd(memberFilesVO);	
				}
				else {
					memberFilesVO.setUsername(professorVO.getUsername());
					memberFilesVO.setFileName(fileName);
					memberFilesVO.setOriName(multipartFile.getOriginalFilename());
					result = memberDAO.setFileUpdate(memberFilesVO);
				}
			}
		return result;
	}
	
	public int setAdministratorUpdate(AdministratorVO administratorVO, MultipartFile multipartFile, MemberVO memberVO) throws Exception{
		int result = memberDAO.setAdministratorUpdate(administratorVO);
		
		if(memberVO.getPassword() != null && memberVO.getPassword().length() > 0) {
			memberVO.setPassword(passwordEncoder.encode(memberVO.getPassword()));
			memberDAO.setPwUpdate(memberVO);
		}
		
			if(multipartFile != null) {
				String fileName = fileManager.saveFile(path, multipartFile);
				MemberFilesVO memberFilesVO = new MemberFilesVO();
				memberFilesVO.setUsername(administratorVO.getUsername());
				memberFilesVO = memberDAO.getFileDetail(memberFilesVO);
			
				
				if(memberFilesVO == null) {
					memberFilesVO = new MemberFilesVO();
					memberFilesVO.setUsername(administratorVO.getUsername());
					memberFilesVO.setFileName(fileName);
					memberFilesVO.setOriName(multipartFile.getOriginalFilename());
					result = memberDAO.setFileAdd(memberFilesVO);	
				}
				else {
					memberFilesVO.setUsername(administratorVO.getUsername());
					memberFilesVO.setFileName(fileName);
					memberFilesVO.setOriName(multipartFile.getOriginalFilename());
	//				log.info("oriname : {}", memberFilesVO.getUsername());
					result = memberDAO.setFileUpdate(memberFilesVO);
				}
			}
		return result;
	}
	
}
