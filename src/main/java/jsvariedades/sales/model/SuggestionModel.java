package jsvariedades.sales.model;

import jakarta.persistence.*;
import jsvariedades.sales.model.base.BaseModel;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_suggestion")
public class SuggestionModel extends BaseModel {

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    @OneToMany(mappedBy = "suggestion")
    private List<SuggestionItemModel> suggestionItemModel = new ArrayList<>();

    public SuggestionModel() {
    }

    public SuggestionModel(String status, List<SuggestionItemModel> suggestionItemModel) {
        this.status = status;
        this.suggestionItemModel = suggestionItemModel;
    }

    public String getStatus() {
        return status;
    }

    public SuggestionModel setStatus(String status) {
        this.status = status;
        return this;
    }

    public List<SuggestionItemModel> getSuggestionItemModel() {
        return suggestionItemModel;
    }

    public SuggestionModel setSuggestionItemModel(List<SuggestionItemModel> suggestionItemModel) {
        this.suggestionItemModel = suggestionItemModel;
        return this;
    }

    @Override
    public String toString() {
        return "SuggestionModel{" +
                "status='" + status + '\'' +
                ", suggestionItemModel=" + suggestionItemModel +
                '}';
    }
}
