package bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NaturalClient implements Client {

    private String name;
    private String surname;
    private int passportSeries;
    private int passportNumbers;

    ArrayList<Account> accountsList;

    @Override
    public String toString() {
        return new StringBuilder("NaturalClient{name=")
                .append(name)
                .append(", surname=")
                .append(surname)
                .append(", passportSeries=")
                .append(passportSeries)
                .append(", passportNumbers=")
                .append(passportNumbers)
                .append(", accountsList=")
                .append(accountsList)
                .append('}').toString();
    }

    public NaturalClient(String name, String surname, int passportSeries, int passportNumbers) {
        this.name = name;
        this.surname = surname;
        this.passportSeries = passportSeries;
        this.passportNumbers = passportNumbers;
        accountsList = new ArrayList<>(0);
    }

    public NaturalClient(String name, String surname, int passportSeries, int passportNumbers, ArrayList<Account> accountsList) {
        this.name = name;
        this.surname = surname;
        this.passportSeries = passportSeries;
        this.passportNumbers = passportNumbers;
        this.accountsList = accountsList;
    }

    public Account searchBankAccount(int id) {
        if(accountsList != null){
            for (Account account : accountsList) {
               if(account.getId() == id){
                   return account;
               }
            }
        }
        return null;
    }

    public ArrayList<Account> getAccountsList() {
        return accountsList;
    }

    public double totalBalanceAllAccounts(){
        double sum = 0;
        for(Account account : getAccountsList()){
            sum += account.getAccountBalance();
        }
        return sum;
    }

    public ArrayList<Account> getPositiveAccountList(){
        ArrayList<Account> accountsList = new ArrayList<>();
        for(Account account : getAccountsList()){
            if(account.getAccountBalance() > 0){
                accountsList.add(account);
            }
        }
        return accountsList;
    }

    public void deletingAccount(int id){
        int deleteAccountIndex = 0;
        for(Account account : accountsList){
            if(account.getId() == id){
                deleteAccountIndex = accountsList.indexOf(account);
            }
        }
        accountsList.remove(deleteAccountIndex);
    }

    public void addingBankAccount(Account account){
        accountsList.add(account);
    }

    public void reduceBankAccount(Account account, double amount){
        if(accountsList.contains(account)){
            account.replenishmentAccountBalance(amount);
        }
    }

    public void increaseBankAccount(Account account, double amount) {
        if(accountsList.contains(account)){
            account.replenishmentAccountBalance(amount);
        }
    }

    @Override
    public Account account(int id) {
        return searchBankAccount(id);
    }

    @Override
    public ArrayList<Account> allAccount() {
        return getAccountsList();
    }

    @Override
    public ArrayList<Account> allDebitAccount() {
        ArrayList<Account> arrayList = new ArrayList<>();
        for (Account account : allAccount()){
            if (account instanceof DebitAccount){
                arrayList.add(account);
            }
        }
        return arrayList;
    }

    @Override
    public ArrayList<Account> allCreditAccount() {
        ArrayList<Account> arrayList = new ArrayList<>();
        for (Account account : allAccount()){
            if (account instanceof CreditAccount){
                arrayList.add(account);
            }
        }
        return arrayList;
    }

    @Override
    public double sumDebitAccountBalance() {
        double sum = 0;
        ArrayList<Account> arrayList = allDebitAccount();
        for(Account account : arrayList){
            sum += account.getAccountBalance();
        }
        return sum;
    }

    @Override
    public double sumAccruedInterest() {
        double sum = 0;
        ArrayList<Account> arrayList = allCreditAccount();
        for(Account account : arrayList){
            sum += ((CreditAccount) account).getAccruedInterest();
        }
        return sum;
    }

    @Override
    public double sumAccruedCommissions() {
        double sum = 0;
        ArrayList<Account> arrayList = allCreditAccount();
        for(Account account : arrayList){
            sum += ((CreditAccount) account).getAccruedCommissions();
        }
        return sum;
    }

    @Override
    public double negativeCreditBalance() {
        double sum = 0;
        ArrayList<Account> arrayList = allCreditAccount();
        for(Account account : arrayList){
            if(account.getAccountBalance() < 0) {
                sum += account.getAccountBalance();
            }
        }
        return sum;
    }

    @Override
    public ArrayList<Account> positiveAccountBalance() {
        ArrayList<Account> positiveAccountBalance = new ArrayList<>();
        ArrayList<Account> arrayList = allAccount();
        for(Account account : arrayList){
            if(account.getAccountBalance() > 0) {
                positiveAccountBalance.add(account);
            }
        }
        return positiveAccountBalance;
    }

    @Override
    public void removeAccount(int id) { // дублирование метода deletingAccount(int id)
        deletingAccount(id);
    }

    @Override
    public void addingAccount(Account account) { // дублирование метода addingBankAccount(Account account)
        addingBankAccount(account);
    }

    @Override
    public void debitingAmountFromAccount(Account account, double amount) { // дублирование метода reduceBankAccount
        reduceBankAccount(account, amount);
    }

    @Override
    public void addingAmountFromAccount(Account account, double amount) { // дублирование метода increaseBankAccount
        increaseBankAccount(account, amount);
    }
}