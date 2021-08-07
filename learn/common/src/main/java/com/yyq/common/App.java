package com.yyq.common;

import java.lang.annotation.Annotation;

public class App {

    @Test(name="xx", age=6)
    public void printApp(){

    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {

        Annotation[] array = Class.forName("com.yyq.common.App").getMethod("printApp").getAnnotations();
        for (Annotation an : array) {
            System.out.println(an);
            if (an instanceof Test) {
                System.out.println("Tag is" + an);
                System.out.println(((Test) an).name());
            }
        }
    }
}
