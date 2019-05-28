package zadanie3;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class AirLineFilteringApp {
    private static AirLine[] airLines = {
            new AirLine("Симферополь",
                    "22",
                    "Typical",
                    LocalTime.of(12, 40),
                    Collections.singleton(DayOfWeek.MONDAY)
            ),
            new AirLine("Москва",
                    "33",
                    "Typical",
                    LocalTime.of(13, 30),
                    Collections.singleton(DayOfWeek.WEDNESDAY)
            ),
            new AirLine("Рио-де-Жанейро",
                    "44",
                    "Typical",
                    LocalTime.of(18, 0),
                    Collections.singleton(DayOfWeek.WEDNESDAY)
            ),
            new AirLine("Париж",
                    "55",
                    "Typical",
                    LocalTime.of(8, 0),
                    Collections.singleton(DayOfWeek.WEDNESDAY)
            ),
            new AirLine(
                    "Лондон",
                    "66",
                    "Typical",
                    LocalTime.of(12, 20),
                    new HashSet<>(Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.FRIDAY))
            )
    };

    public static void main(String[] args) {
        System.out.println("В Симферополь");
        Stream.of(airLines)
                .filter(airLine -> airLine.getDestination().equals("Симферополь"))
                .forEach(System.out::println);
        System.out.println("По средам");
        Stream.of(airLines)
                .filter(airLine -> airLine.getDayOfWeeks().contains(DayOfWeek.WEDNESDAY))
                .forEach(System.out::println);
        System.out.println("По средам после 9:40");
        Stream.of(airLines)
                .filter(AirLineFilteringApp::wednesDaysAfter940)
                .forEach(System.out::println);
    }

    private static boolean wednesDaysAfter940(AirLine airLine) {
        return airLine.getDayOfWeeks().contains(DayOfWeek.WEDNESDAY) &&
                airLine.getTimeStart().isAfter(LocalTime.of(9, 40));
    }
}
