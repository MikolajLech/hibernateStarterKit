package pl.spring.demo.service.impl;

import static pl.spring.demo.entity.QBookEntity.bookEntity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.entity.QBookEntity;
import pl.spring.demo.mapper.BookMapper;
import pl.spring.demo.repository.BookRepository;
import pl.spring.demo.service.BookService;
import pl.spring.demo.to.BookTo;

import com.mysema.query.jpa.hibernate.HibernateQuery;

@Service
@Transactional(readOnly = true)
public class BookServiceCriteria implements BookService {
	@Autowired
	private BookRepository bookRepository;

	
	public List<BookTo> findBooksByTitle(String title) {
		HibernateQuery qry = createQuery(bookEntity);
		qry.where(bookEntity.title.like(title));
		return BookMapper.map2To(qry.list(bookEntity));
	}
	private HibernateQuery createQuery(QBookEntity bookentity) {
		return new HibernateQuery().from(bookentity);
	}
	
    @Override
    public List<BookTo> findAllBooks() {
        return BookMapper.map2To(bookRepository.findAll());
//        return BookMapper.map2To(qry.);
    }

//    @Override
//    public List<BookTo> findBooksByTitle(String title) {
//        return BookMapper.map2To(bookRepository.findBookByTitle(title));
//    }

    @Override
    public List<BookTo> findBooksByAuthor(String author) {
        return BookMapper.map2To(bookRepository.findBookByAuthor(author));
    }

    @Override
    @Transactional(readOnly = false)
    public BookTo saveBook(BookTo book) {
        BookEntity entity = BookMapper.map(book);
        entity = bookRepository.save(entity);
        return BookMapper.map(entity);
    }
    
	@Override
	@Transactional(readOnly = false)
	public BookTo addBook(BookTo book) {
		BookEntity entity = BookMapper.map(book);
		entity = bookRepository.save(entity);
		return BookMapper.map(entity);
	}
	
	@Override
	@Transactional(readOnly = false)
	public BookTo getBook(Long bookId) {
		return BookMapper.map(bookRepository.getOne(bookId));
	}
	
	@Override
	@Transactional(readOnly = false)
	public BookTo findBookById(Long bookId) {
		return BookMapper.map(bookRepository.findOne(bookId));
	}

	@Override
	@Transactional(readOnly = false)
	public BookTo delete(Long bookId) {
		BookEntity bookEntity = bookRepository.findOne(bookId);
		BookTo bookCopy = new BookTo(BookMapper.map(bookEntity));
		bookRepository.delete(bookEntity);
		return bookCopy;
	}
}
