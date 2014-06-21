package web1;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class simple5 extends SimpleTagSupport {
	private int count;

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspFragment jf = this.getJspBody();
		
		for(int i = 0; i < count; i++){
			jf.invoke(null);
		}
	}
	
}
