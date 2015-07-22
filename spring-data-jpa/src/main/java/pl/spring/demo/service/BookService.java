package pl.spring.demo.service;

import pl.spring.demo.to.BookTo;

import java.util.List;

public interface BookService {

	List<BookTo> findAllBooks();
	List<BookTo> findBooksByTitle(String title);
	List<BookTo> findBooksByAuthor(String author);
	BookTo findBookById(Long bookId);
	BookTo saveBook(BookTo book);
	BookTo getBook(Long bookId);
	BookTo delete(Long bookId);
	BookTo addBook(BookTo book);
}