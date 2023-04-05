package com.epam.rd.autotasks.sprintplanning;

import com.epam.rd.autotasks.sprintplanning.tickets.Bug;
import com.epam.rd.autotasks.sprintplanning.tickets.Ticket;
import com.epam.rd.autotasks.sprintplanning.tickets.UserStory;

public class Sprint {
    private Ticket [] sprints;
    private int addCount;
    private int time;
    private final int capacity1;
    private final int ticketsLimit1;

    public Sprint(int capacity, int ticketsLimit) {
        sprints = new Ticket[ticketsLimit];
        capacity1 = capacity;
        ticketsLimit1 = ticketsLimit;
    }

    public boolean addUserStory(UserStory userStory) {
        if (userStory == null || userStory.isCompleted() || addCount>=ticketsLimit1 || (capacity1<time + userStory.getEstimate())) {
            return false;
        }
        else if (userStory.dependsOn.length == 0) {    //нет зависимостей - добавить
            sprints[addCount++] = userStory;
            time+=userStory.getEstimate();
            return true;
        }
        else {                                      //иначе проверить наличие зависимотей в Спринте
            int dependencyInArray = 0;
            for (Ticket sprint : sprints) {         // цикл зависимостей и цикл сспринта перебираем на совпадение
                for (int i1 = 0; i1 < userStory.dependsOn.length; i1++) {
                    if (sprint == userStory.dependsOn[i1]) {
                        dependencyInArray++;
                    }
                }
            }
            if (dependencyInArray == userStory.dependsOn.length) {
                sprints[addCount++] = userStory;
                time += userStory.getEstimate();
                return true;
            }
        }
        return false;
    }

    public boolean addBug(Bug bugReport) {
        if (bugReport == null || bugReport.isCompleted() || addCount>=ticketsLimit1 || (capacity1<time + bugReport.getEstimate())){
            return false;
        } else{
            sprints[addCount++] = bugReport;
            time+= bugReport.getEstimate();
            return true;
        }
    }

    public Ticket[] getTickets() {
        Ticket [] sprints1 = new Ticket[addCount];
        for (int i = 0; i < sprints1.length; i++) {
            sprints1[i] = sprints[i];
        }
        return sprints1;
    }

    public int getTotalEstimate() {
        return time;
    }
}
