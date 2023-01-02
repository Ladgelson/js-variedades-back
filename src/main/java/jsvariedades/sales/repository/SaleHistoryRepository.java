package jsvariedades.sales.repository;

import jsvariedades.sales.model.SaleHistoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleHistoryRepository extends JpaRepository<SaleHistoryModel, Long> {
}
