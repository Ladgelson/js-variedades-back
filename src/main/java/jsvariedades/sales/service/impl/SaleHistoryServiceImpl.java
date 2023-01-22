package jsvariedades.sales.service.impl;

import jsvariedades.sales.enums.SaleAction;
import jsvariedades.sales.model.SaleHistoryModel;
import jsvariedades.sales.model.SaleModel;
import jsvariedades.sales.repository.SaleHistoryRepository;
import jsvariedades.sales.service.SaleHistoryService;
import org.springframework.stereotype.Service;

@Service
public class SaleHistoryServiceImpl implements SaleHistoryService {

    private final SaleHistoryRepository saleHistoryRepository;

    public SaleHistoryServiceImpl(SaleHistoryRepository saleHistoryRepository) {
        this.saleHistoryRepository = saleHistoryRepository;
    }

    @Override
    public void save(SaleModel sale, SaleAction action) {
        var commit = new SaleHistoryModel()
                .setSale(sale)
                .setStatus(sale.getStatus())
                .setAction(action);
        saleHistoryRepository.save(commit);
    }
}
