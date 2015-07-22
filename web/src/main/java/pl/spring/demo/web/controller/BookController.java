package pl.spring.demo.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.spring.demo.service.BookService;
import pl.spring.demo.to.BookTo;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String books(Map<String, Object> params) {
        final List<BookTo> allBooks = bookService.findAllBooks();
        params.put("books", allBooks);
        return "bookList";
    }
    
    @RequestMapping(value = "/bookListInTable", method = RequestMethod.GET)
	public String bookList(Map<String, Object> params) {
		final List<BookTo> allBooks = bookService.findAllBooks();
		params.put("books", allBooks);
		return "bookListInTable";
	}

	@RequestMapping(value = "/deleteBook/{id}", method = RequestMethod.POST)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		BookTo deletedBook = bookService.delete(bookId);
		System.out.println(deletedBook.getTitle());
		model.addAttribute("deletedBook", deletedBook);
		return "deletedBook";
	}
	
	@RequestMapping(value = "/addBook", method = RequestMethod.GET)
	public String addBook(Model model) {
		BookTo book = new BookTo();
		model.addAttribute("book", book);
		return "addBook";
	}
	
	@RequestMapping(value = "/addedBook", method = RequestMethod.POST)
	public String addBook(Model model, BookTo book) {
		model.addAttribute("book", book);
		bookService.addBook(book);
		return "addedBook";
	}
	
	@RequestMapping(value = "/addedBook/{id}/{title}/{authors}/{library}", method = RequestMethod.POST)
	public String addBook(Model model, @PathVariable("id") Long id, 
			@PathVariable("title") String title, @PathVariable("authors") String authors,
			@PathVariable("library") String library) {
		BookTo book = new BookTo(id, title, authors, library);
		model.addAttribute("book", book);
		if(bookService.findBookById(book.getId()) != null) {
			return "bookAlreadyExists";
		}
		bookService.addBook(book);
		return "addedBook";
	}
	
	@RequestMapping(value = "/newBook", method = RequestMethod.GET)
	public String showWebNewBook() {
		return "newBook";
	}
}
