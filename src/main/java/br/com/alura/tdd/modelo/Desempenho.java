package br.com.alura.tdd.modelo;

import java.math.BigDecimal;

public enum Desempenho {
    A_DESEJAR {
        @Override
        public BigDecimal getPercentual() {
            return new BigDecimal("0.03");
        }
    }, BOM {
        @Override
        public BigDecimal getPercentual() {
            return new BigDecimal("0.15");
        }
    }, OTIMO {
        @Override
        public BigDecimal getPercentual() {
            return new BigDecimal("0.30");
        }
    }, RUIM {
        @Override
        public BigDecimal getPercentual() {
            // TODO Auto-generated method stub
            return BigDecimal.ZERO;
        }
    };


    public abstract BigDecimal getPercentual();
    
}
