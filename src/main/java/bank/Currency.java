package bank;

public enum Currency {
    USD(79.1),
    EUR(89.2),
    JOY(1.47),
    TRY(0.173),
    AED(0.05),
    RUB(1);


    private final double currencyValue;

    Currency(double currencyValue) {
        this.currencyValue = currencyValue;
    }

    public double getCurrencyValue() {
        return currencyValue;
    }
}
