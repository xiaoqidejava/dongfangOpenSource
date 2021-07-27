package com.luzhikun.proxyFactory;

import com.luzhikun.dao.UserDao;
import com.luzhikun.dao.UserDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author Rookie Coder
 * @Description
 * @Date
 **/
public class MyJDKProxy {

    public static void main(String[] args) {
        // 创建接口的实现类代理对象
        Class[] interfaces = {UserDao.class};
        UserDaoImpl userDao = new UserDaoImpl();
        UserDao userDao1 = (UserDao) Proxy.newProxyInstance(MyJDKProxy.class.getClassLoader(),interfaces,new UserDaoProxy(userDao));
        String xiaoqi = userDao1.say("xiaoqi");
        System.out.println(xiaoqi);

    }
}
class UserDaoProxy implements InvocationHandler{

    private Object object;
    public UserDaoProxy(Object obj){
        this.object=obj;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        // 在方法执行之前做的增强
        System.out.println("方法之前做的增强");
        Object invoke = method.invoke(object, objects);
        // 在方法执行之后做的增强
        System.out.println("方法之后做的增强");
        return invoke;
    }
}

