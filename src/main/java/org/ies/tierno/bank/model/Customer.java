package org.ies.tierno.bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private String nif;
    private String name;
    private String surname;
    private int zipCode;
}
