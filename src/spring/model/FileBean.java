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
      // 파라미터로 전달된 업로드 파일을 받는다. 
      MultipartFile mf = request.getFile("save");  // 원본파일객체
      String fileName = mf.getOriginalFilename();  // 파일명 
      dto.setOrgname(fileName);  // 파일의 원본이름을 DTO 추가 
      int num = FileServiceImpl.fileInsert(dto);
      
      // 파일명에서 확장자 찾기 
      String ext = fileName.substring(fileName.lastIndexOf("."));
      String saveName = "file_"+num+ext;
      
      // DB savename update / 글번호와 저장이름을 DTO 대입  
      dto.setNum(num);
      dto.setSavename(saveName);
      
      FileServiceImpl.fileUpdate(dto);  // sql Update 진행 
      
      
      //String savePath = "D:\\eclipse-workspace\\spring\\WebContent\\save\\";  // 업로드파일 저장경로 
      String savePath = request.getRealPath("save");
      File saveFile = new File(savePath+"\\"+saveName); // 저장위치 객체 
      try {
         mf.transferTo(saveFile);  // 파일 저장 (완료)!!
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