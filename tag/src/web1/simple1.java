package web1;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class simple1 extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		  JspFragment js= this.getJspBody();
		  js.invoke(null);
		
		
	}
}
