package repository;

import model.TipoTransacao;
import model.Transacao;

import java.util.ArrayList;
import java.util.List;

public class TransacaoRepository {

    private List <Transacao> transacoes = new ArrayList<>();

    public  void adicionar (Transacao transacao){
        transacoes.add(transacao);
    }

    public List<Transacao> listaAll(){
        return transacoes;
    }

    public List<Transacao> filterForType(String tipo){
        return transacoes.stream()
                .filter(t -> t.getTipo().name().equalsIgnoreCase(tipo))
                .toList();
    }
}
