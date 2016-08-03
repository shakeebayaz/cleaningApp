package com.thinker.crystal.myapplication.activity;

import com.thinker.crystal.myapplication.model.CleaningCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by techjini on 3/8/16.
 */
public class DummyData {
    public static List<String> getLevelOneData() {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add("state " + i);
        }
        list.add("Select Country");
        return list;
    }

    public static List<String> getLevelTwoData() {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add("City " + i);
        }
        list.add("Select City");
        return list;
    }

   public static List<CleaningCategory> getCleaningCategoryList(){
       List<CleaningCategory> list = new ArrayList<>();

       for (int i = 0; i < 10; i++) {
           CleaningCategory obj = new CleaningCategory();
           obj.setCategoryName("Category "+i);
           list.add(obj);
       }

       return list;
   }
}
