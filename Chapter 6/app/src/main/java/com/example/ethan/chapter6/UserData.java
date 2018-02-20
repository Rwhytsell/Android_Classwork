package com.example.ethan.chapter6;

/**
 * Model used to hold user entered data and calculate other values from that data.
 *
 */
public class UserData {
    private int guests;
    private double tipPercentage;
    private double bill;
    private double totalTip = bill * (tipPercentage / 100);
    private double totalBill = bill + totalTip;
    private double tipPerGuest = totalTip / guests;
    private double totalPerGuest = totalBill / guests;

    /**
     * Instanciates the user data with the default values
     * No parameters because it should only be created once
     */
    public UserData(){
        this.guests = 2;
        this.tipPercentage = 15.0;
        this.bill = 0.0;
    }

    /**
     * Gets the number of guests.
     *
     * @return the number of guests
     */
    public int getGuests() {
        return guests;
    }

    /**
     * Sets the number of guests.
     *
     * @param guests the number guests
     */
    public void setGuests(int guests) {
        this.guests = guests;
    }

    /**
     * Gets the tip percentage.
     *
     * @return the tip percentage
     */
    public double getTipPercentage() {
        return tipPercentage;
    }

    /**
     * Sets the tip percentage.
     *
     * @param tipPercentage the tip percentage
     */
    public void setTipPercentage(double tipPercentage) {
        this.tipPercentage = tipPercentage;
    }

    /**
     * Gets the initial bill.
     *
     * @return the bill
     */
    public double getBill() {
        return bill;
    }

    /**
     * Sets what the bill is before tip.
     *
     * @param bill the bill
     */
    public void setBill(double bill) {
        this.bill = bill;
    }

    /**
     * Gets total tip for the bill and tip percentage.
     *
     * @return the total tip
     */
    public double getTotalTip() {
        totalTip = bill * (tipPercentage / 100);
        return totalTip;
    }


    /**
     * Gets total bill including tip.
     *
     * @return the total bill
     */
    public double getTotalBill() {
        totalBill = bill + totalTip;
        return totalBill;
    }

    /**
     * Gets tip per guest.
     *
     * @return the tip per guest
     */
    public double getTipPerGuest() {
        tipPerGuest = totalTip / guests;

        return tipPerGuest;
    }


    /**
     * Gets total per guest.
     *
     * @return the total per guest
     */
    public double getTotalPerGuest() {
        totalPerGuest = totalBill / guests;
        return totalPerGuest;
    }

}
