package com.epam.oleg.client.config;

import com.epam.oleg.client.client.UserClient;
import com.epam.oleg.client.dto.UserSearchRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import javax.annotation.PostConstruct;

@Configuration
public class SoapClientConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setPackagesToScan("com.oleg.epam", "io.spring.guides.gs_producing_web_service");

        return jaxb2Marshaller;
    }

    @Bean
    public UserClient userClient(Jaxb2Marshaller jaxb2Marshaller) {
        UserClient userClient = new UserClient();
        userClient.setDefaultUri("http://localhost:8080/ws");
        userClient.setMarshaller(jaxb2Marshaller);
        userClient.setUnmarshaller(jaxb2Marshaller);
        return userClient;
    }
}
