package main;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class UserAction implements ApplicationAware, SessionAware {

    private Map<String, Object> application;
    private Map<String, Object> session;

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setApplication(Map<String, Object> application) {
        this.application = application;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    /**
     * 登录
     *
     * @return 结果
     */
    public String login() {

        //设置name
        session.put("name", name);

        //获取在线人数
        Integer count = (Integer) application.get("count");
        //当在线人数为空时
        if (count == null) {
            count = 0;
        }
        //在线人数加1
        count++;

        //设置在线人数
        application.put("count", count);

        //返回
        return "success";
    }

    /**
     * 登出
     *
     * @return 结果
     */
    public String logout() {

        //获取在线人数
        Integer count = (Integer) application.get("count");

        //在线人数减1
        if (count != null && count > 0) {
            count--;
            application.put("count", count);
        }

        //使session失效
        ((SessionMap) session).invalidate();

        return "success";
    }

}
