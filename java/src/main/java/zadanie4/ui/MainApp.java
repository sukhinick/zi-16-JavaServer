package zadanie4.ui;

import zadanie4.logic.VoyageService;
import zadanie4.logic.VoyageServiceImpl;
import zadanie4.model.Voyage;
import zadanie4.model.VoyageType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class MainApp {

    private static final VoyageService voyageService = new VoyageServiceImpl();
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        runUI();
    }

    private static void runUI() throws IOException {
        boolean sort = askAction();
        if (sort) {
            String field = askSortProperty();
            List<Voyage> voyages = voyageService.getSortedBy(field);
            System.out.println("Список доступных путёвок, отсортированный по " + field);
            voyages.forEach(System.out::println);
        } else {
            VoyageType type = askType();
            Byte duration = askDuration();
            List<Voyage> voyages = voyageService.filter(type, duration);
            System.out.println("Вот, что мы можем вам предложить");
            voyages.forEach(System.out::println);
            System.out.println("Правда, заманчиво?)");
        }
    }

    private static Byte askDuration() throws IOException {
        System.out.println("Введите минимальную желаемую продолжительность путёвки (в днях)");
        String duration = reader.readLine();
        return Byte.valueOf(duration);
    }

    private static VoyageType askType() throws IOException {
        System.out.println("Введите желаемый тип путёвки (варианты - " + Arrays.toString(VoyageType.values()) + ")");
        String type = reader.readLine();
        try {
            return VoyageType.valueOf(type);
        } catch (IllegalArgumentException e) {
            System.out.println("Тип путёвки не распознан");
            askType();
        }
        throw new RuntimeException(""); // никогда не сработает.
    }

    private static String askSortProperty() throws IOException {
        System.out.println("По какому полю сортируем? Доступны: type, duration, mealIncluded");
        String field = reader.readLine();
        if (!field.equals("type") && !field.equals("duration") && !field.equals("mealIncluded")) {
            System.out.println("Некорректный ввод - выберите поле для сортировки");
            askSortProperty();
        }
        return field;
    }

    private static boolean askAction() throws IOException {
        System.out.println("1. Сортировать");
        System.out.println("2. Выбрать путёвку");
        System.out.println("0. Выход из программы");
        String line = reader.readLine();
        if (line.equals("0")) {
            System.out.println("До скорых встреч!");
            System.exit(0);
        }
        return line.equals("1");
    }
}
