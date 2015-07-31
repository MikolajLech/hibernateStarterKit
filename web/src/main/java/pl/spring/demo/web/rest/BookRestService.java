package pl.spring.demo.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.spring.demo.service.BookService;
import pl.spring.demo.to.BookTo;

@Controller
@ResponseBody
public class BookRestService {

    @Autowired
//    @Qualifier("bookServiceImpl")
    private BookService bookServiceImpl;

    @RequestMapping(value = "/books-by-title", method = RequestMethod.GET)
    public List<BookTo> findBooksByTitle(@RequestParam("titlePrefix") String titlePrefix) {
        return bookServiceImpl.findBooksByTitle(titlePrefix);
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public BookTo saveBook(@RequestBody BookTo book) {
        return bookServiceImpl.saveBook(book);
    }
}
