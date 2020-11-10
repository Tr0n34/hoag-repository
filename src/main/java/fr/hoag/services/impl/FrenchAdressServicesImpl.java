package fr.hoag.services.impl;

import fr.hoag.components.RestTemplateResponseErrorHandler;
import fr.hoag.models.referentials.FrenchAdress;
import fr.hoag.models.referentials.builders.FrenchAdressBuilder;
import fr.hoag.services.FrenchAdressServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class FrenchAdressServicesImpl implements FrenchAdressServices {

    private static final Logger LOGGER = LoggerFactory.getLogger(FrenchAdressServicesImpl.class);
    private static final String DELIMITER_URL = "/";

    @Value("${api.adress.fr}")
    private String resource;
    @Value("${api.adress.fr.search}")
    private String operation;

    private RestTemplate service;

    @Autowired
    public FrenchAdressServicesImpl(RestTemplateBuilder restTemplateBuilder) {
        this.service = restTemplateBuilder.errorHandler(new RestTemplateResponseErrorHandler()).build();
    }

    @Override
    public FrenchAdress search(String q, String type, String codePostal, String codeInsee, int autoComplete, int limit) {
        String path = String.join(DELIMITER_URL, resource, operation);
        LOGGER.debug("API de recherche d'adresse : {}", path);
        UriComponents uri = UriComponentsBuilder.fromHttpUrl(path)
                .queryParam("q", q)
                .queryParam("type", type)
                .queryParam("postcode", codePostal)
                .queryParam("citycode", codeInsee)
                .queryParam("autocomplete", autoComplete)
                .queryParam("limit", limit)
                .build();
        ResponseEntity<FrenchAdress> response = service.getForEntity(uri.toUri(), FrenchAdress.class);
        LOGGER.debug("Response {}", response);
        LOGGER.debug("FrenchAddr : {}", response.getBody());
        return FrenchAdressBuilder.newBuilder().build();
    }

}
