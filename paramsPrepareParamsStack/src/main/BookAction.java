package main;

import com.opensymphony.xwork2.ModelDriven;
import main.bean.Book;
import main.dao.BookDao;
import org.apache.struts2.interceptor.RequestAware;

import java.math.BigInteger;
import java.util.Map;

public class BookAction implements RequestAware, ModelDriven<Book> {

    private Map<String, Object> request;
    private BookDao bookDao = new BookDao();

    private Book book;

    private BigInteger id;

    @Override
    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }

    @Override
    public Book getModel() {
        if (id != null) {
            book = bookDao.get(id);
        } else {
            book = new Book();
        }
        return book;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String list() {
        request.put("books", bookDao.list());
        return "list";
    }

    public String save() {
        return "save";
    }

    /**
     * 编辑Book
     * 为什么代码块是空的？
     * 1.我们使用<default-interceptor-ref name="paramsPrepareParamsStack"/>作为默认的拦截器栈。
     * 2.paramsPrepareParamsStack拦截器栈里面，modelDriven拦截器前面会先执行params拦截器，于是呢 id 属性就有值了。
     * 3.当id有值时，getModel方法执行就会走if (id != null) { book = bookDao.get(id); }
     * 4.于是book就有值，并置于栈顶。
     * 5.直接返回即可。
     *
     * @return
     */
    public String edit() {
        return "edit";
    }

    public String update() {
        bookDao.update(book);
        return "update";
    }

    public String delete() {
        bookDao.delete(book.getId());
        return "delete";
    }

}
