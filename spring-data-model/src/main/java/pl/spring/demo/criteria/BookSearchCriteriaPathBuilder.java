package pl.spring.demo.criteria;

public class BookSearchCriteriaPathBuilder {

	private String key;
	private String operation;
	private Object value;
	
	public BookSearchCriteriaPathBuilder() {
		
	}

	public String getKey() {
		return key;
	}

	public String getOperation() {
		return operation;
	}

	public Object getValue() {
		return value;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	
}
