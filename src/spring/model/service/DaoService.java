package spring.model.service;

import java.util.List;

public interface DaoService {
	// Dao ������ �ʿ��� ������ �ۼ��Ѵ�.
	// Dao = ���� / dbms / ���� ... �� �����ҹ���� �����Ѵ�.
	public static final String dbConnect = "jdbc/orcl";
	
	// ��ü ����� ����
	public List selectAll()throws Exception;
	
	public Object selectOne(String id)throws Exception;
}
