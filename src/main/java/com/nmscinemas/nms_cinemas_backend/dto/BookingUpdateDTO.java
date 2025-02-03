package com.nmscinemas.nms_cinemas_backend.dto;

public class BookingUpdateDTO {
    private int numberOfTickets;

    public BookingUpdateDTO() {}

    public BookingUpdateDTO(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }
}

