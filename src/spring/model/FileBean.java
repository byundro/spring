package spring.model;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import spring.model.service.FileService;

@Controller
@RequestMapping("/file/")

public class FileBean {
	
	@Autowired
	private FileService fileServiceImpl = null;
	
	@RequestMapping("form.do")
	public String form() {
		return "1207/form";
	}
	
	@RequestMapping("upload.do")
	public String upload(MultipartHttpServletRequest request ,  FileDTO dto)throws Exception {
		// 파라미터로 전달된 업로드를 받는다.
		MultipartFile mf = request.getFile("save"); // 원본파일객체
		String fileName = mf.getOriginalFilename(); //파일명
		dto.setOrgname(fileName);
		int num = fileServiceImpl.fileInsert(dto);
	
		//파일명에서 마지막 (점.) 위치찾기
		String ext = fileName.substring(fileName.lastIndexOf("."));
		String saveName = "file_"+num+ext;
		// System.out.println("확장자"+ext);
		// DB savename update
		dto.setNum(num);
		dto.setSavename(saveName);
		
		fileServiceImpl.fileUpdate(dto); // sql Update 진행
		
		
		String savePath = "D:\\eclipse-workspace\\spring\\WebContent\\save\\"; //업로드 파일경로
		File saveFile = new File(savePath+saveName); // 저장위치 객체
		try {
			mf.transferTo(saveFile); //파일저장(완료)!!
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println(savePath);
		
		return "1207/upload";
	}
	// request 객체
	// 저장경로
	// 최대 업로드 크기
	// 인코딩
	// 파일이름 중복방지
	/*
	 * 파일이름과 확장자 구분
	 * ex) test.java.png
	 */
	
	

}
