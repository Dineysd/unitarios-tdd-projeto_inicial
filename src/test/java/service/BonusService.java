package service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

public class BonusService {
    @Test
    public void deveriaBonusSerZeroParaSalarioMuitoAlto() {
        br.com.alura.tdd.service.BonusService serviceb = new br.com.alura.tdd.service.BonusService();
        BigDecimal bonus = serviceb.calcularBonus(new Funcionario("nome", LocalDate.now(), new BigDecimal("120000")));

        assertEquals(BigDecimal.ZERO, bonus);
    }
}
