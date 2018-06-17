package cn.lands.liuwang.investservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "cn.lands.liuwang")
public class InvestServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(InvestServiceApplication.class, args);
    }
}
