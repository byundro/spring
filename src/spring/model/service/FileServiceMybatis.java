package spring.model.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.model.FileDTO;

@Service("fileDAO")
public class FileServiceMybatis implements FileService{

	@Autowired
	private SqlSessionTemplate dao = null;

	@Override
	public int fileInsert(FileDTO dto) throws Exception {
		
		return dao.insert("test.insertFile", dto);
	}

	@Override
	public FileDTO selectNum(int num) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List selectId(String id) throws Exception {
		return dao.selectList("test.selectId",id);
	}

	@Override
	public void fileUpdate(FileDTO dto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fileDelete(int num) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List selectAll() throws Exception {
		// selectList - select결과 여러개일때.. 
		// selectOne - select결과 하나일때.. 
		
		// 		SQL.xml 의 id속성으로 호출
		return dao.selectList("test.selectAll");
	}

	@Override
	public String selectId(int num) throws Exception {
		return dao.selectOne("test.selectOne" , num);
	}

	@Override
	public String selectFile(FileDTO dto) throws Exception {
		// return dao.selectOne("test.selectFile" , dto);
		
		Map map = new HashMap();
		map.put("mid", "aaa");  // id
		map.put("mnum",14);		// num
		
		return dao.selectOne("test.selectMap", map);
	}

	@Override
	public int selectCount() throws Exception {
		return dao.selectOne("test.selectCount");
	}

}












