package main;

import com.opensymphony.xwork2.ActionSupport;

import java.util.Collections;
import java.util.Date;

public class I18NAction extends ActionSupport {

    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String execute() throws Exception {

        //创建Date
        date = new Date();

        //1.在Action中访问国际化资源文件的value值。
        String username = getText("username");
        System.out.println("username: " + username);

        //2.访问带占位符的
        String time = getText("time", Collections.singletonList(date));
        System.out.println("time: " + time);

        return SUCCESS;
    }
}
