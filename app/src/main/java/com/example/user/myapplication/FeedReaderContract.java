package com.example.user.myapplication;

public class FeedReaderContract {

    private FeedReaderContract() {}

    public static final String TABLE_NAME = "user_tbl";

    public static final String _ID = "id";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String USER_ID = "user_id";
    public static final String STATUS = "status";

    private int id;
    private String userId;
    private String username;
    private String password;
    private String status;

    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + USERNAME + " TEXT,"
                    + PASSWORD + " TEXT,"
                    + USER_ID + " TEXT,"
                    + STATUS + " TEXT"
                    + ")";

    public FeedReaderContract(int id, String userId, String username, String password, String status) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.status = status;

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
