package main.dao;

import main.bean.Book;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class BookDao {

    private Map<BigInteger, Book> books = new LinkedHashMap<>();
    private BigInteger id = BigInteger.ZERO;

    public BookDao() {
        books.put(BigInteger.valueOf(1), new Book());
        books.put(BigInteger.valueOf(2), new Book());
        books.put(BigInteger.valueOf(3), new Book());
        books.put(BigInteger.valueOf(4), new Book());
        books.put(BigInteger.valueOf(5), new Book());
    }

    public BigInteger save(Book book) {
        id = id.add(BigInteger.ONE);
        books.put(id, book);
        return id;
    }

    public void update(Book book) {
        Book temp = books.get(book.getId());
        if (temp == null) {
            return;
        }
        books.put(book.getId(), book);
    }

    public void delete(BigInteger id) {
        books.remove(id);
    }

    public List<Book> list() {
        List<Book> bookList = new ArrayList<>();
        books.forEach((bigInteger, book) -> {
            bookList.add(book);
        });
        return bookList;
    }
}
