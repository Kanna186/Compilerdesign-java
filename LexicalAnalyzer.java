import java.util.*;

class LexicalAnalyzer {
    static final List<String> keywords = Arrays.asList("if", "else", "while", "do", "break", "continue", "int", "double", "float", "return", "char", "case", "sizeof", "long", "short", "typedef", "switch", "unsigned", "void", "static", "struct", "goto");
    static final List<String> operators = Arrays.asList("+", "-", "*", "/", ">", "<", "=", "!=", "<=", ">=");
    
    static boolean isDelimiter(char ch) {
        return " +-*/,;><=()[]{}".indexOf(ch) != -1;
    }
    
    static boolean isOperator(String str) {
        return operators.contains(str);
    }
    
    static boolean isKeyword(String str) {
        return keywords.contains(str);
    }
    
    static boolean isInteger(String str) {
        return str.matches("\\d+");
    }
    
    static boolean isRealNumber(String str) {
        return str.matches("\\d+\\.\\d+");
    }
    
    static boolean validIdentifier(String str) {
        return Character.isLetter(str.charAt(0));
    }
    
    static void parse(String str) {
        for (String token : str.split("\\s+")) {
            if (isKeyword(token)) System.out.println("'" + token + "' IS A KEYWORD");
            else if (isOperator(token)) System.out.println("'" + token + "' IS AN OPERATOR");
            else if (isInteger(token)) System.out.println("'" + token + "' IS AN INTEGER");
            else if (isRealNumber(token)) System.out.println("'" + token + "' IS A REAL NUMBER");
            else if (validIdentifier(token)) System.out.println("'" + token + "' IS A VALID IDENTIFIER");
            else System.out.println("'" + token + "' IS NOT A VALID IDENTIFIER");
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the code to analyze and type 'exit' to finish:");
        while (true) {
            String input = sc.nextLine();
            if (input.equals("exit")) break;
            parse(input);
        }
        sc.close();
    }
}
