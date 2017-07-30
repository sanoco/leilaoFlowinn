package biz.flowinn.leilaovirtual.beans;


public class ItemBean {
	
	private String nome;
	private String valorBase;
	private String incremento;
	private String valorFinal;
	private String valorAtual;
	private String usuario;
	private String status;
	private String dataLimite;
	private String horarioLimite;
	private String valorLance;
	private String action;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getValorBase() {
		return valorBase;
	}
	public void setValorBase(String valorBase) {
		this.valorBase = valorBase;
	}
	
	public String getIncremento() {
		return incremento;
	}
	public void setIncremento(String incremento) {
		this.incremento = incremento;
	}
	public String getValorFinal() {
		return valorFinal;
	}
	public void setValorFinal(String valorFinal) {
		this.valorFinal = valorFinal;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDataLimite() {
		return dataLimite;
	}
	public void setDataLimite(String dataLimite) {
		this.dataLimite = dataLimite;
	}
	public String getHorarioLimite() {
		return horarioLimite;
	}
	public void setHorarioLimite(String horarioLimite) {
		this.horarioLimite = horarioLimite;
	}
	public String getValorAtual() {
		return valorAtual;
	}
	public void setValorAtual(String valorAtual) {
		this.valorAtual = valorAtual;
	}
	
	
	public String getValorLance() {
		return valorLance;
	}
	public void setValorLance(String valorLance) {
		this.valorLance = valorLance;
	}
	public void clean(){
		this.nome="";
		this.valorBase="";
		this.incremento="";
		this.valorFinal="";
		this.valorAtual="";
		this.usuario="";
		this.status="";
		this.dataLimite="";
		this.horarioLimite="";
		this.valorLance="";
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
	
	

}
