package web1;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
//control tag remain part not exec
public class simple4 extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		throw new SkipPageException();
	}
}
