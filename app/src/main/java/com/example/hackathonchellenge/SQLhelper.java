package com.example.hackathonchellenge;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class SQLhelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "hackathon";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "Macroeconomic";
    private static  final String TABLE_NAME_AGRI = "Agriculture";
    private static  final String TABLE_NAME_TRADE = "Trade";
    //define columns Macroeconomic table.
    private static final String YEAR_COL = "Year";
    private static final String PER_ANNUAL_GDP_INDIA_COL = "PerAnnualGDPGrowthIndia";
    private static final String PER_ANNUAL_GDP_CHINA_COL = "PerAnnualGDPGrowthChina";
    private static final String PER_ANNUAL_GDP_USA_COL = "PerAnnualGDPGrowthUSA";
    private static final String DOLLAR_ANNUAL_GDP_INDIA_COL = "DollarGDPGrowthIndia";
    private static final String DOLLAR_ANNUAL_GDP_CHINA_COL = "DollarGDPGrowthChina";
    private static final String DOLLAR_ANNUAL_GDP_USA_COL = "DollarGDPGrowthUSA";
    private static final String CURRENT_ACCOUNT_BALANCE_CHINA_COL = "CurrentAccountBalanceChina";
    private static final String CURRENT_ACCOUNT_BALANCE_INDIA_COL = "CurrentAccountBalanceIndia";
    private static final String CURRENT_ACCOUNT_BALANCE_USA_COL = "CurrentAccountBalanceUSA";
    private static final String FDI_PERCENT_GDP_CHINA_COL = "FDIPercentGDPChina";
    private static final String FDI_PERCENT_GDP_INDIA_COL = "FDIPercentGDPIndia";
    private static final String FDI_PERCENT_GDP_USA_COL = "FDIPercentGDPUSA";
    private static final String FDI_OUTFLOW_DOLLAR_BOP_CHINA_COL = "FDIOutflowDollarBOPChina";
    private static final String FDI_OUTFLOW_DOLLAR_BOP_INDIA_COL = "FDIOutflowDollarBOPIndia";
    private static final String FDI_OUTFLOW_DOLLAR_BOP_USA_COL = "FDIOutflowDollarBOPUSA";

    //defineagriculture table
    private static final String AGRI_YEAR = "Year";
    private static final String PerAFFGDPChina = "PerAFFGDPChina";
    private static final String PerAFFGDPIndia = "PerAFFGDPIndia";
    private static final String PerAFFGDPUSA = "PerAFFGDPUSA";
    private static final String ManufacturingChina = "ManufacturingChina";
    private static final String ManufacturingIndia = "ManufacturingIndia";
    private static final String ManufacturingUSA = "ManufacturingUSA";
    private static final String AnnaulAFFChina = "AnnaulAFFChina";
    private static final String AnnaulAFFIndia = "AnnaulAFFIndia";
    private static final String AnnaulAFFUSA = "AnnaulAFFUSA";
    private static final String FertilizerConsumptionChina = "FertilizerConsumptionChina";
    private static final String FertilizerConsumptionIndia = "FertilizerConsumptionIndia";
    private static final String FertilizerConsumptionUSA = "FertilizerConsumptionUSA";
    private static final String FertilizerPerConsumptionChina = "FertilizerPerConsumptionChina";
    private static final String FertilizerPerConsumptionIndia = "FertilizerPerConsumptionIndia";
    private static final String FertilizerPerConsumptionUSA = "FertilizerPerConsumptionUSA";

    //define trade table
    private static final String TRADE_YEAR = "Year";
    private static final String reservesChina = "reservesChina";
    private static final String reservesIndia = "reservesIndia";
    private static final String reservesUSA = "reservesUSA";
    private static final String debtChina = "debtChina";
    private static final String debtIndia = "debtIndia";
    private static final String debtUSA = "debtUSA";
    private static final String GNIChina = "GNIChina";
    private static final String GNIIndia = "GNIIndia";
    private static final String GNIUSA = "GNIUSA";
    private static final String CurrentGNIChina = "CurrentGNIChina";
    private static final String CurrentGNIIndia = "CurrentGNIIndia";
    private static final String CurrentGNIUSA = "CurrentGNIUSA";


    public SQLhelper(Context context) {

        super(context, DB_NAME, null, DB_VERSION);
    }
    
    //create a Database

    @Override
    public void onCreate(SQLiteDatabase db) {
            // on below line we are creating
            // an sqlite query and we are
            // setting our column names
            // along with their data types.
            String query = "CREATE TABLE " + TABLE_NAME + " ("
                    + YEAR_COL + " TEXT , "
                    + PER_ANNUAL_GDP_INDIA_COL + " TEXT,"
                    + PER_ANNUAL_GDP_CHINA_COL + " TEXT,"
                    + PER_ANNUAL_GDP_USA_COL + " TEXT,"
                    + DOLLAR_ANNUAL_GDP_INDIA_COL + " TEXT,"
                    + DOLLAR_ANNUAL_GDP_CHINA_COL + " TEXT,"
                    + DOLLAR_ANNUAL_GDP_USA_COL + " TEXT,"
                    + CURRENT_ACCOUNT_BALANCE_CHINA_COL + " TEXT,"
                    + CURRENT_ACCOUNT_BALANCE_INDIA_COL + " TEXT,"
                    + CURRENT_ACCOUNT_BALANCE_USA_COL + " TEXT,"
                    + FDI_PERCENT_GDP_CHINA_COL + " TEXT,"
                    + FDI_PERCENT_GDP_INDIA_COL + " TEXT,"
                    + FDI_PERCENT_GDP_USA_COL + " TEXT,"
                    + FDI_OUTFLOW_DOLLAR_BOP_CHINA_COL + " TEXT,"
                    + FDI_OUTFLOW_DOLLAR_BOP_INDIA_COL + " TEXT,"
                    + FDI_OUTFLOW_DOLLAR_BOP_USA_COL + " TEXT)";

            // Agriculture Table

        String agriQuery = "CREATE TABLE " + TABLE_NAME_AGRI + " ("
                + AGRI_YEAR + " TEXT , "
                + PerAFFGDPChina + " TEXT,"
                + PerAFFGDPIndia + " TEXT,"
                + PerAFFGDPUSA + " TEXT,"
                + ManufacturingChina + " TEXT,"
                + ManufacturingIndia + " TEXT,"
                + ManufacturingUSA + " TEXT,"
                + AnnaulAFFChina + " TEXT,"
                + AnnaulAFFIndia + " TEXT,"
                + AnnaulAFFUSA + " TEXT,"
                + FertilizerConsumptionChina + " TEXT,"
                + FertilizerConsumptionIndia + " TEXT,"
                + FertilizerConsumptionUSA + " TEXT,"
                + FertilizerPerConsumptionChina + " TEXT,"
                + FertilizerPerConsumptionIndia + " TEXT,"
                + FertilizerPerConsumptionUSA + " TEXT)";

        String tradeQuery = "CREATE TABLE " + TABLE_NAME_TRADE + " ("
                + TRADE_YEAR + " TEXT , "
                + reservesChina + " TEXT,"
                + reservesIndia + " TEXT,"
                + reservesUSA + " TEXT,"
                + debtChina + " TEXT,"
                + debtIndia + " TEXT,"
                + debtUSA + " TEXT,"
                + GNIChina + " TEXT,"
                + GNIUSA + " TEXT,"
                + CurrentGNIChina + " TEXT,"
                + CurrentGNIIndia + " TEXT,"
                + CurrentGNIUSA + " TEXT)";
        // at last we are calling a exec sql
            // method to execute above sql query
            Log.e("create table Query", query);
            db.execSQL(query);
            db.execSQL(agriQuery);
            db.execSQL(tradeQuery);
        }


    // this method is use to add Macroeconomic data from csv  to our SQLite Database.
    public void addCSVRowtoDB(String[] inValues) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method as we update data to db.
        SQLiteDatabase db = this.getWritableDatabase();

        // creating a variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all value along with its key and value pair.
        values.put(YEAR_COL, inValues[0]);
        values.put(PER_ANNUAL_GDP_INDIA_COL, addNullValues(inValues[1]));
        values.put(PER_ANNUAL_GDP_CHINA_COL, addNullValues(inValues[2]));
        values.put(PER_ANNUAL_GDP_USA_COL, addNullValues(inValues[3]));
        values.put(DOLLAR_ANNUAL_GDP_INDIA_COL, addNullValues(inValues[4]));
        values.put(DOLLAR_ANNUAL_GDP_CHINA_COL, addNullValues(inValues[5]));
        values.put(DOLLAR_ANNUAL_GDP_USA_COL, addNullValues(inValues[6]));
        values.put(CURRENT_ACCOUNT_BALANCE_CHINA_COL, addNullValues(inValues[7]));
        values.put(CURRENT_ACCOUNT_BALANCE_INDIA_COL, addNullValues(inValues[8]));
        values.put(CURRENT_ACCOUNT_BALANCE_USA_COL, addNullValues(inValues[9]));
        values.put(FDI_PERCENT_GDP_CHINA_COL, addNullValues(inValues[10]));
        values.put(FDI_PERCENT_GDP_INDIA_COL, addNullValues(inValues[11]));
        values.put(FDI_PERCENT_GDP_USA_COL, addNullValues(inValues[12]));
        values.put(FDI_OUTFLOW_DOLLAR_BOP_CHINA_COL, addNullValues(inValues[13]));
        values.put(FDI_OUTFLOW_DOLLAR_BOP_INDIA_COL, addNullValues(inValues[14]));
        values.put(FDI_OUTFLOW_DOLLAR_BOP_USA_COL, addNullValues(inValues[15]));
        // after adding all values we are passing content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }




    public void addAgriDataoDB(String[] inValues) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method as we update data to db.
        SQLiteDatabase db = this.getWritableDatabase();

        // creating a variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all value along with its key and value pair.
        values.put(YEAR_COL, inValues[0]);
        values.put(PerAFFGDPChina, addNullValues(inValues[1]));
        values.put(PerAFFGDPIndia, addNullValues(inValues[2]));
        values.put(PerAFFGDPUSA, addNullValues(inValues[3]));
        values.put(ManufacturingChina, addNullValues(inValues[4]));
        values.put(ManufacturingIndia, addNullValues(inValues[5]));
        values.put(ManufacturingUSA, addNullValues(inValues[6]));
        values.put(AnnaulAFFChina, addNullValues(inValues[7]));
        values.put(AnnaulAFFIndia, addNullValues(inValues[8]));
        values.put(AnnaulAFFUSA, addNullValues(inValues[9]));
        values.put(FertilizerConsumptionChina, addNullValues(inValues[10]));
        values.put(FertilizerConsumptionIndia, addNullValues(inValues[11]));
        values.put(FertilizerConsumptionUSA, addNullValues(inValues[12]));
        values.put(FertilizerPerConsumptionChina, addNullValues(inValues[13]));
        values.put(FertilizerPerConsumptionIndia, addNullValues(inValues[14]));
        values.put(FertilizerPerConsumptionUSA, addNullValues(inValues[15]));
        // after adding all values we are passing content values to our table.
        db.insert(TABLE_NAME_AGRI, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    public void addTradeDataToDB(String[] inValues) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method as we update data to db.
        SQLiteDatabase db = this.getWritableDatabase();

        // creating a variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all value along with its key and value pair.
        values.put(TRADE_YEAR, inValues[0]);
        values.put(reservesChina, addNullValues(inValues[1]));
        values.put(reservesIndia, addNullValues(inValues[2]));
        values.put(reservesUSA, addNullValues(inValues[3]));
        values.put(debtChina, addNullValues(inValues[4]));
        values.put(debtIndia, addNullValues(inValues[5]));
        values.put(ManufacturingUSA, addNullValues(inValues[6]));
        values.put(debtUSA, addNullValues(inValues[7]));
        values.put(GNIChina, addNullValues(inValues[8]));
        values.put(GNIIndia, addNullValues(inValues[9]));
        values.put(GNIUSA, addNullValues(inValues[10]));
        values.put(CurrentGNIChina, addNullValues(inValues[11]));
        values.put(CurrentGNIIndia, addNullValues(inValues[12]));
        values.put(CurrentGNIUSA, addNullValues(inValues[13]));
        // after adding all values we are passing content values to our table.
        db.insert(TABLE_NAME_TRADE, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_AGRI);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_TRADE);
        onCreate(db);
    }

    private String addNullValues(String columnValue){
        if (columnValue.isEmpty() || columnValue.startsWith("#")) {
            return "0.0";
        }
        return columnValue;
    }

    public ArrayList<MacroeconomicsModel> readMacroeconomicsData(){
        SQLiteDatabase db = this.getReadableDatabase();
        System.out.println(db);
        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + TABLE_NAME
                , null);
        // on below line we are creating a new array list.
        ArrayList<MacroeconomicsModel> courseModalArrayList = new ArrayList<>();
        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
                courseModalArrayList.add(new MacroeconomicsModel(cursorCourses.getString(0),
                        cursorCourses.getString(1),
                        cursorCourses.getString(2),
                        cursorCourses.getString(3),
                        cursorCourses.getString(4),
                        cursorCourses.getString(5),
                        cursorCourses.getString(6),
                        cursorCourses.getString(7),
                        cursorCourses.getString(8),
                        cursorCourses.getString(9),
                        cursorCourses.getString(10),
                        cursorCourses.getString(11),
                        cursorCourses.getString(12),
                        cursorCourses.getString(13),
                        cursorCourses.getString(14),
                        cursorCourses.getString(15)));
            }
                while (cursorCourses.moveToNext()) ;
            }
        // at last closing our cursor
        // and returning our array list.
        System.out.println(courseModalArrayList);
        cursorCourses.close();
        return courseModalArrayList;

    }



    public ArrayList<AgricultureModel> readAgricultureData(){
        SQLiteDatabase db = this.getReadableDatabase();
        System.out.println(db);
        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + TABLE_NAME_AGRI
                , null);
        // on below line we are creating a new array list.
        ArrayList<AgricultureModel> AgricultureModalArrayList = new ArrayList<>();
        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
                AgricultureModalArrayList.add(new AgricultureModel(cursorCourses.getString(0),
                        cursorCourses.getString(1),
                        cursorCourses.getString(2),
                        cursorCourses.getString(3),
                        cursorCourses.getString(4),
                        cursorCourses.getString(5),
                        cursorCourses.getString(6),
                        cursorCourses.getString(7),
                        cursorCourses.getString(8),
                        cursorCourses.getString(9),
                        cursorCourses.getString(10),
                        cursorCourses.getString(11),
                        cursorCourses.getString(12),
                        cursorCourses.getString(13),
                        cursorCourses.getString(14),
                        cursorCourses.getString(15)));
            }
            while (cursorCourses.moveToNext()) ;
        }
        // at last closing our cursor
        // and returning our array list.
        System.out.println(AgricultureModalArrayList);
        cursorCourses.close();
        return AgricultureModalArrayList;

    }
}
