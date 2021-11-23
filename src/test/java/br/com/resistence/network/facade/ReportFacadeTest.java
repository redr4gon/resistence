package br.com.resistence.network.facade;

import br.com.resistence.network.controller.response.ReportMessageResponse;
import br.com.resistence.network.entity.Rebel;
import br.com.resistence.network.mapper.RebelMapper;
import br.com.resistence.network.repository.RebelRepository;
import br.com.resistence.network.service.RebelService;
import br.com.resistence.network.util.FakerGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ReportFacadeTest {

    @Mock
    private RebelService rebelService;

    @InjectMocks
    private ReportFacade facade;

    private FakerGenerator fakerGenerator;

    @BeforeAll
    public void ReportFacadeTest() {
        fakerGenerator = new FakerGenerator();
        rebelService = new RebelService(mock(RebelRepository.class), mock(RebelMapper.class));
        facade = new ReportFacade(rebelService);
        MockitoAnnotations.openMocks(facade);
    }

    @Test
    public void shouldFindTotalRebel() {

        List<Rebel> rebelsBlackForce = fakerGenerator.generateRandomBlackForce(1);
        List<Rebel> rebels = fakerGenerator.generateRandomBlackForce(4);

        when(rebelService.findAllBlackForce()).thenReturn(rebelsBlackForce);
        when(rebelService.findAll()).thenReturn(rebels);

        ReportMessageResponse response = facade.totalRebel();

        assertNotNull(response, "Objeto de teste vazio!");
        assertEquals("75.00%", response.getValue());
    }

    @Test
    public void shouldFindTotalBlackForce() {

        List<Rebel> rebelsBlackForce = fakerGenerator.generateRandomBlackForce(1);
        List<Rebel> rebels = fakerGenerator.generateRandomBlackForce(4);

        when(rebelService.findAllBlackForce()).thenReturn(rebelsBlackForce);
        when(rebelService.findAll()).thenReturn(rebels);

        ReportMessageResponse response = facade.totalRebelBlackForce();

        assertNotNull(response, "Objeto de teste vazio!");
        assertEquals("25.00%", response.getValue());
    }

}
