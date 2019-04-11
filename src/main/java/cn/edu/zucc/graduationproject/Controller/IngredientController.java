package cn.edu.zucc.graduationproject.Controller;

import cn.edu.zucc.graduationproject.Service.IngredientService;
import cn.edu.zucc.graduationproject.util.GsonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IngredientController {
    @Autowired
    IngredientService ingredientService;
    @RequestMapping(value = "/Ingredient")
    public String getallIngredient(ModelMap map){
        map.put("list", GsonHelper.toJson(ingredientService.getalligd()));
        return "ingredientmanager";
    }
}
