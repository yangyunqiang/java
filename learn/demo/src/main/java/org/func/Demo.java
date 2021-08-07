package org.func;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Demo {

    public String processFile(BufferProcessor p) throws IOException {

        System.out.println(System.getProperty("user.dir"));
        try(BufferedReader br =
                new BufferedReader(new FileReader("pom.xml"))) {
            return p.process(br);
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new Demo().processFile((BufferedReader br) -> br.readLine()));
    }
}
