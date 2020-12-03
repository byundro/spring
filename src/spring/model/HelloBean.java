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

@Controller // spring-servlet.xml ��Ʈ�� ��û�� �޴´�.
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
		System.out.println("bean ������...");

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
		// DAO ȣ����� ó���� �Ѵ�.
		// ó���� ����� View�� ������.(Model.ui)
		// request.setAttribute();
		// session.setAttribute();
		// Model�ǰ��ó���� view�� �����ϱ����� ��ü. Java.util.Map���� �������.
		// view ���Ͽ��� ǥ����� ${ǥ�����}�� ����Ѵ�.
		
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
		mv.addObject("name", "java"); //���ް�
		mv.addObject("num", "01234");
		return mv;	
	}
}