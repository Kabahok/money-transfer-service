package ru.dev.egoravdeev.moneytransferservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.dev.egoravdeev.moneytransferservice.service.TransferBuilder;
import ru.dev.egoravdeev.moneytransferservice.util.GenerateCode;
import ru.dev.egoravdeev.moneytransferservice.util.GenerateId;
import ru.dev.egoravdeev.moneytransferservice.util.MoneyTransfer;
import ru.dev.egoravdeev.moneytransferservice.util.MoneyTransferUtil;

@Configuration
public class WebConfig {

    @Bean
    public TransferBuilder transferBuilder() {
        return new TransferBuilder();
    }


    @Bean
    public GenerateId generateId() {
        return new GenerateId();
    }

    @Bean
    public GenerateCode generateCode() {
        return new GenerateCode();
    }

    @Bean
    public MoneyTransfer moneyTransfer() {
        return new MoneyTransferUtil();
    }
}
