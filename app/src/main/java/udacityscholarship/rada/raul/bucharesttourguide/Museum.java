package udacityscholarship.rada.raul.bucharesttourguide;

/**
 * {@link Museum} represents a Museum about which the user can find more information.
 * The class extends {@link Attraction}, providing some fields that are relevant only for Museums
 */
public class Museum extends Attraction {

    //no individual large pic for museum available; the museum_vector asset is used for all museum.
    private static final int LARGE_PIC = R.drawable.museum_vector;

    /**
     * Museum object constructor
     *
     * @param nameId         String resource ID for Museum name
     * @param openingHoursId String resource ID for Museum opening hours
     * @param geoId          String resource ID for Museum GPS coordinates
     * @param addressId      ID of Museum address
     * @param webAddressId   ID of Museum web address
     * @param phoneNumberId  ID of Museum phone number
     * @param typeId         ID of Museum type
     */
    public Museum(int nameId, int openingHoursId, int geoId, int addressId, int webAddressId, int phoneNumberId, int typeId) {
        this.setLargePicId(LARGE_PIC);
        this.setNameId(nameId);
        this.setOpeningHoursId(openingHoursId);
        this.setGeoId(geoId);
        this.setAddressId(addressId);
        this.setWebAddressId(webAddressId);
        this.setPhoneNumberId(phoneNumberId);
        this.setTypeId(typeId);
    }
}
