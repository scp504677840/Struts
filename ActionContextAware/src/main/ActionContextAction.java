package main;

import org.apache.struts2.dispatcher.HttpParameters;
import org.apache.struts2.dispatcher.Parameter;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.HttpParametersAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class ActionContextAction implements ApplicationAware, SessionAware, RequestAware, HttpParametersAware {

    private Map<String, Object> application;
    private Map<String, Object> request;
    private Map<String, Object> session;
    private HttpParameters httpParameters;

    @Override
    public void setApplication(Map<String, Object> application) {
        this.application = application;
    }

    @Override
    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    @Override
    public void setParameters(HttpParameters httpParameters) {
        this.httpParameters = httpParameters;
    }

    public String execute() {

        Object applicationPut = application.put("application", "application value");
        System.out.println("applicationPut: " + applicationPut);

        Object sessionPut = session.put("session", "session value");
        System.out.println("sessionPut: " + sessionPut);

        Object requestPut = request.put("request", "request value");
        System.out.println("requestPut: " + requestPut);

        // http://192.168.0.105:8080/context.action?name=tom
        Parameter parameter = httpParameters.get("name");
        String value = parameter.getValue();
        System.out.println("name: " + value);

        return "success";
    }

    /**
     * 着重说明Session
     *
     * @return
     */
    public String session(){
        SessionMap sessionMap = (SessionMap) session;
        //可以使session失效
        sessionMap.invalidate();
        return "success";
    }

}
