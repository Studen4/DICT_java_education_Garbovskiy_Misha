package MatrixProcessing;

import java.util.Scanner;

public class Matrix {
    private final int rows;
    private final int cols;
    private final double[][] elements;

    public Matrix(int rows, int cols, double[][] matrix) {
        this.rows = rows;
        this.cols = cols;
        this.elements = matrix;
    }

    public static Matrix createMatrix() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of rows in matrix: ");
        int matrixRows = scanner.nextInt();
        System.out.print("Enter number of cols in matrix: ");
        int matrixCols = scanner.nextInt();
        double[][] matrix = new double[matrixRows][matrixCols];

        System.out.println("Enter matrix elements:");
        for (int i = 0; i < matrixRows; i++) {
            for (int j = 0; j < matrixCols; j++) {
                System.out.print("Element in position [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrix[i][j] = scanner.nextDouble();
            }
        }

        return new Matrix(matrixRows, matrixCols, matrix);
    }

    public void displayMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(elements[i][j] + " ");
            }
            System.out.println();
        }
    }

    public Matrix add(Matrix other) {
        if (rows != other.rows || cols != other.cols) {
            throw new IllegalArgumentException("Matrices must have the same dimensions for addition.");
        }

        double[][] result = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = elements[i][j] + other.elements[i][j];
            }
        }

        return new Matrix(rows, cols, result);
    }

    public Matrix multiplyByConstant(double constant) {
        double[][] result = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = elements[i][j] * constant;
            }
        }

        return new Matrix(rows, cols, result);
    }

    public Matrix multiply(Matrix other) {
        if (cols != other.rows) {
            throw new IllegalArgumentException("Number of columns in the first matrix must be equal to the number of rows in the second matrix.");
        }

        double[][] result = new double[rows][other.cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                double sum = 0;
                for (int k = 0; k < cols; k++) {
                    sum += elements[i][k] * other.elements[k][j];
                }
                result[i][j] = sum;
            }
        }

        return new Matrix(rows, other.cols, result);
    }

    public Matrix transposeMainDiagonal() {
        double[][] result = new double[cols][rows];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                result[i][j] = elements[j][i];
            }
        }

        return new Matrix(cols, rows, result);
    }

    public Matrix transposeSideDiagonal() {
        double[][] result = new double[cols][rows];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                result[i][j] = elements[rows - j - 1][cols - i - 1];
            }
        }

        return new Matrix(cols, rows, result);
    }

    public Matrix transposeVertical() {
        double[][] result = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = elements[i][cols - j - 1];
            }
        }

        return new Matrix(rows, cols, result);
    }

    public Matrix transposeHorizontal() {
        double[][] result = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(elements[rows - i - 1], 0, result[i], 0, cols);
        }

        return new Matrix(rows, cols, result);
    }

    public double determinant() {
        if (rows != cols) {
            System.out.println("Matrix must be square!");
            return 0;
        }

        double[][] tempVarMatrix = elements;
        int tempVarRows = rows;
        double determinant = 1;

        for (int i = 0; i < tempVarRows; i++) {
            if (tempVarMatrix[i][i] == 0) {
                for (int j = i + 1; j < tempVarRows; j++) {
                    if (tempVarMatrix[j][i] != 0) {
                        double[] tempRow = tempVarMatrix[i];
                        tempVarMatrix[i] = tempVarMatrix[j];
                        tempVarMatrix[j] = tempRow;
                        determinant *= -1;
                        break;
                    }
                }
                if (tempVarMatrix[i][i] == 0) {
                    return 0;
                }
            }

            determinant *= tempVarMatrix[i][i];
            for (int j = i + 1; j < tempVarRows; j++) {
                double booster = tempVarMatrix[j][i] / tempVarMatrix[i][i];
                for (int k = i; k < tempVarRows; k++) {
                    tempVarMatrix[j][k] -= booster * tempVarMatrix[i][k];
                }
            }
        }

        return determinant;
    }

    public Matrix inverse() {
        double determinant = determinant();
        if (determinant == 0) {
            System.out.println("This matrix doesn't have an inverse.");
            return null;
        }

        if (rows == 2 && cols == 2) {
            double[][] result = new double[2][2];
            result[0][0] = elements[1][1];
            result[0][1] = -elements[0][1];
            result[1][0] = -elements[1][0];
            result[1][1] = elements[0][0];

            Matrix inverseMatrix = new Matrix(2, 2, result);
            for (int i = 0; i < inverseMatrix.rows; i++) {
                for (int j = 0; j < inverseMatrix.cols; j++) {
                    inverseMatrix.elements[i][j] /= determinant;
                }
            }
            return inverseMatrix;
        } else {
            double[][] inverseMatrixElements = new double[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    double minorSymbol = Math.pow(-1, i + j);
                    Matrix minorMatrix = minor(i, j);
                    inverseMatrixElements[j][i] = minorMatrix.determinant() * minorSymbol / determinant;
                }
            }

            return new Matrix(rows, cols, inverseMatrixElements);
        }
    }

    public Matrix minor(int i, int j) {
        double[][] minorMatrixElements = new double[rows - 1][cols - 1];
        int minorRows = 0;
        int minorCols; // Оголосити змінну тут

        for (int row = 0; row < rows; row++) {
            if (row == i) {
                continue;
            }

            minorCols = 0; // Ініціалізувати змінну тут

            for (int col = 0; col < cols; col++) {
                if (col == j) {
                    continue;
                }
                minorMatrixElements[minorRows][minorCols] = elements[row][col];
                minorCols++;
            }

            minorRows++;
        }

        return new Matrix(minorRows, cols - 1, minorMatrixElements);
    }


}
