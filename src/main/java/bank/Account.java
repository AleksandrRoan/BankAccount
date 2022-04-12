package bank;

import java.util.Objects;

public abstract class Account {
    //todo: порядок декларации полей: сначала константы, потом поля
    private int id;
    private double accountBalance;
    private static final double DEFAULT_BALANCE = 0.0;
    private double serviceFee; //комиссия за обслуживание
    private Currency currency;
    //todo: порядок декларации методов: конструкторы, методы доступа, equals,hashcode,toString, прочие
    @Override
    public String toString() {
        return new StringBuilder()
                .append("Account{id=")
                .append(id)
                .append(", accountBalance=")
                .append(accountBalance)
                .append(", serviceFee=")
                .append(serviceFee)
                .append(", currency=")
                .append(currency)
                .append('}')
                .toString();
    }

    //todo: узкий конструктор вызывает широкий, не дублируй код
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id
                && Double.compare(account.accountBalance, accountBalance) == 0
                && Double.compare(account.serviceFee, serviceFee) == 0
                && currency == account.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountBalance, serviceFee, currency);
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

    public void debitingTheAmount(double amount) throws InsufficientFundsException {
        if (accountBalance > amount) {
            //todo: легко меняется на accountBalance -= amount
            accountBalance = getAccountBalance() - amount;
        } else {
            throw new InsufficientFundsException("Вы пытаетесь списать сумму, превышающую остаток или лимит по карте");
        }
    }

    public void replenishmentAccountBalance(double amount){
        accountBalance = getAccountBalance() + amount;
    }
}
