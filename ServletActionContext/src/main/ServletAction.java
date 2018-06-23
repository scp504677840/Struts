package main;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.mapper.ActionMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;
import java.util.Map;

public class ServletAction {
    public String execute() {

        //getActionMapping
        ActionMapping actionMapping = ServletActionContext.getActionMapping();

        //getPageContext
        PageContext pageContext = ServletActionContext.getPageContext();

        //getRequest
        HttpServletRequest request = ServletActionContext.getRequest();

        //getResponse
        HttpServletResponse response = ServletActionContext.getResponse();

        //getServletContext
        ServletContext servletContext = ServletActionContext.getServletContext();

        //getActionContext
        ActionContext actionContext = ServletActionContext.getActionContext(request);
        actionContext.getApplication().put("application","application value");
        actionContext.getSession().put("session","session value");
        ((Map<String,Object>)actionContext.get("request")).put("request","request value");

        //getValueStack
        ValueStack valueStack = ServletActionContext.getValueStack(request);

        return "success";
    }
}
