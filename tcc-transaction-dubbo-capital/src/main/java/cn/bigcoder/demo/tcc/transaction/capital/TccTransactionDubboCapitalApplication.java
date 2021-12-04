package cn.bigcoder.demo.tcc.transaction.capital;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mengyun.tcctransaction.spring.annotation.EnableTccTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo(scanBasePackages = "cn.bigcoder.demo.tcc.transaction.capital.service")
@MapperScan("cn.bigcoder.demo.tcc.transaction.capital.dao")
@EnableTccTransaction
public class TccTransactionDubboCapitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(TccTransactionDubboCapitalApplication.class, args);
    }

}
