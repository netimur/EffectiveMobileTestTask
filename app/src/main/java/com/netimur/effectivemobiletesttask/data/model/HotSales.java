package com.netimur.effectivemobiletesttask.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "hot_sales")
final public class HotSales implements Parcelable {
    @PrimaryKey
    private final int id;
    @SerializedName("is_new")
    private final boolean isNew;
    private final String title;
    private final String subtitle;
    @SerializedName("picture")
    private final String pictureUrl;
    @SerializedName("is_buy")
    private final boolean isBuy;

    public HotSales(int id, boolean isNew, String title, String subtitle, String pictureUrl, boolean isBuy) {
        this.id = id;
        this.isNew = isNew;
        this.title = title;
        this.subtitle = subtitle;
        this.pictureUrl = pictureUrl;
        this.isBuy = isBuy;
    }

    protected HotSales(Parcel in) {
        id = in.readInt();
        isNew = in.readByte() != 0;
        title = in.readString();
        subtitle = in.readString();
        pictureUrl = in.readString();
        isBuy = in.readByte() != 0;
    }

    public static final Creator<HotSales> CREATOR = new Creator<HotSales>() {
        @Override
        public HotSales createFromParcel(Parcel in) {
            return new HotSales(in);
        }

        @Override
        public HotSales[] newArray(int size) {
            return new HotSales[size];
        }
    };

    public int getId() {
        return id;
    }

    public boolean isNew() {
        return isNew;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public boolean isBuy() {
        return isBuy;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeByte((byte) (isNew ? 1 : 0));
        dest.writeString(title);
        dest.writeString(subtitle);
        dest.writeString(pictureUrl);
        dest.writeByte((byte) (isBuy ? 1 : 0));
    }

    @Override
    public String toString() {
        return "HomeStore{" +
                "id=" + id +
                ", isNew=" + isNew +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", isBuy=" + isBuy +
                '}';
    }
}
