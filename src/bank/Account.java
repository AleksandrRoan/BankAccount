package bank;

public abstract class Account {

    private int id;
    private double accountBalance;
    private static final double DEFAULT_BALANCE = 0.0;
    private double serviceFee; //комиссия за обслуживание
    private Currency currency;

    public Account(int id, double accountBalance, double serviceFee) {
        this.id = id;
        this.accountBalance = accountBalance;
        this.serviceFee = serviceFee;
        this.currency = Currency.RUB;
    }

    public Account(int id, double accountBalance, double serviceFee, Currency currency) {
        this.id = id;
        this.accountBalance = accountBalance;
        this.serviceFee = serviceFee;
        this.currency = currency;
    }

    public Account(int id, double accountBalance) {
        this.id = id;
        this.accountBalance = accountBalance;
        this.currency = Currency.RUB;
    }

    public Account(int id) {
        this.id = id;
        accountBalance = DEFAULT_BALANCE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public double getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(double serviceFee) {
        this.serviceFee = serviceFee;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        recalculationOfTheCommission(currency, this.currency);
        this.currency = currency;
    }

    public void recalculationOfTheCommission(Currency oldCurrency, Currency newCurrency){
        this.serviceFee = serviceFee * newCurrency.getCurrencyValue() / oldCurrency.getCurrencyValue();
        this.accountBalance = accountBalance * newCurrency.getCurrencyValue() / oldCurrency.getCurrencyValue();
    }

    public void subtractionServiceFee() {
        accountBalance = getAccountBalance() - getServiceFee();
    }

    public void debitingTheAmount(double amount){
        accountBalance = getAccountBalance() - amount;
    }

    public void replenishmentAccountBalance(double amount){
        accountBalance = getAccountBalance() + amount;
    }
}
