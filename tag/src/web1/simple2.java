package web1;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class simple2 extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		 JspFragment jf = this.getJspBody();
		 
		 for(int i=1; i<5; i++){
			 jf.invoke(null);
		 }
		 
		
	}
}
