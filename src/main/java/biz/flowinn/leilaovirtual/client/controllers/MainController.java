package biz.flowinn.leilaovirtual.client.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import biz.flowinn.leilaovirtual.beans.HomeBean;
import biz.flowinn.leilaovirtual.beans.ItemBean;
import biz.flowinn.leilaovirtual.bo.ItemBO;
import biz.flowinn.leilaovirtual.vo.ItemVO;

@Controller
public class MainController extends ParentController {
	
	public static final String ACTION_RELOAD="reload";

	@RequestMapping( value = "/index", method = RequestMethod.GET, produces = "text/html")
    public String home(HomeBean bean, BindingResult bindingResult,
			  			Model uiModel,
			  			RedirectAttributes redirectAttributes) {
        
		
		return "home";
		
	
    }
	
	@RequestMapping( value = "/criarItem", method = RequestMethod.GET, produces = "text/html")
    public String criarItem(ItemBean bean, BindingResult bindingResult,
			  			Model uiModel,
			  			RedirectAttributes redirectAttributes) {
        
		return "criarItem";
	
    }
	
	@RequestMapping( value = "/consultarItem", method = RequestMethod.GET, produces = "text/html")
    public String consultarItem(ItemBean bean, BindingResult bindingResult,
			  			Model uiModel,
			  			RedirectAttributes redirectAttributes) {
        
		return "consultarItem";
	
    }
	
	@RequestMapping( value = "/updateItem", method = RequestMethod.GET, produces = "text/html")
    public String updateItem(ItemBean bean, BindingResult bindingResult,
			  			Model uiModel,
			  			RedirectAttributes redirectAttributes) throws Exception{
        
		ItemBO bo = ItemBO.getInstance();
		Set<ItemVO> allItems = bo.getAllActive();
		
		
		uiModel.addAttribute("listaItems", allItems);
		
		return "updateItem";
	
    }
	
	@RequestMapping( value = "/reloadItem", method = RequestMethod.POST, produces = "text/html")
    public String reloadItem(ItemBean bean, BindingResult bindingResult,
			  			Model uiModel,
			  			RedirectAttributes redirectAttributes) throws Exception{
        
		ItemBO bo = ItemBO.getInstance();
		Set<ItemVO> allItems = bo.getAllActive();
		
		ItemVO item = bo.getItem(bean);
	
		uiModel.addAttribute("currentItem", item);
		uiModel.addAttribute("listaItems", allItems);
		uiModel.addAttribute("listaIncrementos", listIncremento(item));
		
		bean.setValorLance("");
		bean.setUsuario("");
		uiModel.addAttribute("itemBean", bean);
		
		return "updateItem";
	
    }
	
	
	
	
	
	
}
