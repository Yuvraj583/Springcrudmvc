package com.api.book.bootrestbook.services;

// import java.util.ArrayList;
// import java.util.stream.Collector;
// import java.util.stream.Collectors;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

@Component
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    // private static List<Book> list = new ArrayList<>();

    // static {

    // list.add(new Book(12, "java Complete refrence ", "XYZ"));
    // list.add(new Book(36, "Head fisrt to java ", "ABC"));
    // list.add(new Book(12963, "Think in java ", "LMN"));

    // }

    // get all books
    public List<Book> getAllBooks() {
        // return list;
        List<Book> list = (List<Book>) this.bookRepository.findAll();
        return list;
    }

    // get single book by id
    public Book getBookByIdBook(int id) {
        Book book = null;
        try {
            // book = list.stream().filter(e -> e.getId() == id).findFirst().get();

            book = this.bookRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    // adding the book
    public Book addBook(Book b) {
        // list.add(b);
        // return b;
        Book result = bookRepository.save(b);
        return result;
    }

    // delete book
    public void deleteBook(int bid) {

        // list = list.stream().filter(book -> book.getId() !=
        // bid).collect(Collectors.toList());
        bookRepository.deleteById(bid);
    }

    // update book
    public void updateBook(Book book, int bookId) {
        // list = list.stream().map(b -> {
        // if (b.getId() == bookId) {
        // b.setTitle(book.getTitle());
        // b.setAuthor(book.getAuthor());
        // }
        // return b;
        // }).collect(Collectors.toList());
        book.setId(bookId);
        bookRepository.save(book);
    }

}
