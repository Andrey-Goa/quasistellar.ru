package ru.quasistellar.portfolios;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;


@Controller
public class PortfolioAdminController {
    private static final String DIR = "src/main/resources/static/img/portfolio/";
    @Autowired
    PortfolioService portfolioService;

    @RequestMapping(value="/admin/portfolio", method = RequestMethod.GET)
    public String adminPortfolio(Model model) {
        model.addAttribute("portfolios", portfolioService.all());
        return "admin/portfolio/portfolios";
    }

    @RequestMapping(value = "/admin/portfolio/new", method = RequestMethod.GET)
    public String portfolioNew(Model model) {
        model.addAttribute("portfolio", new Portfolio());
        return "admin/portfolio/new";
    }

    @RequestMapping(value = "/admin/portfolio/new", method = RequestMethod.POST)
    public String portfolioCreate(@Valid Portfolio portfolio, BindingResult result, @RequestParam("file") MultipartFile file) {

        if (result.hasErrors()) {
            return "admin/portfolio/new";


        } else {
            if (!file.isEmpty()) {
                String name = file.getOriginalFilename();
                PortfolioFile portfolioFile = new PortfolioFile();
                boolean load = portfolioFile.loadFile(portfolio,file);
                if (load){
                    portfolio.setImgPath(name);
                } else{
                    return "admin/portfolio/new";
                }
            } else {
                return "admin/portfolio/new";

            }
            portfolioService.create(portfolio);
            return "redirect:/admin/portfolio";



        }
    }


    @RequestMapping(value = "/admin/portfolio/del/{portfolioId}", method = RequestMethod.POST)
    public String portfolioDelete(@PathVariable("portfolioId") Integer portfolioId, Model model) {
        Portfolio portfolio = portfolioService.find(portfolioId);
        portfolioService.delete(portfolioId);
        return "redirect:/admin/portfolio";



    }

    @RequestMapping(value = "/admin/portfolio/edit/{portfolioId}", method = RequestMethod.GET)
    public String portfolioEdit(@PathVariable("portfolioId") Integer portfolioId, Model model) {
        model.addAttribute("portfolio", portfolioService.find(portfolioId));

        return "admin/portfolio/edit";
    }

    @RequestMapping(value = "/admin/portfolio/edit/{portfolioId}", method = RequestMethod.POST)
    public String portfolioUpdate(@PathVariable("portfolioId") Integer portfolioId, @Valid Portfolio portfolio, Model model, BindingResult result, @RequestParam("file") MultipartFile file ) {
        portfolio.setId(portfolioId);
        if (file != null) {
            String name = file.getOriginalFilename();
            PortfolioFile portfolioFile = new PortfolioFile();
            boolean load = portfolioFile.loadFile(portfolio,file);
                if(load) {
                    portfolio.setImgPath(name);
                }
            }


        if (result.hasErrors()) {
            model.addAttribute("portfolio", portfolio);
            return "admin/portfolio/edit";
        }else {

            portfolioService.update(portfolio);
            return "redirect:/admin/portfolio";
        }
    }


}
