package WebService.service;



import java.net.MalformedURLException;



public class Greeting {


	private final long id;
	private final String content;
	
	
    private int myAge; 
	

	

	public Greeting(long id, String content, int myAge) throws MalformedURLException
	{
		this.id = id;
		this.content = content;
		this.myAge = myAge;
	}

	public int getMyage() {
		 
		return myAge;
	}

	
	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
	
	
}
