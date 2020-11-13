package fr.hoag.controllers;

import fr.hoag.configuration.Config;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileReader;
import java.io.IOException;

@RestController()
@RequestMapping("configuration")
public class ConfigurationController {

    public static final Logger logger = LoggerFactory.getLogger(ConfigurationController.class);

    @Autowired
    MavenXpp3Reader reader;

    @Autowired
    Config configuration;

    @GetMapping("/version-app")
    public String version() throws IOException, XmlPullParserException {
        Model model = reader.read(new FileReader("pom.xml"));
        logger.debug("Maven Model : {}", model.toString());
        return model.getVersion();
    }

    @GetMapping("/version-api-user")
    public String versionApi() {
        return this.configuration.versionApiUser;
    }

}
