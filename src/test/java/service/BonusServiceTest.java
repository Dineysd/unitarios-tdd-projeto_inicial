package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;

public class BonusServiceTest {
    private BonusService service;

    @BeforeEach
    private void inicializar(){
        service = new BonusService();
    }

    @Test
    public void deveLancaExceptionParaSalarioAcimaDeDezMilSemBonus() {
        
       // assertThrows( IllegalArgumentException.class, 
       // () -> service.calcularBonus(new Funcionario("nome", LocalDate.now(), new BigDecimal("12000"))));

       try {
        service.calcularBonus(new Funcionario("nome", LocalDate.now(), new BigDecimal("12000")));
        fail("Caso não der exception, falhe");
       } catch (Exception e) {
        assertEquals("Funcionario com salario acima de 10000 não possui bonus", e.getMessage());
       }

    }

    @Test
    public void deveriaBonusSerDe10PorcentoParaSalarioAbaixoDe10Mil() {
        
        BigDecimal bonus = service.calcularBonus(new Funcionario("nome", LocalDate.now(), new BigDecimal("2500")));

        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    public void deveriaBonusSerDe10PorcentoParaSalarioIgualA10Mil() {
        
        BigDecimal bonus = service.calcularBonus(new Funcionario("nome", LocalDate.now(), new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}
