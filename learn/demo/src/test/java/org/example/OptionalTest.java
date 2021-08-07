package org.example;

import lombok.Data;
import org.junit.Test;

import java.util.Optional;

@Data
class Car {
    String id;
    Insurance ins;

    public Car(String id, Insurance ins) {
        this.id = id;
        this.ins = ins;
    }

    public Optional<Insurance> getIns() {
        return Optional.ofNullable(ins);
    }
}

@Data
class Insurance {
    String name;
    String age;

    public Insurance(String name, String age) {
        this.name = name;
        this.age = age;
    }
}

public class OptionalTest {

    @Test
    public  void testDemo() {

        Insurance ins = new Insurance("1", "2");
        Car car = new Car("1", ins);
        Optional<Insurance> insOpt = Optional.ofNullable(ins);
        Optional<String> name  = insOpt.map(Insurance::getName);

        Optional<Car> carOpt = Optional.ofNullable(car);


        Optional<String> name1  = carOpt.flatMap(Car::getIns).map(Insurance::getName);
        System.out.println(name1.orElse("23"));

        insOpt.filter(value -> "1".equals((ins.getName()))).ifPresent(x->System.out.println("ok"));

    }
}
