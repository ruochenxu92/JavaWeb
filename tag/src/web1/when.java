package web1;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class when extends SimpleTagSupport {
	private boolean test;
	
	public void setTest(boolean test) {
		this.test = test;
	}

	@Override
	public void doTag() throws JspException, IOException {
		simple7 parent = (simple7) this.getParent();
		if(test || parent.isDO()){
			this.getJspBody().invoke(null);
			parent.setDO(true);
			
		}
		
		
	}
	
	
}
