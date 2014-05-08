package perso.challenges.crackthecode.arraysandstring;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertTrue;


/**
 * User: sennen
 * Date: 02/05/2014
 * Time: 13:10
 */
public class ArrayUtilsTest {
    private static final int[][] IMG_2_2 = {{2, 1}, {3, 4}};
    private static final int[][] IMG_2_2_ROTATED = {{3, 2}, {4, 1}};
    private static final int[][] IMG_3_3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    private static final int[][] IMG_3_3_ROTATED = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
    private static final int[][] IMG_3_4 = {{1, 2, 3, 0}, {4, 5, 6, 10}, {7, 8, 9, 0}};
    private static final int[][] IMG_3_4_TO_ZERO = {{0, 0, 0, 0}, {4, 5, 6, 0}, {0, 0, 0, 0}};

    @Test
    public void test90DegRotation() throws Exception {
        assertArrayEquals(IMG_2_2_ROTATED, ArrayUtils.rotate(IMG_2_2));
        assertArrayEquals(IMG_3_3_ROTATED, ArrayUtils.rotate(IMG_3_3));
    }

    @Test
    public void testSetColumnAndLineToZeroForZeroElement() throws Exception {
        assertArrayEquals(IMG_2_2, ArrayUtils.setColumnAndLineToZeroForZeroElement(IMG_2_2));
        assertArrayEquals(IMG_3_3, ArrayUtils.setColumnAndLineToZeroForZeroElement(IMG_3_3));
        assertArrayEquals(IMG_3_4_TO_ZERO, ArrayUtils.setColumnAndLineToZeroForZeroElement(IMG_3_4));
    }

    private void assertArrayEquals(Object[] expected, Object[] actual) {
        assertTrue("Expected : " + Arrays.deepToString(expected) + " ; Actual : " + Arrays.deepToString(actual),
                   Arrays.deepEquals(expected, actual));
    }
}
