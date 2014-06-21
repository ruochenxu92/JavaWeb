package web1;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class forEach2 extends SimpleTagSupport {
	private Object items;
	private String var;
	private Collection collection;

	public Object getItems() {
		return items;
	}
	
	public void setItems(Object items) {
		this.items = items;
		if(items instanceof Map){
			Map map = (Map) items;
			collection =  map.entrySet();
		}
		if(items instanceof Collection){
			collection= (Collection) items;
		}
		
			
		if(items.getClass().isArray()){
			this.collection = new ArrayList();
			int count = Array.getLength(items);
			for(int i = 0; i<count;i++ ){
				Object o = Array.get(items, i);
				collection.add(o);
			}
		}
		
		
		
		
		
//		if(items instanceof Object[]){
//			Object obj[]= (Object[]) items;
//			collection = Arrays.asList(obj);			
//		}
//		if(items instanceof int[]){
//			int[] tmp = (int[]) items;
//			List list = new ArrayList();
//			for(int i : tmp){
//				list.add(i);
//			}
//			collection = list;
//		}
				
	}
	
	public String getVar() {
		return var;
	}
	
	public void setVar(String var) {
		this.var = var;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		Iterator it = collection.iterator();
		while(it.hasNext()){
			Object value = it.next();
			this.getJspContext().setAttribute(var, value);
			this.getJspBody().invoke(null);
		}
	}
}
