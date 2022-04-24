package com.example.hackathonchellenge;

import java.util.ArrayList;
import java.util.List;

public class ReaderController {

    public static List<MacroeconomicsModel> getMacroEconomicsData(SQLhelper sqlHelper) {
         List<MacroeconomicsModel> getMacroData = null;
         try{
             getMacroData = sqlHelper.readMacroeconomicsData();
         }
         catch (Exception e) {
        //log the exception
          }
         return getMacroData;
    }

}
