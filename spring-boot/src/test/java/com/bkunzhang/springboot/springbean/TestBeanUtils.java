package com.bkunzhang.springboot.springbean;

import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * Created by bkunzhang on 2019/6/27.
 */
public class TestBeanUtils {
    @Test
    public void property() {

        PropertyDescriptor[] descriptors = BeanUtils.getPropertyDescriptors(Bean1.class);

        PropertyDescriptor aDescriptor = BeanUtils.getPropertyDescriptor(Bean1.class, "a");
        Method method = aDescriptor.getReadMethod();


        PropertyDescriptor dDescriptor = BeanUtils.getPropertyDescriptor(Bean1.class, "d");
        Method m2 = dDescriptor.getReadMethod();
    }


}
