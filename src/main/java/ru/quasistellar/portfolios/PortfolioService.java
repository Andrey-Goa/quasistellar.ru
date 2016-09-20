package ru.quasistellar.portfolios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PortfolioService {

    @Autowired
    PortfolioRepository portfolioRepository;

    public Iterable<Portfolio> all() {
        return portfolioRepository.findAll();
    }

    public Portfolio create(Portfolio portfolio) {
        return portfolioRepository.save(portfolio);
    }

    public Portfolio find(int portfolioId) {
        return portfolioRepository.findOne(portfolioId);
    }

    public Portfolio update(Portfolio updatedPortfolio) {
        return portfolioRepository.save(updatedPortfolio);
    }

    public void delete(int portfolioId) {
        portfolioRepository.delete(portfolioId);
    }
}
