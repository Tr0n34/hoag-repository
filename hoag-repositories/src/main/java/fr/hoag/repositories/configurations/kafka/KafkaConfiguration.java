package fr.hoag.repositories.configurations.kafka;

import fr.hoag.repositories.configurations.YamlPropertySourceFactory;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySource(value = "classpath:kafka.yml", factory = YamlPropertySourceFactory.class)
public class KafkaConfiguration {

    @Value("${server.address}")
    private String serverAddress;

    @Value("${server.port}")
    private String port;


    @Bean
    public KafkaAdmin admin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, String.join(":", this.serverAddress, this.port));
        return new KafkaAdmin(configs);
    }

}
