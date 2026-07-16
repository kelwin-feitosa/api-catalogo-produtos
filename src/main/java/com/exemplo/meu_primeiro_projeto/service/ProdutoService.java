package com.exemplo.meu_primeiro_projeto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.exemplo.meu_primeiro_projeto.dto.ProdutoRequest;
import com.exemplo.meu_primeiro_projeto.dto.ProdutoResponse;
import com.exemplo.meu_primeiro_projeto.exception.CategoriaNaoEncontradaException;
import com.exemplo.meu_primeiro_projeto.exception.ProdutoJaExisteException;
import com.exemplo.meu_primeiro_projeto.exception.ProdutoNaoEncontradoException;
import com.exemplo.meu_primeiro_projeto.model.Categoria;
import com.exemplo.meu_primeiro_projeto.model.Produto;
import com.exemplo.meu_primeiro_projeto.repository.CategoriaRepository;
import com.exemplo.meu_primeiro_projeto.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    private final ProdutoRepository repository;
    private final CategoriaRepository categoriaRepository;
    
    public ProdutoService(ProdutoRepository repository, CategoriaRepository categoriaRepository) {
        this.repository = repository;
        this.categoriaRepository = categoriaRepository;
    }


    public List<ProdutoResponse> listarProdutos() {
        return repository.findAll()
                .stream()
                .map(this::converterParaResponse)
                .toList();
    }

    public ProdutoResponse criarProduto(ProdutoRequest request) {
        verificarDuplicidade(request);
        Categoria categoria = buscarCategoria(request.categoriaId());

        Produto produto = converterParaProduto(request, categoria);
        Produto salvo = repository.save(produto);

        return converterParaResponse(salvo);
    }

    public ProdutoResponse atualizarProduto(Long id, ProdutoRequest atualizandoProduto) {
        Produto produto = buscarEntidade(id);
        verificarDuplicidade(produto, atualizandoProduto);
        
        produto.setNome(atualizandoProduto.nome());
        produto.setPreco(atualizandoProduto.preco());
        produto.setDescricao(atualizandoProduto.descricao());
        produto.setQuantidadeEstoque(atualizandoProduto.quantidadeEstoque());
        Categoria categoria = buscarCategoria(atualizandoProduto.categoriaId());
        produto.setCategoria(categoria);

        Produto produtoAtualizado = repository.save(produto);
        return converterParaResponse(produtoAtualizado);
    }

    public ProdutoResponse buscarPorId(Long id) { //Para o usuário
        return converterParaResponse(buscarEntidade(id));
    }

    public void deletarProduto(Long id) {
        Produto produto = buscarEntidade(id);
        repository.delete(produto);                   
    }

    private Produto converterParaProduto(ProdutoRequest request, Categoria categoria) {
        return new Produto(
            request.nome(),
            request.preco(),
            request.descricao(),
            request.quantidadeEstoque(),
            categoria
        );
    }

    private ProdutoResponse converterParaResponse(Produto produto){
        Long categoriaId = produto.getCategoria() != null
            ? produto.getCategoria().getId()
            : null;

        return new ProdutoResponse (
            produto.getId(),
            produto.getNome(),
            produto.getPreco(),
            produto.getDescricao(),
            produto.getQuantidadeEstoque(),
            categoriaId,
            produto.getDataCadastro()
        );
    }

    private Produto buscarEntidade(Long id) { //Para uso interno
        return repository.findById(id)
            .orElseThrow(() -> new ProdutoNaoEncontradoException("Produto não encontrado."));
    }

    private Categoria buscarCategoria(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> 
                    new CategoriaNaoEncontradaException("Categoria não encontrada.")
                );
    }
    
    private void verificarDuplicidade(ProdutoRequest request) {
        if(repository.existsByNome(request.nome())) {
            throw new ProdutoJaExisteException("Já existe um produto com esse nome.");
        }
    }

    private void verificarDuplicidade(Produto produto, ProdutoRequest request) {
    if(!produto.getNome().equals(request.nome())) {
        verificarDuplicidade(request);
    }
}
}
