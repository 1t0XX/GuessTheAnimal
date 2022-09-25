import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> allWords = List.of(new Scanner(System.in).nextLine().split("\\W+"));
        Map<String, Long> mapOfWords = allWords.stream()
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()));

        Map<String, Long> result = mapOfWords.entrySet().stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(Map.Entry<String, Long>::getValue))
                        .thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        result.entrySet().stream()
                .map(e -> e.getKey())
                .limit(10)
                .forEach(System.out::println);


    }
}