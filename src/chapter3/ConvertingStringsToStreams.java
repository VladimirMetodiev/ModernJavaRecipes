package chapter3;

public class ConvertingStringsToStreams {
    public static void main(String[] args) {
        String data = "pas2si-on ate!ly";

        // Превръщам символен низ в поток от символи
        String result = data
                .codePoints()
                .filter(Character::isLetter)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        System.out.println(result);


        printLine();


        data = "Eva, can I see bees in a cave?";
        if(isPalindrome(data)) System.out.println("Yes, it is.");
        else System.out.println("No, it is not");


        printLine();


        data = "Yellow pears";

        result = encode(data);
        System.out.println(result);

        result = decode(result);
        System.out.println(result);
    }

    private static void printLine() {
        System.out.println("==============================");
    }

    private static boolean isPalindrome(String expression) {
        String forward = expression.toLowerCase()
                .codePoints()
                .filter(Character::isLetterOrDigit)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        String backward = new StringBuilder(forward).reverse().toString();

        return forward.equals(backward);
    }

    private static String encode(String expression) {
        return expression.chars().map(ch -> ch + 7).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }

    private static String decode(String expression) {
        return expression.chars().map(ch -> ch - 7).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }
}
