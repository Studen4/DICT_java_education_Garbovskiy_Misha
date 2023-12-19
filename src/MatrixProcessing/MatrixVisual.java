package MatrixProcessing;

import java.util.Scanner;
public class MatrixVisual {
    private final MatrixOperations matrixOperations;

    public MatrixVisual() {
        this.matrixOperations = new MatrixOperations();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Hi, it's matrix calculator v 0.1");
            System.out.println("Enter command number to start:");
            System.out.println("Commands list:");
            System.out.println("1) Add matrices");
            System.out.println("2) Multiply matrix by constant");
            System.out.println("3) Multiply matrices");
            System.out.println("4) Transpose matrices");
            System.out.println("5) Calculate determinant");
            System.out.println("6) Inverse matrix");
            System.out.println("0) Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 0 -> {
                    System.out.println("Thanks for watching, goodbye!");
                    return;
                }
                case 1 -> {
                    System.out.println("Enter first matrix!");
                    Matrix firstMatrix = Matrix.createMatrix();
                    System.out.println("Enter second matrix!");
                    Matrix secondMatrix = Matrix.createMatrix();
                    Matrix resultMatrix1 = matrixOperations.addMatrices(firstMatrix, secondMatrix);
                    System.out.println("Result matrix:");
                    resultMatrix1.displayMatrix();
                }
                case 2 -> {
                    System.out.println("Enter matrix!");
                    Matrix matrix2 = Matrix.createMatrix();
                    System.out.println("Enter constant to multiply your matrix:");
                    double constant = scanner.nextDouble();
                    Matrix resultMatrix2 = matrixOperations.multiplyByConstant(matrix2, constant);
                    System.out.println("Result matrix:");
                    resultMatrix2.displayMatrix();
                }
                case 3 -> {
                    System.out.println("Enter first matrix!");
                    Matrix firstMatrix3 = Matrix.createMatrix();
                    System.out.println("Enter second matrix!");
                    Matrix secondMatrix3 = Matrix.createMatrix();
                    Matrix resultMatrix3 = matrixOperations.multiplyMatrices(firstMatrix3, secondMatrix3);
                    System.out.println("Result matrix:");
                    resultMatrix3.displayMatrix();
                }
                case 4 -> {
                    System.out.println("Enter matrix!");
                    Matrix matrix4 = Matrix.createMatrix();
                    System.out.println("Which format of transposition you prefer?");
                    System.out.println("1. Main diagonal");
                    System.out.println("2. Side diagonal");
                    System.out.println("3. Vertical line");
                    System.out.println("4. Horizontal line");
                    int transpositionVar = scanner.nextInt();
                    Matrix resultMatrix4;
                    switch (transpositionVar) {
                        case 1 -> resultMatrix4 = matrixOperations.transposeMainDiagonal(matrix4);
                        case 2 -> resultMatrix4 = matrixOperations.transposeSideDiagonal(matrix4);
                        case 3 -> resultMatrix4 = matrixOperations.transposeVertical(matrix4);
                        case 4 -> resultMatrix4 = matrixOperations.transposeHorizontal(matrix4);
                        default -> {
                            System.out.println("Invalid choice!");
                            continue;
                        }
                    }
                    System.out.println("Result matrix:");
                    resultMatrix4.displayMatrix();
                }
                case 5 -> {
                    System.out.println("Enter matrix!");
                    Matrix matrix5 = Matrix.createMatrix();
                    double determinant = matrixOperations.determinant(matrix5);
                    System.out.println("Determinant: " + determinant);
                }
                case 6 -> {
                    System.out.println("Enter matrix!");
                    Matrix matrix6 = Matrix.createMatrix();
                    Matrix inverseMatrix = matrixOperations.inverse(matrix6);
                    if (inverseMatrix != null) {
                        System.out.println("Inverse matrix:");
                        inverseMatrix.displayMatrix();
                    }
                }
                default -> System.out.println("Invalid choice! Please enter a valid command number.");
            }
        }
    }
}