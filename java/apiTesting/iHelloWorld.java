package apiTesting;

import jakarta.jws.*;

import jakarta.jws.soap.*;

import jakarta.jws.soap.SOAPBinding.Style;
 
/**
 * Service Endpoint Interface
 * @author w3spoint
 */
@WebService
@SOAPBinding(style = Style.RPC)
public interface iHelloWorld {
	@WebMethod String sayHello(String name);
}
