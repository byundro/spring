package spring.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.model.service.DaoService;

@Controller
public class TestBean {
	
	@Autowired
	// Ŭ�������� <bean id = "Ŭ������" > ������ �ϰ� �ȴ�.
	// BoardDaoImpl => boardDaoImpl �� �����ش� ù���� �ҹ���
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