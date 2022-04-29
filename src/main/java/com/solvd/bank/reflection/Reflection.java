package com.solvd.bank.reflection;

import com.solvd.bank.bankWork.CustomerData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.*;

public class Reflection {
    private static final Logger LOGGER = LogManager.getLogger(Reflection.class);


    public static void main(String args[]) throws Exception {
        CustomerData cd = new CustomerData();
        Class cls = cd.getClass();

        LOGGER.info("The name of class is: " + cls.getName());
        LOGGER.info("---------------------------------------------------------------");
        Constructor[] constructors = cls.getDeclaredConstructors();//all
        LOGGER.info("Constructors:\n");
        for (Constructor constructor : constructors) {
            LOGGER.info("The name of constructor is: " + constructor.getName());
            Parameter[] parameters = constructor.getParameters();
            for (Parameter parameter : parameters) {
                LOGGER.info(parameter.getName());
                LOGGER.info(parameter.getType().getName());
            }
        }
        LOGGER.info("---------------------------------------------------------------");
        LOGGER.info("The public methods of class are : ");
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            LOGGER.info(method.getName());
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                LOGGER.info(parameter.getName());
                LOGGER.info(parameter.getType().getName());
            }
            LOGGER.info(Modifier.toString(method.getModifiers()));
            LOGGER.info(method.getReturnType().getName());
        }
        LOGGER.info("---------------------------------------------------------------");
        LOGGER.info("Fields:");
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            LOGGER.info(Modifier.toString(field.getModifiers()) + " "
                    + field.getType().getName() + " " + field.getName());
        }
        LOGGER.info("---------------------------------------------------------------");
        Field field = cls.getDeclaredField("customerCardNumber");
        field.setAccessible(true);
        LOGGER.info("Field customerCardNumber before changing: ");
        LOGGER.info(field.get(cd));
        field.set(cd, "4444123443215555");
        LOGGER.info("Field customerCardNumber after changing: ");
        LOGGER.info(field.get(cd));
        LOGGER.info("---------------------------------------------------------------");
        LOGGER.info("Method invoke: ");
        Method methodCall = cls.getDeclaredMethod("getCustomerCardNumber");
        methodCall.invoke(cd);
    }

}
