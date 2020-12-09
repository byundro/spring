package spring.model.service;

import java.util.List;

import spring.model.FileDTO;

public interface FileService {
	// 값을 입력 하고 글번호를 리턴한다.
	public int fileInsert(FileDTO dto)throws Exception;
	public FileDTO selectNum(int num)throws Exception;
	public List selectId(String id)throws Exception;
	
	public void fileUpdate(FileDTO dto)throws Exception;
	public void fileDelete(int num)throws Exception;
	public List selectAll() throws Exception;
}
