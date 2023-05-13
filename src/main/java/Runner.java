import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Runner {

    private static final String ADDRESS_OF_FILE = "src/main/resources/%d.csv";
    private static final int amountOfFiles = 5;
    private static final String PLUS = " + ";
    private static final String MINUS = " - ";


    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();

        for (int counter = 1; counter <= amountOfFiles; counter++) {
            final String formattedString = "src/main/resources/1.csv";
            getResult(formattedString, builder);
            System.out.println(builder);
        }

        System.out.println(Integer.parseInt("-1"));

    }

    public static void getResult(String nameOfFile, StringBuilder resultString) {

        resultString.setLength(0);

        try {
            File file = new File(nameOfFile);
            Scanner scanner = new Scanner(file);

            double result = 0;
            int amountOfWrongValues = 0;

            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(";");
                int positionToReadFrom = 0;
                String whatAreWeParsing = line[0];

                if (!line[0].equals(null) && canItBeTheNumebrOfElement(whatAreWeParsing)) {
                    positionToReadFrom=(int)Double.parseDouble(line[0]);
                } else {
                    amountOfWrongValues++;
                    continue;
                }

                for (int i = positionToReadFrom; i < line.length; i++) {
                    try {
                        double currentDigit = Double.parseDouble(line[i]);
                        result += currentDigit;
                        resultString.append(returnSign(currentDigit) + Math.abs(currentDigit));

                    } catch (Exception exception) {
                        amountOfWrongValues += 1;
                    }
                }
            }

            resultString.append(String.format(") = %d%nerror-lines = %d", (int)result, (int) amountOfWrongValues));

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    private static String returnSign(double toCompare) {
        return toCompare < 0 ? MINUS : PLUS;
    }

    private static boolean canWeParseThisValue(String whatToParse) {
        try {
            Double d = Double.parseDouble(whatToParse);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    private static boolean canItBeTheNumebrOfElement(String number) {

        try {
            Double d = Double.parseDouble(number);
            if (d >= 0) {
                double truncatedNumber = (double) d;
                double difference = d - d;
                return difference == 0 && d >= Long.MIN_VALUE && d <= Long.MAX_VALUE;
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
