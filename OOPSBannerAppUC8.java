import java.util.HashMap;
import java.util.Map;

public class OOPSBannerApp {

    private static final int HEIGHT = 5;

    // Centralized Character Pattern Storage
    private static Map<Character, String[]> patternMap = new HashMap<>();

    public static void main(String[] args) {

        initializePatterns();
        renderBanner("OOPS");
    }

    // Initialize HashMap with character patterns
    private static void initializePatterns() {

        patternMap.put('O', new String[]{
                " *** ",
                "*   *",
                "*   *",
                "*   *",
                " *** "
        });

        patternMap.put('P', new String[]{
                "**** ",
                "*   *",
                "**** ",
                "*    ",
                "*    "
        });

        patternMap.put('S', new String[]{
                " ****",
                "*    ",
                " *** ",
                "    *",
                "**** "
        });
    }

    // Render function using Map lookup + StringBuilder
    private static void renderBanner(String word) {

        StringBuilder[] banner = new StringBuilder[HEIGHT];

        for (int i = 0; i < HEIGHT; i++) {
            banner[i] = new StringBuilder();
        }

        for (char ch : word.toCharArray()) {

            String[] pattern = patternMap.get(ch);

            if (pattern == null) {
                continue; // skip unknown characters
            }

            for (int i = 0; i < HEIGHT; i++) {
                banner[i].append(pattern[i]).append("  ");
            }
        }

        for (StringBuilder line : banner) {
            System.out.println(line);
        }
    }
}