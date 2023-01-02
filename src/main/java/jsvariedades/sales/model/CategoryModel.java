package jsvariedades.sales.model;

import jakarta.persistence.*;
import jsvariedades.sales.model.base.BaseModel;

@Entity
@Table(name = "tb_category")
public class CategoryModel extends BaseModel {

    @Column(nullable = false)
    private String name;

    public CategoryModel(){}

    public CategoryModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public CategoryModel setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "CategoryModel{" +
                "name=" + name +
                '}';
    }
}
