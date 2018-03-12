package recreate;

public class AbstractBeanWithConstructor {

	private String message;
	
	
	public AbstractBeanWithConstructor (String message) {
		this.message = message;
	}
	
	public String getMsg() {
		return message;
	}
}
