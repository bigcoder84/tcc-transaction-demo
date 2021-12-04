package cn.bigcoder.demo.tcc.transaction.capital.config;

import org.mengyun.tcctransaction.repository.MemoryStoreTransactionRepository;
import org.mengyun.tcctransaction.repository.TransactionRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Jindong.Tian
 * @date: 2021-12-04
 **/
@Configuration
public class TccTransactionConfig {
    @Bean("transactionRepository")
    public TransactionRepository memoryStoreTransactionRepository() {
        MemoryStoreTransactionRepository repository = new MemoryStoreTransactionRepository();
        repository.setDomain("TCC:DUBBO:CAPITAL:");
        return repository;
    }
}
