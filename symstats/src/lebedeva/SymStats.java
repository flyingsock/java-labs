package lebedeva;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author amricko0b
 * @since 10/14/18
 */
public class SymStats  {

    private static final List<Character> VOWELLS
            = Arrays.asList('А', 'О', 'У', 'Ы', 'И', 'E', 'Ё', 'Э', 'Я', 'Ю', 'Й');

    private final char[] target;

    private final Map<Character, Integer> stats = new HashMap<>();

    public SymStats(String target) {
        this.target = target.toUpperCase().toCharArray();

        for (char ch : VOWELLS) {
            this.stats.put(ch, 0);
        }
    }

    /**
     * Вычисляет статистику использования символов в данной строке
     */
    public void calculate() {
        for (char ch : target) {
            if (VOWELLS.contains(ch)) {
                int current = this.stats.get(ch);
                this.stats.put(ch, ++current);
            }
        }
    }

    /**
     * Возвращает количество вхождений указанного символа
     */
    public int countChar(char c) {
        return this.stats.get(c);
    }

    /**
     * Возвращает общее число подсчитываемых символов
     */
    public int countTotal() {
        return this.target.length;
    }

    /**
     * Выдает подсчитанную статистику на экран
     */
    public void writeStats() {
        for (Map.Entry<Character, Integer> entry : this.stats.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                System.out.print(entry.getKey());
            }
        }
    }
}
