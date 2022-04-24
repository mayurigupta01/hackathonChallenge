package com.example.hackathonchellenge;

import com.anychart.core.stock.indicators.TRIX;

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

    public static List<AgricultureModel> getAgricultureData(SQLhelper sqlHelper) {
        List<AgricultureModel> getAgricultureData = null;
        try{
            getAgricultureData = sqlHelper.readAgricultureData();
        }
        catch (Exception e) {
            //log the exception
        }
        return getAgricultureData;
    }


    public static List<TradeModel> getTradeData(SQLhelper sqlHelper) {
        List<TradeModel> getTradeData = null;
        try{
            getTradeData = sqlHelper.readTradeData();
        }
        catch (Exception e) {
            //log the exception
        }
        return getTradeData;
    }


}
