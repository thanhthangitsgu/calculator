public class RawCalculator extends FunctionCalculator {

    public Object param;
    public RawCalculator(Object param) {
        this.param = param;
    }
    @Override
    public Object calculate() {
        return param;
    }
}