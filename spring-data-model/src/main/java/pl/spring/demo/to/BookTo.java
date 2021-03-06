package pl.spring.demo.to;

public class BookTo {
    private Long id;
    private String title;
    private String authors;
    private String libraryName;
	private Long libraryId;
    
    public BookTo() {
    }
    
    public BookTo(Long id, String title, String authors, String library) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.libraryName = library;
    }
    
    public BookTo(BookTo copy) {
    	this.id = copy.id;
    	this.title = copy.title;
    	this.authors = copy.authors;
    	this.libraryName = copy.libraryName;
    	this.libraryId = copy.libraryId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }
    
    public String getLibrary() {
    	return libraryName;
    }
    
    public void setLibrary(String library) {
    	this.libraryName = library;
    }

	public Long getLibraryId() {
		return libraryId;
	}
}
