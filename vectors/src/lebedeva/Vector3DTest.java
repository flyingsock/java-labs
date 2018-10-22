package lebedeva;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author amricko0b
 * @since 10/12/18
 */

@RunWith(JUnit4.class)
public class Vector3DTest {

    @Test
    public void testAdd() {
        Vector first = new Vector3D();
        Vector second = new Vector3D(5.3D, 0, 9);

        Vector result = first.add(second);

        assert result.getComponent(1) == 5.3D;
        assert result.getComponent(2) == 0;
        assert result.getComponent(3) == 9;
    }

    @Test
    public void testSub() {
        Vector first = new Vector3D(5.3D, 0, 9);
        Vector second = new Vector3D();

        Vector result = first.sub(second);

        assert result.getComponent(1) == 5.3D;
        assert result.getComponent(2) == 0;
        assert result.getComponent(3) == 9;

        first = new Vector3D(3, 3, 3);
        second = new Vector3D(2, 1, 0);

        result = first.sub(second);

        assert result.getComponent(1) == 1;
        assert result.getComponent(2) == 2;
        assert result.getComponent(3) == 3;
    }

    @Test
    public void testMult() {
        Vector first = new Vector3D(3, 0, 5);
        Vector result = first.multiply(3);

        assert result.getComponent(1) == 9;
        assert result.getComponent(2) == 0;
        assert result.getComponent(3) == 15;
    }

    @Test
    public void testScalar() {
        Vector first = new Vector3D(5.3D, 0, 9);
        Vector second = new Vector3D();

        double result = first.scalar(second);

        assert result == 0;

        first = new Vector3D(3, 3, 3);
        second = new Vector3D(2, 1, 0);

        result = first.scalar(second);

        assert result == 9;
    }

    @Test
    public void testLen() {
        Vector first = new Vector3D(4, 4, 2);
        System.out.println(first.len());
        assert first.len() == 6.0;
    }
}
