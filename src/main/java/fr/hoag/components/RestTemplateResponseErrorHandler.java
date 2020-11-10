package fr.hoag.components;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;
import java.net.URI;

@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return response.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR
                || response.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR;
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if ( response.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR ) {
            // handle client error
        } else if ( response.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR ) {
            // handle server error
        }
    }

    @Override
    public void handleError(URI url, HttpMethod method, ClientHttpResponse response) throws IOException {
        if ( response.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR ) {
            // handle client error
        } else if ( response.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR ) {
            // handle server error
        }
    }

}
