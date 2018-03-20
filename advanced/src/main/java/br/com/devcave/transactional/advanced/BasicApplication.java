package br.com.devcave.transactional.advanced;

import br.com.devcave.transactional.advanced.domain.Bill;
import br.com.devcave.transactional.advanced.domain.TypeEnum;
import br.com.devcave.transactional.advanced.domain.User;
import br.com.devcave.transactional.advanced.repository.UserRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.IntStream;

@Configuration
@SpringBootApplication
@EnableSwagger2
@Controller
public class BasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicApplication.class, args);
    }


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("br.com.devcave.transactional.advanced.controller"))
                .build();
    }

    @GetMapping("/")
    public String getSwagger() {
        return "redirect:swagger-ui.html";
    }

    @Autowired
    public void create(UserRepository userRepository) {
        Faker faker = new Faker(new Locale("pt", "BR"));
        ZoneId defaultZoneId = ZoneId.systemDefault();
        List<User> userList = new ArrayList<>();
        IntStream.range(0, 10).forEach(i -> {
            List<Bill> billList = new ArrayList<>();
            IntStream.range(1,faker.number().numberBetween(2,20)).forEach(j->
                    billList.add(new Bill(TypeEnum.values()[faker.number().numberBetween(0, TypeEnum.values().length)],
                            BigDecimal.valueOf(faker.number().randomDouble(2, 1, 100)),
                            faker.date().between(
                                    Date.from(LocalDate.of(2017,1,1).atStartOfDay(defaultZoneId).toInstant()),
                                    Date.from(LocalDate.of(2017,12,1).atStartOfDay(defaultZoneId).toInstant()))
                                    .toInstant().atZone(defaultZoneId).toLocalDate(),
                            null)));
            userList.add(new User(faker.name().name(), faker.numerify("###########"),billList));
        });
        userRepository.saveAll(userList);
    }
}