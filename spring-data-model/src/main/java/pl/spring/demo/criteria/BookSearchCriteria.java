package pl.spring.demo.criteria;

public class BookSearchCriteria {

	private String title;
	private String author;
	private String libraryName;
	
	public BookSearchCriteria() {
		
	}
	
	public BookSearchCriteria(String title, String author, String libraryName) {
		this.title = title;
		this.author = author;
		this.libraryName = libraryName;
	}

	public String getAuthor() {
		return author;
	}

	public String getLibraryName() {
		return libraryName;
	}

	public String getTitle() {
		return title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
}
