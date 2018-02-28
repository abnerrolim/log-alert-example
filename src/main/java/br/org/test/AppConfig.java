package br.org.test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@ComponentScan({
        "br.org.test"})
@Configuration
public class AppConfig extends WebMvcConfigurerAdapter {

}
