package com.example.hackathonchellenge;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLhelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "hackathon";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "Macroeconomic";
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
                    + DOLLAR_ANNUAL_GDP_CHINA_COL + " REAL,"
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

            // at last we are calling a exec sql
            // method to execute above sql query
            Log.e("create table Query", query);
            db.execSQL(query);
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
        values.put(PER_ANNUAL_GDP_INDIA_COL,inValues[1]);
        values.put(PER_ANNUAL_GDP_CHINA_COL, inValues[2]);
        values.put(PER_ANNUAL_GDP_USA_COL, inValues[3]);
        values.put(DOLLAR_ANNUAL_GDP_INDIA_COL, inValues[4]);
        values.put(DOLLAR_ANNUAL_GDP_CHINA_COL, inValues[5]);
        values.put(DOLLAR_ANNUAL_GDP_USA_COL, inValues[6]);
        values.put(CURRENT_ACCOUNT_BALANCE_CHINA_COL, inValues[7]);
        values.put(CURRENT_ACCOUNT_BALANCE_INDIA_COL, inValues[8]);
        values.put(CURRENT_ACCOUNT_BALANCE_USA_COL, inValues[9]);
        values.put(FDI_PERCENT_GDP_CHINA_COL, inValues[10]);
        values.put(FDI_PERCENT_GDP_INDIA_COL, inValues[11]);
        values.put(FDI_PERCENT_GDP_USA_COL, inValues[12]);
        values.put(FDI_OUTFLOW_DOLLAR_BOP_CHINA_COL, inValues[13]);
        values.put(FDI_OUTFLOW_DOLLAR_BOP_INDIA_COL, inValues[14]);
        values.put(FDI_OUTFLOW_DOLLAR_BOP_USA_COL, inValues[15]);
        // after adding all values we are passing content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    private String addNullvalues(String columnValue){
        if (columnValue.isEmpty()) {
            return null;
        }
        return columnValue;
    }

}