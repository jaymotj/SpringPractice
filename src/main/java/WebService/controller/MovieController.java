package WebService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import WebService.domain.Movie;
import WebService.service.OmdbService;

@RestController
@RequestMapping("/omdb")
public class MovieController {

    @Autowired
    private OmdbService omdbService;
    
    @RequestMapping(value="/searchByTitle", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Movie searchByTitle(String title) {
        
        return omdbService.searchByTitle(title);
    }
    
    
    @RequestMapping(value="/searchById", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Movie searchById(String Id) {
        
    	return omdbService.searchById(Id);
    }
}
