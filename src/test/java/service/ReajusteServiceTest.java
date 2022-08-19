package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.ReajusteService;

public class ReajusteServiceTest {

    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach
    private void inicializar(){
        service = new ReajusteService();
        funcionario = new Funcionario("Carlos", LocalDate.now(), new BigDecimal("1000"));
    }

    @Test
    public void deveLancarUmaExceptionCasoDesempenhoForRuim(){
        try {
            service.reajusteSalarioPor(funcionario, Desempenho.RUIM);
            fail("caso não de exception, falhe!");
        } catch (Exception e) {
            assertEquals("Desempenho ruim, sem reajuste!", e.getMessage());
        }
        
    }
     
    @Test
    public void deveReajusteSerDeTresPorcentoCasoDesempenhoForADesejar() {
        BigDecimal valor =  service.reajusteSalarioPor(funcionario, Desempenho.A_DESEJAR);

        assertEquals(new BigDecimal("1030.00"), valor);
    }

    @Test
    public void deveReajusteSerDeQuinzePorcentoCasoDesempenhoForBom() {
        BigDecimal valor =  service.reajusteSalarioPor(funcionario, Desempenho.BOM);

        assertEquals(new BigDecimal("1150.00"), valor);
    }

    @Test
    public void deveReajusteSerDeTrintaPorcentoCasoDesempenhoForOtimo(){
        BigDecimal valor =  service.reajusteSalarioPor(funcionario, Desempenho.OTIMO);

        assertEquals(new BigDecimal("1300.00"), valor);
    }
}
