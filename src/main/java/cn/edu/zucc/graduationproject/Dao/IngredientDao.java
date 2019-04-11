package cn.edu.zucc.graduationproject.Dao;

import cn.edu.zucc.graduationproject.JavaBean.Ingredient;
import cn.edu.zucc.graduationproject.JavaBean.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientDao  extends JpaRepository<Ingredient,String> {
    @Query(value = "SELECT * FROM ingredient ", nativeQuery = true)
    public List<Ingredient> getAllIngredient();
}
