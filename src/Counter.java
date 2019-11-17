import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Map.Entry.comparingByKey;

public class Counter {
    public static void main(String[] args) {
        HashMap<String, String[]> subjects;
        System.out.println("Input sentence: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        Stream<Map.Entry<Character, List<String>>> test = test(userInput);
        printCountedInput(test);
    }

    private static void printCountedInput(Stream<Map.Entry<Character, List<String>>> characterCounter) {
        characterCounter.forEach(entry ->
                System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    private static Stream<Map.Entry<Character, List<String>>> test(String input) {
        input = input.toLowerCase();
        input = input.replaceAll("\\p{Punct}", "");

        String[] split = input.split(" ");
        HashMap<Character, List<String>> characterListHashMap = new HashMap<>();
        char[] chars = input.toCharArray();

        for (char c : chars) {
            if (c == ' ') {
                continue;
            }
            characterListHashMap.put(c, getWordsWithChar(c, split));
        }
        return characterListHashMap.entrySet().stream().sorted(comparingByKey());
    }

    private static List<String> getWordsWithChar(char c, String[] split) {
        return Arrays.stream(split)
                .filter(word -> contains(word, c))
                .distinct()
                .collect(Collectors.toList());
    }

    private static boolean contains(String str, char chr) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == chr) {
                return true;
            }
        }
        return false;
    }


}

