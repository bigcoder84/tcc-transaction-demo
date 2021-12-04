package cn.bigcoder.demo.tcc.transaction.order;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mengyun.tcctransaction.spring.annotation.EnableTccTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableDubbo(scanBasePackages = "cn.bigcoder.demo.tcc.transaction.order.service")
@MapperScan("cn.bigcoder.demo.tcc.transaction.order.dao")
@ComponentScan("cn.bigcoder.demo.tcc.transaction")
@EnableTccTransaction
public class TccTransactionDubboOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(TccTransactionDubboOrderApplication.class, args);
    }

}
