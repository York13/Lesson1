package main;

import main.service.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);

        SummaryService summaryService = context.getBean(SummaryServiceImpl.class);
        summaryService.createHtmlFile("1.properties", "2.properties", "src/main/java/Webapp/summary.html");
    }
}
