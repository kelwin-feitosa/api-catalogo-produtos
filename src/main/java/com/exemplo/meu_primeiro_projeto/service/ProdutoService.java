package com.exemplo.meu_primeiro_projeto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.exemplo.meu_primeiro_projeto.dto.ProdutoRequisicao;
import com.exemplo.meu_primeiro_projeto.dto.ProdutoResposta;
import com.exemplo.meu_primeiro_projeto.exception.ProdutoNaoEncontradoException;
import com.exemplo.meu_primeiro_projeto.model.Produto;
import com.exemplo.meu_primeiro_projeto.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    private final ProdutoRepository repository;
    
    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }


    public List<ProdutoResposta> listarProdutos() {
        return repository.findAll()
                .stream()
                .map(this::converterParaResponse)
                .toList();
    }

    public ProdutoResposta criarProduto(ProdutoRequisicao request) {
        Produto produto = converterParaProduto(request);

        Produto salvo = repository.save(produto);

        return new ProdutoResposta (
            salvo.getId(),
            salvo.getNome(),
            salvo.getPreco(),
            salvo.getDescricao(),
            salvo.getQuantidadeEstoque()
        );
    }

    public ProdutoResposta atualizarProduto(Long id, ProdutoRequisicao atualizandoProduto) {
        Produto produto = repository.findById(id)
                        .orElseThrow(() -> new ProdutoNaoEncontradoException("Produto não encontrado."));
        
        produto.setNome(atualizandoProduto.nome());
        produto.setPreco(atualizandoProduto.preco());
        produto.setDescricao(atualizandoProduto.descricao());
        produto.setQuantidadeEstoque(atualizandoProduto.quantidadeEstoque());

        Produto produtoAtualizado = repository.save(produto);

        return converterParaResponse(produtoAtualizado);
    }

    public ProdutoResposta buscarPorId(Long id) {
        Produto produto = repository.findById(id)
                            .orElseThrow(() -> new ProdutoNaoEncontradoException("Produto não encontrado."));

        return converterParaResponse(produto);
    }

    public void deletarProduto(Long id) {
        Produto produto = repository.findById(id)
                            .orElseThrow(() -> new ProdutoNaoEncontradoException("Produto não encontrado."));

        repository.delete(produto);                   
    }

    private Produto converterParaProduto(ProdutoRequisicao request) {
        return new Produto (
            request.nome(),
            request.preco(),
            request.descricao(),
            request.quantidadeEstoque()
        );
    }

    private ProdutoResposta converterParaResponse(Produto produto){
        return new ProdutoResposta (
            produto.getId(),
            produto.getNome(),
            produto.getPreco(),
            produto.getDescricao(),
            produto.getQuantidadeEstoque()
        );
    }
}
