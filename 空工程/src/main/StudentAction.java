package main;

public class StudentAction {

    /**
     * 添加学生表单
     *
     * @return 跳转到添加学生表单
     */
    public String input() {
        System.out.println("call input");
        return "success";
    }

    /**
     * 保存学生
     *
     * @return 保存学生
     */
    public String save() {
        System.out.println("call save");
        return "success";
    }

}
