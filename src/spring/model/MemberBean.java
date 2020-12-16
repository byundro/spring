package spring.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ch11.logon.LogonDBBean;
import ch11.logon.LogonDataBean;
import spring.model.service.LogonDBService;
import spring.model.service.LogonDBServiceMybatis;

@Controller
@RequestMapping("/member/")
public class MemberBean {
	
	//@Autowired
	//private LogonDBBean memberDAO = null;
	
	@Autowired
	private LogonDBService memberDAO = null;
	
	@RequestMapping("main.do")
	public String main() {
		return "member/main";
	}
	@RequestMapping("inputForm.do")
	public String inputForm() {
		return "member/inputForm";
	}
	@RequestMapping(value="inputPro.do" , method=RequestMethod.POST)
	public String inputPro(LogonDataBean dto)throws Exception {
		memberDAO.insertMember(dto);
		return "member/inputPro";
	}
	
	// 매개변수 String id 를 LogonDataBean 으로 변경
	@RequestMapping("confirmId.do")
	public String confirmId(LogonDataBean member , Model model)throws Exception {
		int check = memberDAO.confirmId(member);
		model.addAttribute("check",check);
		model.addAttribute("id",member.getId());
		return "member/confirmId";
	}
	
	@RequestMapping("confirmId2.do")
	public @ResponseBody String confirmId2(LogonDataBean member , Model model)throws Exception {
		int check = memberDAO.confirmId(member);
		return check+"";
	}
	
	
	
	@RequestMapping("loginForm.do")
	public String loginForm() {
		return "member/loginForm";
	}
	
	// 매개변수 String id,passwd 를 LogonDataBean 으로 변경
	@RequestMapping("loginPro.do")
	public String loginPro(LogonDataBean member  , 
						   HttpSession session , Model model) throws Exception {
		int check = memberDAO.userCheck(member);
		if(check == 1) {
			session.setAttribute("memId", member.getId());
		}
		model.addAttribute("check", check);
		return "member/loginPro";
	}
	
	
	//-------------로그인후 사용가능-----------------------------------------------------
	// 메서드 이름앞   logon_ 붙여준다. 
	
	@RequestMapping("logout.do")
	public String logon_logout(HttpSession session) {	
		session.invalidate();
		return "member/logout";
	}
	
	@RequestMapping("modify.do")
	public String logon_modify() {
		return "member/modify";
	}
	
	@RequestMapping("modifyForm.do")
	public String logon_modifyForm(HttpSession session , Model model) throws Exception{
		
		String id = (String)session.getAttribute("memId");
		LogonDataBean c = memberDAO.getMember(id);
		model.addAttribute("c",c);
		return "member/modifyForm";
	}
	
	@RequestMapping("modifyPro.do")
	public String logon_modifyPro(LogonDataBean dto) throws Exception {
		memberDAO.updateMember(dto);
		return "member/modifyPro";
	}
	
	@RequestMapping("deleteForm.do")
	public String logon_deleteForm( ) throws Exception {
		return "member/deleteForm";
	}
	
	@RequestMapping("deletePro.do")
	public String logon_deletePro(HttpSession session , LogonDataBean member ,Model model) throws Exception {
	    String id = (String)session.getAttribute("memId");
	    member.setId(id);
	    int check = memberDAO.deleteMember(member);
		if(check==1){
			session.invalidate();
		}
		model.addAttribute("check",check);
		
		return "member/deletePro";
	}
}

















