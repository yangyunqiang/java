package org.func;

import lombok.Data;

import java.util.*;

@Data
public class Person {

    private String name;

    private Integer age;

    static public  int randomNum(int min, int max) {

        Random random = new Random();
        int s = random.nextInt(max) % (max - min + 1) + min;
        return s;
    }

    public static int compareByAge(Person a, Person b) {
        return a.age.compareTo(b.age);
    }

    public  void print() {
        System.out.print(age + " ");
    }

    public static void main(String[] args) {
        Person[] personArray = new Person [30];

        for (int i = 0; i < 30; i++) {
            personArray[i] = new Person();
        }

        for(Person person : personArray) {

            Integer num = Person.randomNum(0,30);

            person.setAge(num);
            person.setName("test");
        }

        for(Person person : personArray) {
            person.print();
        }

        System.out.println();

        List<Person> arrayList = Arrays.asList(personArray);
        arrayList.forEach(Person::print);

        System.out.println();

        Arrays.sort(personArray, Person::compareByAge);

        arrayList.forEach(Person::print);


    }
}
