package biz.flowinn.leilaovirtual.bo;


import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import biz.flowinn.leilaovirtual.json.ServiceResponse;
import biz.flowinn.leilaovirtual.util.RestClient;
import biz.flowinn.leilaovirtual.vo.ItemVO;

public class MainBO {
	
	protected ItemVO sendRestRequest(String servico, ItemVO voRequest) throws Exception{
	
		try{
			Response response = buildClient(servico, voRequest);
			
			int status = response.getStatus();
			if (status==200){  // means it connected correctly
				
				ServiceResponse res = (ServiceResponse) response.readEntity(ServiceResponse.class);
				return res.getItem();
			}
			else{
				throw new Exception("Connection error status:"+status);
			}
					
		
		
		}
		catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	
	protected ServiceResponse sendRestRequestByServiceResponse(String servico, ItemVO voRequest) throws Exception{
		
		try{
			Response response = buildClient(servico, voRequest);
			
			int status = response.getStatus();
			if (status==200){  // means it connected correctly
				
				ServiceResponse res = (ServiceResponse) response.readEntity(ServiceResponse.class);
				return res;
			}
			else{
				throw new Exception("Connection error status:"+status);
			}
					
		
		
		}
		catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}

	private Response buildClient(String servico, ItemVO voRequest)
			throws Exception {
		WebTarget webTarget = RestClient.buildWebTarget(servico);
		
		// Accessing the WebService 
		Invocation.Builder builder = webTarget.request(MediaType.APPLICATION_XML);
		Response response = builder.put(Entity.entity(voRequest, MediaType.TEXT_XML));
		return response;
	}

}
