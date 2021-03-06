package pl.spring.demo.to;

public class LibraryTo {
    private Long id;
    private String name;
    
    public LibraryTo() {
    }
    
    public LibraryTo(Long id, String name) {
        this.id = id;
        this.name = name;

    }
    
    public LibraryTo(LibraryTo copy) {
    	this.id = copy.id;
    	this.name = copy.name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String title) {
        this.name = title;
    }
}
