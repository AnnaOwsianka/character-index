import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class CounterTest {

    @Test
    public void testSentence() {
        String input = "ala ma kota, kot koduje w Javie Kota";
        input = input.toLowerCase();
        String s = input.replaceAll("\\p{Punct}", "");
        String[] split = s.split(" ");
        HashMap<Character, List<String>> characterListHashMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            characterListHashMap.put(c, getWordsWithChar(c, split));
        }
        System.out.println("Output: " + characterListHashMap);
    }

    private List<String> getWordsWithChar(char c, String[] split) {
        return Arrays.stream(split)
                .filter(word -> contains(word, c))
                .distinct()
                .collect(Collectors.toList());
    }

    public boolean contains(String str, char chr) {

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == chr) {
                return true;
            }
        }
        return false;
    }
}
