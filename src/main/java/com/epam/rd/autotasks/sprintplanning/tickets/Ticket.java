package com.epam.rd.autotasks.sprintplanning.tickets;

public class Ticket {

    protected final int id;
    protected final String name;
    protected final int estimate;
    protected boolean complete;

    public Ticket(int id, String name, int estimate) {
        this.id = id;
        this.name = name;
        this.estimate = estimate;
        this.complete = false;

    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public boolean isCompleted() {
        return this.complete;
    }

    public void complete() {
        this.complete = true;
    }

    public int getEstimate() {
        return this.estimate;
    }
}
