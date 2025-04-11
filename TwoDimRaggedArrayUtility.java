import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class TwoDimRaggedArrayUtility {

    public TwoDimRaggedArrayUtility() {}

    public static double getAverage(double[][] data) {
        double total = 0;
        int count = 0;
        for (double[] row : data) {
            for (double val : row) {
                total += val;
                count++;
            }
        }
        return total / count;
    }

    public static double getColumnTotal(double[][] data, int column) {
        double total = 0;
        for (double[] row : data) {
            if (column < row.length) {
                total += row[column];
            }
        }
        return total;
    }

    public static double getHighestInArray(double[][] data) {
        double highest = data[0][0];
        for (double[] row : data) {
            for (double val : row) {
                if (val > highest) highest = val;
            }
        }
        return highest;
    }

    public static double getHighestInColumn(double[][] data, int column) {
        double highest = Double.NEGATIVE_INFINITY;
        for (double[] row : data) {
            if (column < row.length && row[column] > highest) {
                highest = row[column];
            }
        }
        return highest;
    }

    public static int getHighestInColumnIndex(double[][] data, int column) {
        double highest = Double.NEGATIVE_INFINITY;
        int index = -1;
        for (int i = 0; i < data.length; i++) {
            if (column < data[i].length && data[i][column] > highest) {
                highest = data[i][column];
                index = i;
            }
        }
        return index;
    }

    public static double getHighestInRow(double[][] data, int row) {
        double highest = data[row][0];
        for (int i = 1; i < data[row].length; i++) {
            if (data[row][i] > highest) {
                highest = data[row][i];
            }
        }
        return highest;
    }

    public static int getHighestInRowIndex(double[][] data, int row) {
        double highest = data[row][0];
        int index = 0;
        for (int i = 1; i < data[row].length; i++) {
            if (data[row][i] > highest) {
                highest = data[row][i];
                index = i;
            }
        }
        return index;
    }

    public static double getLowestInArray(double[][] data) {
        double lowest = data[0][0];
        for (double[] row : data) {
            for (double val : row) {
                if (val < lowest) lowest = val;
            }
        }
        return lowest;
    }

    public static double getLowestInColumn(double[][] data, int column) {
        double lowest = Double.POSITIVE_INFINITY;
        for (double[] row : data) {
            if (column < row.length && row[column] < lowest) {
                lowest = row[column];
            }
        }
        return lowest;
    }

    public static int getLowestInColumnIndex(double[][] data, int column) {
        double lowest = Double.POSITIVE_INFINITY;
        int index = -1;
        for (int i = 0; i < data.length; i++) {
            if (column < data[i].length && data[i][column] < lowest) {
                lowest = data[i][column];
                index = i;
            }
        }
        return index;
    }

    public static double getLowestInRow(double[][] data, int row) {
        double lowest = data[row][0];
        for (int i = 1; i < data[row].length; i++) {
            if (data[row][i] < lowest) {
                lowest = data[row][i];
            }
        }
        return lowest;
    }

    public static int getLowestInRowIndex(double[][] data, int row) {
        double lowest = data[row][0];
        int index = 0;
        for (int i = 1; i < data[row].length; i++) {
            if (data[row][i] < lowest) {
                lowest = data[row][i];
                index = i;
            }
        }
        return index;
    }

    public static double getRowTotal(double[][] data, int row) {
        double total = 0;
        for (int i = 0; i < data[row].length; i++) {
            total += data[row][i];
        }
        return total;
    }

    public static double getTotal(double[][] data) {
        double total = 0;
        for (double[] row : data) {
            for (double val : row) {
                total += val;
            }
        }
        return total;
    }

    public static double[][] readFile(File file) {
        double[][] arr = null;

        try {
            Scanner scan = new Scanner(file);

            int rows = 0;
            while (scan.hasNextLine()) {
                rows++;
                scan.nextLine();
            }

            arr = new double[rows][];
            scan = new Scanner(file);

            int i = 0;
            while (scan.hasNextLine()) {
                String line = scan.nextLine().trim();
                Scanner lineScan = new Scanner(line);

                int columnCount = 0;
                while (lineScan.hasNextDouble()) {
                    columnCount++;
                    lineScan.nextDouble();
                }
                lineScan.close();

                arr[i] = new double[columnCount];
                lineScan = new Scanner(line);
                for (int j = 0; j < columnCount; j++) {
                    arr[i][j] = lineScan.nextDouble();
                }
                lineScan.close();
                i++;
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred: " + e);
        }

        return arr;
    }

    public static void writeToFile(double[][] data, File outputFile) {
        try {
            PrintWriter f = new PrintWriter(outputFile);

            for (double[] row : data) {
                for (int j = 0; j < row.length; j++) {
                    f.print(row[j]);
                    if (j < row.length - 1) {
                        f.print(" ");
                    }
                }
                f.println();
            }

            f.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}
