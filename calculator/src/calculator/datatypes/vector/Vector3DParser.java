package calculator.datatypes.vector;

import calculator.AbstractValue;
import calculator.AbstractValueParser;
import calculator.ParseValueException;

/**
 * @author amricko0b
 * @since 10/13/18
 */
public class Vector3DParser implements AbstractValueParser {

    @Override
    public AbstractValue parse(String value) throws ParseValueException {
        if (!value.matches("\\[[0-9,]+\\]")) {
            throw new NumberFormatException("неверный формат: формат комплексного числа (r,i)");
        }

        String[] components = value.replace('[', '\0')
                .replace(']', '\0')
                .replace(',', ' ').split("\\s");

        return new Vector3D(Double.parseDouble(components[0]), Double.parseDouble(components[1]), Double.parseDouble(components[2]));
    }

    @Override
    public String getDatatypeName() {
        return "трёхмерный вектор";
    }
}
