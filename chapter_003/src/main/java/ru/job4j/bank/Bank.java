package ru.job4j.bank;

import java.util.*;

public class Bank {

    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        this.users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void deleteUser(User user) {
        this.users.remove(user);
    }

    public void addAccountToUser(String pasport, Account account) {
        List accounts = this.users.get(findUser(pasport));
        if (accounts != null && accounts.indexOf(account) == -1) {
            accounts.add(account);
        }
    }

    public void deleteAccountFromUser(String pasport, Account account) {
        List accounts = this.users.get(findUser(pasport));
        if (accounts != null && accounts.indexOf(account) != -1) {
            accounts.remove(account);
        }
    }

    private User findUser(String pasport) {
        User result = User.EMPTY;
        for (Map.Entry<User, List<Account>> entry : this.users.entrySet()) {
            if (entry.getKey().getPasport() == pasport) {
                result = entry.getKey();
                break;
            }
        }
        return result;
    }

    public List<Account> getUserAccounts(String passport) {
        return this.users.get(findUser(passport));
    }

    private Account getActualAccount(String passport, Account account) {
        List<Account> list = this.users.get(findUser(passport));
        int index = list == null ? -1 : list.indexOf(account);
        return index == -1 ? Account.EMPTY : list.get(index);
    }

    public boolean transferMoney(String srcPassport, Account srcRequisite,
                                 String destPassport, Account destRequisite, double amount) {
        return getActualAccount(srcPassport, srcRequisite).transfer(
                getActualAccount(destPassport, destRequisite), amount);
    }

    public Map<User, List<Account>> getUsers() {
        return users;
    }

    public String toString() {
        return "Bank{" + "accounts=" + users + "}";
    }
}
