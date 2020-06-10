import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountsTest {
    Accounts accounts;
    @BeforeEach
    void setUp() {
        accounts = new Accounts();
        accounts.addAccount(new Account("arnold",1));
        accounts.addAccount(new Account("elvis",2));
        accounts.addAccount(new Account("elian",3));
        accounts.addAccount(new Account("ena",4));
    }

    @Test
    void getAllAccounts() {
        assertEquals(4,accounts.getAllAccounts().size());
    }

    @Test
    void addAccount() {
        assertEquals(5,accounts.getSize());
        accounts.addAccount(new Account("alguien",5));
        assertEquals(5,accounts.getSize());
    }

    @Test
    void getSize() {
        accounts.addAccount(new Account("ramon",5));
        assertEquals(5,accounts.getSize());
    }

    @Test
    void bigAccounts() {
        accounts.getAccount(0).deposit(100);
        assertEquals(1,accounts.bigAccounts(100).size());
    }

    @Test
    void bigAccountsCount() {
        accounts.getAccount(0).deposit(100);
        accounts.getAccount(1).deposit(50);
        assertEquals(2, accounts.bigAccountsCount(50));
    }

    @Test
    void addBonus() {
        accounts.addBonus(500);
        for (Account account: accounts.getAllAccounts()) {
            assertTrue(account.getAmount() == 500);
        }
    }
}