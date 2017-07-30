package biz.flowinn.leilaovirtual.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import biz.flowinn.leilaovirtual.beans.ItemBean;


public class UpdateItemValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return ItemBean.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		
		ItemBean bean = (ItemBean) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "", "Campo 'Nome'  obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "valorLance", "","Campo 'Valor Licitacao'  obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "usuario", "","Campo 'Usuario'  obrigatorio");
		
	}

}
