package ru.quasistellar.portfolios;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.quasistellar.Application;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class PortfolioServiceTest {


    @Mock
    PortfolioRepository portfolioRepository;

    @InjectMocks
    PortfolioService portfolioService;

    private List<Portfolio> portfolioList;
    private Portfolio portfolioOne;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        portfolioList = new ArrayList<>();
        portfolioOne = mock(Portfolio.class);
    }

    @Test
    public void testAll() throws Exception {
        when(portfolioRepository.findAll()).thenReturn(portfolioList);
        Iterable<Portfolio> portfolios = portfolioService.all();
        verify(portfolioRepository, times(1)).findAll();
        assertThat(portfolios, is(equalTo(portfolioList)));

    }

    @Test
    public void testCreate() throws Exception {
        Portfolio portfolio = new Portfolio();
        portfolioService.create(portfolio);
        verify(portfolioRepository,times(1)).save(portfolio);
    }

    @Test
    public void testFind() throws Exception {
        when(portfolioService.find(1)).thenReturn(portfolioOne);
        portfolioService.find(1);
        verify(portfolioRepository, times(1)).findOne(1);

    }

    @Test
    public void testUpdate() throws Exception {
        Portfolio portfolio = new Portfolio();
        portfolioService.update(portfolio);
        verify(portfolioRepository,times(1)).save(portfolio);
    }

    @Test
    public void testDelete() throws Exception {
        portfolioRepository.delete(1);
        verify(portfolioRepository, times(1)).delete(1);

    }
}