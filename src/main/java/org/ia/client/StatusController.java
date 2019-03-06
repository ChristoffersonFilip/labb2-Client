package org.ia.client;



import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
public class StatusController {

        RestTemplate restTemplate;

        public StatusController(RestTemplate restTemplate) {
            this.restTemplate = restTemplate;
        }


        @GetMapping("/getstatus")
        public List<Status> getAllModelsl() {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<?> httpEntity = new HttpEntity<Object>(headers);

              ResponseEntity<List<Status>> responseEntity =
                    restTemplate.exchange("http://storestatus-env.kj3uq9qghj.us-east-2.elasticbeanstalk.com/status/",
                            HttpMethod.GET,
                            httpEntity,
                            new ParameterizedTypeReference<List<Status>>() {
            });
              return responseEntity.getBody();
        }


}
