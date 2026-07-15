package com.exemplo.meu_primeiro_projeto.model;


import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

@Entity
public class Produto { //Os produtos
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Categoria categoria;

    private String nome;
    private BigDecimal preco;
    private String descricao;
    private Integer quantidadeEstoque;
    private LocalDateTime dataCadastro;

    protected Produto() {}

    public Produto(String nome, BigDecimal preco, String descricao, Integer quantidadeEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    @PrePersist
    public void prePersist() {
        dataCadastro = LocalDateTime.now();
    }
    
    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Integer getQuantidadeEstoque() { return quantidadeEstoque; }
    public void setQuantidadeEstoque(Integer quantidadeEstoque) { this.quantidadeEstoque = quantidadeEstoque; }

    public LocalDateTime getDataCadastro() { return this.dataCadastro; }
    public void setDataCadastro(LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }

}