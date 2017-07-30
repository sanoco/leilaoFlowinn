package biz.flowinn.leilaovirtual.client.controllers;


import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import biz.flowinn.leilaovirtual.beans.ItemBean;
import biz.flowinn.leilaovirtual.bo.ItemBO;
import biz.flowinn.leilaovirtual.validators.NewItemValidator;
import biz.flowinn.leilaovirtual.validators.SearchItemValidator;
import biz.flowinn.leilaovirtual.validators.UpdateItemValidator;
import biz.flowinn.leilaovirtual.vo.ItemVO;

@Controller
public class ItemController extends ParentController{


	
	@RequestMapping( value = "/actionCreateItem", method = RequestMethod.POST, produces = "text/html")
    public String actionCreateItem(ItemBean bean, BindingResult bindingResult,
			  			Model uiModel,
			  			RedirectAttributes redirectAttributes) {
        
		/* Validações */
		NewItemValidator validator = new NewItemValidator();
		ValidationUtils.invokeValidator( validator, bean, bindingResult );
		
		if (bindingResult.hasErrors()) {
			List<ObjectError> errors = bindingResult.getAllErrors();
			uiModel.addAttribute( "valErrors", errors );
			return "criarItem";
		}
		
		
		/* Criação do item */
		try{
			ItemBO bo = ItemBO.getInstance();
			ItemVO returnVO = bo.createNewItem(bean);
		
			uiModel.addAttribute("flagInsertion",new Boolean(true));
			uiModel.addAttribute("respItemVO", returnVO);
			
			if (returnVO!=null){ // Clean the form
				bean.clean();
				uiModel.addAttribute("itemBean", bean);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return "criarItem";
		
	
    }
	
	@RequestMapping( value = "/actionGetItem", method = RequestMethod.POST, produces = "text/html")
    public String actionGetItem(ItemBean bean, BindingResult bindingResult,
			  			Model uiModel,
			  			RedirectAttributes redirectAttributes) {
        
		/* Validações */
		SearchItemValidator validator = new SearchItemValidator();
		ValidationUtils.invokeValidator( validator, bean, bindingResult );
		
		if (bindingResult.hasErrors()) {
			List<ObjectError> errors = bindingResult.getAllErrors();
			uiModel.addAttribute( "valErrors", errors );
			return "consultarItem";
		}
		
		try{
			ItemBO bo = ItemBO.getInstance();
			ItemVO returnVO = bo.getItem(bean);
		
			uiModel.addAttribute("flagSearch",new Boolean(true));
			uiModel.addAttribute("respItemVO", returnVO);
			
			if (returnVO!=null){ // Clean the form
				bean.clean();
				uiModel.addAttribute("itemBean", bean);
			}
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		return "consultarItem";
		
	
    }
	
	@RequestMapping( value = "/actionUpdateItem", method = RequestMethod.POST, produces = "text/html")
    public String actionUpdateItem(ItemBean bean, BindingResult bindingResult,
			  			Model uiModel,
			  			RedirectAttributes redirectAttributes) throws Exception {
        
		/* Validações */
		UpdateItemValidator validator = new UpdateItemValidator();
		ValidationUtils.invokeValidator( validator, bean, bindingResult );
		
		if (bindingResult.hasErrors()) {
			List<ObjectError> errors = bindingResult.getAllErrors();
			uiModel.addAttribute( "valErrors", errors );
			

			ItemBO bo = ItemBO.getInstance();
			Set<ItemVO> allItems = bo.getAllActive();
			
			ItemVO item = bo.getItem(bean);
			uiModel.addAttribute("currentItem", item);
			uiModel.addAttribute("listaItems", allItems);
			uiModel.addAttribute("listaIncrementos", listIncremento(item));
			
			return "updateItem";
		}
		
		
		
		try{
			ItemBO bo = ItemBO.getInstance();
			ItemVO returnVO = bo.lanceItem(bean);
		
			uiModel.addAttribute("flagUpdate",new Boolean(true));
			uiModel.addAttribute("respItemVO", returnVO);
			
			if (returnVO!=null){ // Clean the form
				bean.clean();
				uiModel.addAttribute("itemBean", bean);
			}
			
			Set<ItemVO> allItems = bo.getAllActive();
			uiModel.addAttribute("listaItems", allItems);
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		return "updateItem";
		
	
    }
	
	
}
