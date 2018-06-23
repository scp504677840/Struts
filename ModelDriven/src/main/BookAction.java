package main;

import com.opensymphony.xwork2.ModelDriven;
import main.bean.Book;
import main.dao.BookDao;
import org.apache.struts2.interceptor.RequestAware;

import java.util.Map;

public class BookAction implements RequestAware, ModelDriven<Book> {

    private Map<String, Object> request;
    private BookDao bookDao = new BookDao();

    private Book book;

    @Override
    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }

    @Override
    public Book getModel() {
        book = new Book();
        return book;
    }

    public String save() {
        return "save";
    }

    public String list() {
        request.put("books", bookDao.list());
        return "list";
    }

    public String delete() {
        bookDao.delete(book.getId());
        return "delete";
    }

}
