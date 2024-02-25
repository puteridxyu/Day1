/*
 * package lesson8.assignment2.q5;
 * 
 * import java.util.Arrays;
 * 
 * public class Matrix<T> {
 * private T[][] matrix;
 * private int rows;
 * private int columns;
 * 
 * public Matrix(int rows, int columns) {
 * this.rows = rows;
 * this.columns = columns;
 * this.matrix = (T[][]) new Object[rows][columns];
 * }
 * 
 * public void setElement(int row, int col, T value) {
 * if (row < 0 || row >= rows || col < 0 || col >= columns) {
 * throw new IllegalArgumentException("Invalid matrix indices");
 * }
 * matrix[row][col] = value;
 * }
 * 
 * public T getElement(int row, int col) {
 * if (row < 0 || row >= rows || col < 0 || col >= columns) {
 * throw new IllegalArgumentException("Invalid matrix indices");
 * }
 * return matrix[row][col];
 * }
 * 
 * public Matrix<T> transpose() {
 * Matrix<T> transposedMatrix = new Matrix<>(columns, rows);
 * for (int i = 0; i < rows; i++) {
 * for (int j = 0; j < columns; j++) {
 * transposedMatrix.setElement(j, i, matrix[i][j]);
 * }
 * }
 * return transposedMatrix;
 * }
 * 
 * public Matrix<T> add(Matrix<T> other) {
 * if (rows != other.rows || columns != other.columns) {
 * throw new
 * IllegalArgumentException("Matrix dimensions do not match for addition");
 * }
 * 
 * Matrix<T> result = new Matrix<>(rows, columns);
 * for (int i = 0; i < rows; i++) {
 * for (int j = 0; j < columns; j++) {
 * result.setElement(i, j, addElements(matrix[i][j], other.getElement(i, j)));
 * }
 * }
 * 
 * return result;
 * }
 * 
 * private T addElements(T element1, T element2) {
 * // Assuming T supports addition; you might need to handle different cases
 * based
 * // on T
 * return element1 + element2;
 * }
 * 
 * public Matrix<T> multiply(Matrix<T> other) {
 * if (columns != other.rows) {
 * throw new
 * IllegalArgumentException("Matrix dimensions do not match for multiplication"
 * );
 * }
 * 
 * Matrix<T> result = new Matrix<>(rows, other.columns);
 * for (int i = 0; i < rows; i++) {
 * for (int j = 0; j < other.columns; j++) {
 * result.setElement(i, j, multiplyElements(i, j, other));
 * }
 * }
 * 
 * return result;
 * }
 * 
 * private T multiplyElements(int row, int col, Matrix<T> other) {
 * // Assuming T supports multiplication; you might need to handle different
 * cases
 * // based on T
 * T sum = matrix[row][0] * other.getElement(0, col);
 * for (int k = 1; k < columns; k++) {
 * sum = addElements(sum, matrix[row][k] * other.getElement(k, col));
 * }
 * return sum;
 * }
 * 
 * @Override
 * public String toString() {
 * StringBuilder result = new StringBuilder();
 * for (T[] row : matrix) {
 * result.append(Arrays.toString(row)).append('\n');
 * }
 * return result.toString();
 * }
 * 
 * public static void main(String[] args) {
 * // Test Matrix with Integer elements
 * Matrix<Integer> matrixA = new Matrix<>(2, 3);
 * matrixA.setElement(0, 0, 1);
 * matrixA.setElement(0, 1, 2);
 * matrixA.setElement(0, 2, 3);
 * matrixA.setElement(1, 0, 4);
 * matrixA.setElement(1, 1, 5);
 * matrixA.setElement(1, 2, 6);
 * 
 * Matrix<Integer> matrixB = new Matrix<>(3, 2);
 * matrixB.setElement(0, 0, 7);
 * matrixB.setElement(0, 1, 8);
 * matrixB.setElement(1, 0, 9);
 * matrixB.setElement(1, 1, 10);
 * matrixB.setElement(2, 0, 11);
 * matrixB.setElement(2, 1, 12);
 * 
 * System.out.println("Matrix A:");
 * System.out.println(matrixA);
 * 
 * System.out.println("Matrix B:");
 * System.out.println(matrixB);
 * 
 * Matrix<Integer> resultAddition = matrixA.add(matrixB);
 * System.out.println("Matrix Addition (A + B):");
 * System.out.println(resultAddition);
 * 
 * Matrix<Integer> resultMultiplication = matrixA.multiply(matrixB);
 * System.out.println("Matrix Multiplication (A * B):");
 * System.out.println(resultMultiplication);
 * }
 * }
 */