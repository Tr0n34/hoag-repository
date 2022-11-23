package fr.hoag.repositories.configurations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.IOException;

public class YamlPropertySourceFactory implements PropertySourceFactory {

    private static final Logger logger = LoggerFactory.getLogger(YamlPropertySourceFactory.class);

    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
        YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
        factory.setResources(resource.getResource());
        logger.debug("loading property source : {}", resource.getResource().getFilename());
        return new PropertiesPropertySource(
                resource.getResource().getFilename(),
                factory.getObject()
        );
    }
}
