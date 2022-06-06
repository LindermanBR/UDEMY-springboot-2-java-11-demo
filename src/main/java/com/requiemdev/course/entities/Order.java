package com.requiemdev.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity		// Informa que essa será uma entidade do banco relacional
@Table(name = "tb_order")		// Cria a tabela utilizando o nome citado "tb_order"
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id		// informa que a variável abaixo será a chave primária no banco de dados
	@GeneratedValue(strategy = GenerationType.IDENTITY)		//Atribui a responsabilidade ao provedor
	private Long id;
	private Instant moment;
	
	@ManyToOne		// instrui a JPA que essa será uma associação de muitos para um
	@JoinColumn(name = "client_id")		//o nome da chave estrangeira no banco de dados
	private User client;
	
	public Order() {
		
	}

	public Order(Long id, Instant moment, User client) {
		super();
		this.id = id;
		this.moment = moment;
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", moment=" + moment + ", client=" + client + "]";
	}
	
	
	
}
