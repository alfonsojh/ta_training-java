package com.epam.training.alfonso_javier.Fundamentals.Task7;

/**
 * Encapsulates two-dimensional array-matrix block of real ({@code double}) type.
 * {@code Matrix} is the cover for two-dimensional array of real values, storing matrix
 * values with operations of matrix addition, deduction, and multiplication.
 */
public class Matrix {

    private final double[][] data;
    private final int rows;
    private final int cols;

    /**
     * Creates an empty matrix with predetermined number
     * of rows and columns (all values in matrix equal to 0)
     *
     * @param rows number of rows
     * @param cols number of columns
     * @throws MatrixException if {@code rows} or {@code cols} less than 1
     */
    public Matrix(int rows, int cols) {

        if (rows < 1 || cols < 1) {
            throw new MatrixException("Invalid size");
        }

        this.rows = rows;
        this.cols = cols;

        data = new double[rows][cols];
    }

    /**
     * Creates a matrix based on existing two-dimensional array
     *
     * @param values two-dimensional array
     * @throws MatrixException if {@code rows} or {@code cols} less than 1
     */
    public Matrix(double[][] values) {

        if (values == null ||
                values.length == 0 ||
                values[0].length == 0) {

            throw new MatrixException("Invalid array");
        }

        rows = values.length;
        cols = values[0].length;

        for (int i = 0; i < rows; i++) {

            if (values[i] == null ||
                    values[i].length != cols) {

                throw new MatrixException("Jagged array");
            }
        }

        data = values;
    }

    /**
     * Returns count of matrix rows.
     *
     * @return count of rows in the matrix
     */
    public int getRows() {
        return rows;
    }

    /**
     * Returns count of matrix columns
     *
     * @return count of columns in the matrix
     */
    public int getColumns() {
        return cols;
    }

    /**
     * Returns an element via predetermined correct indexes.
     *
     * @param row row index
     * @param col column index
     * @return the element via indexes
     * @throws MatrixException if index out of bounds
     */
    public double get(int row, int col) {

        checkIndexes(row, col);

        return data[row][col];
    }

    /**
     * Sets new value via predetermined correct indexes.
     *
     * @param row   row index
     * @param col   column index
     * @param value value to set
     * @throws MatrixException if index out of bounds
     */
    public void set(int row, int col, double value) {

        checkIndexes(row, col);

        data[row][col] = value;
    }

    /**
     * Returns standard two-dimensional array out of matrix.
     * Any changes in the returned array will be reflected to internal array.
     *
     * @return matrix values
     */
    public double[][] toArray() {
        return data;
    }

    /**
     * Adds all elements of {@code other} matrix to corresponding elements
     * of this matrix and creates new {@code Matrix} with resulting two-dimensional array
     *
     * @param other another {@code Matrix} object
     * @return new matrix
     * @throws MatrixException if matrices have different size
     */
    public Matrix add(Matrix other) {

        if (rows != other.rows ||
                cols != other.cols) {

            throw new MatrixException("Different sizes");
        }

        double[][] result =
                new double[rows][cols];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                result[i][j] =
                        data[i][j] + other.data[i][j];
            }
        }

        return new Matrix(result);
    }

    /**
     * Subtract all elements of {@code other} matrix from corresponding elements
     * of this matrix and creates new {@code Matrix} with resulting two-dimensional array
     *
     * @param other another {@code Matrix} object
     * @return new matrix
     * @throws MatrixException if matrices have different size
     */
    public Matrix subtract(Matrix other) {

        if (rows != other.rows ||
                cols != other.cols) {

            throw new MatrixException("Different sizes");
        }

        double[][] result =
                new double[rows][cols];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                result[i][j] =
                        data[i][j] - other.data[i][j];
            }
        }

        return new Matrix(result);
    }

    /**
     * Multiply this matrix to {@code other} matrix.
     *
     * @param other another matrix
     * @return new matrix
     * @throws MatrixException if matrices have non-compliant sizes
     */
    public Matrix multiply(Matrix other) {

        if (cols != other.rows) {

            throw new MatrixException(
                    "Incompatible sizes");
        }

        double[][] result =
                new double[rows][other.cols];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < other.cols; j++) {

                for (int k = 0; k < cols; k++) {

                    result[i][j] +=
                            data[i][k] *
                                    other.data[k][j];
                }
            }
        }

        return new Matrix(result);
    }

    private void checkIndexes(int row, int col) {

        if (row < 0 || row >= rows ||
                col < 0 || col >= cols) {

            throw new MatrixException(
                    "Index out of bounds");
        }
    }
}