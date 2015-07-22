package pl.spring.demo.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "BOOK"/*, uniqueConstraints = @UniqueConstraint(columnNames = "BOOK_TITLE")*/)
public class BookEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, length = 50)
	private String title;
	
	@ManyToOne(fetch=FetchType.LAZY, targetEntity=LibraryEntity.class)
	@JoinColumn(name = "LIBRARY_ID", referencedColumnName = "id", nullable = false, updatable = false)
	private LibraryEntity library;
	
	// for hibernate
	protected BookEntity() {
	}

	public BookEntity(Long id, String title) {
		this.id = id;
		this.title = title;
	}
	
	public BookEntity(Long id, String title, Long libraryId) {
		this.id = id;
		this.title = title;
		this.library = new LibraryEntity(libraryId);
	}

//	@GeneratedValue(strategy = IDENTITY)
//    @Column(name = "BOOK_ID", unique = true, nullable = false)
    public Long getId() {
    	return this.id;
    }
	
	public void setId(Long id) {
		this.id = id;
	}

	public LibraryEntity getLibrary() {
		return this.library;
	}	
	
	public void setLibrary(LibraryEntity library) {
		this.library = library;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "BOOK_AUTHOR",
            joinColumns = {@JoinColumn(name = "BOOK_ID", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "AUTHOR_ID", nullable = false, updatable = false)}
    )
    private Set<AuthorEntity> authors = new HashSet<>();
    
    public Set<AuthorEntity> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<AuthorEntity> authors) {
        this.authors = authors;
    }
}
