package org.ies.tierno.bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.attribute.standard.DateTimeAtCompleted;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bank {
    private String name;

    private List<Customer> customers;

    private Map<String, Account> accountsByIban;


    public boolean transfer(String from, String to, double amount) {
        if (!accountsByIban.containsKey(from)) {
            System.out.println("No existe la cuenta origen");
        } else if (!accountsByIban.containsKey(to)) {
            System.out.println("No existe la cuenta destino");
        } else {
            var fromAccount = accountsByIban.get(from);
            if (fromAccount.withdraw(amount)) {
                var toAccount = accountsByIban.get(to);
                toAccount.deposit(amount);
                return true;
            }
        }
        return false;
    }

    public boolean withdraw(String iban, double amount) {
        if (accountsByIban.containsKey(iban)) {
            var account = accountsByIban.get(iban);
            return account.withdraw(amount);
        } else {
            System.out.println("No existe la cuenta con iban " + iban);
            return false;
        }
    }

    public List<Account> getCustomerAccounts(String nif) {
        List<Account> accounts = new ArrayList<>();
        for (var account : accountsByIban.values()) {
            if (account.getNif().equals(nif)) {
                accounts.add(account);
            }
        }
        return accounts;
    }

    public void deposit(String iban, double amount) {
        if (accountsByIban.containsKey(iban)) {
            Account account = accountsByIban.get(iban);
            account.deposit(amount);
        } else {
            System.out.println("No existe la cuenta " + iban);
        }
    }
}
