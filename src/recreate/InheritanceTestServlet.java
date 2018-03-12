package recreate;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.Set;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.AnnotatedField;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/inheritance")
public class InheritanceTestServlet  extends HttpServlet {

	@Inject BeanManager beanManager;
	
	private BeanWithConstructor bean; 

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		PrintWriter pw = response.getWriter();
		
		CreationalContext cc = beanManager.createCreationalContext(null);
		
		for (AnnotatedField<?> field : beanManager.createAnnotatedType(this.getClass()).getFields()) {
			if (field.getJavaMember().getName().equals("bean")){
				InjectionPoint injectionPoint = beanManager.createInjectionPoint(field);;
				beanManager.getInjectableReference(injectionPoint, cc);
			}
		}
	}
	
}
