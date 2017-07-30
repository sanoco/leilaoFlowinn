package biz.flowinn.leilaovirtual.client.controllers;

import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import biz.flowinn.leilaovirtual.dao.ItemDAO;
import biz.flowinn.leilaovirtual.json.ServiceResponse;
import biz.flowinn.leilaovirtual.vo.ItemVO;


@RestController
public class RestServiceController {
	
	@RequestMapping(value = "/rest/createNewItem",consumes = {"text/xml"})
	@ResponseBody
    public ServiceResponse createNewItem(@RequestBody ItemVO reqVO, HttpServletResponse response) {
        
		ItemVO respVO = ItemDAO.getInstance().insert(reqVO);
		
		ServiceResponse resp = new ServiceResponse();
		resp.setResult(ServiceResponse.SUCCESS);
		resp.setItem(respVO);
		
		return resp;
		
	
    }
	
	@RequestMapping(value = "/rest/getItem",consumes = {"text/xml"})
	@ResponseBody
    public ServiceResponse getItem(@RequestBody ItemVO reqVO, HttpServletResponse response) {
        
		ItemVO respVO = ItemDAO.getInstance().get(reqVO);
		
		ServiceResponse resp = new ServiceResponse();
		resp.setResult(ServiceResponse.SUCCESS);
		resp.setItem(respVO);
		
		return resp;
		
	
    }
	
	@RequestMapping(value = "/rest/updateItem",consumes = {"text/xml"})
	@ResponseBody
    public ServiceResponse updateItem(@RequestBody ItemVO reqVO, HttpServletResponse response) {
        
		ItemVO respVO = ItemDAO.getInstance().update(reqVO);
		
		ServiceResponse resp = new ServiceResponse();
		resp.setResult(ServiceResponse.SUCCESS);
		resp.setItem(respVO);
		
		return resp;
		
	
    }
	
	@RequestMapping(value = "/rest/getAll",consumes = {"text/xml"})
	@ResponseBody
    public ServiceResponse getAll(@RequestBody ItemVO reqVO, HttpServletResponse response) {
        
		Set<ItemVO> allItems = ItemDAO.getInstance().getAll();
		
		ServiceResponse resp = new ServiceResponse();
		resp.setResult(ServiceResponse.SUCCESS);
		resp.setAllItems(allItems);
		
		return resp;
		
	
    }

}
