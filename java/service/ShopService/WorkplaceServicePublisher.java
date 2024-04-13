package service.ShopService;

import javax.xml.ws.Endpoint;

public class WorkplaceServicePublisher {
	 public static void main(String[] args) {
		 
		  Endpoint.publish("http://localhost:8000/home/WorkplaceService"
		    , new WorkplaceServiceImpl());
	}
}
