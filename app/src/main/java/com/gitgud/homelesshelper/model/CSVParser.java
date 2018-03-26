package com.gitgud.homelesshelper.model;

/**
 * Created by csaet on 2/24/2018.
 */

import android.content.Context;
import android.util.Log;

import com.gitgud.homelesshelper.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;


public class CSVParser {

    private static ArrayList<Shelter> shelterList = new ArrayList<>();

    /**
     *
     * @param content the Activity needed to access the3
     */
    public CSVParser(Context content) {
        try {
            InputStream reader = content.getResources().openRawResource(R.raw.homeless_shelter_database);
            BufferedReader bReader = new BufferedReader(new InputStreamReader(reader));
            String line = bReader.readLine();
            String[] data;
            while ((line = bReader.readLine()) != null) {
                String[] finalData = new String[9];
                int increment = 0;
                data = line.split(",");
                int location = -1;
                Log.e("myApp", Integer.toString(data.length));

                while (increment < data.length) {
                    //Log.e("myApp", Integer.toString(increment));
                    if (data[increment].length() < 1) {
                        location += 2;
                        increment++;
                        finalData[location] = "";
                        Log.e("myApp", "THIS FREAKING RUNS");
                    } else if (data[increment].charAt(0) != 32) {
                        location++;
                        finalData[location] = "";
                    }
                    //Log.e("myApp", data[increment]);
                    Log.e("myApp", "current increment: " + Integer.toString(increment));
                    Log.e("myApp", "current location: " + Integer.toString(location));
                    Log.w("myApp", "what is loaded: " + data[increment]);
                    finalData[location] = finalData[location] + data[increment];
                    increment++;
                }

//                Log.w("myApp", data[increment]);
//                finalData[0] = data[increment++];
//                Log.e("myApp", "the real number:  " + finalData[0]);
//                Log.w("myApp", data[increment]);
//                finalData[1] = data[increment++];
//                Log.e("myApp", "the real name:  " + finalData[1]);
//
//                finalData[2] = "";
//                while ((data[increment].length() > 0 && data[increment].charAt(0) < 58
//                        && data[increment].charAt(0) > 47) || data[increment].charAt(0) == 32) {
//                    if (finalData[2].length() > 1) {
//                        finalData[2] += ", ";
//                    }
//                    Log.w("myApp", " Is this appearing? " + data[increment]);
//                    finalData[2] = finalData[2] + data[increment];
//                    increment++;
//                }
//                if (finalData[2].equals("")) {
//                    increment++;
//                }
//                Log.e("myApp", "the real: capacity " + finalData[2]);
//                Log.w("myApp", data[increment]);
//                finalData[3] = data[increment++];
//                Log.e("myApp", "the real:  restriction" + finalData[3]);
//                Log.w("myApp", data[increment]);
//                finalData[4] = data[increment++];
//                Log.e("myApp", "the real:  longitude" + finalData[4]);
//                Log.w("myApp", data[increment]);
//                finalData[5] = data[increment++];
//                Log.e("myApp", "the real:  latitude" + finalData[5]);
//
//
//                finalData[8] = data[data.length - 1];
//                int inc = data.length - 2;
//                finalData[7] = "";
//                while( !(data[inc].charAt(data[inc].length() - 2) < 58
//                        && data[inc].charAt(data[inc].length() - 2) > 47)) {
//                Log.e("myApp", "look here senpai " + data[inc].charAt(data[inc].length() - 2));
//                    if (finalData[7].length() > 0) {
//                        finalData[7] += ", ";
//                    }
//                    Log.w("myApp", data[inc]);
//                    finalData[7] = data[inc] + finalData[7];
//                    inc--;
//                }
//
//                finalData[6] = "";
//                while (increment < inc) {
//                    finalData[6] += data[increment];
//                    increment++;
//                }
//
//                Log.e("myApp", "\n\n\n " + finalData[2] + "\n\n\n");

                shelterList.add(new Shelter(finalData[0], finalData[1], finalData[2], finalData[3],
                        finalData[4], finalData[5], finalData[6], finalData[7], finalData[8]));

            }
            bReader.close();

            Log.e("myApp", "All shelters reached");

        } catch (Exception e) {
            Log.e("myApp", "Can't parse through data");
        }
        for(Shelter x: shelterList) {
            Log.e("myApp", x.toString());
        }

    }

}
//package com.gitgud.homelesshelper.model;
//
///**
// * Created by csaet on 2/24/2018.
// */
//
//import android.content.Context;
//import android.util.Log;
//
//import com.gitgud.homelesshelper.R;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//import static java.lang.Double.parseDouble;
//import static java.lang.Integer.parseInt;
//
//
//public class CSVParser {
//
//    private static ArrayList<Shelter> shelterList = new ArrayList<>();
//
//    /**
//     *
//     * @param content the Activity needed to access the3
//     */
//    public CSVParser(Context content) {
//        try {
//            InputStream reader = content.getResources().openRawResource(R.raw.homeless_shelter_database);
//            BufferedReader bReader = new BufferedReader(new InputStreamReader(reader));
//            String line = bReader.readLine();
//            String[] data;
//            while ((line = bReader.readLine()) != null) {
//                String[] finalData = new String[9];
//                int increment = 0;
//                data = line.split(",");
//                int location = -1;
//                Log.e("myApp", Integer.toString(data.length));
//
//                while (increment < data.length) {
//                    //Log.e("myApp", Integer.toString(increment));
//                    if (data[increment].length() < 1) {
//                        location += 2;
//                        increment++;
//                        finalData[location] = "";
//                        Log.e("myApp", "THIS FREAKING RUNS");
//                    } else if (data[increment].charAt(0) != 32) {
//                        location++;
//                        finalData[location] = "";
//                    } else {
//                        finalData[location] += ",";
//                    }
//                    //Log.e("myApp", data[increment]);
//                    Log.e("myApp", "current increment: " + Integer.toString(increment));
//                    Log.e("myApp", "current location: " + Integer.toString(location));
//                    Log.w("myApp", "what is loaded: " + data[increment]);
//                    finalData[location] = finalData[location] + data[increment];
//                    increment++;
//                }
//
//                shelterList.add(new Shelter(finalData[0], finalData[1], finalData[2], finalData[3],
//                        finalData[4], finalData[5], finalData[6], finalData[7], finalData[8]));
//
//            }
//            bReader.close();
//
//            Log.e("myApp", "All shelters reached");
//
//        } catch (Exception e) {
//            Log.e("myApp", "Can't parse through data");
//        }
//        for(Shelter x: shelterList) {
//            Log.e("myApp", x.toString());
//        }
//
//    }
//
//}