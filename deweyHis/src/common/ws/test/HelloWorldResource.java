//package common.ws.test;
//
///* 
// * ´´½¨RESTful Web Services
// *  HelloWorldResource 
// * 
// * Created on July 23, 2008, 10:13 AM 
// * 
// * To change this template, choose Tools | Template Manager 
// * and open the template in the editor. 
// */
//import javax.ws.rs.core.Context;
//import javax.ws.rs.core.UriInfo;
//import javax.ws.rs.Path;
//import javax.ws.rs.GET;
//import javax.ws.rs.PUT;
//import javax.ws.rs.ProduceMime;
//import javax.ws.rs.ConsumeMime;
//
///** 
// * REST Web Service 
// * 
// * @author meerasubbarao 
// */
//
//@Path("helloWorld")
//public class HelloWorldResource {
//	@Context
//	private UriInfo context;
//
//	/** Creates a new instance of HelloWorldResource */
//	public HelloWorldResource() {
//	}
//
//	/** 
//	 * Retrieves representation of an instance of com.stelligent.ws.HelloWorldResource 
//	 * @return an instance of java.lang.String 
//	 */
//	@GET
//	@ProduceMime("text/plain")
//	// application/xml 
//	public String getText() {
//		//TODO return proper representation object  
//		//throw new UnsupportedOperationException();
//		return "Hello World from REST web services generated in 60 seconds";  
//	}
//
//	/** 
//	 * PUT method for updating or creating an instance of HelloWorldResource 
//	 * @param content representation for the resource 
//	 * @return an HTTP response with content of the updated or created resource. 
//	 */
//	@PUT
//	@ConsumeMime("text/plain")
//	public void putText(String content) {
//	}
//}