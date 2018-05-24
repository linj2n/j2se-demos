package cn.linj2n.reflect;

import org.junit.Test;
import java.lang.reflect.*;

import static org.junit.Assert.*;

public class CarTest {
    @Test
    public void testCarByReflect() throws Throwable{

        // 通过类装载器获取 Car 类对象
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("cn.linj2n.reflect.Car");

        // 获取类的默认构造器并通过它实例化 Car
        Constructor cons = clazz.getConstructor((Class[])null);
        Car car = (Car)cons.newInstance();

        // 通过反射方法设置属性

        Method setBrand = clazz.getMethod("setBrand",String.class);
        setBrand.invoke(car,"雷克萨斯NX200");
        Method setColor = clazz.getMethod("setColor",String.class);
        setColor.invoke(car,"黑色");
        Method setMaxSpeed = clazz.getMethod("setMaxSpeed",int.class);
        setMaxSpeed.invoke(car,200);

        System.out.println(car.toString());
    }
}