package com.advertManager;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Аннтоация @SpringBootApplication объединяет аннотации @Configuration, @EnableAutoConfiguration и @ComponentScan,
 * объявляет MainApplication классом-конфигурацией, включает автоматическую конфигурацию приложения
 * и включает автоматический поиск компонентов в пакете и во всех вложенных.
 * <p>
 * Класс MainApplication расширяет класс SpringBootServletInitializer
 * и переопределяет метод SpringApplicationBuilder configure(SpringApplicationBuilder builder)
 * для запуска приложения при развёртывании в сервере приложении.
 */

@SpringBootApplication
public class MainApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args)
                .registerShutdownHook();
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MainApplication.class);
    }

}
