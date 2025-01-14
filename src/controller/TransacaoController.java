package controller;

import service.TransacaoService;
import model.TipoTransacao;
import model.Transacao;
import java.util.List;



import java.time.LocalDate;

public class TransacaoController {
    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }


    public void adicionarTransacao(String descricao, double valor, LocalDate data, String tipoStr) throws IllegalAccessException {
        // Converte o tipo recebido como String para o enum TipoTransacao
        TipoTransacao tipo;
        try {
            tipo = TipoTransacao.valueOf(tipoStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalAccessException("Tipo de transação inválido. Use 'RECEITA' ou 'DESPESA'.");
        }

        transacaoService.adicionarTransacao(descricao, valor, data, tipo);
    }

    public List<Transacao> listarTransacoes() {
        return transacaoService.listarTodas();

    }

    public List<Transacao> filtrarTransacoesPorTipo(String tipoStr) {
        return transacaoService.filtrarPorTipo(tipoStr);
    }

    public double calcularSaldo() {
        return transacaoService.calcularSaldo();
    }

}