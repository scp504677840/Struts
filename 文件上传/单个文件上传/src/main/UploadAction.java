package main;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class UploadAction extends ActionSupport {

    private File head;
    private String headContentType;
    private String headFileName;
    private String headDesc;

    @Override
    public String execute() throws Exception {
        System.out.println("head: " + head);
        System.out.println("headContentType: " + headContentType);
        System.out.println("headFileName: " + headFileName);
        System.out.println("headDesc: " + headDesc);

        ServletContext servletContext = ServletActionContext.getServletContext();
        String dir = servletContext.getRealPath("/files/" + headFileName);
        System.out.println("dir: " + dir);

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(head);
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

        return SUCCESS;
    }

    public File getHead() {
        return head;
    }

    public void setHead(File head) {
        this.head = head;
    }

    public String getHeadContentType() {
        return headContentType;
    }

    public void setHeadContentType(String headContentType) {
        this.headContentType = headContentType;
    }

    public String getHeadFileName() {
        return headFileName;
    }

    public void setHeadFileName(String headFileName) {
        this.headFileName = headFileName;
    }

    public String getHeadDesc() {
        return headDesc;
    }

    public void setHeadDesc(String headDesc) {
        this.headDesc = headDesc;
    }
}
