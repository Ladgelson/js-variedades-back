package jsvariedades.sales.config.logging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class LogArgumentConfiguration {

    @Bean
    @Autowired(required = false)
    public LogArgumentMapper bean(List<LogArgumentTypeConfiguration> configurations){
        LogArgumentMapper mapper = new LogArgumentMapper();

        configurations.forEach(config -> config.configure(mapper));

        return mapper;
    }
}
