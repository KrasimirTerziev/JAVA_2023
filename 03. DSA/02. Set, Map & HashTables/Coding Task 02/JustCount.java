import java.util.*;

public class CharacterCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputString = scanner.nextLine();
        scanner.close();

        String result = countCharacters(inputString);
        System.out.println(result);
    }

    public static String countCharacters(String inputString) {
        Map<Character, Integer> lowercaseCount = new HashMap<>();
        Map<Character, Integer> uppercaseCount = new HashMap<>();
        Map<Character, Integer> symbolCount = new HashMap<>();

        for (char c : inputString.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lowercaseCount.put(c, lowercaseCount.getOrDefault(c, 0) + 1);
            } else if (Character.isUpperCase(c)) {
                uppercaseCount.put(c, uppercaseCount.getOrDefault(c, 0) + 1);
            } else {
                symbolCount.put(c, symbolCount.getOrDefault(c, 0) + 1);
            }
        }

        int lowercaseMax = getMaxCount(lowercaseCount);
        int uppercaseMax = getMaxCount(uppercaseCount);
        int symbolMax = getMaxCount(symbolCount);

        List<Character> lowercaseChars = getCharactersWithMaxCount(lowercaseCount, lowercaseMax);
        List<Character> uppercaseChars = getCharactersWithMaxCount(uppercaseCount, uppercaseMax);
        List<Character> symbolChars = getCharactersWithMaxCount(symbolCount, symbolMax);

        String lowercaseOutput = lowercaseChars.isEmpty() ? "-" : lowercaseChars.get(0) + " " + lowercaseMax;
        String uppercaseOutput = uppercaseChars.isEmpty() ? "-" : uppercaseChars.get(0) + " " + uppercaseMax;
        String symbolOutput = symbolChars.isEmpty() ? "-" : symbolChars.get(0) + " " + symbolMax;

        return symbolOutput + "\n" + lowercaseOutput + "\n" + uppercaseOutput;
    }

    public static int getMaxCount(Map<Character, Integer> charCountMap) {
        if (charCountMap.isEmpty()) {
            return 0;
        }
        return Collections.max(new ArrayList<>(charCountMap.values()));
    }

    public static List<Character> getCharactersWithMaxCount(Map<Character, Integer> charCountMap, int maxCount) {
        List<Character> characters = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() == maxCount) {
                characters.add(entry.getKey());
            }
        }
        return characters;
    }
}