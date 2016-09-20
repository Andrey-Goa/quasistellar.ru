package ru.quasistellar.portfolios;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.security.web.util.RedirectUrlBuilder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import ru.quasistellar.Application;

import javax.mail.Multipart;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class PortfolioAdminControllerTest {

    @Mock
    PortfolioService portfolioService;

    @InjectMocks
    PortfolioAdminController portfolioAdminController;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = standaloneSetup(portfolioAdminController).build();
    }

    @Test
    public void testAdminPortfolio() throws Exception {
        List<Portfolio> portfolioList = new ArrayList<>();
        when(portfolioService.all()).thenReturn(portfolioList);
        mockMvc.perform(get("/admin/portfolio"))
                .andExpect(status().isOk())
                .andExpect(view().name("admin/portfolio/portfolios"))
                .andExpect(model().attribute("portfolios", portfolioList));

    }

    @Test
    public void testPortfolioNew() throws Exception {
        mockMvc.perform(get("/admin/portfolio/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("admin/portfolio/new"))
                .andExpect(model().attribute(("portfolio"), is(not(nullValue()))));


    }

    @Test
    public void portfolioCreateTest() throws Exception{
        Portfolio port = new Portfolio();
        MultipartFile file = mock(MultipartFile.class);
        PortfolioFile portfolioFile = mock(PortfolioFile.class);
        when(portfolioFile.loadFile(port,file)).thenReturn(true);
        when(portfolioService.create(any(Portfolio.class))).thenReturn(port);


    }


    @Test
    public void portfolioDeleteTest() throws  Exception{
        Portfolio portfolio = mock(Portfolio.class);
        Model model;
        PortfolioAdminController portfolioAdminController = new PortfolioAdminController();
        when(portfolioService.find(1)).thenReturn(portfolio);


    }

    @Test
    public void testPortfolioEdit() throws Exception {
       Portfolio portfolio = mock(Portfolio.class);

        when(portfolioService.find(1)).thenReturn(portfolio);

        mockMvc.perform(get("/admin/portfolio/edit/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("admin/portfolio/edit"))
                .andExpect(model().attribute("portfolio", portfolio));
    }



}