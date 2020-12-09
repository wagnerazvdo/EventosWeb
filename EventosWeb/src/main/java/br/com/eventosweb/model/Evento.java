/**
 * 
 */
package br.com.eventosweb.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author wagne
 *
 */
@Entity
@Table(name="tb_eventos")
public class Evento implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String local;
	private String data;
	private String horario;

	
	@JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "evento")
	private List<Convidado> convidados;

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;

	}
	public List<Convidado> getProdutos() {
		return convidados;
	}
	public void setProdutos(List<Convidado> convidados) {
		this.convidados = convidados;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public List<Evento> getcConvidados() {
		// TODO Auto-generated method stub
		return null;
	}
	
}