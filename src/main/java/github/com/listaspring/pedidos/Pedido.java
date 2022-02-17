package github.com.listaspring.pedidos;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String descricao;
	
	@Column
	private boolean finalizado;
	
	@Column
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime momentCriado;
	
	public void setMomentCriado(LocalDateTime dateTime) {
		this.momentCriado = dateTime;
	}
	
	@Column
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime momentFinalizado;
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public boolean isFinalizado() {
		return finalizado;
	}



	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}



	public LocalDateTime getMomentFinalizado() {
		return momentFinalizado;
	}



	public void setMomentFinalizado(LocalDateTime momentFinalizado) {
		this.momentFinalizado = momentFinalizado;
	}



	public LocalDateTime getMomentCriado() {
		return momentCriado;
	}



	@PrePersist
	public void beforeSave() {
		setMomentCriado(LocalDateTime.now());
	}
	
	
	
	
	
	
}
