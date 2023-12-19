package MatrixProcessing;

public class MatrixOperations {
    public Matrix addMatrices(Matrix matrixA, Matrix matrixB) {
        return matrixA.add(matrixB);
    }

    public Matrix multiplyByConstant(Matrix matrix, double constant) {
        return matrix.multiplyByConstant(constant);
    }

    public Matrix multiplyMatrices(Matrix matrixA, Matrix matrixB) {
        return matrixA.multiply(matrixB);
    }

    public Matrix transposeMainDiagonal(Matrix matrix) {
        return matrix.transposeMainDiagonal();
    }

    public Matrix transposeSideDiagonal(Matrix matrix) {
        return matrix.transposeSideDiagonal();
    }

    public Matrix transposeVertical(Matrix matrix) {
        return matrix.transposeVertical();
    }

    public Matrix transposeHorizontal(Matrix matrix) {
        return matrix.transposeHorizontal();
    }

    public double determinant(Matrix matrix) {
        return matrix.determinant();
    }

    public Matrix inverse(Matrix matrix) {
        return matrix.inverse();
    }

}
