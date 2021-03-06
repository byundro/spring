package spring.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.model.service.DaoService;
import spring.model.service.TestService;

@Controller
@RequestMapping("/test/")
public class TestBean {

	@Autowired
	private TestService testDAO = null;
	
	// http://localhost:8080/spring/test/main.do?num=10&id=aaa
	
	@RequestMapping("main.do")
	public String main(FileDTO dto , Model model)throws Exception {
		model.addAttribute("testDAO" , testDAO.select(dto));
		return "1210/main";
	}
	
	// num / id 파라미터 전송후 .. id 수정확인
	@RequestMapping("update.do")
	public String update(FileDTO dto)throws Exception {
		testDAO.update(dto);
		return "1210/main";
	}
	
	@RequestMapping("select.do")
	public String selectFor(Model model)throws Exception{
		List list = new ArrayList();
		list.add(10);list.add(11);list.add(12);list.add(13);

		list = testDAO.select(list);
		model.addAttribute("list", list);
		
		return "1210/select";
	}
}











