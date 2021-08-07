package org.example;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */

@Data
class PersonInfo {
    private Integer age;
    private String name;

    public PersonInfo(Integer i, String name) {
        age = i;
        this.name = name;
    }
};


public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        List<PersonInfo> lisiList = new ArrayList<>();
        Consumer<PersonInfo> consumer  = x -> {
            if (x.getName().equals("lisi")){
                lisiList.add(x);
            }
        };

        consumer.accept(new PersonInfo(99,"lisi"));
        List<PersonInfo> lisiList2 = Stream.of(
                new PersonInfo(21,"zhangsan"),
                new PersonInfo(22,"lisi"),
                new PersonInfo(23,"wangwu"),
                new PersonInfo(24,"wangwu"),
                new PersonInfo(23,"lisi"),
                new PersonInfo(26,"lisi"),
                new PersonInfo(26,"zhangsan")
        ).filter(x-> x.getName().equals("lisi")).collect(Collectors.toList());

        System.out.println(lisiList2);
    }
}
