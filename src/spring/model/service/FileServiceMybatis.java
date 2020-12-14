package spring.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.model.FileDTO;

@Service("fileDAO")
public class FileServiceMybatis implements FileService {
	
	   
	@Autowired
	private SqlSessionTemplate dao = null;
	

	@Override
	public int fileInsert(FileDTO dto) throws Exception {

		return 0;
	}

	@Override
	public FileDTO selectNum(int num) throws Exception {

		return null;
	}

	@Override
	public List selectId(String id) throws Exception {
		return dao.selectList("test.selectId", id);
	}

	@Override
	public void fileUpdate(FileDTO dto) throws Exception {

		
	}

	@Override
	public void fileDelete(int num) throws Exception {
		
	}

	@Override
	public List selectAll() throws Exception { 
		// selectList - select 결과가 여러개 일때
		// selectOne - select 결과가 하나일때
		// SQL.xml 의 id속성으로 호출
		return dao.selectList("test.selectAll");
	}

	@Override
	public String selectId(int num) throws Exception {
		//				호출할 id   , parameterType 대입값
		return dao.selectOne("test.selectOne" , num); 		
	}

	@Override
	public String selectFile(FileDTO dto) throws Exception {
		return dao.selectOne("test.selectFile" , dto);
	}

}
