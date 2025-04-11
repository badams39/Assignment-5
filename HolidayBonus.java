public class HolidayBonus {
	public static final double HIGH_BONUS = 5000.0;
	public static final double LOW_BONUS = 1000.0;
	public static final double OTHER_BONUS = 2000.0;
	
    public static double[] calculateHolidayBonus(double[][] data) {
        double[] bonuses = new double[data.length];
        int maxCols = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i].length > maxCols) {
                maxCols = data[i].length;
            }
        }
        for (int col = 0; col < maxCols; col++) {
            double highest =Double.NEGATIVE_INFINITY;
            double lowest = Double.POSITIVE_INFINITY;
            int highestIndex = -1;
            int lowestIndex = -1;
            for (int row = 0; row < data.length; row++) {
                if (col < data[row].length && data[row][col] > 0) {
                    double value = data[row][col];
                    if (value > highest) {
                        highest = value;
                        highestIndex = row;
                    }
                    if (value < lowest) {
                        lowest = value;
                        lowestIndex = row;
                    }
                }
            }
            for (int row = 0; row < data.length; row++) {
                if (col < data[row].length && data[row][col] > 0) {
                    if (row == highestIndex) {
                        bonuses[row] += HIGH_BONUS;
                    } else if (row == lowestIndex) {
                        bonuses[row] += LOW_BONUS;
                    } else {
                        bonuses[row] += OTHER_BONUS;
                    }
                }
            }
        }
        return bonuses;
    }
    public static double calculateTotalHolidayBonus(double[][] data) {
        double total = 0.0;
        double[] bonuses = calculateHolidayBonus(data);
        for (double bonus : bonuses) {
            total += bonus;
        }
        return total;
    }
}