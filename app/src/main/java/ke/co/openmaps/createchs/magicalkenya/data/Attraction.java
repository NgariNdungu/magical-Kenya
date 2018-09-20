package ke.co.openmaps.createchs.magicalkenya.data;

import android.support.annotation.Nullable;

public class Attraction {
    private String mName;
    private String mTag;
    private String mDescription;
    private int mImage;

    public Attraction(String name, @Nullable String tag, String description) {
        this.mName = name;
        this.mTag = tag;
        this.mDescription = description;
    }

    public Attraction(String name, @Nullable String tag, String description, int image) {
        this.mName = name;
        this.mTag = tag;
        this.mDescription = description;
        this.mImage = image;
    }

    public String getName() {
        return mName;
    }

    public String getTag() {
        return mTag;
    }

    public String getDescription() {
        return mDescription;
    }

    public int getImage() {
        return mImage;
    }
}
