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

    private Account getActualAccount(User user, Account account) {
       List<Account> list = this.users.get(user);
       return list.get(list.indexOf(account));
    }

    public boolean transferMoney(String srcPassport, Account srcRequisite,
                                 String destPassport, Account destRequisite, double amount) {
        boolean result = false;
        List<Account> srcAccounts = this.users.get(findUser(srcPassport));
        List<Account> destAccounts = this.users.get(findUser(destPassport));
        if (srcAccounts != null && destAccounts != null
                && srcAccounts.contains(srcRequisite) && destAccounts.contains(destRequisite)) {
            result =  getActualAccount(findUser(srcPassport), srcRequisite).transfer(
                    getActualAccount(findUser(destPassport), destRequisite), amount);
        }
        return result;
    }

    public Map<User, List<Account>> getUsers() {
        return users;
    }

    public String toString() {
        return "Bank{" + "accounts=" + users + "}";
    }
}
