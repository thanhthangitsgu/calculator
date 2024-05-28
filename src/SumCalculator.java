import java.util.List;

public class SumCalculator extends FunctionCalculator {

    private List<FunctionCalculator> params;

    public SumCalculator(List<FunctionCalculator> params) {
        this.params = params;
    }

    @Override
    public Object calculate() {
        Double result = 0.0;

        for(FunctionCalculator param : params) {
            Object res = param.calculate();
            if (res instanceof Number number) {
                result += number.doubleValue();
            }
        }

        return result;
    }
}
