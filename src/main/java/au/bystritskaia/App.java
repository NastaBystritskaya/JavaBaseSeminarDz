package au.bystritskaia;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{

    /**
     * Список имен к задаче 2.
     */
    private static final List<String> names = List.of(
            "Иван Иванов",
            "Светлана Петрова",
            "Кристина Белова",
            "Анна Мусина",
            "Анна Крутова",
            "Иван Юрин",
            "Петр Лыков",
            "Павел Чернов",
            "Петр Чернышов",
            "Мария Федорова",
            "Марина Светлова",
            "Мария Савина",
            "Мария Рыкова",
            "Марина Лугова",
            "Анна Владимирова",
            "Иван Мечников",
            "Петр Петин",
            "Иван Ежов"
    );

    /**
     * Главный метод.
     * @param args Аргументы
     */
    public static void main( String[] args )
    {
        printInCount();
        printDuelInList();
    }

    /**
     * Задача 2. Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.
     */
    private static void printDuelInList() {
        System.out.println("Количество популярных имен в списке:");
        Map<String, Integer> res = names.stream().collect(Collectors.toMap(v1 -> v1.split(" ")[0], val2-> 1, Integer::sum));
        System.out.println(res.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).map(entry -> entry.getKey() + ":" + entry.getValue()).collect(Collectors.joining(", \n")));

    }

    /**
     * Задача 1. Подсчитать количество вхождения каждого слова.
     */
    private static void printInCount() {
        String text = "Россия идет вперед всей планеты. Планета — это не Россия.";
        System.out.printf("""
                Количество вхождений слов в тексте '%s'
                %n""", text);
        Map<String,Integer> res = getInCount(text);
        System.out.println(res.entrySet().stream().map(entry -> entry.getKey() + ":" + entry.getValue()).collect(Collectors.joining(", \n")));
    }

    /**
     * Подчет количетсва вхождений слова.
     * @param text Текст
     * @return Map с количеством вхождений
     */
    private static Map<String,Integer> getInCount(String text) {
        Map<String,Integer> result = new HashMap<>();
        Arrays.asList(text
                .replaceAll("[!-,.?—:;]", "")
                .replace("  ", " ")
                .split(" ")).forEach(word -> result.merge(word.toLowerCase(),1, Integer::sum));
        return result;
    }
}
