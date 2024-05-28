public class RawCalculator extends SingleParamCalculator {

    public RawCalculator(Object param) {
        super(param);
    }

    public RawCalculator() {
        super();
    }

    @Override
    public Object calculate() {
        return param;
    }
}