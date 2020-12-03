package spring.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestBean {
   // http://localhost:8080/spring/test/main.do
   @RequestMapping("/test/main.do")
   public String main() throws Exception{
      Class c = Class.forName("oracle.jdbc.driver.OracleDriver");
      Object cn = c.newInstance();
      System.out.println(cn);
      return "test/main";
   }
}