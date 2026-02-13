import java.util.Scanner;

public class ReverseEachWordFromLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a line of text:");
        String inputLine = scanner.nextLine();
        scanner.close();

        String reversedLine = reverseWords(inputLine);
        System.out.println("Original string: " + inputLine);
        System.out.println("Reversed words string: " + reversedLine);
    }

    public static String reverseWords(String str) {
        // Split the string into words based on whitespace
        String[] words = str.split("\\s");
        StringBuilder reversedString = new StringBuilder();

        for (String word : words) {
            // Reverse each word using StringBuilder's reverse() method
            StringBuilder individualWord = new StringBuilder(word);
            individualWord.reverse();

            // Append the reversed word and a space
            reversedString.append(individualWord).append(" ");
        }

        // Trim any trailing space and return the result
        return reversedString.toString().trim();
    }
}
