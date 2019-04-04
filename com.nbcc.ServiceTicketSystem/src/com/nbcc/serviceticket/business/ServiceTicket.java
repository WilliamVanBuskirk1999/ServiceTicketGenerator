/*
 * Service Ticket Class
 * Bill 
 * Assignment 3
   March 5th
 */
package com.nbcc.serviceticket.business;

import com.nbcc.exception.ServiceTicketException;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author billy
 */
public class ServiceTicket implements Serializable {

    public String shortDescription;
    public String assignedTo;
    public String currentState;
    public boolean isOpen;
    public String severity;
    public Date dateOpened;
    public Date dateLastActioned;
    public Date dateETA;
    public String longDescription;
    public String actionTaken;

    public ServiceTicket() {

    }

    // <editor-fold defaultstate="collapsed" desc="Getters And Setters ">
    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public boolean isIsOpen() {
        return isOpen;
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public Date getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(Date dateOpened) {
        this.dateOpened = dateOpened;
    }

    public Date getDateLastActioned() {
        return dateLastActioned;
    }

    public void setDateLastActioned(Date dateLastActioned) {
        this.dateLastActioned = dateLastActioned;
    }

    public Date getDateETA() {
        return dateETA;
    }

    public void setDateETA(Date dateETA) {
        this.dateETA = dateETA;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getActionTaken() {
        return actionTaken;
    }

    public void setActionTaken(String actionTaken) {
        this.actionTaken = actionTaken;
    }

// </editor-fold>
    /**
     * Gets the number of the corresponding string month
     */
    public int getMonthNumber(String monthName) {
        return Month.valueOf(monthName.toUpperCase()).getValue();
    }

    /**
     * Ensures the required fields are provided
     *
     * @return
     */
    public boolean hasRequiredFields() {
        if (this.shortDescription.equals("") && this.assignedTo.equals("") && this.currentState.equals("")
                && this.severity.equals("") && this.longDescription.equals("")) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * If the ticket isn't open, the action taken property is required
     *
     * @return false if the action taken is an empty string when a ticket is
     * closed
     */
    private boolean checkForActionTaken() {
        if (this.isOpen == false) {
            if (this.actionTaken.equals("")) {
                return false;
            }
        }
        return true;
    }

    /**
     * Calculates the ETA based on the severity
     * @return The date of the ETA
     */
    private Date calculateETA() {
        Calendar eta = Calendar.getInstance();
        eta.setTime(this.dateOpened);

        if (this.severity.equals("Severe")) {
            eta.add(Calendar.DAY_OF_MONTH, 3);
        } else if (this.severity.equals("High")) {
            eta.add(Calendar.DAY_OF_MONTH, 4);
        } else if (this.severity.equals("Medium")) {
            eta.add(Calendar.DAY_OF_MONTH, 5);
        } else if (this.severity.equals("Low")) {
            eta.add(Calendar.DAY_OF_MONTH, 5);
        }
        
        return eta.getTime();
    }
    
    /**
     * Ensures that the date of last action is a valid date that is not in the future
     * @return true if the date is valid, false if not
     */
    private boolean isDateLastActionedValid(){
        Calendar lastAction = Calendar.getInstance();
        lastAction.setTime(this.dateLastActioned);
        
        Calendar openedDate = Calendar.getInstance();
        openedDate.setTime(this.dateOpened);
        
        if(openedDate.compareTo(lastAction) < 0){
            return false;
        }
        
        return true;
    }

    /**
     * Creates a new service ticket
     * @throws ServiceTicketException 
     */
    public void createServiceTicket() throws ServiceTicketException {
        if(!hasRequiredFields()){
            throw new ServiceTicketException("Please fill out all required fields");
        }else if(!checkForActionTaken()){
            throw new ServiceTicketException("Action taken is required when the ticket is closed");
        }else if(!isDateLastActionedValid()){
            throw new ServiceTicketException("The date last actioned cannot be before the ticket open date");
        }else{
           setDateETA(calculateETA());
        }
    }

}
