/**
 *  this class represents a bank account implementation
 * @author Arnold Avalos
 */
public class Account {

    private String owner = "";
    private int number;
    private int amount;

    /** constructor for the account class
     * @param owner
     * @param number
     */
    public Account(String owner, int number) {
        if (owner == null || owner.trim().isEmpty() || number < 0) {
            throw new IllegalArgumentException("Invalid Account fields");
        }
        this.owner = owner;
        this.number = number;
    }

    /** method that returns the account amount available
     * @return amount
     */
    public int getAmount() {
        return amount;
    }

    /** method that withdraws a amount from the account
     * @param amount
     */
    public void withdraw(int amount) {
        if (amount < 0) throw new IllegalArgumentException("cannot withdraw negative amounts");
        if (this.amount >= amount) {
            this.amount -= amount;
        } else {
            throw new IllegalArgumentException("insufficient funds");
        }
    }

    /** method to deposit money to the account
     * @param amount
     */
    public void deposit(int amount) {
        if (amount >= 0) {
            this.amount += amount;
        } else {
            throw new IllegalArgumentException("cannot deposit negative amounts");
        }
    }

    @Override
    public String toString() {
        return "hello " + this.owner + " your account #" + this.number + " balance is: " + this.amount;
    }

}
