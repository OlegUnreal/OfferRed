package com.epam.oleg.soap.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;
import org.springframework.ws.soap.security.wss4j2.callback.SimplePasswordValidationCallbackHandler;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
import java.util.List;
import java.util.Properties;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

	@Bean
	public SimplePasswordValidationCallbackHandler securityCallbackHandler() {
		SimplePasswordValidationCallbackHandler callbackHandler = new SimplePasswordValidationCallbackHandler();
		Properties users = new Properties();
		users.setProperty("admin", "secret");
		callbackHandler.setUsers(users);
		return callbackHandler;
	}

	@Bean
	public Wss4jSecurityInterceptor securityInterceptor() {
		Wss4jSecurityInterceptor securityInterceptor = new Wss4jSecurityInterceptor();
		securityInterceptor.setValidationActions("UsernameToken");
		securityInterceptor.setValidationCallbackHandler(securityCallbackHandler());
		return securityInterceptor;
	}

	@Override
	public void addInterceptors(List<EndpointInterceptor> interceptors) {
		interceptors.add(securityInterceptor());
	}

	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/ws/*");
	}

	@Bean(name = "offers")
	public DefaultWsdl11Definition offersWsdl11Definition(XsdSchema offersSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("OffersPort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://spring.io/guides/gs-producing-web-service");
		wsdl11Definition.setSchema(offersSchema);
		return wsdl11Definition;
	}

	@Bean(name = "products")
	public DefaultWsdl11Definition productsWsdl11Definition(XsdSchema productsSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("productsPort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://spring.io/guides/gs-producing-web-service");
		wsdl11Definition.setSchema(productsSchema);
		return wsdl11Definition;
	}

	@Bean(name = "lots")
	public DefaultWsdl11Definition lotsWsdl11Definition(XsdSchema lotsSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("LotsPort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://spring.io/guides/gs-producing-web-service");
		wsdl11Definition.setSchema(lotsSchema);
		return wsdl11Definition;
	}

	@Bean(name = "users")
	public DefaultWsdl11Definition usersWsdl11Definition(XsdSchema usersSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("UsersPort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://spring.io/guides/gs-producing-web-service");
		wsdl11Definition.setSchema(usersSchema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema productsSchema() {
		return new SimpleXsdSchema(new ClassPathResource("products.xsd"));
	}

	@Bean
	public XsdSchema usersSchema() {
		return new SimpleXsdSchema(new ClassPathResource("users.xsd"));
	}

	@Bean
	public XsdSchema offersSchema() {
		return new SimpleXsdSchema(new ClassPathResource("offers.xsd"));
	}

	@Bean
	public XsdSchema lotsSchema() {
		return new SimpleXsdSchema(new ClassPathResource("lots.xsd"));
	}

}
