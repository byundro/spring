package spring.model;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import spring.model.service.FileService;

@Controller
@RequestMapping("/file/")
public class FileBean {
   
   @Autowired
   private FileService FileServiceImpl = null;
   
   @RequestMapping("form.do")
   public String form() {
      return "1207/form";
   }
   
   @RequestMapping("upload.do")
   public String upload(MultipartHttpServletRequest request,FileDTO dto)throws Exception {
      // �Ķ���ͷ� ���޵� ���ε� ������ �޴´�. 
      MultipartFile mf = request.getFile("save");  // �������ϰ�ü
      String fileName = mf.getOriginalFilename();  // ���ϸ� 
      dto.setOrgname(fileName);  // ������ �����̸��� DTO �߰� 
      int num = FileServiceImpl.fileInsert(dto);
      
      // ���ϸ��� Ȯ���� ã�� 
      String ext = fileName.substring(fileName.lastIndexOf("."));
      String saveName = "file_"+num+ext;
      
      // DB savename update / �۹�ȣ�� �����̸��� DTO ����  
      dto.setNum(num);
      dto.setSavename(saveName);
      
      FileServiceImpl.fileUpdate(dto);  // sql Update ���� 
      
      
      //String savePath = "D:\\eclipse-workspace\\spring\\WebContent\\save\\";  // ���ε����� ������ 
      String savePath = request.getRealPath("save");
      File saveFile = new File(savePath+"\\"+saveName); // ������ġ ��ü 
      try {
         mf.transferTo(saveFile);  // ���� ���� (�Ϸ�)!!
      }catch(Exception e) {
         e.printStackTrace();
      }
      return "redirect:/file/list.do";
   }
   
   @RequestMapping("list.do")
   public String list(Model model)throws Exception {
      
      model.addAttribute("list", FileServiceImpl.selectAll());
      
      return "1207/list";
   }
   
   @RequestMapping("down.do")
   public ModelAndView down(HttpServletRequest request , String file ) {
	   String path = request.getRealPath("save")+"//"+file;
	   File f = new File(path);
	   ModelAndView mv = new ModelAndView("download" , "downloadFile" , f);
	   								// bean id   , parameterName,	   
	   return mv;   
   }

}