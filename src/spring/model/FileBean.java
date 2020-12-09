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
		// �Ķ���ͷ� ���޵� ���ε带 �޴´�.
		MultipartFile mf = request.getFile("save"); // �������ϰ�ü
		String fileName = mf.getOriginalFilename(); //���ϸ�
		dto.setOrgname(fileName);
		int num = fileServiceImpl.fileInsert(dto);
	
		//���ϸ��� ������ (��.) ��ġã��
		String ext = fileName.substring(fileName.lastIndexOf("."));
		String saveName = "file_"+num+ext;
		// System.out.println("Ȯ����"+ext);
		// DB savename update
		dto.setNum(num);
		dto.setSavename(saveName);
		
		fileServiceImpl.fileUpdate(dto); // sql Update ����
		
		
		String savePath = "D:\\eclipse-workspace\\spring\\WebContent\\save\\"; //���ε� ���ϰ��
		File saveFile = new File(savePath+saveName); // ������ġ ��ü
		try {
			mf.transferTo(saveFile); //��������(�Ϸ�)!!
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println(savePath);
		
		return "1207/upload";
	}
	// request ��ü
	// ������
	// �ִ� ���ε� ũ��
	// ���ڵ�
	// �����̸� �ߺ�����
	/*
	 * �����̸��� Ȯ���� ����
	 * ex) test.java.png
	 */
	
	

}
