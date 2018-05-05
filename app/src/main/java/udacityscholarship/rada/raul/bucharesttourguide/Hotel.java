package udacityscholarship.rada.raul.bucharesttourguide;

public class Hotel extends Attraction {

    /** int variable showing the number of stars of the attraction, if relevant */
    private int mStarNumber;

    public Hotel (int nameId, int openingHoursId, int largePicId, int geoId, int starNumber){
        this.setNameId(nameId);
    }
}
