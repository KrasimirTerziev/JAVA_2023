package com.company.oop.cosmetics;

import com.company.oop.cosmetics.core.CosmeticsEngineImpl;
import com.company.oop.cosmetics.models.ToothpasteImpl;
import com.company.oop.cosmetics.models.contracts.Product;
import com.company.oop.cosmetics.models.enums.GenderType;

import java.util.ArrayList;

public class Startup {

    public static void main(String[] args) {
        CosmeticsEngineImpl engine = new CosmeticsEngineImpl();
        engine.start();
//        ArrayList<String> ingredients = new ArrayList<>();
//        ingredients.add("ingredients");
//        ToothpasteImpl toothpasteOne = new ToothpasteImpl(
//                "Tooth",
//                "Colgate",
//                10,
//                GenderType.MEN,
//                ingredients
//        );
//
//        ToothpasteImpl toothpasteTwo = new ToothpasteImpl(
//                "Tooth",
//                "Colgate",
//                12,
//                GenderType.MEN,
//                ingredients
//        );
//
//        System.out.println(toothpasteOne == toothpasteTwo);
//        System.out.println(toothpasteOne.equals(toothpasteTwo));
    }

}
