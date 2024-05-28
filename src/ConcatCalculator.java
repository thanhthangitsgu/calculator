import java.util.List;

public class ConcatCalculator extends FunctionCalculator {
    private final List<FunctionCalculator> params;

    public ConcatCalculator(List<FunctionCalculator> params) {
        this.params = params;
    }

    @Override
    public Object calculate() {
        StringBuilder result = new StringBuilder();
        for(FunctionCalculator func : params) {
            Object res = func.calculate();
            if (res != null) {
                result.append(res);
            }
        }
        return result.toString();
    }
}
