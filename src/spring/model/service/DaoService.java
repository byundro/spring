package spring.model.service;

import java.util.List;

public interface DaoService {
	// Dao 구현에 필요한 내용을 작성한다.
	// Dao = 파일 / dbms / 엑셀 ... 등 저장할방법을 구현한다.
	public static final String dbConnect = "jdbc/orcl";
	
	// 전체 저장된 정보
	public List selectAll()throws Exception;
	
	// 하나의 정보 가져오기
	public Object selectOne(String id)throws Exception;
}
