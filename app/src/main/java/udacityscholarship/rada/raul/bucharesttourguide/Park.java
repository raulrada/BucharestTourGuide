package udacityscholarship.rada.raul.bucharesttourguide;

/**
 * {@link Park} represents a Park about which the user can find more information.
 * The class implements {@link Attraction}, providing some fields that are relevant only for Parks
 */
public class Park extends Attraction {

    /** constant value showing whether the Park has small pic */
    private static final boolean HAS_SMALL_PIC = true;

    /** constant value showing whether the Park has size information attached */
    private static final boolean HAS_SIZE = true;

    /** constant value showing whether the Park has size information attached */
    private static final boolean HAS_OPENING_YEAR = true;

    /** ID of Attraction small picture */
    private int mSmallPicId;

    /** String resource ID for Attraction size */
    private int mSizeId;

    /** String resource ID for Attraction opening year */
    private int mSinceId;

    /**
     * Park object constructor
     * @param nameId String resource ID for Park name
     * @param openingHoursId String resource ID for Park opening hours
     * @param largePicId ID of Park large picture
     * @param geoId String resource ID for Park GPS coordinates
     * @param smallPicId ID of Park small picture
     * @param sizeId String resource ID for Park size
     */
    public Park(int nameId, int openingHoursId, int largePicId, int geoId, int smallPicId,
                int sizeId, int sinceId){
        this.setNameId(nameId);
        this.setOpeningHoursId(openingHoursId);
        this.setLargePicId(largePicId);
        this.setGeoId(geoId);
        mSmallPicId = smallPicId;
        mSizeId = sizeId;
        mSinceId = sinceId;
    }

    /**
     * @return id of small picture of the Attraction
     */
    public int getSmallPicId(){
        return mSmallPicId;
    }

    /**
     * @return id of String resource containing the size of the Attraction
     */
    public int getSizeId(){
        return mSizeId;
    }

    /**
     * @return id of String resource containing the opening year of the Attraction
     */
    public int getSinceId(){
        return mSinceId;
    }

    /**
     * @return whether the Park has a small pic provided
     */
    public boolean hasSmallImage(){
        return HAS_SMALL_PIC;
    }

    /**
     * @return whether the Park has a size provided
     */
    public boolean hasSize(){
        return HAS_SIZE;
    }

    /**
     * @return whether the Park has an opening year provided
     */
    public boolean hasSince(){
        return HAS_OPENING_YEAR;
    }
}
