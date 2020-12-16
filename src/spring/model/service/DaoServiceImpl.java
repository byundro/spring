package spring.model.service;
import java.sql.Connection;


import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.stereotype.Service;

@Service
public class DaoServiceImpl implements DaoService {
	
	private Connection getConnection() throws Exception {
		 Context initCtx = new InitialContext();
		 Context envCtx = (Context) initCtx.lookup("java:comp/env");
		 DataSource ds = (DataSource)envCtx.lookup(DaoService.dbConnect);
		 return ds.getConnection();
	}	
	public List selectAll() throws Exception {
		
		return null;
	}

	public Object selectOne(String id) throws Exception {
		
		return null;
	}
}







