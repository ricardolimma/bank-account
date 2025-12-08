package com.bank.account.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@Document(collection = "accounts")
public class Account {

    @Id
    private String accountId;
    private String ownerName;
    private BigDecimal balance;

    public boolean hasSufficientFunds(BigDecimal amount) {
        return balance.compareTo(amount) >= 0;
    }

    private void debit(BigDecimal amount) {
        this.balance = this.balance.subtract(amount);
    }

    private void credit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }

}
