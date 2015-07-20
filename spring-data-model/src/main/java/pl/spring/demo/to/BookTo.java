package pl.spring.demo.to;

public class BookTo {
    private Long id;
    private String title;
    private String authors;
    private String library;
    
    public BookTo() {
    }

    public BookTo(Long id, String title, String authors, String library) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.library = library;
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
    	return library;
    }
    
    public void setLibrary(String library) {
    	this.library = library;
    }
}
