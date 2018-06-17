package cn.lands.liuwang.investservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "cn.lands.liuwang")
public class InvestServiceApplication {
    private static final Logger logger = LogManager.getLogger(InvestServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(InvestServiceApplication.class, args);
    }
}
