package cn.edu.zucc.graduationproject.Dao;

import cn.edu.zucc.graduationproject.JavaBean.Ingredient;
import cn.edu.zucc.graduationproject.JavaBean.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IngredientDao  extends JpaRepository<Ingredient,String> {
    @Query(value = "SELECT * FROM ingredient ", nativeQuery = true)
    public List<Ingredient> getAllIngredient();

    @Modifying
    @Transactional
    @Query(value = "insert into ingredient value(?,?,?,?)", nativeQuery = true)
    public void createingredient(String ingredientid, String ingredientname,int ingredientnum, int ingredientmaxnum);

    @Modifying
    @Transactional
    @Query(value = "update ingredient u set u.ingredientname=?1,u.ingredientnum=?2,u.ingredientmaxnum=?3 where u.ingredientid=?4", nativeQuery = true)
    public void updateingredient(String ingredientname,int ingredientnum, int ingredientmaxnum,String ingredientid);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ingredient WHERE ingredient.ingredientid=?1", nativeQuery = true)
    public void deleteingredient(String ingredientid);

}
