package recreate;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.Typed;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Named;

@Dependent
public class BeanProducer {


	@Produces
	@Typed(BeanWithConstructor.class)
	@RequestScoped
	public BeanWithConstructor produceBean() {
		return new BeanWithConstructor("A bean with a no-args constructor extending an abstract class without a no-args default constructor was successfuly produced");
	}
	
	@Produces
	@RequestScoped
	public NonInheritingBeanWithDefaultConstructor produceNonInheritingBean() {
		NonInheritingBeanWithDefaultConstructor bean = new NonInheritingBeanWithDefaultConstructor();
		bean.setMsg("A bean with no supertype and an implicit constructor was succssfully produced");
		return bean;
	}
}
