package books;

import org.openqa.selenium.WebDriver;
import utils.BaseUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainClass extends BaseUtils {
    static WebDriver driverFirefox;

    public static void main(String[] args) {

        /*var result = new ArrayList<>();
        Stream.of("hello there again".split(" ")).collect(Collectors.toCollection(LinkedList::new))
                .descendingIterator().forEachRemaining(result::add);*/

        //System.out.println(Collections.reverse(Stream.of("hello there again".split(" ")).collect(Collectors.toList())));

        String result = Stream.of("hello there again testing".split(" ")).map(s -> s + " ").collect(
                Collectors.collectingAndThen(
                        Collectors.toList(),
                        l -> {
                            Collections.reverse(l);
                            return l;
                        }
                )
        ).stream().collect(Collectors.joining());

        System.out.println(result);

    }
}
