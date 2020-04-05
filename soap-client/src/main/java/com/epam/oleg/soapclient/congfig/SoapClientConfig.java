package com.epam.oleg.soapclient.congfig;

import com.epam.oleg.soapclient.client.UserClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapClientConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setContextPath("com.oleg.epam.soapclient");

        return jaxb2Marshaller;
    }

    @Bean
    public UserClient articleClient(Jaxb2Marshaller jaxb2Marshaller) {
        UserClient articleClient = new UserClient();
        articleClient.setDefaultUri("http://localhost:8080/ws");
        articleClient.setMarshaller(jaxb2Marshaller);
        articleClient.setUnmarshaller(jaxb2Marshaller);
        return articleClient;
    }
}
