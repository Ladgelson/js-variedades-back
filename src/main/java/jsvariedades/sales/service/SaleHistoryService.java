package jsvariedades.sales.service;

import jsvariedades.sales.enums.SaleAction;
import jsvariedades.sales.model.SaleModel;

public interface SaleHistoryService {
    void save(SaleModel sale, SaleAction action);
}
