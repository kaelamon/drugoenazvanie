package test.otherlessons.streamapi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FruitFilter {
    public static void main(String[] args) throws IOException {
        System.out.println(fruitStream()
                .filter(fruit -> fruit.isFresh == true)
                .collect(Collectors.toList()));

        System.out.println(fruitStream()
                .filter(fruit -> fruit.isFresh == false)
                .peek((fruit) -> fruit.setToDo("выкинуть в мусорку"))
                .collect(Collectors.toList()));

        System.out.println(fruitStream()
                .filter(fruit -> fruit instanceof Orange & fruit.isFresh)
                .peek(fruit -> ((Orange) fruit).eatOrange())
                .collect(Collectors.toList()));

        System.out.println(fruitStream()
                .filter(fruit -> fruit instanceof Apple & fruit.isFresh)
                .limit(2)
                .peek(fruit -> ((Apple) fruit).makeJam())
                .collect(Collectors.toList()));

        FruitFilter fruitFilter = new FruitFilter();
        System.out.println(fruitFilter
                .byFile().filter(s -> s.equals("Orange")).map(s -> new Orange(true,""))
                .collect(Collectors.toList()));
        System.out.println(fruitFilter
                .byFile().filter(s -> s.equals("Apple")).map(s -> new Apple(true,""))
                .collect(Collectors.toList()));
    }

    static Stream<Fruit> fruitStream() {
        List<Fruit> fruits = new ArrayList<>(){
            {
                add(new Apple(true, ""));
                add(new Apple(false, ""));
                add(new Apple(true, ""));
                add(new Apple(false, ""));
                add(new Apple(true, ""));
                add(new Orange(false, ""));
                add(new Orange(true, ""));
                add(new Orange(false, ""));
                add(new Orange(true, ""));
                add(new Orange(false, ""));
            }
        };
        return fruits.stream();
    }

    // stream для 5-го задания
    Stream<String> byFile() throws IOException {
        return Files.lines(Path.of("src/test/java/test/otherlessons/streamapi/output.txt"));
    }
}
