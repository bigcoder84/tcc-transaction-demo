package cn.bigcoder.demo.tcc.transaction.redpacket.config;

import org.mengyun.tcctransaction.repository.JdbcTransactionRepository;
import org.mengyun.tcctransaction.repository.MemoryStoreTransactionRepository;
import org.mengyun.tcctransaction.repository.RedisTransactionRepository;
import org.mengyun.tcctransaction.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;

import javax.sql.DataSource;

/**
 * @author: Jindong.Tian
 * @date: 2021-12-04
 **/
@Configuration
public class TccTransactionConfig {

    //没有持久化能力，仅可用于测试
    //@Bean("transactionRepository")
    //public TransactionRepository memoryStoreTransactionRepository(){
    //    MemoryStoreTransactionRepository repository = new MemoryStoreTransactionRepository();
    //    repository.setDomain("TCC:DUBBO:CAPITAL:");
    //    return repository;
    //}

    @Bean("transactionRepository")
    public TransactionRepository memoryStoreTransactionRepository2(JedisPool jedisPool) {
        RedisTransactionRepository repository = new RedisTransactionRepository();
        repository.setDomain("TCC:DUBBO:CAPITAL:");
        repository.setJedisPool(jedisPool);
        return repository;
    }

}
