package jsvariedades.sales.model;

import jakarta.persistence.*;
import jsvariedades.sales.model.base.BaseModel;

@Entity
@Table(name = "tb_like")
public class LikeModel extends BaseModel {

    @ManyToOne
    private UserModel user;

    @ManyToOne
    private ProductModel productModel;

    public LikeModel() {
    }

    public LikeModel(UserModel user, ProductModel productModel) {
        this.user = user;
        this.productModel = productModel;
    }

    public UserModel getUser() {
        return user;
    }

    public LikeModel setUser(UserModel user) {
        this.user = user;
        return this;
    }

    public ProductModel getProductModel() {
        return productModel;
    }

    public LikeModel setProductModel(ProductModel productModel) {
        this.productModel = productModel;
        return this;
    }

    @Override
    public String toString() {
        return "LikeModel{" +
                "user=" + user +
                ", productModel=" + productModel +
                '}';
    }
}
