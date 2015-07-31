package pl.spring.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import pl.spring.demo.entity.BookEntity;

public interface BookCriteriaRepository extends JpaRepository<BookEntity, Long>, QueryDslPredicateExecutor<BookEntity> {
    public List<BookEntity> findBookByTitle(String title);
}
