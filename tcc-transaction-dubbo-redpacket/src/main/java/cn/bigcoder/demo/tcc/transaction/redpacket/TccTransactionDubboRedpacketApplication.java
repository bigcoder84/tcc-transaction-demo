package cn.bigcoder.demo.tcc.transaction.redpacket;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mengyun.tcctransaction.spring.annotation.EnableTccTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableDubbo(scanBasePackages = "cn.bigcoder.demo.tcc.transaction.redpacket.service")
@MapperScan("cn.bigcoder.demo.tcc.transaction.redpacket.dao")
@EnableTccTransaction
public class TccTransactionDubboRedpacketApplication {

    public static void main(String[] args) {
        SpringApplication.run(TccTransactionDubboRedpacketApplication.class, args);
    }

}
