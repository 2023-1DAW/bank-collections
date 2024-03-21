package org.ies.tierno.bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String iban;

    private String nif;

    private Double balance;

    public void deposit(double amount) {
        balance += amount;
    }
}
