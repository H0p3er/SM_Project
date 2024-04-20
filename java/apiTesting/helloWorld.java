package apiTesting;
import jakarta.jws.WebService;
	 
public class helloWorld {

	/**
	 * Service Endpoint Implementation
	 * @author w3spoint
	 */
	@WebService(endpointInterface = "com.w3spoint.business.IHelloWorld")
	public class HelloWorld implements iHelloWorld {
		@Override
		public String sayHello(String name) {
			return "JAX-WS RCP Style. Hello " + name;
		}
	}
}
