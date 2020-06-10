import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * this class represents a collection of accounts
 */
public class Accounts {

    private List<Account> accounts;

    public Accounts(){
        accounts = new ArrayList<>();
    }

    /**
     * method that returns a list of all accounts
     * @return
     */
    public List<Account> getAllAccounts() {
        return accounts;
    }

    /**
     * method to add acounts to the collection
     * @param account
     */
    public void addAccount(Account account){
        this.accounts.add(account);
    }

    /**
     * method that return the collection size
     * @return
     */
    public int getSize(){
        return this.accounts.size();
    }

    /**
     * method that returns a list of accounts wich amount are equal o greater than the argument
     * @param amount
     * @return
     */
     public List<Account> bigAccounts(int amount){
        return this.accounts.stream().filter(account -> account.getAmount() >= amount).collect(Collectors.toList());
     }

    /**
     * method that returns the number of accounts wich amount are equal o greater than the argument
     * @param amount
     * @return
     */
    public int bigAccountsCount(int amount){
        return (int)this.accounts.stream().filter(account -> account.getAmount() >= amount).count();
    }

    /**
     * method that deposits a fixed amount to every account
     * @param amount
     */
    public void addBonus(int amount){
        this.accounts.stream().forEach(account -> account.deposit(amount));
    }
    public Account getAccount(int index){
        return this.accounts.get(index);
    }


}
