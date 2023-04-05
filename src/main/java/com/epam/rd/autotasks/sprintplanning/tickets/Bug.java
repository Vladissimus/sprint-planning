package com.epam.rd.autotasks.sprintplanning.tickets;

public class Bug extends Ticket {
    String USName;

    public static Bug createBug(int id, String name, int estimate, UserStory userStory) {
        if (userStory==null || !userStory.complete){
            return null;
        } else {
            return new Bug(id,name,estimate,userStory);
        }
    }

    private Bug(int id, String name, int estimate, UserStory userStory) {
        super(id, name, estimate);
        USName = userStory.name;
    }

    @Override
    public String toString() {
        return "[Bug " + this.id + "] " + USName + ": " + this.name;
    }
}