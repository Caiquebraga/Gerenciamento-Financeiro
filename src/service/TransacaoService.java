package service;

import model.Transacao;
import model.TipoTransacao;
import repository.TransacaoRepository;

import java.time.LocalDate;
import java.util.List;

public class TransacaoService {
    private final TransacaoRepository transacaoRepository;


    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    public void adicionarTransacao(String descricao, double valor, LocalDate data, TipoTransacao tipo) throws IllegalAccessException {
        if (valor <=0){
            throw new IllegalAccessException("O valor da transação deve ser positivo.");
        }

        Transacao transacao = new Transacao(descricao, valor, data, tipo);
        transacaoRepository.adicionar(transacao);
    }

    public List<Transacao> listarTodas(){
        return transacaoRepository.listaAll();
    }

    public List<Transacao> filtrarPorTipo(String tipo) {
        return transacaoRepository.filterForType(tipo);
    }

    public double calcularSaldo() {
        double receitas = transacaoRepository.filterForType("RECEITA").stream()
                .mapToDouble(Transacao::getValor)
                .sum();
        double despesas = transacaoRepository.filterForType("DESPESA").stream()
                .mapToDouble(Transacao::getValor)
                .sum();
        return receitas - despesas;
    }


}
