package jsvariedades.sales.repository;

import jsvariedades.sales.model.SaleItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleItemRepository extends JpaRepository<SaleItemModel, Long> {
}
