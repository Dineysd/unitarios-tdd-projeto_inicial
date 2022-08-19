package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteService {

    public BigDecimal reajusteSalarioPor(Funcionario funcionario, Desempenho desempenho) {
        /* Refatoração com padrão strategy
        // Antes 
        if(desempenho == Desempenho.A_DESEJAR){
            BigDecimal reajuste = funcionario.getSalario().multiply(new BigDecimal("0.03"));
            funcionario.addReajusteNoSalario(reajuste);
        } else if(desempenho == Desempenho.BOM){
            BigDecimal reajuste = funcionario.getSalario().multiply(new BigDecimal("0.15"));
            funcionario.addReajusteNoSalario(reajuste);
        } else if(desempenho == Desempenho.OTIMO){
            BigDecimal reajuste = funcionario.getSalario().multiply(new BigDecimal("0.30"));
            funcionario.addReajusteNoSalario(reajuste);
        } */

        //Depois
        if(desempenho.getPercentual().equals(BigDecimal.ZERO)){
            throw new IllegalArgumentException("Desempenho ruim, sem reajuste!");
        }
        getCalcularReajuste(funcionario, desempenho.getPercentual());

        return funcionario.getSalario().setScale(2, RoundingMode.HALF_UP);
    }

    private void getCalcularReajuste(Funcionario funcionario, BigDecimal percentual){
        BigDecimal reajuste = funcionario.getSalario().multiply(percentual);
            funcionario.addReajusteNoSalario(reajuste);
    }
    
}
