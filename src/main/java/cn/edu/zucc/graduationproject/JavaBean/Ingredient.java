package cn.edu.zucc.graduationproject.JavaBean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ingredient")
public class Ingredient {
    @Id
    private String ingredientid;
    @Column(name = "ingredientname")
    private String ingredientname;
    @Column(name = "ingredientnum")
    private int ingredientnum;
    @Column(name = "ingredientmaxnum")
    private int ingredientmaxnum;

    public int getIngredientmaxnum() {
        return ingredientmaxnum;
    }

    public void setIngredientmaxnum(int ingredientmaxnum) {
        this.ingredientmaxnum = ingredientmaxnum;
    }

    public String getIngredientid() {
        return ingredientid;
    }

    public void setIngredientid(String ingredientid) {
        this.ingredientid = ingredientid;
    }

    public String getIngredientname() {
        return ingredientname;
    }

    public void setIngredientname(String ingredientname) {
        this.ingredientname = ingredientname;
    }

    public int getIngredientnum() {
        return ingredientnum;
    }

    public void setIngredientnum(int ingredientnum) {
        this.ingredientnum = ingredientnum;
    }
}
