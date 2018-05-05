package udacityscholarship.rada.raul.bucharesttourguide;

/**
 * {@link Attraction} represents an attraction of interest for the user.
 * It contains resource IDs for attraction name, opening hours,
 * large picture and GPS coordinates. Abstract class is implemented by Hotel, Park, Museum
 * and Restaurant classes.
 */
abstract class Attraction {

    /** String resource ID for Attraction name */
    private int mNameId;

    /** String resource ID for Attraction opening hours */
    private int mOpeningHoursId;

    /** ID of Attraction large picture */
    private int mLargePicId;

    /** String resource ID for Attraction GPS coordinates */
    private int mGeoId;

    /**
     * setter method for nameId
     * @param nameId identifies the String resource containing the name of the Attraction
     */
    public void setNameId (int nameId){
        mNameId = nameId;
    }

    /**
     * @return id of String resource containing the name of the Attraction
     */
    public int getNameId(){
        return mNameId;
    }

    /**
     * setter methond for openingHoursId
     * @param openingHoursId identifies the String resource containing the opening hours
     *                       of the Attraction
     */
    public void setOpeningHoursId (int openingHoursId){
        mOpeningHoursId = openingHoursId;
    }

    /**
     * @return id of String resource containing the opening hours of the Attraction
     */
    public int getOpeningHoursId(){
        return mOpeningHoursId;
    }

    /**
     * setter method for largePicId
     * @param largePicId identifies the id of the big picture of the Attraction
     */
    public void setLargePicId (int largePicId){
        mLargePicId = largePicId;
    }

    /**
     * @return id of large picture of the Attraction
     */
    public int getLargePicId(){
        return mLargePicId;
    }

    /**
     * setter method for geoId
     * @param geoId identifies the String resource containing the GPS coordinates of the Attraction
     */
    public void setGeoId (int geoId){
        mGeoId = geoId;
    }

    /**
     * @return id of String resource containing the GPS coordinates of the Attraction
     */
    public int getGeoId(){
        return mGeoId;
    }

}
