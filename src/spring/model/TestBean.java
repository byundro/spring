package spring.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.model.service.DaoService;

@Controller
public class TestBean {
	
	@Autowired
	// 클래스명이 <bean id = "클래스명" > 역할을 하게 된다.
	// BoardDaoImpl => boardDaoImpl 로 적어준다 첫글자 소문자
	private DaoService board = null;
	
	@RequestMapping("/test/service.do")
	public String service() {
		System.out.println(board);
		return "";
	}
	
   // http://localhost:8080/spring/test/main.do
   @RequestMapping("/test/main.do")
   public String main() throws Exception{
      Class c = Class.forName("oracle.jdbc.driver.OracleDriver");
      Object cn = c.newInstance();
      System.out.println(cn);
      return "test/main";
   }
  
}