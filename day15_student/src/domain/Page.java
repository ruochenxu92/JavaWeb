package domain;

import java.util.List;

public class Page {
	private List list;
	
	private final int pagesize = 10;
	private int pagenum;
	
	private int totalrecords;
	private int startindex;

	private int startpage;
	private int endpage;

	private int lastpage;
	
	/***************************************************************************************/
	public Page(int pagenum, int totalrecords){
		this.pagenum = pagenum;
		this.totalrecords = totalrecords;
		
		this.startindex = pagenum * pagesize - pagesize;
		
		this.startpage = pagenum - 4;
		
		this.endpage = pagenum + 5;
		
		if( totalrecords % pagesize == 0 ){
			this.lastpage = totalrecords / this.pagesize;
		}else{
			this.lastpage = totalrecords / this.pagesize + 1;
		}
		
		if(this.startpage < 1){
			this.startpage = 1;
		}
		if(this.endpage > this.lastpage ){
			this.endpage = this.lastpage;
		}
	}
	
	
	
	
	public int getStartpage() {
		return startpage;
	}
	
	public void setStartpage(int startpage) {
		this.startpage = startpage;
	}
	
	public int getEndpage() {
		return endpage;
	}
	
	public void setEndpage(int endpage) {
		this.endpage = endpage;
	}
	
	public int getLastpage() {
		return lastpage;
	}
	
	public void setLastpage(int lastpage) {
		this.lastpage = lastpage;
	}
	
	public int getPagesize() {
		return pagesize;
	}
	
	public int getPagenum() {
		return pagenum;
	}
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}
	public int getTotalrecords() {
		return totalrecords;
	}
	public void setTotalrecords(int totalrecords) {
		this.totalrecords = totalrecords;
	}
	public int getStartindex() {
		return startindex;
	}
	public void setStartindex(int startindex) {
		this.startindex = startindex;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
}
