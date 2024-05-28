import java.util.List;

public abstract class MultipleParamCalculator extends FunctionCalculator {
    List<FunctionCalculator> params;

    public MultipleParamCalculator(List<FunctionCalculator> params) {
        this.params = params;
    }

    public void setParams(List<FunctionCalculator> params) {
        this.params = params;
    }

    @Override
    public abstract Object calculate();
}
