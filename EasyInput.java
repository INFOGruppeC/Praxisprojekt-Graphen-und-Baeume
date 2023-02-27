import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EasyInput {

    public static String getInputString(String question, String fallback) throws IOException {
        System.out.println(question);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("> ");
        String result = br.readLine();
        if (result.isEmpty()) {
            System.err.println("Invalid input! Defaulting to " + fallback);
            result = fallback;
        }
        return result;
    }

    public static String getInputString(String question) throws IOException {
        return getInputString(question, "");
    }

    public static int getInputInt(String question, int fallback) throws IOException {
        System.out.println(question);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("> ");
        String resultString = br.readLine();
        int result = fallback;
        try {
            result = Integer.parseInt(resultString);
        } catch (NumberFormatException e) {
            System.err.println("Invalid input! Please enter a number! Defaulting to " + fallback);
        }
        return result;
    }

    public static int getInputInt(String question) throws IOException {
        return getInputInt(question, 0);
    }

    public static boolean getInputBoolean(String question) throws IOException {
        System.out.println(question + " (y/N)");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("> ");
        String result = br.readLine();
        return result.equalsIgnoreCase("y");
    }

}
