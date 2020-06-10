import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


class AccountTest {

    Account account;

    @BeforeEach
    void setUp() {
        account = new Account("Arnold",1);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = { " ", "   ", "\t", "\n" })
    void invalidAccountOwnerTest(String args){
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            account = new Account(args,1);
        });
    }

    @Test
    void invalidAccountNumberTest(){
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            account = new Account("arnold",-10);
        });
    }

    @Test
    void invalidDepositAmountTest(){
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            account.deposit(-100);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = { -10,10 })
    void invalidWithdrawAmountTest(int args){
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            account.withdraw(args);
        });
    }

    @Test
    void getAmountTest(){
        assertEquals(0,account.getAmount());
        account.deposit(100);
        assertEquals(100,account.getAmount());
    }
    @Test
    void depositTest(){
        account.deposit(10);
        assertEquals(10,account.getAmount());
    }

    @Test
    void withdrawTest(){
        account.deposit(10);
        account.withdraw(8);
        assertEquals(2,account.getAmount());
    }


}