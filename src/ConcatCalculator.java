import java.util.List;

public class ConcatCalculator extends MultipleParamCalculator {
    public ConcatCalculator(List<FunctionCalculator> params) {
        super(params);
    }

    @Override
    public Object calculate() {
        StringBuilder result = new StringBuilder();
        for(FunctionCalculator func : params.reversed()) {
            Object res = func.calculate();
            if (res != null) {
                result.append(res);
            }
        }
        return result.toString();
    }
}
