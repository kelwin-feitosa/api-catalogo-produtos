package com.exemplo.meu_primeiro_projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemplo.meu_primeiro_projeto.model.ItemVenda;

public interface ItemVendaRepository extends JpaRepository<ItemVenda, Long> {

}