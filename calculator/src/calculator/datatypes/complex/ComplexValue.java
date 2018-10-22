package calculator.datatypes.complex;

import calculator.AbstractValue;
import calculator.DivisionByZeroException;
import calculator.OperationNotSupportedException;

/**
 * @author Lebedeva Maria
 */
public class ComplexValue extends AbstractValue {

    private final double real;

    private final double imaginary;

    public ComplexValue(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    @Override
    public AbstractValue add(AbstractValue operand) throws OperationNotSupportedException {
        if (operand instanceof ComplexValue) {
            double real = this.real + ((ComplexValue) operand).real;
            double imaginary = this.imaginary + ((ComplexValue) operand).imaginary;
            return new ComplexValue(real, imaginary);
        } else {
            throw new OperationNotSupportedException("операнды разных типов");
        }
    }

    @Override
    public AbstractValue sub(AbstractValue operand) throws OperationNotSupportedException {
        if (operand instanceof ComplexValue) {
            double real = this.real - ((ComplexValue) operand).real;
            double imaginary = this.imaginary - ((ComplexValue) operand).imaginary;
            return new ComplexValue(real, imaginary);
        } else {
            throw new OperationNotSupportedException("операнды разных типов");
        }
    }

    @Override
    public AbstractValue mul(AbstractValue operand) throws OperationNotSupportedException {
        if (operand instanceof ComplexValue) {
            ComplexValue complex = (ComplexValue) operand;
            double real = (this.real * complex.real) - (this.imaginary * complex.imaginary);
            double imaginary = (this.imaginary * complex.real) + (this.real * complex.imaginary);
            return new ComplexValue(real, imaginary);
        } else {
            throw new OperationNotSupportedException("операнды разных типов");
        }
    }

    @Override
    public AbstractValue div(AbstractValue operand) throws DivisionByZeroException, OperationNotSupportedException {
        if (operand instanceof ComplexValue) {
            ComplexValue complex = (ComplexValue) operand;
            double divider = Math.pow(this.real, 2) + Math.pow(complex.imaginary, 2);

            if (divider == 0.0D) {
                throw new DivisionByZeroException();
            }

            double real = (this.real * complex.real) + (this.imaginary * complex.imaginary);
            double imaginary = (this.imaginary * complex.real) - (this.real * complex.imaginary);
            return new ComplexValue(real / divider, imaginary / divider);
        } else {
            throw new OperationNotSupportedException("операнды разных типов");
        }
    }

    @Override
    public String toString() {
        return "(" + this.real + ',' + this.imaginary + "j)";
    }
}
