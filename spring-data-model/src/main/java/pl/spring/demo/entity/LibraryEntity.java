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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LIBRARY"/*, uniqueConstraints = @UniqueConstraint (columnNames = "LIBRARY_NAME")*/)
public class LibraryEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//    @GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	@Column(name = "name", unique = true, nullable = false, length = 50)
	private String name;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "library", cascade=CascadeType.ALL)
	private Set<BookEntity> booksInLibrary = new HashSet<BookEntity>(0);
	
	// for hibernate
	protected LibraryEntity() {
	}
	
	public LibraryEntity(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public LibraryEntity(Long id) {
		this.id = id;
	}
	
    public Long getLibraryId() {
    	return this.id;
    }
    
    public void setLibraryId(Long id) {
    	this.id = id;
    }
    
    public String getLibraryName() {
    	return name;
    }
    
    public void setLibraryName(String name) {
    	this.name = name;
    }

    public Set<BookEntity> getBooksInLibrary() {
    	return this.booksInLibrary;
    }
    
    public void setBooksInLibrary(Set<BookEntity> books) {
    	this.booksInLibrary = books;
    }
}
