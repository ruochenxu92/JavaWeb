package web1;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class otherwise extends SimpleTagSupport {
	
	@Override
	public void doTag() throws JspException, IOException {
		simple7 parent = (simple7) this.getParent();
		if(!parent.isDO()){
			this.getJspBody().invoke(null);
		}
		
		
		
	}
	
	
	
	
}
