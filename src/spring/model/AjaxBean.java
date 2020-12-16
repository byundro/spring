package spring.model;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxBean {
	@RequestMapping("date.do")
	public String date() {
		return "1216/date";
	}
	
	@RequestMapping("time.do")
	public String time(Model model) {
		model.addAttribute("time" , new Date());
		return "1216/time";
	}
	
	@RequestMapping("time2.do")
	public @ResponseBody String time2(Model model) {
		Date d = new Date();
		// 문자열 - 숫자 / 영문 
		return d.toString();
	}
}










