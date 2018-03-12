package recreate;

import javax.enterprise.context.RequestScoped;

public class BeanWithConstructor extends AbstractBeanWithConstructor {

	public BeanWithConstructor() {
		super("hello world");
	}
	
	public BeanWithConstructor(String message) {
		super(message);
	}

}
