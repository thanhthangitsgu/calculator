public abstract class SingleParamCalculator extends FunctionCalculator {
    Object param;

    public SingleParamCalculator(Object param) {
        this.param = param;
    }

    public SingleParamCalculator() {}

    @Override
    public abstract Object calculate();
}
