import java.util.HashMap;
import java.util.Map;

public class OOPSBannerAppUC7 {

    // Static Inner Class to store character and its pattern
    static class CharacterPattern {
        private char character;
        private String[] pattern;

        public CharacterPattern(char character, String[] pattern) {
            this.character = character;
            this.pattern = pattern;
        }

        public char getCharacter() {
            return character;
        }

        public String[] getPattern() {
            return pattern;
        }
    }

    // Map to store all character patterns
    static class CharacterPatternMap {
        private static final Map<Character, CharacterPattern> patternMap = new HashMap<>();

        static {
            patternMap.put('O', new CharacterPattern('O', new String[]{
                    " *** ",
                    "*   *",
                    "*   *",
                    "*   *",
                    " *** "
            }));

            patternMap.put('P', new CharacterPattern('P', new String[]{
                    "**** ",
                    "*   *",
                    "**** ",
                    "*    ",
                    "*    "
            }));

            patternMap.put('S', new CharacterPattern('S', new String[]{
                    " ****",
                    "*    ",
                    " *** ",
                    "    *",
                    "**** "
            }));
        }

        public static String[] getPattern(char ch) {
            CharacterPattern cp = patternMap.get(ch);
            return (cp != null) ? cp.getPattern() : null;
        }
    }

    public static void main(String[] args) {

        String word = "OOPS";
        int height = 5;

        StringBuilder[] banner = new StringBuilder[height];

        for (int i = 0; i < height; i++) {
            banner[i] = new StringBuilder();
        }

        for (char ch : word.toCharArray()) {
            String[] pattern = CharacterPatternMap.getPattern(ch);

            for (int i = 0; i < height; i++) {
                banner[i].append(pattern[i]).append("  ");
            }
        }

        for (StringBuilder line : banner) {
            System.out.println(line);
        }
    }
} 