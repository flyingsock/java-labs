package calculator.datatypes.vector;

import calculator.AbstractValue;
import calculator.DivisionByZeroException;
import calculator.OperationNotSupportedException;
import calculator.datatypes.real.RealValue;

/**
 * “рЄхмерный вектор.
 *
 * @author Lebedeva Maria
 */
public final class Vector3D extends AbstractValue {

    private static final double ORIGIN = 0.0D;

    private final double x;

    private final double y;

    private final double z;

    /**
     * ¬ектор в начале координат
     */
    public Vector3D() {
        this.x = ORIGIN;
        this.y = ORIGIN;
        this.z = ORIGIN;
    }

    public Vector3D(double x) {
        this.x = x;
        this.y = ORIGIN;
        this.z = ORIGIN;
    }

    public Vector3D(double x, double y) {
        this.x = x;
        this.y = y;
        this.z = ORIGIN;
    }

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public AbstractValue add(AbstractValue operand) throws OperationNotSupportedException {
        if (operand instanceof Vector3D) {
            Vector3D vector3D = (Vector3D) operand;

            double newX = this.x + vector3D.x;
            double newY = this.y + vector3D.y;
            double newZ = this.z + vector3D.z;

            return new Vector3D(newX, newY, newZ);
        } else {
            throw new OperationNotSupportedException("операнды разных типов");
        }
    }

    @Override
    public AbstractValue sub(AbstractValue operand) throws OperationNotSupportedException {
        throw new OperationNotSupportedException("операци€ делени€ не определена дл€ векторов");
    }

    @Override
    public AbstractValue mul(AbstractValue operand) throws OperationNotSupportedException {
        if (operand instanceof Vector3D) {
            Vector3D vector3D = (Vector3D) operand;

            double newX = this.x * vector3D.x;
            double newY = this.y * vector3D.y;
            double newZ = this.z * vector3D.z;

            // —кал€рное произведение - возращаем скал€р
            return new RealValue(newX + newY + newZ);
        } else {
            throw new OperationNotSupportedException("операнды разных типов");
        }
    }

    @Override
    public AbstractValue div(AbstractValue operand) throws DivisionByZeroException,
            OperationNotSupportedException {
        if (operand instanceof Vector3D) {
            Vector3D vector3D = (Vector3D) operand;

            double newX = this.x - vector3D.x;
            double newY = this.y - vector3D.y;
            double newZ = this.z - vector3D.z;

            return new Vector3D(newX, newY, newZ);
        } else {
            throw new OperationNotSupportedException("операнды разных типов");
        }
    }

    @Override
    public String toString() {
        return "[" + this.x + ',' + this.y + ',' + this.z + "]";
    }
}
