package lebedeva;

/**
 * Трёхмерный вектор.
 *
 * @author Lebedeva Maria
 */
public final class Vector3D implements Vector {

    private final double x;

    private final double y;

    private final double z;

    /**
     * Вектор в начале координат
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
    public int dimension() {
        return 3;
    }

    @Override
    public double getComponent(int i) {
        switch (i) {
            case 1:
                return this.x;
            case 2:
                return this.y;
            case 3:
                return this.z;
            default:
                throw new IllegalArgumentException("запрашиваемая компонента превышает размерность вектора");
        }
    }

    @Override
    public double scalar(Vector other) {
        if (other.dimension() != this.dimension()) {
            throw new IllegalArgumentException("размерности векторов не совпадают");
        }

        // Можно и циклом, но бабушка учила меня, что циклы - злоЪ.
        // Мы же, на данном шаге знаем, что размерность обоих векторов = 3

        double multX = other.getComponent(1) * this.getComponent(1);
        double multY = other.getComponent(2) * this.getComponent(2);
        double multZ = other.getComponent(3) * this.getComponent(3);

        return multX + multY + multZ;
    }

    @Override
    public Vector add(Vector other) {
        if (other.dimension() != this.dimension()) {
            throw new IllegalArgumentException("размерности векторов не совпадают");
        }

        // Помятуя о бабушке... и о том, что класс таки неизменяемый.

        double sumX = other.getComponent(1) + this.getComponent(1);
        double sumY = other.getComponent(2) + this.getComponent(2);
        double sumZ = other.getComponent(3) + this.getComponent(3);

        return new Vector3D(sumX, sumY, sumZ);
    }

    @Override
    public Vector sub(Vector other) {
        if (other.dimension() != this.dimension()) {
            throw new IllegalArgumentException("размерности векторов не совпадают");
        }

        // ... икается ей, наверное ...

        double difX = this.getComponent(1) - other.getComponent(1);
        double difY = this.getComponent(2) - other.getComponent(2);
        double difZ = this.getComponent(3) - other.getComponent(3);

        return new Vector3D(difX, difY, difZ);
    }

    @Override
    public Vector multiply(double factor) {

        double newX = this.getComponent(1) * factor;
        double newY = this.getComponent(2) * factor;
        double newZ = this.getComponent(3) * factor;

        return new Vector3D(newX, newY, newZ);
    }

    @Override
    public double len() {

        // Лааадно, уговорили

        double temporary = 0.0D;
        for (int i = 1; i <= this.dimension(); i++) {
            temporary += Math.pow(this.getComponent(i), 2);
        }

        return Math.sqrt(temporary);
    }
}
