package br.api.produtos.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.api.produtos.modelo.ProdutoModelo;
import br.api.produtos.serviço.ProdutoServico;

@RestController
public class ProdutoControle {

    @Autowired
    private ProdutoServico ps;
    @GetMapping("/listar")
    public Iterable<ProdutoModelo> listar(){
        return ps.listar();
    }
    @GetMapping("/")
    public String nota(){
        return "Api de produtos funcionando";
    }
    
}
