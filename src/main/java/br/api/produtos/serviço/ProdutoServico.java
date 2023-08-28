package br.api.produtos.serviço;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.api.produtos.modelo.ProdutoModelo;
import br.api.produtos.repositorio.ProdutoRepositorio;

@Service
public class ProdutoServico {
    @Autowired ProdutoRepositorio pr;

    //Método para listar todos os produtos
    public Iterable<ProdutoModelo>listar(){
        return pr.findAll();
    }
}
