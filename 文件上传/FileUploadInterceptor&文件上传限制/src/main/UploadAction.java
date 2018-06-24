package main;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class UploadAction extends ActionSupport {

    private List<File> head;
    private List<String> headContentType;
    private List<String> headFileName;
    private List<String> headDesc;

    @Override
    public String execute() throws Exception {
        System.out.println("head: " + head);
        System.out.println("headContentType: " + headContentType);
        System.out.println("headFileName: " + headFileName);
        System.out.println("headDesc: " + headDesc);

        ServletContext servletContext = ServletActionContext.getServletContext();

        for (int i = 0; i < head.size(); i++) {
            String dir = servletContext.getRealPath("/files/" + headFileName.get(i));
            System.out.println("dir: " + dir);

            FileInputStream fis = null;
            FileOutputStream fos = null;

            try {
                fis = new FileInputStream(head.get(i));
                fos = new FileOutputStream(dir);

                byte[] buf = new byte[1024];
                int length = -1;
                while (true) {
                    length = fis.read(buf);
                    if (length == -1) {
                        break;
                    }
                    fos.write(buf, 0, length);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return INPUT;
    }

    public List<File> getHead() {
        return head;
    }

    public void setHead(List<File> head) {
        this.head = head;
    }

    public List<String> getHeadContentType() {
        return headContentType;
    }

    public void setHeadContentType(List<String> headContentType) {
        this.headContentType = headContentType;
    }

    public List<String> getHeadFileName() {
        return headFileName;
    }

    public void setHeadFileName(List<String> headFileName) {
        this.headFileName = headFileName;
    }

    public List<String> getHeadDesc() {
        return headDesc;
    }

    public void setHeadDesc(List<String> headDesc) {
        this.headDesc = headDesc;
    }
}
