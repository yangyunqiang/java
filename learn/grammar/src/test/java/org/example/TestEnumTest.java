package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestEnumTest {

    @Test
    public  void testEnum() {
        System.out.println(TestEnum.START.ordinal());
        TestEnum testEnum = Enum.valueOf(TestEnum.class, "START");
        Enum.valueOf("START")
    }


}