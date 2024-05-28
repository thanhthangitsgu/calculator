import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        FunctionCalculator func = parseFunction("CONCAT(\"Hello\", CONCAT(\"World\", SUM(4, 5)))");
        if (func != null) {
            System.out.println(func.calculate());
        }
    }

    public static FunctionCalculator parseFunction(String statement) {
        Stack<FunctionCalculator> stack = new Stack<>();
        int i = 0;
        String formula;
        
        while (i < statement.length()) {
            formula = "";
            ArrayList<FunctionCalculator> params = new ArrayList<>();

            //Get formula
            if (Character.isLetter(statement.charAt(i))) {
                int lastIndexOfOperator = statement.indexOf('(', i);
                formula = statement.substring(i, lastIndexOfOperator);
                i = lastIndexOfOperator;
            }

            //Get string
            if (statement.charAt(i) == '"') {
                int lastIndexOfOperator = statement.indexOf('"', i + 1);
                formula = "RAW";
                params.add(new RawCalculator(statement.substring(i + 1, lastIndexOfOperator)));
                i = lastIndexOfOperator;
            }

            //Get number
            if (Character.isDigit(statement.charAt(i))) {
                StringBuilder strNumber = new StringBuilder();
                while (Character.isDigit(statement.charAt(i))) {
                    strNumber.append(statement.charAt(i++));
                }
                double num = Double.parseDouble(strNumber.toString());
                formula = "RAW";
                params.add(new RawCalculator(num));
                i--;
            }

            if (statement.charAt(i) == ')') {
                FunctionCalculator temp = stack.pop();
                while (temp instanceof SingleParamCalculator
                        || (temp instanceof MultipleParamCalculator multipleParamCalculator
                        && !multipleParamCalculator.params.isEmpty())) {
                    params.add(temp);
                    temp = stack.pop();
                }

                if (temp instanceof MultipleParamCalculator multipleParamCalculator) {
                    multipleParamCalculator.setParams(params);
                }
                stack.push(temp);
            }

            if (!formula.isEmpty()) {
                FunctionCalculator calculator = FactoryCalculator.createCalculator(formula, params);
                stack.push(calculator);
            }
            i++;
        }

        if (!stack.isEmpty()) {
            return stack.pop();
        }
        return null;
    }
}