package bank;

import java.util.ArrayList;

public interface Client {
    public Account account(int id); // метод, возвращающий ссылку на счет по его уникальному номеру

    public ArrayList<Account> allAccount(); // метод, возвращающий список (класс ArrayList<Account>) всех счетов

    public ArrayList<Account> allDebitAccount(); // метод, возвращающий список счетов дебетовых карт

    public ArrayList<Account> allCreditAccount(); // метод, возвращающий список счетов кредитных карт

    public double sumDebitAccountBalance(); // метод, возвращающий суммарный остаток на всех дебетовых счетах

    public double sumAccruedInterest(); // метод, возвращающий сумму начисленных процентов клиента

    public double sumAccruedCommissions(); // метод, возвращающий сумму комиссионных клиента

    public double negativeCreditBalance(); // метод, возвращающий суммарный отрицательный остаток по картам

    public ArrayList<Account> positiveAccountBalance(); // метод, возвращающий список счетов с положительным остатком

    public void removeAccount(int id); // метод удаления счета по его номеру

    public void addingAccount(Account account); // метод добавления счета

    public void debitingAmountFromAccount(Account account, double amount); // метод списывания средств со счета

    public void addingAmountFromAccount(Account account, double amount); // метод пополнения счета
}
