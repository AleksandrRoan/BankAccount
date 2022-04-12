package bank;

public class AccountNumberGenerator {
    private static int count = 0;

    public static int getNext(){
        return count++;
    }

    public static int getCurrent(){
        return count;
    }

    public void reset(){
        count = 0;
    }

}
