package com.bank.account.infrastructure.kafka;

import com.bank.account.application.event.TransactionInitiatedEvent;
import com.bank.account.application.service.AccountAppService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
    private final AccountAppService appService;

    public KafkaListeners(AccountAppService appService) {
        this.appService = appService;
    }

    @KafkaListener(topics = "transaction.initiated", groupId = "account-service-group")
    public void onTransactionInitiated(TransactionInitiatedEvent event) {
        appService.handleTransactionInitiated(event);
    }

    @KafkaListener(topics = "transaction.credit", groupId = "account-service-group")
    public void onTransactionCredit(TransactionInitiatedEvent event) {
        appService.handleTransactionCredit(event);
    }
}
