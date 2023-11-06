import java.util.Scanner;

public class Password {

    public static int minimumNumber(int n, String password) {
        final String numbers = "0123456789";
        final String lower_case = "abcdefghijklmnopqrstuvwxyz";
        final String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String special_characters = "!@#$%^&*()-+";

        boolean hasDigit = false;
        boolean hasLowerCase = false;
        boolean hasUpperCase = false;
        boolean hasSpecialChar = false;

        for (char ch : password.toCharArray()) {
            if (numbers.contains(String.valueOf(ch))) {
                hasDigit = true;
            } else if (lower_case.contains(String.valueOf(ch))) {
                hasLowerCase = true;
            } else if (upper_case.contains(String.valueOf(ch))) {
                hasUpperCase = true;
            } else if (special_characters.contains(String.valueOf(ch))) {
                hasSpecialChar = true;
            }
        }

        int missingCriteria = 0;

        if (!hasDigit) {
            missingCriteria++;
        }
        if (!hasLowerCase) {
            missingCriteria++;
        }
        if (!hasUpperCase) {
            missingCriteria++;
        }
        if (!hasSpecialChar) {
            missingCriteria++;
        }

        if (n + missingCriteria < 6) {
            return 6 - n;
        }

        return missingCriteria;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        String password = scanner.nextLine();

        int minCharsToAdd = minimumNumber(n, password);
        System.out.println(minCharsToAdd);
    }
}
