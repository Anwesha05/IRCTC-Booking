package org.example.entities;







public class Ticket {
    private String ticketId;
    private String userId;
    private String source;
    private String destination;
    private String dateOfTravel;
    private Train train;

    public Ticket(){};
    public Ticket(String ticketId, String userId, String source, String destination,
                  String dateOfTravel, Train train){
        this.ticketId=ticketId;
        this.userId=userId;
        this.source=source;
        this.destination=destination;
        this.dateOfTravel=dateOfTravel;
        this.train=train;
    }

    private String getTicketId(){
        return ticketId;
    }

    private String getUserId(){
        return userId;
    }
    private String getSource(){
        return source;
    }
    private String getDestination(){
        return destination;
    }
    private String getDateOfTravel(){
        return dateOfTravel;
    }
    private Train getTrain(){
        return train;
    }

    private void setTicketId(String ticketId){
        this.ticketId=ticketId;
    }
    private void setUserId(String userId){
        this.userId=userId;
    }
    private void setDestination(String destination){
        this.destination=destination;
    }
    private void setSource(String source){
        this.source=source;
    }
    private void setDateOfTravel(String dateOfTravel){
        this.dateOfTravel=dateOfTravel;
    }
    private void setTrain(Train train){
        this.train=train;
    }

    public String getTicketInfo(){
        return String.format("Ticket Id:%s belongs to User %s from %s to %s on %s",ticketId,userId,source,destination);
    }

}
