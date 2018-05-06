package udacityscholarship.rada.raul.bucharesttourguide;

/**
 * {@link Attraction} represents an attraction of interest for the user.
 * It contains resource IDs for attraction name, opening hours,
 * large picture and GPS coordinates. Abstract class is extended by Hotel, Park, Museum
 * and Restaurant classes, in order to allow for different data members for different
 * {@link Attraction} types.
 */
abstract class Attraction {

    /** constant value showing whether the {@link Attraction} has small pic available*/
    private static final int NO_SMALL_PIC = -1;

    /** constant value showing whether the {@link Attraction} has size information attached */
    private static final int NO_SIZE = -1;

    /** constant value showing whether the {@link Attraction} has size information attached */
    private static final int NO_OPENING_YEAR = -1;

    /** constant value showing whether the {@link Attraction} has type information attached */
    private static final int NO_TYPE = -1;

    /** constant value showing whether the {@link Attraction} is classified by star number */
    private static final int NO_STARS = -1;

    /** String resource ID for {@link Attraction} name */
    private int mNameId;

    /** String resource ID for {@link Attraction} opening hours */
    private int mOpeningHoursId;

    /** ID of Attraction large picture */
    private int mLargePicId;

    /** String resource ID for {@link Attraction} GPS coordinates */
    private int mGeoId;

    /** ID of {@link Attraction} small picture */
    private int mSmallPicId = NO_SMALL_PIC;

    /** String resource ID for {@link Attraction} size */
    private int mSizeId = NO_SIZE;

    /** String resource ID for {@link Attraction} opening year */
    private int mSinceId = NO_OPENING_YEAR;

    /** String resource ID for {@link Attraction} type */
    private int mTypeId = NO_TYPE;

    /** int showing the number of stars to which the {@link Attraction} is classified */
    private int mStarsNumber = NO_STARS;

    /**
     * setter method for nameId
     * @param nameId identifies the String resource containing the name of the {@link Attraction}
     */
    public void setNameId (int nameId){
        mNameId = nameId;
    }

    /**
     * @return id of String resource containing the name of the {@link Attraction}
     */
    public int getNameId(){
        return mNameId;
    }

    /**
     * setter methond for openingHoursId
     * @param openingHoursId identifies the String resource containing the opening hours
     *                       of the {@link Attraction}
     */
    public void setOpeningHoursId (int openingHoursId){
        mOpeningHoursId = openingHoursId;
    }

    /**
     * @return id of String resource containing the opening hours of the {@link Attraction}
     */
    public int getOpeningHoursId(){
        return mOpeningHoursId;
    }

    /**
     * setter method for largePicId
     * @param largePicId identifies the id of the big picture of the {@link Attraction}
     */
    public void setLargePicId (int largePicId){
        mLargePicId = largePicId;
    }

    /**
     * @return id of large picture of the {@link Attraction}
     */
    public int getLargePicId(){
        return mLargePicId;
    }

    /**
     * setter method for geoId
     * @param geoId identifies the String resource containing the GPS coordinates of the {@link Attraction}
     */
    public void setGeoId (int geoId){
        mGeoId = geoId;
    }

    /**
     * @return id of String resource containing the GPS coordinates of the {@link Attraction}
     */
    public int getGeoId(){
        return mGeoId;
    }

    /**
     * setter method for nameId
     * @param smallPicId identifies the id of the small picture of the {@link Attraction}
     */
    public void setSmallPicId (int smallPicId){
        mSmallPicId = smallPicId;
    }

    /**
     * @return the id of the small picture of the {@link Attraction}
     */
    public int getSmallPicId(){
        return mSmallPicId;
    }

    /**
     * setter method for geoId
     * @param sizeId identifies the String resource containing the size of the {@link Attraction}
     */
    public void setSizeId (int sizeId){
        mSizeId = sizeId;
    }

    /**
     * @return id of String resource containing the size of the {@link Attraction}
     */
    public int getSizeId(){
        return mSizeId;
    }

    /**
     * setter method for geoId
     * @param sinceId identifies the String resource containing the opening year of the {@link Attraction}
     */
    public void setSinceId (int sinceId){
        mSinceId = sinceId;
    }

    /**
     * @return id of String resource containing the opening year of the {@link Attraction}
     */
    public int getSinceId(){
        return mSinceId;
    }

    /**
     * setter method for typeId
     * @param typeId identifies the String resource containing the type of the {@link Attraction}
     */
    public void setType (int typeId){
        mTypeId = typeId;
    }

    /**
     * @return id of String resource containing the type of the {@link Attraction}
     */
    public int getTypeId(){
        return mTypeId;
    }

    /**
     * setter method for geoId
     * @param starsNumber the number of stars of the {@link Attraction}
     */
    public void setStarsNumber (int starsNumber){
        mStarsNumber = starsNumber;
    }

    /**
     * @return the number of stars of the {@link Attraction}
     */
    public int getStarsNumber(){
        return mStarsNumber;
    }

    /**
     * @return whether the {@link Attraction} has a small pic provided
     */
    public boolean hasSmallImage(){
        return mSmallPicId != NO_SMALL_PIC;
    }

    /**
     * @return whether the {@link Attraction} has a size provided
     */
    public boolean hasSize(){
        return mSizeId != NO_SIZE;
    }

    /**
     * @return whether the {@link Attraction} has an opening year provided
     */
    public boolean hasSince(){
        return mSinceId != NO_OPENING_YEAR;
    }

    /**
     * @return whether the {@link Attraction} has a type provided
     */
    public boolean hasType(){
        return mTypeId != NO_TYPE;
    }

    /**
     * @return whether the {@link Attraction} is classified by stars number
     */
    public boolean hasStars(){
        return mStarsNumber != NO_STARS;
    }
}
