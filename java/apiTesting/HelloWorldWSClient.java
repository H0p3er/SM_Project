package apiTesting;
import java.net.MalformedURLException;
import java.net.URL;
 
import javax.xml.namespace.QName;
import jakarta.xml.ws.*;
 
public class HelloWorldWSClient {
 public static void main(String args[]){
  try {
	URL url = new URL("http://localhost:8080/ws/helloWorldRCP?wsdl");
	QName qname = new QName("http://business.w3spoint.com/",
			"HelloWorldService"); 
	Service service = Service.create(url, qname);
	iHelloWorld helloWorld = service.getPort(iHelloWorld.class);  
	System.out.println(helloWorld.sayHello("w3spoint"));
  } catch (MalformedURLException e) {
	e.printStackTrace();
  } 
 }
}