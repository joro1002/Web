package aop.basic;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BasicPointcutSample {

    @Pointcut(value = "execution(* aop.model.Student.sayHello())")
    public void trackSayHello() {

    }

    @Before("trackSayHello()")
    public void logBeforeTheMethod() {
        System.out.println("Before executing of say hello!");
    }

    @After("trackSayHello()")
    public void logAfterTheMethod(){
        System.out.println("After executing of say hello!");
    }
}
