package ru.job4j.bank;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BankTest {
    private Bank bank;
    private User user;
    private Account account;
    private User user2;
    private Account account2;

    @Before
    public void start() {
        this.bank = new Bank();
        this.user = new User("test", "test");
        this.account = new Account(100, "pasport");
        this.bank.addUser(this.user);
        this.bank.addAccountToUser(this.user.getPasport(), this.account);
        this.user2 = new User("test2", "pasport2");
        this.bank.addUser(user2);
        this.account2 = new Account(100, "pasport");
        this.bank.addAccountToUser(user2.getPasport(),  this.account2);
    }

    @Test
    public void thenAddNewUser() {
        this.bank.addUser(this.user);
       // this.bank.deleteUser(this.user);
        this.bank.addAccountToUser("test", this.account);
        this.bank.addAccountToUser("test", this.account);
        this.bank.addAccountToUser("test", new Account(100, "35"));
        this.bank.deleteAccountFromUser("test", this.account);
        List<Account> list = this.bank.getUserAccounts("test");
    }

    @Test
    public void thenDeleteUser() {
        this.bank.deleteUser(this.user);
        boolean result = this.bank.getUsers().containsKey(this.user);
        assertThat(false, is(result));
    }

    @Test
    public void whenAddAccountToUserThenAccountIncreaseOnOne() {
        boolean result = this.bank.getUsers().get(this.user).contains(this.account);
        assertThat(true, is(result));
    }

    @Test
    public void whenDeleteAccountToUserThenAccountReductionOnOne() {
        this.bank.deleteAccountFromUser(this.user.getPasport(), this.account);
        boolean result = this.bank.getUsers().get(this.user).contains(this.account);
        assertThat(false, is(result));
    }

    @Test
    public void whenSuccessTransfer() {
        boolean result = this.bank.transferMoney(this.user.getPasport(), this.account, this.user2.getPasport(), this.account2, 100);
        assertThat(true, is(result));
    }

    @Test
    public void whenNoSuccessTransfer() {
        boolean result = this.bank.transferMoney(this.user.getPasport(), this.account, this.user2.getPasport(), this.account2, 101);
        assertThat(false, is(result));
    }

    @Test
    public void whenNoSuccessTransferNotFoundAccount() {
        boolean result = this.bank.transferMoney("asd", this.account, this.user2.getPasport(), this.account2, 101);
        assertThat(false, is(result));
    }
}