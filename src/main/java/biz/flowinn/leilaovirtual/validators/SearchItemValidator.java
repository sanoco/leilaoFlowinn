package biz.flowinn.leilaovirtual.validators;

import java.text.SimpleDateFormat;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import biz.flowinn.leilaovirtual.beans.ItemBean;
import biz.flowinn.leilaovirtual.util.StringUtil;


public class SearchItemValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return ItemBean.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		
		ItemBean bean = (ItemBean) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "", "Campo 'Nome'  obrigatorio");
		
	}

}
