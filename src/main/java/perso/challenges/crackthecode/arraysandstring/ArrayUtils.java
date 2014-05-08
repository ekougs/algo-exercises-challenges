package perso.challenges.crackthecode.arraysandstring;

/**
 * User: sennen
 * Date: 02/05/2014
 * Time: 13:10
 */
public class ArrayUtils {
    public static int[][] rotate(int[][] matrix) {
        int imgLength = matrix.length;
        for (int position = 0, lastIndex = imgLength - 1; position < imgLength / 2; position++, lastIndex--) {
            for (int index = position; index < lastIndex; index++) {
                // Colonne position inversee remplace ligne position
                // Ligne position remplace colonne lastIndex
                // Colonne lastIndex remplace ligne lastIndex inversee
                // Ligne lastIndex inversee remplace colonne position inversee
                int invertedIndex = lastIndex - index;
                int temp1 = matrix[position][index];
                matrix[position][index] = matrix[invertedIndex][position];
                matrix[invertedIndex][position] = matrix[lastIndex][invertedIndex];
                matrix[lastIndex][invertedIndex] = matrix[index][lastIndex];
                matrix[index][lastIndex] = temp1;
            }
        }
        return matrix;
    }

    public static int[][] setColumnAndLineToZeroForZeroElement(int[][] matrix) {
        int rowSize = matrix.length;
        int columnSize = matrix[0].length;
        boolean[] linesToReset = new boolean[rowSize];
        boolean[] columnsToReset = new boolean[columnSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                if(matrix[i][j] == 0) {
                    linesToReset[i] = true;
                    columnsToReset[j] = true;
                }
            }
        }
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                if(linesToReset[i] || columnsToReset[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }
}
