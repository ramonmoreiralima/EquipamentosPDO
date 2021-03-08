package br.com.pdo.model;
import java.util.Date;
import java.io.Serializable;

public class Equipamento implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String hostname;
	private String descricao;
	private String ip1;
	private String ip2;
	private String mascara;
	private String gateway;
	private String tipo;
	private String batismo;
	private String serialNumber;
	private String servico;


	public Equipamento() {
		super();
	}
	public Equipamento(Integer id,String hostname,String descricao,String ip1,String ip2,String mascara,
			String gateway,String tipo,String batismo,String serialNumber,String servico
			) {
		super();
		this.id = id;
		this.hostname = hostname;
		this.descricao = descricao;
		this.ip1 = ip1;
		this.ip2 = ip2;
		this.mascara = mascara;
		this.gateway = gateway;
		this.tipo = tipo;
		this.batismo = batismo;
		this.serialNumber = serialNumber;
		this.servico = servico;
	}
	public Equipamento(String hostname,String descricao,String ip1,String ip2,String mascara,
			String gateway,String tipo,String batismo,String serialNumber,String servico
			) {
		super();
		this.hostname = hostname;
		this.descricao = descricao;
		this.ip1 = ip1;
		this.ip2 = ip2;
		this.mascara = mascara;
		this.gateway = gateway;
		this.tipo = tipo;
		this.batismo = batismo;
		this.serialNumber = serialNumber;
		this.servico = servico;
	}

	@Override
	public String toString() {
		return "Equipamento [id=" + id + 
				", hostname=" + hostname + 
				", descricao=" + descricao +
				", ip1=" + ip1 + 
				", ip2=" + ip2 + 
				", mascara=" + mascara + 
				", gateway=" + gateway + 
				", tipo=" + tipo + 
				", batismo=" + batismo + 
				", serialNumber=" + serialNumber + 
				", servico=" + servico + 
				"]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getIp1() {
		return ip1;
	}
	public void setIp1(String ip1) {
		this.ip1 = ip1;
	}
	public String getIp2() {
		return ip2;
	}
	public void setIp2(String ip2) {
		this.ip2 = ip2;
	}
	public String getMascara() {
		return mascara;
	}
	public void setMascara(String mascara) {
		this.mascara = mascara;
	}
	public String getGateway() {
		return gateway;
	}
	public void setGateway(String gateway) {
		this.gateway = gateway;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getBatismo() {
		return batismo;
	}
	public void setBatismo(String batismo) {
		this.batismo = batismo;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getServico() {
		return servico;
	}
	public void setServico(String servico) {
		this.servico = servico;
	}
	
	

	
}
