package spring.model.service;

import java.util.List;

public interface DaoService {
	// Dao ������ �ʿ��� ������ �ۼ��Ѵ�. 
	// Dao = ���� / DBMS / ���� .. �� �����Ҽ��ִ� ����� �����Ѵ�. 	
	public static final String dbConnect = "jdbc/orcl";
	
	// ��ü���� �������� 
	public List selectAll()throws Exception;
	
	// �ϳ��� ���� �������� 
	public Object selectOne(String id)throws Exception;
}








