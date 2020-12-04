package spring.model.service;

import java.sql.Connection;
import java.util.List;

public interface BoardDaoService {
	
	// DB ���� ������ �����Ѵ�.!!
	// tomcat ���� context.xml Ŀ�ؼ�Ǯ ���� ���� Ȱ��
	// oracle / mysql ����
	// DB url ������Ʈ �Ŵ��� ����
	// DB ���� ���� �ݿ��� 23~01�� ����
	public Connection getConnection() throws Exception;
	
	// ������ ������ ����
	// num , writer , subject , content �ʼ�
	// num / writer ��ȿ���˻� �ڵ� �ۼ�
	public void insertArticle(BoardDataBean article) throws Exception;
	public int getArticleCount() throws Exception;
	public List getArticles(int start, int end) throws Exception;
	public BoardDataBean getArticle(int num) throws Exception;
	public BoardDataBean updateGetArticle(int num) throws Exception;
	public int updateArticle(BoardDataBean article) throws Exception;
	public int deleteArticle(int num, String passwd) throws Exception;

}
