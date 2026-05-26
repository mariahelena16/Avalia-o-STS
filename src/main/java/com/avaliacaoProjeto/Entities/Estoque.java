package com.avaliacaoProjeto.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class Estoque {



	@Getter
	@Setter
	@Data
	@NoArgsConstructor
	@Entity
	@Table(name = "estoque")
	public class Aluno {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@NotNull
		@NotBlank
		private String localizacao;

		@NotNull
		@NotBlank
		private int quantidade;

		
		@ManyToOne
		@JoinColumn(name = "produto_id")
		private Produtos produto;


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getLocalizacao() {
			return localizacao;
		}


		public void setLocalizacao(String localizacao) {
			this.localizacao = localizacao;
		}


		public int getQuantidade() {
			return quantidade;
		}


		public void setQuantidade(int quantidade) {
			this.quantidade = quantidade;
		}


		public Produtos getProdutos() {
			return produto;
		}


		public void setProdutos (Produtos produto) {
			this.produto = produto;
		}

	}}
			