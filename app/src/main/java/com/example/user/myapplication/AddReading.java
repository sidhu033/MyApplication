package com.example.user.myapplication;

public class AddReading
{

    public AddReading() {}

    public static final String TABLE_NAME = "reading_tbl";

    public static final String _ID = "id";
    public static final String USER_ID = "user_id";
    public static final String SYNC_STATUS = "sync_status";
    public static final String RSYS = "r_sys";
    public static final String RDYS = "r_dys";
    public static final String RPULSE = "r_pulse";
    public static final String LSYS = "l_sys";
    public static final String LDYS = "l_dys";
    public static final String LPULSE = "l_pulse";

    private int id;
    private String userId;
    private String syncStatus;
    private String rSys;
    private String lSys;
    private String rDys;
    private String lDys;
    private String rPulse;
    private String lPulse;

    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + USER_ID + " TEXT,"
                    + SYNC_STATUS + " TEXT,"
                    + RSYS + " TEXT,"
                    + RDYS + " TEXT,"
                    + RPULSE + " TEXT,"
                    + LSYS + " TEXT,"
                    + LDYS + " TEXT,"
                    + LPULSE + " TEXT"
                    + ")";

    public AddReading(int id, String userId, String syncStatus,
                      String rSys, String rDys, String rPulse,
                      String lSys, String lDys, String lPulse) {
        this.id = id;
        this.userId = userId;
        this.syncStatus = syncStatus;
        this.rSys = rSys;
        this.rDys = rDys;
        this.rPulse = rPulse;
        this.lSys = lSys;
        this.lDys = lDys;
        this.lPulse = lPulse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(String syncStatus) {
        this.syncStatus = syncStatus;
    }

    public String getrSys() {
        return rSys;
    }

    public void setrSys(String rSys) {
        this.rSys = rSys;
    }

    public String getlSys() {
        return lSys;
    }

    public void setlSys(String lSys) {
        this.lSys = lSys;
    }

    public String getrDys() {
        return rDys;
    }

    public void setrDys(String rDys) {
        this.rDys = rDys;
    }

    public String getlDys() {
        return lDys;
    }

    public void setlDys(String lDys) {
        this.lDys = lDys;
    }

    public String getrPulse() {
        return rPulse;
    }

    public void setrPulse(String rPulse) {
        this.rPulse = rPulse;
    }

    public String getlPulse() {
        return lPulse;
    }

    public void setlPulse(String lPulse) {
        this.lPulse = lPulse;
    }
}
