package com.example.mizmer2;

import java.util.ArrayList;

/**
 * Created by Sefa on 28.02.2018.
 */

public class OurData {

//    public static String[] title = new String[]{
//            "sefa",
//            "burhan",
//            "mustafa",
//            "fatih",
//            "mehmet"
//    };
//
//    public static int[] picturePath = new int[] {
//            R.drawable.user_portrait,
//            R.drawable.user_portrait,
//            R.drawable.user_portrait,
//            R.drawable.user_portrait,
//            R.drawable.user_portrait
//    };

    public static ArrayList titles = new ArrayList();
   // public static ArrayList pictures = new ArrayList();

    public void addTitle(String name){
        titles.add(name);
    }
}
