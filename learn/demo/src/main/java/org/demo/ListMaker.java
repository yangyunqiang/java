package org.demo;

import java.util.ArrayList;
import java.util.List;

public class ListMaker<T> {
    List<T> create() { return new ArrayList(); }
    Class<T> kind;
    private final int SIZE = 100;

    public  void f(Object arg) {

    }

    public static void main(String[] args) {
        ListMaker<String> stringListMaker = new ListMaker<String>();
        List<String> stringList = stringListMaker.create();
    }
}
