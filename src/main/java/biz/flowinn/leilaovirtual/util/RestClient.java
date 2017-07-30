package biz.flowinn.leilaovirtual.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;


public class RestClient {
	
	public static WebTarget buildWebTarget(String serviceName) throws Exception{
		
		WebTarget target = null;
		try{
			
			ClientConfig config = new ClientConfig();
			HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("user","password");
			config.register(feature);
			
			
			JerseyWithSSL ssl = new JerseyWithSSL();
			Client client = ssl.initClient(config);
			
			target = client.target(serviceName);
			
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
		
		return target;
	}

}
