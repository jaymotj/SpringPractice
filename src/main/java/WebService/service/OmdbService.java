package WebService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import WebService.domain.Movie;

@Service
public class OmdbService {

    @Value("${omdb.key}")
    String omdbKey;
    
    @Value("${omdb.url}")
    String omdbUrl;
    
    private final RestTemplate restTemplate;
    
    @Autowired
    public OmdbService(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();

       
    }

    
    public Movie searchByTitle(String title) {
      
       String url = omdbUrl + "?apikey=" + omdbKey + "&t=" + title;
        return restTemplate.getForObject(url, Movie.class);        
    }
    
 public Movie searchById(String Id) {
        
        String url = omdbUrl + "?apikey=" + omdbKey + "&i=" + Id;
          return restTemplate.getForObject(url, Movie.class);
          
    }
}
