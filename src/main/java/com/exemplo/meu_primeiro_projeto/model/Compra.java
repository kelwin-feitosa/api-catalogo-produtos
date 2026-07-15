package com.exemplo.meu_primeiro_projeto.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;

@Entity
public class Compra {  //Representando as compras feitas com o fornecedor

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Fornecedor fornecedor;

    @OneToMany(mappedBy = "compra")
    private List<ItemCompra> itens;

    private LocalDateTime dataCompra;
    private BigDecimal valorTotal;

    protected Compra() {}

    public Compra(LocalDateTime dataCompra, BigDecimal valorTotal) {
        this.dataCompra = dataCompra;
        this.valorTotal = valorTotal;
    }

    @PrePersist
    public void prePersist() {
        dataCompra = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Fornecedor getFornecedor() { return fornecedor; }
    public void setFornecedor(Fornecedor fornecedor) { this.fornecedor = fornecedor; }

    public List<ItemCompra> getItemCompra() { return itens; }
    public void setItens(List<ItemCompra> itens) { this.itens = itens; }

    public LocalDateTime getDataCompra() { return dataCompra; }
    public void setDataCompra(LocalDateTime dataCompra) { this.dataCompra = dataCompra; }

    public BigDecimal getValorTotal() { return valorTotal; }
    public void setValorTotal(BigDecimal valorTotal) { this.valorTotal = valorTotal; }

}