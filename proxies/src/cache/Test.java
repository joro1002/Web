package cache;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        Object obhToProxy = new StudentServiceImpl();

        StudentServiceIfc proxiedService = (StudentServiceIfc) Proxy.newProxyInstance(
                Test.class.getClassLoader(),
                new Class[]{StudentServiceIfc.class},
                new StudentServiceIfcInvocationHandler(obhToProxy)
        );

        System.out.println(proxiedService.getClass());
        System.out.println(proxiedService.getAllStudents());
        System.out.println(proxiedService.getAllStudents());

    }
}
