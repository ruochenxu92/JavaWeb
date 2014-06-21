package web1;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class simple3 extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		JspFragment jf = this.getJspBody();
		StringWriter sw = new StringWriter();
		
		jf.invoke(sw);
		
		String content = sw.toString();
		content = content.toUpperCase();
		
		this.getJspContext().getOut().write(content);
		 
		
	}
}
