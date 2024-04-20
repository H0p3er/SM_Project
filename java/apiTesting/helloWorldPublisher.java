package apiTesting;

import jakarta.xml.ws.Endpoint;
public class helloWorldPublisher {
	public static void main(String args[]){
		Endpoint.publish("http://localhost:8080/ws/helloWorldRCP", 
				new helloWorld());
	}
}