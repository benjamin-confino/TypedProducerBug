package recreate;

public class NonInheritingBeanWithDefaultConstructor {

    private String message;
	
    public void setMsg(String msg) {
    	message = msg;
    }
	
	public NonInheritingBeanWithDefaultConstructor (String message) {
		this.message = message;
	}
	
	public NonInheritingBeanWithDefaultConstructor() {
		message = "defualt message";
	}

}
