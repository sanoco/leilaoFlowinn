package biz.flowinn.leilaovirtual.dao;

import java.util.Set;
import java.util.TreeSet;

import biz.flowinn.leilaovirtual.bo.ItemBO;
import biz.flowinn.leilaovirtual.database.MockDatabase;
import biz.flowinn.leilaovirtual.vo.ItemVO;

public class ItemDAO {
	
	private static ItemDAO singleton;
	
	private ItemDAO(){ };
	
	public static synchronized ItemDAO getInstance( ) {
	      if (singleton == null)
	          singleton=new ItemDAO();
	      return singleton;
	   }
	
	public ItemVO insert(ItemVO vo){
		try{
			MockDatabase.items.add(vo);
			return vo;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	public ItemVO get(ItemVO vo){
		try{
			for(ItemVO item : MockDatabase.items){
				if (item.getNome().equalsIgnoreCase(vo.getNome())){
					return item;
				}
			}
			return null;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	public ItemVO update(ItemVO vo){
		try{
			for(ItemVO item : MockDatabase.items){
				if (item.getNome().equalsIgnoreCase(vo.getNome())){
					item.setValorBase(vo.getValorBase());
					item.setValorAtual(vo.getValorAtual());
					item.setValorFinal(vo.getValorFinal());
					item.setIncremento(vo.getIncremento());
					item.setUsuario(vo.getUsuario());
					item.setStatus(vo.getStatus());
					item.setDataLimite(vo.getDataLimite());
					item.setHorarioLimite(vo.getHorarioLimite());
					return item;
				}
			}
			return null;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	public Set<ItemVO> getAll(){
		return MockDatabase.items;
	}

}
