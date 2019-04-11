package cn.edu.zucc.graduationproject.Service;

import cn.edu.zucc.graduationproject.Dao.IngredientDao;
import cn.edu.zucc.graduationproject.JavaBean.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {
    @Autowired
    IngredientDao ingredientDao;
    public List<Ingredient> getalligd(){
        return ingredientDao.getAllIngredient();
    }
}
