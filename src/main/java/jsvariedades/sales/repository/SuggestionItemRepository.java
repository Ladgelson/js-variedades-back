package jsvariedades.sales.repository;

import jsvariedades.sales.model.SuggestionItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuggestionItemRepository extends JpaRepository<SuggestionItemModel, Long> {
}
