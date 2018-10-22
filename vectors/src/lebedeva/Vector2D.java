package lebedeva;

/**
 * @author amricko0b
 * @since 10/12/18
 */
public class Vector2D implements Vector {

    /**
     * Начало координат
     */


    private final double x;

    private final double y;

    /**
     * Вектор в начале координат
     */
    public Vector2D() {
        this.x = ORIGIN;
        this.y = ORIGIN;
    }

    public Vector2D(double x) {
        this.x = x;
        this.y = ORIGIN;
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
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

        return multX + multY;
    }

    @Override
    public Vector add(Vector other) {
        if (other.dimension() != this.dimension()) {
            throw new IllegalArgumentException("размерности векторов не совпадают");
        }

        // Помятуя о бабушке... и о том, что класс таки неизменяемый.

        double sumX = other.getComponent(1) + this.getComponent(1);
        double sumY = other.getComponent(2) + this.getComponent(2);

        return new Vector2D(sumX, sumY);
    }

    @Override
    public Vector sub(Vector other) {
        if (other.dimension() != this.dimension()) {
            throw new IllegalArgumentException("размерности векторов не совпадают");
        }

        // ... икается ей, наверное ...

        double difX = other.getComponent(1) - this.getComponent(1);
        double difY = other.getComponent(2) - this.getComponent(2);

        return new Vector2D(difX, difY);
    }

    @Override
    public Vector multiply(double factor) {

        double newX = this.getComponent(1) * factor;
        double newY = this.getComponent(2) * factor;

        return new Vector2D(newX, newY);
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
