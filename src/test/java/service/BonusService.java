package service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

public class BonusService {
    @Test
    public void deveriaBonusSerZeroParaSalarioAcimaDe10Mil() {
        br.com.alura.tdd.service.BonusService serviceb = new br.com.alura.tdd.service.BonusService();
        BigDecimal bonus = serviceb.calcularBonus(new Funcionario("nome", LocalDate.now(), new BigDecimal("12000")));

        assertEquals(new BigDecimal("0.00"), bonus);
    }

    @Test
    public void deveriaBonusSerDe10PorcentoParaSalarioAbaixoDe10Mil() {
        br.com.alura.tdd.service.BonusService serviceb = new br.com.alura.tdd.service.BonusService();
        BigDecimal bonus = serviceb.calcularBonus(new Funcionario("nome", LocalDate.now(), new BigDecimal("2500")));

        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    public void deveriaBonusSerDe10PorcentoParaSalarioIgualA10Mil() {
        br.com.alura.tdd.service.BonusService serviceb = new br.com.alura.tdd.service.BonusService();
        BigDecimal bonus = serviceb.calcularBonus(new Funcionario("nome", LocalDate.now(), new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}
