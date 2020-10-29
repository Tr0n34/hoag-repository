package fr.hoag.components.readers;

import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class MavenReader {

    @Bean
    public MavenXpp3Reader createMavenReader() {
        return new MavenXpp3Reader();
    }

}
