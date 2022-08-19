package service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.ReajusteService;

public class ReajusteServiceTest {
     
    @Test
    public void deveReajusteSerDeTresPorcentoCasoDesempenhoForADesejar(){
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Carlos", LocalDate.now(), new BigDecimal("1000"));

        BigDecimal valor =  service.reajusteSalarioPor(funcionario, Desempenho.A_DESEJAR);

        assertEquals(new BigDecimal("1030.00"), valor);
    }

    @Test
    public void deveReajusteSerDeQuinzePorcentoCasoDesempenhoForBom(){
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Carlos", LocalDate.now(), new BigDecimal("1000"));

        BigDecimal valor =  service.reajusteSalarioPor(funcionario, Desempenho.BOM);

        assertEquals(new BigDecimal("1150.00"), valor);
    }

    @Test
    public void deveReajusteSerDeTrintaPorcentoCasoDesempenhoForOtimo(){
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Carlos", LocalDate.now(), new BigDecimal("1000"));

        BigDecimal valor =  service.reajusteSalarioPor(funcionario, Desempenho.OTIMO);

        assertEquals(new BigDecimal("1300.00"), valor);
    }
}
