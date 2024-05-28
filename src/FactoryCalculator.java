import java.util.List;

public class FactoryCalculator {
    public static FunctionCalculator createCalculator(String formula, List<FunctionCalculator> params) {
        return switch (formula) {
            case "SUM" -> new SumCalculator(params);
            case "CONCAT" -> new ConcatCalculator(params);
            case "RAW" -> params.isEmpty() ? new RawCalculator() : params.getFirst();
            default -> null;
        };
    }
}
