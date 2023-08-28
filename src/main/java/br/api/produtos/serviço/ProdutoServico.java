package br.api.produtos.serviço;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.api.produtos.modelo.ProdutoModelo;
import br.api.produtos.modelo.RespostaModelo;
import br.api.produtos.repositorio.ProdutoRepositorio;

@Service
public class ProdutoServico {
    @Autowired ProdutoRepositorio pr;

    //Método para listar todos os produtos
    public Iterable<ProdutoModelo>listar(){
        return pr.findAll();
    }
    @Autowired
    private RespostaModelo rm;
    //método para cadastrar ou alterar produtos
    public ResponseEntity<?>cadastrarAlterar(ProdutoModelo pm, String acao){
        if(pm.getNome().equals("")){
            rm.setMensagem("O nome do produto é obrigatório");
            return new ResponseEntity<RespostaModelo>(rm,HttpStatus.BAD_REQUEST);
        }else if(pm.getMarca().equals("")){
            rm.setMensagem( " O nome da marca é obrigatório");
            return new ResponseEntity<RespostaModelo>(rm,HttpStatus.BAD_REQUEST);
        }else{
            if(acao.equals("cadastrar")){
                return new ResponseEntity<ProdutoModelo>(pr.save(pm),HttpStatus.CREATED);
            }
            else{
                return new ResponseEntity<ProdutoModelo>(pr.save(pm),HttpStatus.OK);
            }
        }
    }
}
