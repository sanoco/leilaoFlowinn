package biz.flowinn.leilaovirtual.client.controllers;

import java.util.ArrayList;
import java.util.List;

import biz.flowinn.leilaovirtual.vo.ItemVO;

public class ParentController {
	
	/*
	 * Retorna uma lista com os incrementos possiveis
	 * Retorna 10 itens.
	 */
	protected List<String> listIncremento(ItemVO item ){
		int count = 10;
		Float currentValue = item.getIncremento();
		ArrayList<String> finalList = new ArrayList<String>();
		for (int i=0;i<count;i++){
			finalList.add(String.valueOf(currentValue));
			currentValue = currentValue.floatValue() + item.getIncremento().floatValue();
		}
		return finalList;
		
	}

}
