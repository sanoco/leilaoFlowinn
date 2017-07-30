package biz.flowinn.leilaovirtual.validators;

import java.text.SimpleDateFormat;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import biz.flowinn.leilaovirtual.beans.ItemBean;
import biz.flowinn.leilaovirtual.util.StringUtil;


public class NewItemValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return ItemBean.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		
		ItemBean bean = (ItemBean) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "", "Campo 'Nome'  obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "valorBase", "", "Campo 'Valor Base' obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "incremento", "", "Campo 'Incremento' obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dataLimite", "", "Campo 'Data Limite' obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "horarioLimite", "", "Campo 'Hora Limite' obrigatorio");
		
		try{
			if (StringUtil.isValid(bean.getValorBase())){
				new Float(bean.getValorBase().replace(',','.'));
			}
		}
		catch(Exception e){
			errors.rejectValue( "valorBase","",null,"Campo 'Valor Base': formato invalido");
		}
		
		try{
			if (StringUtil.isValid(bean.getIncremento())){
				new Float(bean.getIncremento().replace(',','.'));
			}
		}
		catch(Exception e){
			errors.rejectValue( "incremento","",null,"Campo 'Incremento': formato invalido");
		}
		
		try{
			new SimpleDateFormat("dd/MM/yyyy").parse(bean.getDataLimite());
		}
		catch(Exception e){
			errors.rejectValue( "dataLimite","",null,"Campo 'Data Limite': formato invalido");
		}
		
		try{
			new SimpleDateFormat("HH:mm:ss").parse(bean.getHorarioLimite());
		}
		catch(Exception e){
			errors.rejectValue( "horarioLimite","",null,"Campo 'Horario Limite': formato invalido");
		}
		
	}

}
