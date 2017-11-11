package chapter2;

import java.util.Random;
import java.util.Scanner;

/**
 * Class {@code VariantC} contains methods which solve
 * tasks on matrixes
 *
 * @author Ann Kondratieva
 */

public class VariantC {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n;

        System.out.println("Input the size of matrix: ");
        n = scanner.nextInt();
        int matrix[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = new Random().nextInt(2 * n + 1) - n;
                if (matrix[i][j] >= 0) System.out.print(" " + matrix[i][j] + " ");
                else System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Task 1: ");
        printMatrix(sortArrayByOneColumn(matrix));
        System.out.println("Task 2: ");
        printMatrix(cyclicShift(matrix));
        System.out.println("Task 3: ");
        System.out.println(maxNumerOfRisingElements(matrix));
        System.out.println("Task 4: ");
        System.out.println(sumOfElementsBetweenFirstAndSecondPositiveElements(matrix));
        System.out.println("Task 5: ");
        printMatrix(transposeMatrix(matrix));
        System.out.println("Task 6: ");
        printMatrix(rotateMatrix(matrix));
        System.out.println("Task 7: ");
        System.out.println(determinantOfMatrix(matrix));
        System.out.println("Task 8: ");
        printMatrix(arithmeticalMeanOfString(matrix));
        System.out.println("Task 14: ");
        System.out.println(saddlePoints(matrix));
        System.out.println("Task 15: ");
        sortArrayBySums(matrix);
        printMatrix(matrix);
        System.out.println("Task 18: ");
        sortArrayBySumsOfCol(matrix);
        printMatrix(matrix);
        System.out.println("Task 16: ");
        System.out.println(localMin(matrix));
        System.out.println("Task 17: ");
        System.out.println(minLocalMax(matrix));
        System.out.println("Task 11: ");
        changeWithMin(matrix);
        printMatrix(matrix);
        System.out.println("Task 12: ");
        zeroAfterAll(matrix);
        printMatrix(matrix);
        System.out.println("Task 9: ");
        deleteMax(matrix);
        System.out.println("Task 10: ");
        deleteZero(matrix);
        double[][] doubles = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                doubles[i][j] = new Random().nextDouble()*10;
                if (doubles[i][j] >= 0) System.out.print(" " + doubles[i][j] + " ");
                else System.out.print(doubles[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Task 13: ");
        printMatrix(roundToInt(doubles));
        System.out.println("Task 19: ");
        maxOnMainDiagonal(doubles);
        printDoubleMatrix(doubles);




    }

    /**
     * Task: 1. Упорядочить строки матрицы в порядке возрастания значений
     * элементов k-го столбца.
     *
     * @param matrix the reference object for array.
     * @return sorted matrix
     */
    public static int[][] sortArrayByOneColumn(int[][] matrix) {
        System.out.println("Input the number of column: ");
        int k = scanner.nextInt();
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                if (matrix[j][k] < matrix[j + 1][k]) {
                    int temp[] = matrix[j];
                    matrix[j] = matrix[j + 1];
                    matrix[j + 1] = temp;
                }
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] >= 0 || matrix[i][j]>=10) System.out.print(" " + matrix[i][j] + " ");
                else System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printDoubleMatrix(double[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] >= 0) System.out.print(" " +  matrix[i][j] + " ");
                else System.out.print( matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Task: 2. Выполнить циклический сдвиг заданной матрицы на k позиций вправо
     *
     * @param matrix the reference object for array.
     * @return changed matrix
     */
    public static int[][] cyclicShift(int[][] matrix) {
        System.out.println("Input a number of positions: ");
        int k = scanner.nextInt();
        for (int i = 0; i < matrix[0].length; i++) {
            int temp[] = new int[k];
            int temp1[] = new int[matrix[0].length];
            for (int j = 0; j < matrix[0].length; j++) {
                temp1[j] = matrix[i][j];
            }
            for (int j = 0; j < k; j++) {
                temp[j] = matrix[i][matrix[0].length - k + j];
            }
            for (int j = k, m = 0; j < matrix[0].length; j++, m++) {
                matrix[i][j] = temp1[m];
            }
            for (int j = 0; j < k; j++) {
                matrix[i][j] = temp[j];
            }


        }
        return matrix;
    }

    /**
     * Task: 3. Найти и вывести наибольшее число возрастающих элемен-
     * тов матрицы, идущих подряд.
     *
     * @param matrix the reference object for array.
     * @return number of elements
     */
    public static int maxNumerOfRisingElements(int[][] matrix) {
        int num[] = new int[100];
        int m = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                if (matrix[i][j + 1] > matrix[i][j]) {
                    num[m]++;
                } else {
                    m++;
                }
            }
        }
        int max = num[0];
        for (int i = 0; i < num.length; i++) {
            if (num[i] > max) max = num[i];
        }
        return max;
    }

    /**
     * Task: 4. Найти сумму элементов матрицы, расположенных между первым и вторым
     * положительными элементами каждой строки.
     *
     * @param matrix the reference object for array.
     * @return sum of elements
     */
    public static int sumOfElementsBetweenFirstAndSecondPositiveElements(int[][] matrix) {
        int sum = 0;
        boolean positive = false;

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (matrix[i][j] > 0) {
                    if (positive) break;
                    else {
                        positive = true;
                        continue;
                    }
                }
                if (positive) sum += matrix[i][j];
            }
            positive = false;
        }
        return sum;

    }

    /**
     * Task: 5. Транспонировать квадратную матрицу.
     *
     * @param matrix the reference object for array.
     * @return transposed matrix
     */
    public static int[][] transposeMatrix(int[][] matrix) {
        int matrix1[][] = new int[matrix[0].length][matrix[0].length];

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix1[j][i] = matrix[i][j];

            }
        }

        return matrix1;
    }

    /**
     * Task: 6. Повернуть матрицу на 90 градусов против часовой стрелки.
     *
     * @param matrix the reference object for array.
     * @return changed matrix
     */
    public static int[][] rotateMatrix(int[][] matrix) {
        int[][] newMatrix = new int[matrix[0].length][matrix[0].length];

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                newMatrix[matrix[0].length - j - 1][i] = matrix[i][j];

            }
        }

        return newMatrix;
    }

    /**
     * Task: 7. Вычислить определитель матрицы.
     *
     * @param matrix the reference object for array.
     * @return the determinant of matrix
     */
    public static int determinantOfMatrix(int[][] matrix) {
        int determinant = 0;

        if (matrix[0].length == 1) determinant = matrix[0][0];
        else if (matrix[0].length == 2) {
            determinant = (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
        } else {
            for (int i = 0; i < matrix[0].length; i++) {
                int temp[][] = new int[matrix[0].length - 1][matrix[0].length - 1];
                for (int k = 0, m = 0; m < matrix[0].length - 1; k++, m++) {
                    if (k == 0) k++;
                    for (int j = 0, s = 0; s < matrix[0].length - 1; j++, s++) {
                        if (j == i) j++;
                        temp[m][s] = matrix[k][j];
                    }
                }
                determinant += matrix[0][i] * Math.pow((-1), (1 + 1 + i)) * determinantOfMatrix(temp);

            }
        }

        return determinant;
    }

    /**
     * Task: 8. Построить матрицу, вычитая из элементов каждой строки матрицы ее сред-
     * нее арифметическое.
     *
     * @param matrix the reference object for array.
     * @return created matrix
     */
    public static int[][] arithmeticalMeanOfString(int[][] matrix) {
        int[][] newMatrix = new int[matrix[0].length][matrix[0].length];
        int arithmeticalMean;


        for (int i = 0; i < matrix[0].length; i++) {
            arithmeticalMean = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                arithmeticalMean += matrix[i][j];
            }
            arithmeticalMean /= matrix[0].length;
            for (int j = 0; j < matrix[0].length; j++) {
                newMatrix[i][j] = matrix[i][j] - arithmeticalMean;
            }

        }

        return newMatrix;


    }


    /**
     * Task: 9. Найти максимальный элемент (ы) в матрице и удалить из матрицы все
     * строки и столбцы, его содержащие.
     *
     * @param matrix the reference object for array.
     */
    public static void deleteMax(int[][] matrix) {
        int max = matrix[0][0];
        int counter = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] > max) max = matrix[i][j];
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == max) {
                    counter++;
                    for (int k = i; k < matrix[0].length - 1; k++) {
                        for (int m = 0; m < matrix[0].length; m++) {
                            matrix[k][m] = matrix[k + 1][m];
                        }
                    }
                    for (int k = 0; k < matrix[0].length; k++) {
                        for (int m = j; m < matrix[0].length - 1; m++) {
                            matrix[k][m] = matrix[k][m + 1];
                        }
                    }

                    if (j != matrix[0].length  - 1 && i!=matrix[0].length  - 1) j = 0;
                    else break;
                }
            }
        }
        for (int i = 0; i < matrix[0].length - counter; i++) {
            for (int j = 0; j < matrix[0].length - counter; j++) {
                if (matrix[i][j] >= 0) System.out.print(" " + matrix[i][j] + " ");
                else System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Task: 10. Уплотнить матрицу, удаляя из нее строки и столбцы, заполненные нулями.
     *
     * @param matrix the reference object for array.
     */
    public static void deleteZero(int[][] matrix) {
        int counterStr = 0, counterCol = 0;
        boolean allIsZero;

        for (int i = 0; i < matrix[0].length; i++) {
            allIsZero = false;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    allIsZero = true;
                } else allIsZero = false;
            }
            if (allIsZero == true) {
                counterStr++;
                for (int k = i; k < matrix[0].length - 1; k++) {
                    for (int m = 0; m < matrix[0].length; m++) {
                        matrix[k][m] = matrix[k + 1][m];
                    }
                }

            }
        }
        for (int j = 0; j < matrix[0].length; j++) {
            allIsZero = false;
            for (int i = 0; i < matrix[0].length; i++) {
                if (matrix[i][j] == 0) {
                    allIsZero = true;
                } else allIsZero = false;
            }
            if (allIsZero == true) {
                counterCol++;
                for (int k = 0; k < matrix[0].length; k++) {
                    for (int m = j; m < matrix[0].length - 1; m++) {
                        matrix[k][m] = matrix[k][m + 1];
                    }
                }


            }
        }
        for (int i = 0; i < matrix[0].length - counterStr; i++) {
            for (int j = 0; j < matrix[0].length - counterCol; j++) {
                if (matrix[i][j] >= 0) System.out.print(" " + matrix[i][j] + " ");
                else System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    /**
     * Task: 11. В матрице найти минимальный элемент и переместить его на место заданно-
     * го элемента путем перестановки строк и столбцов.
     *
     * @param matrix the reference object for array.
     */
    public static void changeWithMin(int[][] matrix) {
        int min = matrix[0][0];
        int oldI = 0, oldJ = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    oldI = i;
                    oldJ = j;
                }
            }
        }
        System.out.println("A new place for min:\ni=");
        int newI = scanner.nextInt();
        System.out.println("y=");
        int newJ = scanner.nextInt();

        int[] temp = new int[matrix[0].length];
        for (int j = 0; j < matrix[0].length; j++) {
            temp[j] = matrix[oldI][j];
        }

        if (oldI > newI) {
            for (int i = oldI; i > newI; i--) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = matrix[i - 1][j];
                }
            }
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[newI][j] = temp[j];
            }
        } else if (newI > oldI) {
            for (int i = oldI; i < newI; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = matrix[i + 1][j];
                }
            }
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[newI][j] = temp[j];
            }
        }


        for (int j = 0; j < matrix[0].length; j++) {
            temp[j] = matrix[j][oldJ];
        }

        if (oldJ > newJ) {
            for (int j = oldJ; j > newJ; j--) {
                for (int i = 0; i < matrix[0].length; i++) {
                    matrix[i][j] = matrix[i][j - 1];
                }
            }
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[j][newJ] = temp[j];
            }
        } else if (newJ > oldJ) {
            for (int j = oldJ; j < newJ; j++) {
                for (int i = 0; i < matrix[0].length; i++) {
                    matrix[i][j] = matrix[i][j + 1];
                }
            }
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[j][newJ] = temp[j];
            }
        }


    }

    /**
     * Task: 12. Преобразовать строки матрицы таким образом, чтобы элементы, равные
     * нулю, располагались после всех остальных.
     *
     * @param matrix the reference object for array.
     */
    public static void zeroAfterAll(int[][] matrix) {

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = j; k < matrix[0].length - 1; k++) {
                        matrix[i][k] = matrix[i][k + 1];
                    }
                    matrix[i][matrix[0].length - 1] = 0;
                }
            }
        }

    }

    /**
     * Task: 13. Округлить все элементы матрицы до целого числа.
     *
     * @param doubles the reference object for array.
     */
    public static int[][] roundToInt(double[][] doubles) {
        int[][] newMatr=new int[doubles[0].length][doubles[0].length];
        for (int i = 0; i < doubles[0].length; i++) {
            for (int j = 0; j < doubles[0].length; j++) {
                newMatr[i][j] = (int)Math.round(doubles[i][j]);
            }
        }

        return newMatr;
    }

    /**
     * Task: 14. Найти количество всех седловых точек матрицы. (Матрица А имеет седло-
     * вую точку Аi, j , если Аi, j является минимальным элементом в i-й строке
     * и максимальным в j-м столбце).
     *
     * @param matrix the reference object for array.
     */
    public static int saddlePoints(int[][] matrix) {
        int saddlePoints = 0;
        boolean maxCol = true;
        for (int i = 0; i < matrix[0].length; i++) {
            int min = matrix[i][0];
            int minJ = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    minJ = j;
                }

            }
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[j][minJ] > matrix[i][minJ]) {
                    maxCol = false;
                }

            }
            if (maxCol) saddlePoints++;
        }
        return saddlePoints;
    }

    /**
     * Task: 15. Перестроить матрицу, переставляя в ней строки так, чтобы сумма элемен-
     * тов в строках полученной матрицы возрастала.
     *
     * @param matrix the reference object for array.
     */
    public static void sortArrayBySums(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                int sum1 = 0, sum2 = 0;
                for (int k = 0; k < matrix[0].length; k++) {
                    sum1 += matrix[j][k];
                }
                for (int k = 0; k < matrix[0].length; k++) {
                    sum2 += matrix[j + 1][k];
                }
                if (sum1 > sum2) {
                    for (int k = 0; k < matrix[0].length; k++) {
                        int temp = matrix[j][k];
                        matrix[j][k] = matrix[j + 1][k];
                        matrix[j + 1][k] = temp;
                    }
                }
            }
        }
    }

    /**
     * Task: 16. Найти число локальных минимумов. (Соседями элемента матрицы назовем
     * элементы, имеющие с ним общую сторону или угол. Элемент матрицы назы-
     * вается локальным минимумом, если он строго меньше всех своих соседей.)
     *
     * @param matrix the reference object for array.
     */
    public static int localMin(int[][] matrix) {
        int localMin = 0;

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0) {
                    if (j == 0) {
                        if (matrix[i][j] < matrix[i + 1][j] && matrix[i][j] < matrix[i + 1][j + 1] && matrix[i][j] < matrix[i][j + 1])
                            localMin++;
                    } else if (j == matrix[0].length - 1) {
                        if (matrix[i][j] < matrix[i + 1][j] && matrix[i][j] < matrix[i + 1][j - 1] && matrix[i][j] < matrix[i][j - 1])
                            localMin++;
                    } else {
                        if (matrix[i][j] < matrix[i + 1][j] && matrix[i][j] < matrix[i + 1][j + 1] && matrix[i][j] < matrix[i][j + 1]
                                && matrix[i][j] < matrix[i + 1][j - 1] && matrix[i][j] < matrix[i][j - 1])
                            localMin++;
                    }
                } else if (i == matrix[0].length - 1) {
                    if (j == 0) {
                        if (matrix[i][j] < matrix[i - 1][j] && matrix[i][j] < matrix[i - 1][j + 1] && matrix[i][j] < matrix[i][j + 1])
                            localMin++;
                    } else if (j == matrix[0].length - 1) {
                        if (matrix[i][j] < matrix[i - 1][j] && matrix[i][j] < matrix[i - 1][j - 1] && matrix[i][j] < matrix[i][j - 1])
                            localMin++;
                    } else {
                        if (matrix[i][j] < matrix[i - 1][j] && matrix[i][j] < matrix[i - 1][j + 1] && matrix[i][j] < matrix[i][j + 1]
                                && matrix[i][j] < matrix[i - 1][j - 1] && matrix[i][j] < matrix[i][j - 1])
                            localMin++;
                    }
                } else if (j == 0 && i != 0 && i != matrix[0].length - 1) {
                    if (matrix[i][j] < matrix[i - 1][j] && matrix[i][j] < matrix[i - 1][j + 1] && matrix[i][j] < matrix[i][j + 1]
                            && matrix[i][j] < matrix[i + 1][j] && matrix[i][j] < matrix[i + 1][j + 1])
                        localMin++;
                } else if (j == matrix[0].length - 1 && i != 0 && i != matrix[0].length - 1) {
                    if (matrix[i][j] < matrix[i - 1][j] && matrix[i][j] < matrix[i - 1][j - 1] && matrix[i][j] < matrix[i][j - 1]
                            && matrix[i][j] < matrix[i + 1][j - 1] && matrix[i][j] < matrix[i + 1][j])
                        localMin++;
                } else {
                    if (matrix[i][j] < matrix[i + 1][j] && matrix[i][j] < matrix[i + 1][j + 1] && matrix[i][j] < matrix[i][j + 1]
                            && matrix[i][j] < matrix[i + 1][j - 1] && matrix[i][j] < matrix[i][j - 1]
                            && matrix[i][j] < matrix[i - 1][j] && matrix[i][j] < matrix[i - 1][j + 1] && matrix[i][j] < matrix[i - 1][j - 1])
                        localMin++;
                }

            }
        }

        return localMin;
    }


    /**
     * Task: 17. Найти наименьший среди локальных максимумов. (Элемент матрицы назы-
     * вается локальным минимумом, если он строго меньше всех своих соседей.)
     * @param matrix the reference object for array.
     * @return min element of local maximums
     */
    public static int minLocalMax(int[][] matrix) {
        int minMax;
        int kolvo = 0;
        int[] localMax = new int[matrix.length];

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0) {
                    if (j == 0) {
                        if (matrix[i][j] > matrix[i + 1][j] && matrix[i][j] > matrix[i + 1][j + 1] && matrix[i][j] > matrix[i][j + 1]) {
                            localMax[kolvo] = matrix[i][j];
                            kolvo++;
                        }
                    } else if (j == matrix[0].length - 1) {
                        if (matrix[i][j] > matrix[i + 1][j] && matrix[i][j] > matrix[i + 1][j - 1] && matrix[i][j] > matrix[i][j - 1]) {
                            localMax[kolvo] = matrix[i][j];
                            kolvo++;
                        }
                    } else {
                        if (matrix[i][j] > matrix[i + 1][j] && matrix[i][j] > matrix[i + 1][j + 1] && matrix[i][j] > matrix[i][j + 1]
                                && matrix[i][j] > matrix[i + 1][j - 1] && matrix[i][j] > matrix[i][j - 1]) {
                            localMax[kolvo] = matrix[i][j];
                            kolvo++;
                        }
                    }
                } else if (i == matrix[0].length - 1) {
                    if (j == 0) {
                        if (matrix[i][j] > matrix[i - 1][j] && matrix[i][j] > matrix[i - 1][j + 1] && matrix[i][j] > matrix[i][j + 1]) {
                            localMax[kolvo] = matrix[i][j];
                            kolvo++;
                        }
                    } else if (j == matrix[0].length - 1) {
                        if (matrix[i][j] > matrix[i - 1][j] && matrix[i][j] > matrix[i - 1][j - 1] && matrix[i][j] > matrix[i][j - 1]) {
                            localMax[kolvo] = matrix[i][j];
                            kolvo++;
                        }
                    } else {
                        if (matrix[i][j] > matrix[i - 1][j] && matrix[i][j] > matrix[i - 1][j + 1] && matrix[i][j] > matrix[i][j + 1]
                                && matrix[i][j] > matrix[i - 1][j - 1] && matrix[i][j] > matrix[i][j - 1]) {
                            localMax[kolvo] = matrix[i][j];
                            kolvo++;
                        }
                    }
                } else if (j == 0 && i != 0 && i != matrix[0].length - 1) {
                    if (matrix[i][j] > matrix[i - 1][j] && matrix[i][j] > matrix[i - 1][j + 1] && matrix[i][j] > matrix[i][j + 1]
                            && matrix[i][j] > matrix[i + 1][j] && matrix[i][j] > matrix[i + 1][j + 1]) {
                        localMax[kolvo] = matrix[i][j];
                        kolvo++;
                    }
                } else if (j == matrix[0].length - 1 && i != 0 && i != matrix[0].length - 1) {
                    if (matrix[i][j] > matrix[i - 1][j] && matrix[i][j] > matrix[i - 1][j - 1] && matrix[i][j] > matrix[i][j - 1]
                            && matrix[i][j] > matrix[i + 1][j - 1] && matrix[i][j] > matrix[i + 1][j]) {
                        localMax[kolvo] = matrix[i][j];
                        kolvo++;
                    }
                } else {
                    if (matrix[i][j] > matrix[i + 1][j] && matrix[i][j] > matrix[i + 1][j + 1] && matrix[i][j] > matrix[i][j + 1]
                            && matrix[i][j] > matrix[i + 1][j - 1] && matrix[i][j] > matrix[i][j - 1]
                            && matrix[i][j] > matrix[i - 1][j] && matrix[i][j] > matrix[i - 1][j + 1] && matrix[i][j] > matrix[i - 1][j - 1]) {
                        localMax[kolvo] = matrix[i][j];
                        kolvo++;
                    }
                }

            }
        }

        minMax = localMax[0];
        for (int i = 0; i < kolvo; i++) {
            if (localMax[i] < minMax) minMax = localMax[i];
        }


        return minMax;
    }

    /**
     * Task: 18. Перестроить заданную матрицу, переставляя в ней столбцы так, чтобы зна-
     * чения их характеристик убывали. (Характеристикой столбца прямоуголь-
     * ной матрицы называется сумма модулей его элементов.)
     * @param matrix the reference object for array.
     */
    public static void sortArrayBySumsOfCol(int[][] matrix){
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix[0].length - 1; i++) {
                int sum1 = 0, sum2 = 0;
                for (int k = 0; k < matrix[0].length; k++) {
                    sum1 += Math.abs(matrix[k][i]);
                }
                for (int k = 0; k < matrix[0].length; k++) {
                    sum2 += Math.abs(matrix[k][i + 1]);
                }
                if (sum1 < sum2) {
                    for (int k = 0; k < matrix[0].length; k++) {
                        int temp = matrix[k][i];
                        matrix[k][i] = matrix[k][i + 1];
                        matrix[k][i + 1] = temp;
                    }
                }
            }
        }
    }

    /**
     * Task: 19. Путем перестановки элементов квадратной вещественной матрицы добиться
     * того, чтобы ее максимальный элемент находился в левом верхнем углу, сле-
     * дующий по величине — в позиции (2, 2), следующий по величине — в пози-
     * ции (3, 3) и т. д., заполнив таким образом всю главную диагональ.
     * @param matrix the reference object for array.
     */
    public static void maxOnMainDiagonal(double[][] matrix){
        double max=matrix[0][0];
        int maxNumI=0,maxNumJ=-1;
        double temp=-1;
        for(int i=0; i<matrix[0].length; i++){
            for(int j=0; j<matrix[0].length; j++){
                for(int k=0; k<matrix[0].length; k++){
                    if(j==k && j<i){
                        continue;
                    }
                    if( matrix[j][k]==temp){
                        continue;
                    }
                    if(matrix[j][k]>max){
                        max=matrix[j][k];
                        maxNumI=j;
                        maxNumJ=k;
                    }
                }
            }
            max=0;
            temp=matrix[maxNumI][maxNumJ];
            matrix[maxNumI][maxNumJ]=matrix[i][i];
            matrix[i][i]=temp;
        }
    }

}
