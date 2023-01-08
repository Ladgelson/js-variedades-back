package jsvariedades.sales.dto.response;

import jsvariedades.sales.dto.common.SuggestionItemDTO;
import jsvariedades.sales.enums.SuggestionStatus;

import java.util.List;

public class SuggestionResponse {
    private SuggestionStatus status;
    private List<SuggestionItemDTO> items;

    public SuggestionStatus getStatus() {
        return status;
    }

    public SuggestionResponse setStatus(SuggestionStatus status) {
        this.status = status;
        return this;
    }

    public List<SuggestionItemDTO> getItems() {
        return items;
    }

    public SuggestionResponse setItems(List<SuggestionItemDTO> items) {
        this.items = items;
        return this;
    }

    @Override
    public String toString() {
        return "SuggestionResponse{" +
                "status=" + status +
                ", items=" + items +
                '}';
    }
}
