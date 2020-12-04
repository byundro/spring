package spring.model.service;

import java.sql.Connection;
import java.util.List;

public interface BoardDaoService {
	
	// DB 연결 정보를 정의한다.!!
	// tomcat 서버 context.xml 커넥션풀 셋팅 정보 활용
	// oracle / mysql 선택
	// DB url 프로젝트 매뉴얼 참조
	// DB 서버 매주 금요일 23~01시 점검
	public Connection getConnection() throws Exception;
	
	// 데이터 저장이 목적
	// num , writer , subject , content 필수
	// num / writer 유효성검사 코드 작성
	public void insertArticle(BoardDataBean article) throws Exception;
	public int getArticleCount() throws Exception;
	public List getArticles(int start, int end) throws Exception;
	public BoardDataBean getArticle(int num) throws Exception;
	public BoardDataBean updateGetArticle(int num) throws Exception;
	public int updateArticle(BoardDataBean article) throws Exception;
	public int deleteArticle(int num, String passwd) throws Exception;

}
