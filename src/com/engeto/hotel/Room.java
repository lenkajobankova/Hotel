package com.engeto.hotel;

public class Room {
    private int roomNumber, numberOfBeds, pricePerNight;
    private boolean isBalcony, isSea;

    //region Konstruktor

    public Room(int roomNumber, int numberOfBeds, boolean isBalcony, boolean isSea, int pricePerNight){
        this.roomNumber = roomNumber;
        this.numberOfBeds = numberOfBeds;
        this.isBalcony = isBalcony;
        this.isSea = isSea;
        this.pricePerNight = pricePerNight;
    }

    //endregion

    //region Přístupové metody

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }
    public boolean getBalcony(){
        return isBalcony;
    }
    public String isBalconyAsText(){
        if (isBalcony){
            return " s balkonem";
        }
        else {
            return " bez balkonu";
        }
    }

    public void setBalcony(boolean balcony) {
        isBalcony = balcony;
    }
    public String isSeaAsText(){
        if (isSea){
            return " a s výhledem na moře";
        }
        else {
            return " a bez výhledu na moře";
        }
    }
    public String isSeaYN(){
        if (isSea){
            return "ano";
        }
        else {
            return "ne";
        }
    }
    public boolean getSea(){
        return isSea;
    }
    public void setSea(boolean sea) {
        isSea = sea;
    }

    public int getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(int pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    //endregion
}
