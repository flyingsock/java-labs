package calculator.datatypes.complex;

import calculator.AbstractValue;
import calculator.AbstractValueParser;
import calculator.ParseValueException;

/**
 * @author Lebedeva Maria
 */
public class ComplexValueParser implements AbstractValueParser {

    @Override
    public AbstractValue parse(String value) throws ParseValueException {

        if (!value.matches("\\([0-9]+,[0-9]+\\)")) {
            throw new NumberFormatException("неверный формат: формат комплексного числа (r,i)");
        }

        String[] components = value.replace('(', '\0')
                .replace(')', '\0')
                .replace(',', ' ').split("\\s");

        return new ComplexValue(Double.parseDouble(components[0]), Double.parseDouble(components[1]));
    }

    @Override
    public String getDatatypeName() {
        return "комплексные числа";
    }
}
