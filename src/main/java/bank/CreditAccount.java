package bank;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class CreditAccount extends Account {
    private double interestRate; // годовая процентная ставка в процентах
    private double creditLimit; //лимит по кредитной карте
    private double accruedInterest; // начисленные проценты
    private double accruedCommissions; // начисленные комиссионные

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditAccount that = (CreditAccount) o;
        return Double.compare(that.interestRate, interestRate) == 0
                && Double.compare(that.creditLimit, creditLimit) == 0
                && Double.compare(that.accruedInterest, accruedInterest) == 0
                && Double.compare(that.accruedCommissions, accruedCommissions) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(interestRate, creditLimit, accruedInterest, accruedCommissions);
    }

    public CreditAccount(int id, double accountBalance, double serviceFee) {
        super(id, accountBalance, serviceFee);
        interestRate = 0.0;
        creditLimit = 0.0;
        accruedInterest = 0.0;
        accruedCommissions = 0.0;
    }

    public CreditAccount(int id, double accountBalance, double serviceFee, Currency currency) {
        super(id, accountBalance, serviceFee, currency);
        interestRate = 0.0;
        creditLimit = 0.0;
        accruedInterest = 0.0;
        accruedCommissions = 0.0;
    }

    public CreditAccount(int id, double accountBalance) {
        super(id, accountBalance);
        interestRate = 0.0;
        creditLimit = 0.0;
        accruedInterest = 0.0;
        accruedCommissions = 0.0;
    }

    public CreditAccount(int id) {
        super(id);
        interestRate = 0.0;
        creditLimit = 0.0;
        accruedInterest = 0.0;
        accruedCommissions = 0.0;
    }

    public CreditAccount(int id, double accountBalance, double serviceFee, Currency currency, double interestRate,
                         double creditLimit){
        super(id, accountBalance, serviceFee, currency);
        this.interestRate = interestRate;
        this.creditLimit = creditLimit;
        accruedInterest = 0.0;
        accruedCommissions = 0.0;
    }

    public double getInterestRate() { // метод начисления процентов
        if(getAccountBalance() < creditLimit){
            accruedInterest += (creditLimit - getAccountBalance()) * (interestRate / dayInYear() / 100);
        }
        return interestRate;
    }

    private int dayInYear(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        return cal.getActualMaximum(Calendar.DAY_OF_YEAR);
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public double getAccruedInterest() {
        return accruedInterest;
    }

    public double getAccruedCommissions() {
        return accruedCommissions;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("CreditAccount{interestRate=")
                .append(interestRate)
                .append(", creditLimit=")
                .append(creditLimit)
                .append(", accruedInterest=")
                .append(accruedInterest)
                .append(", accruedCommissions=")
                .append(accruedCommissions)
                .append('}').toString();
    }

    @Override
    public void subtractionServiceFee() {
        accruedCommissions += getServiceFee();
    }

    @Override
    public void replenishmentAccountBalance(double amount) {
        if (amount > 0){
            if (accruedCommissions < amount) {
                amount -= accruedCommissions;
                accruedCommissions = 0;
                if (accruedInterest < amount) {
                    amount -= accruedInterest;
                    accruedInterest = 0;
                    super.replenishmentAccountBalance(amount);
                } else {
                    accruedInterest -= amount;
                }
            } else {
                accruedCommissions -= amount;
            }
        }
    }
}
