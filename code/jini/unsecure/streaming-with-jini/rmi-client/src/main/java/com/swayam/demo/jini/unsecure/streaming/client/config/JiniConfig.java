package com.swayam.demo.jini.unsecure.streaming.client.config;

import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

import com.swayam.demo.jini.unsecure.streaming.api.service.BankDetailService;
import com.swayam.demo.jini.unsecure.streaming.client.ProxyRemoteFactoryBean;

import net.jini.core.discovery.LookupLocator;
import net.jini.export.Exporter;
import net.jini.jeri.BasicILFactory;
import net.jini.jeri.BasicJeriExporter;
import net.jini.jeri.tcp.TcpServerEndpoint;

@Configuration
public class JiniConfig {

    @Autowired
    private Environment environment;

    @Bean
    public LookupLocator lookupLocator() throws MalformedURLException {
	return new LookupLocator(environment.getProperty("jini.registryUrl"));
    }

    @Bean(name = "bankDetailService")
    public ProxyRemoteFactoryBean bankDetailService(LookupLocator lookupLocator) {
	ProxyRemoteFactoryBean proxyRemoteFactoryBean = new ProxyRemoteFactoryBean();
	proxyRemoteFactoryBean.setLookupLocator(lookupLocator);
	proxyRemoteFactoryBean.setServiceName(BankDetailService.class.getSimpleName());
	return proxyRemoteFactoryBean;
    }

    @Bean
    @Scope("prototype")
    public Exporter exporter() {
	return new BasicJeriExporter(TcpServerEndpoint.getInstance(Integer.valueOf(environment.getProperty("jini.rmiPort"))), new BasicILFactory());
    }

}