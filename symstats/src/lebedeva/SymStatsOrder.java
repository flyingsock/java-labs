package lebedeva;

import java.util.*;

/**
 * @author flyingsock
 */
public class SymStatsOrder extends SymStats {

    public SymStatsOrder(String target) {
        super(target);
    }

    @Override
    public void writeStats() {

        List<String> strings = new ArrayList<>();

        for (Map.Entry<Character, Integer> entry : this.stats.entrySet()) {
            if (entry.getValue() > 0) {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < entry.getValue(); i++) {
                    builder.append(entry.getKey());
                }
                strings.add(builder.toString());
            }
        }

        strings.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1;
                } else if (o1.length() < o2.length()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        for (String s : strings) {
            System.out.println(s);
        }
    }
}
