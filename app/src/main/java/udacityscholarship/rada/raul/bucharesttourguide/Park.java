package udacityscholarship.rada.raul.bucharesttourguide;

/**
 * {@link Park} represents a Park about which the user can find more information.
 * The class extends {@link Attraction}, providing some fields that are relevant only for Parks
 */
public class Park extends Attraction {

    /**
     * Park object constructor
     *
     * @param nameId         String resource ID for Park name
     * @param openingHoursId String resource ID for Park opening hours
     * @param largePicId     ID of Park large picture
     * @param geoId          String resource ID for Park GPS coordinates
     * @param smallPicId     ID of Park small picture
     * @param sizeId         String resource ID for Park size
     * @param sinceId        String resource ID for opening year of the Park
     */
    public Park(int nameId, int openingHoursId, int largePicId, int geoId, int smallPicId,
                int sizeId, int sinceId) {
        this.setNameId(nameId);
        this.setOpeningHoursId(openingHoursId);
        this.setLargePicId(largePicId);
        this.setGeoId(geoId);
        this.setSmallPicId(smallPicId);
        this.setSizeId(sizeId);
        this.setSinceId(sinceId);
    }
}
