package udacityscholarship.rada.raul.bucharesttourguide;

/**
 * {@link Hotel} represents a Hotel about which the user can find more information.
 * The class extends {@link Attraction}, providing some fields that are relevant only for Hotels
 */
public class Hotel extends Attraction {

    //no individual large pic for hotels available; the hotel_vector asset is used for all hotels.
    private static final int LARGE_PIC = R.drawable.hotel_vector;

    //all hotels are open 24 hours
    private static final int HOTEL_OPENING_HOURS = R.string.hotel_opening;

    /**
     * Hotel object constructor
     * @param nameId String resource ID for Hotel name
     * @param geoId String resource ID for Hotel GPS coordinates
     * @param addressId ID of Hotel address
     * @param starsNumber number of stars of the Hotel
     * @param webAddressId ID of Hotel web address
     * @param phoneNumberId ID of Hotel phone number
     */
    public Hotel(int nameId, int geoId, int addressId, int starsNumber, int webAddressId, int phoneNumberId){
        this.setOpeningHoursId(HOTEL_OPENING_HOURS);
        this.setLargePicId(LARGE_PIC);
        this.setNameId(nameId);
        this.setGeoId(geoId);
        this.setAddressId(addressId);
        this.setStarsNumber(starsNumber);
        this.setWebAddressId(webAddressId);
        this.setPhoneNumberId(phoneNumberId);
    }
}
