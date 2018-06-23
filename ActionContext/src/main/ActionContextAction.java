package main;

import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.dispatcher.HttpParameters;
import org.apache.struts2.dispatcher.Parameter;

import java.util.Map;

public class ActionContextAction {

    public String execute() {
        ActionContext actionContext = ActionContext.getContext();

        //ActionContext
        //setActionInvocation
        //getActionInvocation

        //setApplication
        //getApplication
        Map<String, Object> application = actionContext.getApplication();
        Object applicationPut = application.put("application", "application value");
        System.out.println("applicationPut: " + applicationPut);

        //setContext
        //getContext
        //ActionContext context = ActionContext.getContext();

        //setContextMap
        //getContextMap
        /*Map<String, Object> contextMap = actionContext.getContextMap();
        contextMap.forEach((k, v) -> {
            System.out.println(k + " : " + v);
        });*/
        //application
        //session
        //request
        //...

        //setConversionErrors
        //getConversionErrors
        //setLocale
        //getLocale
        //setName
        //getName

        //setParameters
        //getParameters
        HttpParameters parameters = actionContext.getParameters();
        Parameter parameter = parameters.get("name");
        //getName
        String name = parameter.getName();
        System.out.println("name: " + name);
        //name: name

        //getValue
        String value = parameter.getValue();
        System.out.println("value: " + value);
        //value: tom
        //取第一个值

        //isDefined
        boolean defined = parameter.isDefined();
        System.out.println("defined: " + defined);
        //defined: true

        //isMultiple
        boolean multiple = parameter.isMultiple();
        System.out.println("multiple: " + multiple);
        //multiple: true

        //getMultipleValues
        String[] multipleValues = parameter.getMultipleValues();
        for (String multipleValue: multipleValues) {
            System.out.println("multipleValue: " + multipleValue);
            //multipleValue: tom
            //multipleValue: jack
        }

        //getObject
        Object object = parameter.getObject();
        System.out.println("object: " + object);
        //object: [Ljava.lang.String;@40d5f847

        //setSession
        //getSession
        Map<String, Object> session = actionContext.getSession();
        Object sessionPut = session.put("session", "session value");
        System.out.println("sessionPut: " + sessionPut);

        //setValueStack
        //getValueStack
        //setContainer
        //getContainer
        //getInstance

        //get
        //案例：获取request
        Map<String, Object> request = (Map<String, Object>) actionContext.get("request");
        Object requestPut = request.put("request", "request value");
        System.out.println("requestPut: " + requestPut);

        //put

        return "success";
    }

}
