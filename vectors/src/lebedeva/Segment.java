package lebedeva;

/**
 * Отрезок.
 *
 * @author Lebedeva Maria
 */
public class Segment {

    private final Vector start;

    private final Vector end;

    public Segment(Vector start, Vector end) {
        this.start = start;
        this.end = end;
    }

    public double len() {
        return end.sub(this.start).len();
    }

    public double distanceTo(Vector point) {

        final double x1 = start.getComponent(0);
        final double y1 = start.getComponent(1);

        final double x2 = end.getComponent(0);
        final double y2 = end.getComponent(1);

        final double x0 = point.getComponent(0);
        final double y0 = point.getComponent(1);

        final double dividen =  Math.abs(((y2-y1)*x0) - ((x2-x1)*y0) + (x2*y1) - (y2*x1));
        final double divider = Math.pow(y2-y1, 2) + Math.pow(x2-x1, 2);

        return dividen / Math.sqrt(divider);
    }

    public Vector getStart() {
        return start;
    }

    public Vector getEnd() {
        return end;
    }
}
