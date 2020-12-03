package spring.model;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // spring-servlet.xml 컨트롤 요청을 받는다.
public class HelloBean {
	
	@Autowired private Date day=null;
	
	/*@Autowired private Dto dto=null;
	 *  
	 * @Autowired private Dto dto2=null;
	 * 
	 * @Autowired private Dto dto3=null;
	 */
	
	/* @Autowired private Dto dto4=null; */
	  
	@Autowired private Dto dto5=null;
	
	@RequestMapping("/hello.do")
	public String aaaa() {
		System.out.println("bean 실행중...");

		return "1130/hello";
	}
	
	
	@RequestMapping("/pro.do")
	public String pro(Dto dto,String name, int num, 
			HttpServletRequest request, 
			HttpSession session,
			HttpServletResponse response,
			Model model) {
		/*
		 * System.out.println(request); System.out.println(session);
		 * System.out.println(response);
		 */
		// DAO 호출등의 처리를 한다.
		// 처리된 결과를 View로 보낸다.(Model.ui)
		// request.setAttribute();
		// session.setAttribute();
		// Model의결과처리를 view로 전달하기위한 객체. Java.util.Map으로 만들어짐.
		// view 파일에서 표현언어 ${표현언어}로 사용한다.
		
			model.addAttribute("name", name);
			model.addAttribute("num", num);
			model.addAttribute("dto", dto);
			model.addAttribute("day", day);
		return "1130/pro";
	}
	@RequestMapping("/pro2.do")
	public ModelAndView pro2() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("1130/pro"); //view path
		mv.addObject("name", "java"); //전달값
		mv.addObject("num", "01234");
		return mv;	
	}
}