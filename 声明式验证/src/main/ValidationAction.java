package main;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 声明式验证
 * 1.书写ValidationAction-validation.xml。规则是Action名称--validation.xml
 * 2.书写验证规则。
 * 3.配置
 *
 * 参考请在Struts本地目录中搜索validation.xml文件。
 */
public class ValidationAction extends ActionSupport {

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
