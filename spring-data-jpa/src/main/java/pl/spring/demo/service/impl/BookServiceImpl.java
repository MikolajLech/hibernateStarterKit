package pl.spring.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.spring.demo.dao.BookDao;
import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.mapper.BookMapper;
import pl.spring.demo.service.BookService;
import pl.spring.demo.to.BookTo;

@Service
@Transactional(readOnly = true)
public class BookServiceImpl implements BookService {

//    @Autowired
//    private BookRepository boookRepository;
	private BookDao bookDaoImpl;

    @Override
    public List<BookTo> findAllBooks() {
        return BookMapper.map2To(bookDaoImpl.findAll());
    }

    @Override
    public List<BookTo> findBooksByTitle(String title) {
        return BookMapper.map2To(bookDaoImpl.findBookByTitle(title));
    }

    @Override
    public List<BookTo> findBooksByAuthor(String author) {
//        return BookMapper.map2To(bookDaoImpl.findBookByAuthor(author));
    	return null;
    }

    @Override
    @Transactional(readOnly = false)
    public BookTo saveBook(BookTo book) {
        BookEntity entity = BookMapper.map(book);
        entity = bookDaoImpl.save(entity);
        return BookMapper.map(entity);
    }
    
	@Override
	@Transactional(readOnly = false)
	public BookTo addBook(BookTo book) {
		BookEntity entity = BookMapper.map(book);
		entity = bookDaoImpl.save(entity);
		return BookMapper.map(entity);
	}
	
	@Override
	@Transactional(readOnly = false)
	public BookTo getBook(Long bookId) {
		return BookMapper.map(bookDaoImpl.getOne(bookId));
	}
	
	@Override
	@Transactional(readOnly = false)
	public BookTo findBookById(Long bookId) {
		return BookMapper.map(bookDaoImpl.findOne(bookId));
	}

	@Override
	@Transactional(readOnly = false)
	public BookTo delete(Long bookId) {
		BookEntity bookEntity = bookDaoImpl.findOne(bookId);
		BookTo bookCopy = new BookTo(BookMapper.map(bookEntity));
		bookDaoImpl.delete(bookEntity);
		return bookCopy;
	}
}
