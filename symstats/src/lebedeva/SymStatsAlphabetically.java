package lebedeva;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author flyingsock
 */
public class SymStatsAlphabetically extends SymStats {

    public SymStatsAlphabetically(String target) {
        super(target);
    }

    @Override
    public void writeStats() {

        List<Character> chars = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : this.stats.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                chars.add(entry.getKey());
            }
        }

        Collections.sort(chars);

        StringBuilder builder = new StringBuilder();

        for (Character character : chars) {
            builder.append(character);
        }

        System.out.println(builder.toString());
    }
}
