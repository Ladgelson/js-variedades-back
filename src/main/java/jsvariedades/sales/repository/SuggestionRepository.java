package jsvariedades.sales.repository;

import jsvariedades.sales.model.SuggestionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuggestionRepository extends JpaRepository<SuggestionModel, Long> {
}
