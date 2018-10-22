package lebedeva;

import java.util.Stack;

/**
 * @author Lebedeva Maria
 */
public class StringValidatorImpl implements StringValidator {

    private static final char PARANTHESIS = '(';

    private static final char BRACE = '{';

    private static final char BRACKET = '[';

    private static final char ANGULAR = '<';

    private static final char CLOSED_PARANTHESIS = ')';

    private static final char CLOSED_BRACE = '}';

    private static final char CLOSED_BRACKET = ']';

    private static final char CLOSED_ANGULAR = '>';

    private final Stack<Character> stack;

    private final String incoming;

    private int errorPos;

    public StringValidatorImpl(String incoming) {
        this.incoming = incoming;
        this.stack = new Stack<>();
    }

    @Override
    public boolean isValid() {
        for (int i = 0; i < this.incoming.length(); i++) {
            final char ch = this.incoming.charAt(i);
            if (ch == PARANTHESIS || ch == BRACKET || ch == BRACE || ch == ANGULAR) {
                this.stack.push(ch);
            }

            if (ch == CLOSED_BRACE || ch == CLOSED_BRACKET || ch == CLOSED_PARANTHESIS || ch == CLOSED_ANGULAR) {
                if (!this.stack.isEmpty()) {
                    char last = stack.peek();
                    if (ch == CLOSED_BRACE && last == BRACE
                            || ch == CLOSED_PARANTHESIS && last == PARANTHESIS
                            || ch == CLOSED_BRACKET && last == BRACKET
                            || ch == CLOSED_ANGULAR && last == ANGULAR) {
                        stack.pop();
                    } else {
                        this.errorPos = i;
                        return false;
                    }
                } else {
                    this.errorPos = i;
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    @Override
    public int getErrorPos() {
        return this.errorPos;
    }

    @Override
    public String getErrorMessage() {
        return this.isValid() ? "Строка сбалансирована" : "Строка несбалансирована";
    }
}
