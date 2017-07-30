package biz.flowinn.leilaovirtual.vo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.util.StringUtils;

import biz.flowinn.leilaovirtual.beans.ItemBean;
import biz.flowinn.leilaovirtual.util.StringUtil;
import biz.flowinn.leilaovirtual.util.Util;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "nome",
    "valorBase",
    "incremento",
    "valorFinal",
    "valorAtual",
    "usuario",
    "status",
    "dataLimite",
    "horarioLimite"
})
@XmlRootElement(name = "Item")
public class ItemVO implements Comparable<ItemVO> {
	
	public static String STATUS_NOVO="NOVO";
	public static String STATUS_LANCE="DISPONIVEL PARA LANCE";
	public static String STATUS_ENCERRADO="ENCERRADO";

	@XmlElement(required = false)
	private String nome;
	
	@XmlElement(required = false)
	private Float valorBase;
	
	@XmlElement(required = false)
	private Float incremento;
	
	@XmlElement(required = false)
	private Float valorFinal;
	
	@XmlElement(required = false)
	private Float valorAtual;
	
	@XmlElement(required = false)
	private String usuario;
	
	@XmlElement(required = false)
	private String status;
	
	@XmlElement(required = false)
	private Date dataLimite;
	
	@XmlElement(required = false)
	private Date horarioLimite;
	
	public ItemVO(){
	}
	
	public ItemVO(ItemBean bean) throws Exception{
		this.nome = bean.getNome();
		if (StringUtil.isValid(bean.getValorBase())){
			this.valorBase=new Float(bean.getValorBase().replace(',','.'));
		}
		if (StringUtil.isValid(bean.getIncremento())){
			this.incremento=new Float(bean.getIncremento().replace(',','.'));
		}
		if (StringUtil.isValid(bean.getValorFinal())){
			this.valorFinal=new Float(bean.getValorFinal().replace(',','.'));
		}
		if (StringUtil.isValid(bean.getValorAtual())){
			this.valorAtual=new Float(bean.getValorAtual().replace(',','.'));
		}
		this.usuario=bean.getUsuario();
		this.status=bean.getUsuario();
		if (StringUtil.isValid(bean.getDataLimite())){
			this.dataLimite=new SimpleDateFormat("dd/MM/yyyy").parse(bean.getDataLimite());
		}
		if (StringUtil.isValid(bean.getHorarioLimite())){
			this.horarioLimite=new SimpleDateFormat("HH:mm:ss").parse(bean.getHorarioLimite());
		}
		
	}
	
	
	public ItemVO(String nome, Float valorBase, Float incremento,
			Float valorFinal, Float valorAtual, String usuario, String status,
			Date dataLimite, Date horarioLimite) {
		super();
		this.nome = nome;
		this.valorBase = valorBase;
		this.incremento = incremento;
		this.valorFinal = valorFinal;
		this.valorAtual = valorAtual;
		this.usuario = usuario;
		this.status = status;
		this.dataLimite = dataLimite;
		this.horarioLimite = horarioLimite;
	}




	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Float getValorBase() {
		return valorBase;
	}
	public void setValorBase(Float valorBase) {
		this.valorBase = valorBase;
	}
	public Float getIncremento() {
		return incremento;
	}
	public void setIncremento(Float incremento) {
		this.incremento = incremento;
	}
	public Float getValorFinal() {
		if (getStatus().equals(ItemVO.STATUS_ENCERRADO)){
			setValorFinal(getValorAtual());
		}
		return valorFinal;
	}
	public void setValorFinal(Float valorFinal) {
		this.valorFinal = valorFinal;
	}
	public Float getValorAtual() {
		if (this.valorAtual==null){
			setValorAtual(this.valorBase);
		}
		return valorAtual;
	}
	public void setValorAtual(Float valorAtual) {
		this.valorAtual = valorAtual;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getStatus() {
		
		/* Soma DataLimite e HorarioLimite */
		Calendar c1 = Util.toCalendar(this.getDataLimite());
		Calendar c2 = Util.toCalendar(this.getHorarioLimite());
		Calendar dueDateC = Calendar.getInstance();
		dueDateC.setTimeInMillis(c1.getTimeInMillis()+c2.getTimeInMillis());
		dueDateC = Util.atualizaTimezone(dueDateC);
		
		/* Data/Horario atual */
		Calendar currentC = Calendar.getInstance();
		currentC.setTimeInMillis(System.currentTimeMillis());
		

		if (currentC.after(dueDateC)){
			setStatus(ItemVO.STATUS_ENCERRADO);
		}
		
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDataLimite() {
		return dataLimite;
	}
	public void setDataLimite(Date dataLimite) {
		this.dataLimite = dataLimite;
	}
	public Date getHorarioLimite() {
		return horarioLimite;
	}
	public void setHorarioLimite(Date horarioLimite) {
		this.horarioLimite = horarioLimite;
	}

	@Override
	public int compareTo(ItemVO o) {
		return this.nome.compareTo(o.getNome());
	}
	
	
	
	
}
