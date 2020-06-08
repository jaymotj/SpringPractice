package WebService;



import java.net.MalformedURLException;
import java.util.concurrent.atomic.AtomicLong;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static String template = "Hello World";
	private final AtomicLong counter = new AtomicLong();
    private int age = 37; 
	

	@GetMapping("/greeting")
	public Greeting greeting() throws MalformedURLException 
	{
		return new Greeting(counter.incrementAndGet(), template, age);
	}
	

	  @RequestMapping(value = "/", method = RequestMethod.GET)
	    public String getIndex() {
	        return "index.html";
	    }
 
}