package ke.co.openmaps.createchs.magicalkenya.data;


public class Attraction {
    private String mName;
    private String mTag;
    private String mDescription;
    private int mImage = 0;

    /**
     * Default constructor.
     *
     * @param attraction an array of 3 strings [name, tag, description]
     */
    public Attraction(String[] attraction) {
        this.mName = attraction[0];
        this.mTag = attraction[1];
        this.mDescription = attraction[2];
    }

    /**
     * Constructor with an associated image
     *
     * @param attraction an array of 3 strings [name, tag, description]
     * @param image the image resource id
     */
    public Attraction(String[] attraction, int image) {
        this.mName = attraction[0];
        this.mTag = attraction[1];
        this.mDescription = attraction[2];
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
