package web;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class TagDemo2 extends TagSupport {
	@Override
	public int doEndTag() throws JspException {
		return Tag.EVAL_PAGE;
	}
}
