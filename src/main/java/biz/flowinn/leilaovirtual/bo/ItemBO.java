package biz.flowinn.leilaovirtual.bo;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import biz.flowinn.leilaovirtual.beans.ItemBean;
import biz.flowinn.leilaovirtual.json.ServiceResponse;
import biz.flowinn.leilaovirtual.util.Util;
import biz.flowinn.leilaovirtual.vo.ItemVO;

public class ItemBO extends MainBO {
	
	public static final String SERVICE_CREATE_ITEM = "http://localhost:8080/rest/createNewItem";
	public static final String SERVICE_GET_ITEM = "http://localhost:8080/rest/getItem";
	public static final String SERVICE_UPDATE_ITEM = "http://localhost:8080/rest/updateItem";
	public static final String SERVICE_GETALL_ITEM = "http://localhost:8080/rest/getAll";
	public static final long CUTDOWN_TIME = 60000; // 1 minuto
	
	
	private static ItemBO singleton;
	
	private ItemBO(){ };
	
	public static synchronized ItemBO getInstance( ) {
	      if (singleton == null)
	          singleton=new ItemBO();
	      return singleton;
	   }
	
	
	public ItemVO createNewItem(ItemBean bean) throws Exception{
		
		/* Verifica se já existe o item cadastrado. Caso positivo, retorna null */
		ItemVO existingVO = getItem(bean);
		if (existingVO!=null){
			return null;
		}
		
		
		ItemVO vo = new ItemVO(bean);
		vo.setStatus(ItemVO.STATUS_NOVO);
		
		/* Conecta ao WebService */
		ItemVO returnVO = sendRestRequest(SERVICE_CREATE_ITEM,vo);
		
		return returnVO;
		
		
		
	}
	
	public ItemVO getItem(ItemBean bean) throws Exception{
		
		ItemVO vo = new ItemVO(bean);
		
		/* Conecta ao WebService */
		ItemVO returnVO = sendRestRequest(SERVICE_GET_ITEM,vo);
		
		return returnVO;
		
	}
	
	
	public ItemVO lanceItem(ItemBean bean) throws Exception{
		
		ItemVO existingVO = getItem(bean);
		if (existingVO==null){
			throw new Exception("O item foi removido: "+bean.getNome());
		}
				
		/* Atualiza o valor atual, baseado no lance */
		Float valorAtual = (existingVO.getValorAtual().floatValue())+(new Float(bean.getValorLance()).floatValue());
		existingVO.setValorAtual(valorAtual);
		existingVO.setUsuario(bean.getUsuario());
		existingVO.setStatus(ItemVO.STATUS_LANCE);
		
		/* Se o lance ocorrer no ultimo minuto, a data limite aumenta 30 segundos */
		Calendar dataLimite = Util.somaDatas(existingVO.getDataLimite(), existingVO.getHorarioLimite());
		long currentIme = System.currentTimeMillis();
		if ((dataLimite.getTimeInMillis()-currentIme)<=CUTDOWN_TIME){ // menor que 1 minuto
			// Data/HorarioLimite aumenta 30 segundos
			long horarioLong = existingVO.getHorarioLimite().getTime()+(CUTDOWN_TIME/2);
			Date novaData = new Date(horarioLong);
			existingVO.setHorarioLimite(novaData);
		}
		
		
		/* Conecta ao WebService */
		ItemVO returnVO = sendRestRequest(SERVICE_UPDATE_ITEM,existingVO);
		
		return returnVO;
		
	}
	
	public Set<ItemVO> getAll() throws Exception{
		
		ItemVO vo = new ItemVO();
		
		/* Conecta ao WebService */
		ServiceResponse resp = sendRestRequestByServiceResponse(SERVICE_GETALL_ITEM,vo);
		
		return resp.getAllItems();
		
	}
	
	/*
	 * Retorna todos os itens, que NAO estejam encerrado
	 */
	public Set<ItemVO> getAllActive() throws Exception{
		
		Set<ItemVO> finalItems = new TreeSet<ItemVO>();
		Set<ItemVO> items = getAll();
		if (items!=null){
			for (ItemVO item:items){
				if (!item.getStatus().equals(ItemVO.STATUS_ENCERRADO)){
					finalItems.add(item);
				}
			}
		}
		return finalItems;
		
	}
	

}
