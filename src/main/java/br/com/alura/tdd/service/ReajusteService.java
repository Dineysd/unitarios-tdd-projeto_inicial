package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteService {

    public BigDecimal reajusteSalarioPor(Funcionario funcionario, Desempenho desempenho) {
        if(desempenho == Desempenho.A_DESEJAR){
            BigDecimal reajuste = funcionario.getSalario().multiply(new BigDecimal("0.03"));
            funcionario.addReajusteNoSalario(reajuste);
        } else if(desempenho == Desempenho.BOM){
            BigDecimal reajuste = funcionario.getSalario().multiply(new BigDecimal("0.15"));
            funcionario.addReajusteNoSalario(reajuste);
        } else if(desempenho == Desempenho.OTIMO){
            BigDecimal reajuste = funcionario.getSalario().multiply(new BigDecimal("0.30"));
            funcionario.addReajusteNoSalario(reajuste);
        }

        return funcionario.getSalario().setScale(2, RoundingMode.HALF_UP);
    }
    
}
