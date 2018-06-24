package main;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.FileInputStream;
import java.io.InputStream;

public class DownloadAction extends ActionSupport {

    /**
     * 文件类型
     */
    private String contentType;

    /**
     * 文件长度
     */
    private long contentLength;

    /**
     * 指定文件输入流的 getter 方法定义的那个属性的名字；默认为inputStream。
     */
    private InputStream inputStream;

    /**
     * 文件名称
     */
    private String fileName;

    @Override
    public String execute() throws Exception {
        contentType = "image/png";
        fileName = "logo.png";

        String filePath = ServletActionContext.getServletContext().getRealPath("/logo.png");
        inputStream = new FileInputStream(filePath);
        contentLength = inputStream.available();
        return SUCCESS;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public long getContentLength() {
        return contentLength;
    }

    public void setContentLength(long contentLength) {
        this.contentLength = contentLength;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
