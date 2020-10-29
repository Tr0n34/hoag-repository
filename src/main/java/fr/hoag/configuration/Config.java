package fr.hoag.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    private static final Logger logger = LoggerFactory.getLogger(Config.class);

    @Value("${versions.api-user}")
    public String versionApiUser;


}
