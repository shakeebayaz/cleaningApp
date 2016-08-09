package com.thinker.crystal.myapplication.activity;

import com.thinker.crystal.myapplication.model.CleaningCategory;
import com.thinker.crystal.myapplication.model.CleaningSelection;

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

    public static List<CleaningCategory> getCleaningCategoryList() {
        List<CleaningCategory> list = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            CleaningCategory obj = new CleaningCategory();
            obj.setCategoryName("Cleaning Category " + i);
            list.add(obj);
        }

        return list;
    }

    public static List<CleaningSelection> getCleaningSectionList() {
        List<CleaningSelection> list = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            CleaningSelection obj = new CleaningSelection();
            obj.setCleaningSectionName("Cleaning \n section " + i);
            obj.setRate(100 * i);
            list.add(obj);
        }

        return list;
    }
}
