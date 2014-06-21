package web1;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class simple7 extends SimpleTagSupport {
	private boolean isDO;

	public boolean isDO() {
		return isDO;
	}

	public void setDO(boolean isDO) {
		this.isDO = isDO;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		this.getJspBody().invoke(null);	
	}
}
