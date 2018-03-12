# TypedProducerBug

This application demonstrates a bug in weld whereby the annotation javax.enterprise.inject.Typed does not affect wheather a ProducerMethod is proxaible or not. 

See also https://issues.jboss.org/projects/WELD/issues/WELD-2466 - which states that it should not matter if a ProducerMethod is proxaible or not. 

To reproduce download the prebuilt war WeldRecreateProducesExtendedAbstract.war and install it on Wildfly. Then visit the url http://localhost:8080/WeldRecreateProducesExtendedAbstract/inheritance this will trigger a servlet to invoke getInjectableReference() directly, and the method will fail because BeanProducer.produceBean() is not proxiable. 

If you place a breakpoint on ProducerMethod line 76 you will see that this is because isTypesProxiable is given the paramater method.getTypeClosure() and getTypeClosure() include recreate.AbstractBeanWithConstructor in it's return. 

For completeness the url http://localhost:8080/WeldRecreateProducesExtendedAbstract/noninheritance will perform the same procedure but withot an unproxiable superclass to simulate what would happen if @Typed restricted the types used to determine if the ProducerMethod is proxiable. The method will complete successfully. 
