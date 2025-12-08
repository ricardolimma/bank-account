package com.bank.account.application.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DebitFailedEvent {
    private String transactionId;
    private String sourceAccountId;
    private String destinationAccountId;
    private String amount;
    private String reason;
}
