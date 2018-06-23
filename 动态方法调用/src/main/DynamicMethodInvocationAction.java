package main;

/**
 * DynamicMethodInvocation
 * 动态方法调用
 * 1.开启动态方法调用
 * <constant name="struts.enable.DynamicMethodInvocation" value="true"/>
 * 2.执行url：http://192.168.0.105:8080/DynamicMethodInvocation!update.do
 *
 * 注意：
 * save方法是在struts.xml 文件中声明过action。而update方法没有。
 */
public class DynamicMethodInvocationAction {

    public String update() {
        System.out.println("--- update ---");
        return "update";
    }

    public String save() {
        System.out.println("--- save ---");
        return "save";
    }

}
