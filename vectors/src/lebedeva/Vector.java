package lebedeva;

/**
 * @author amricko0b
 * @since 10/12/18
 */
public interface Vector {

    /**
     * Начало координат
     */
    public static double ORIGIN = 0.0D;

    int dimension();

    double getComponent(int i);

    double scalar(Vector v);

    double len();

    Vector multiply(double factor);

    Vector add(Vector v);

    Vector sub(Vector v);
}
