package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.StudentDao;
import domain.Page;

public class BusinessService {
	private StudentDao dao = new StudentDao();
	
	public int getTotalRecord(){
		return dao.getTotalRecords();
	}
	
	public Page getPageData(int pagenum){
		Page page = new Page(pagenum, getTotalRecord());
		
			
		int startIndex = page.getStartindex();
		
		int pagesize = page.getPagesize();
		
		page.setList(dao.getPageData(startIndex, pagesize));		
		
		return page;	
	}
	
	
	
	
	
	
}
