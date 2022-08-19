package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;

public class BonusServiceTest {
    @Test
    public void deveLancaExceptionParaSalarioAcimaDeDezMilSemBonus() {
        BonusService service = new BonusService();

        assertThrows( IllegalArgumentException.class, 
        () -> service.calcularBonus(new Funcionario("nome", LocalDate.now(), new BigDecimal("12000"))));

    }

    @Test
    public void deveriaBonusSerDe10PorcentoParaSalarioAbaixoDe10Mil() {
        BonusService serviceb = new BonusService();
        BigDecimal bonus = serviceb.calcularBonus(new Funcionario("nome", LocalDate.now(), new BigDecimal("2500")));

        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    public void deveriaBonusSerDe10PorcentoParaSalarioIgualA10Mil() {
        BonusService serviceb = new BonusService();
        BigDecimal bonus = serviceb.calcularBonus(new Funcionario("nome", LocalDate.now(), new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}
