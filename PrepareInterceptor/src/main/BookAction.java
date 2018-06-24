package main;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import main.bean.Book;
import main.dao.BookDao;
import org.apache.struts2.interceptor.RequestAware;

import java.math.BigInteger;
import java.util.Map;

/**
 * PrepareInterceptor
 * <p>
 * 1.若 Action 实现了 Preparable 接口，则Struts将尝试prepare[ActionMethodName]方法。
 * 2.若 prepare[ActionMethodName]方法不存在时，则将尝试执行prepareDo[ActionMethodName]方法。
 * 3.若都不存在，就都不执行。
 * 4.若PrepareInterceptor的alwaysInvokePrepare属性为false，则Struts2将不会调用实现了 Preparable 接口的Action的prepare方法。
 */
public class BookAction implements RequestAware, ModelDriven<Book>, Preparable {

    private Map<String, Object> request;
    private BookDao bookDao = new BookDao();

    /**
     * 书籍对象
     * 1.这个对象可能来自请求参数
     * 2.也可能来自准备的对象
     */
    private Book book;

    /**
     * 书籍ID
     */
    private BigInteger id;

    /**
     * 书籍列表
     *
     * @return 结果
     */
    public String list() {
        request.put("books", bookDao.list());
        return "list";
    }

    /**
     * 保存
     *
     * @return
     */
    public String save() {
        bookDao.save(book);
        return "save";
    }

    /**
     * 准备将要保存的对象
     */
    public void prepareSave() {
        book = new Book();
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

    /**
     * 准备编辑对象
     */
    public void prepareEdit() {
        book = bookDao.get(id);
    }

    /**
     * 更新数据
     *
     * @return 结果
     */
    public String update() {
        bookDao.update(book);
        return "update";
    }

    /**
     * 准备更新对象
     */
    public void prepareUpdate() {
        book = new Book();
    }

    public String delete() {
        bookDao.delete(book.getId());
        return "delete";
    }

    @Override
    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }

    @Override
    public Book getModel() {
        return book;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    @Override
    public void prepare() throws Exception {
        System.out.println("--- prepare ---");
    }
}
