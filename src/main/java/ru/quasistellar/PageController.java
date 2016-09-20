package ru.quasistellar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.quasistellar.portfolios.PortfolioService;
import javax.servlet.http.HttpServletRequest;


@Controller
public class PageController {


    @Autowired
    PortfolioService portfolioService;
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String pageApp(Model model) {
        model.addAttribute("portfolios", portfolioService.all());
        return "index";
    }

    @RequestMapping(value="/sent", method = RequestMethod.GET)
    public String sentApp() {
        return "sent";
    }


    @RequestMapping(value="/error", method = RequestMethod.GET)
    public String sentError(final HttpServletRequest request) {

        return "error";
    }

}
