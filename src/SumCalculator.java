import java.util.List;

public class SumCalculator extends MultipleParamCalculator {
    public SumCalculator(List<FunctionCalculator> params) {
        super(params);
    }

    @Override
    public Object calculate() {
        double result = 0.0;

        for(FunctionCalculator param : params) {
            Object res = param.calculate();
            if (res instanceof Number number) {
                result += number.doubleValue();
            }
        }

        return result;
    }
}
