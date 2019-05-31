
package com.example.user.myapplication.pojo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SaveEntity implements Parcelable {

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("message")
    @Expose
    private String message;
    public final static Creator<SaveEntity> CREATOR = new Creator<SaveEntity>() {


        @SuppressWarnings({
                "unchecked"
        })
        public SaveEntity createFromParcel(Parcel in) {
            return new SaveEntity(in);
        }

        public SaveEntity[] newArray(int size) {
            return (new SaveEntity[size]);
        }

    };

    protected SaveEntity(Parcel in) {
        this.error = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
    }

    public SaveEntity() {
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(error);
        dest.writeValue(message);
    }

    public int describeContents() {
        return 0;
    }

}
