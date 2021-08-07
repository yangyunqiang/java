package org.example;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.lang.reflect.Type;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }


    @Test
    public void testForeach() {
        Collection collection = new ArrayList();
        collection.add("i");
        collection.add("love");
        collection.add("china");
        collection.add(1);
        collection.remove("i");


        for (Iterator iterator = collection.iterator(); iterator.hasNext();) {// foreach遍历
            iterator.next();
            iterator.remove();
            break;
        }
        collection.forEach(e-> System.out.println(e));
        // 可以使用方法引用简写
        //collection.forEach(System.out::println);
        // 或者迭代器的forEachRemaining方法
        //collection.iterator().forEachRemaining(System.out::println);
    }

    @Test
    public void testSteam() {


        List<String> list = Stream.of("1", "2", "3").filter(x -> {
                    System.out.println(x);
                    return true;
                }
        ).collect(Collectors.toList());

        list.forEach(x -> System.out.println(x) );
    }

    @Test
    public void testMaxSteam() {

        class Track {
            String name;
            Integer price;

            public Track(String name, Integer price) {
                this.name = name;
                this.price = price;
            }

            void print() {
                System.out.printf("name: %s, price: %d", name, price);
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Integer getPrice() {
                return price;
            }

            public void setPrice(Integer price) {
                this.price = price;
            }
        };

        List<Track> tracks = asList(new Track("aa", 524),
                new Track("ab", 523),
                new Track("ac", 522),
                new Track("ad", 521));

        Track shortTrack = tracks.stream().min(Comparator.comparing((track -> track.getPrice()))).get();
        shortTrack.print();
    }

    @Test
    public void testOptional() {
        
    }

    enum Color {RED, GREEN, YELLOW}
    @Test
    public void testEnum() {
        for (Color color : Color.values()) {
            System.out.println("ordinal:" + color.ordinal() + ",name: " + color.name());
        }

        for (Color color : Color.class.getEnumConstants()) {
            System.out.println("ordinal:" + color.ordinal() + ",name: " + color.name());
        }

        System.out.println("ordinal:" + Color.valueOf("RED").ordinal() + ",name: " + Color.valueOf("RED").name());


        System.out.println(Model.class.getGenericInterfaces()[0].getTypeName());
        System.out.println("------------");
        System.out.println(Model.class.getInterfaces()[0].getName());

        Collection<String> collection = new ArrayList<>();
        collection.add("1");
        collection.add("2");

        Iterator iterator = collection.iterator();
        System.out.println(iterator.next());
        System.out.println(iterator.next());
    }

    @Test
    public void testLocalTimeDate() {

        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime2 = LocalDateTime.now().plusHours(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String stringDate = formatter.format(localDateTime);
        System.out.println(stringDate);


        System.out.println(System.currentTimeMillis());

        System.out.println(Instant.now().getEpochSecond());
        //int day = Instant.now().get(ChronoField.DAY_OF_MONTH);

        System.out.println("-----------------------------");
        Duration d1 = Duration.between(localDateTime2, localDateTime);
        System.out.println(d1.getSeconds());

    }


}
