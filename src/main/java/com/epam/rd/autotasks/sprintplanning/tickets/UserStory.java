package com.epam.rd.autotasks.sprintplanning.tickets;

public class UserStory extends Ticket {
    public final UserStory [] dependsOn;

    public UserStory(int id, String name, int estimate, UserStory... dependsOn) {
        super(id, name, estimate);
        this.dependsOn = dependsOn;
    }

    @Override
    public void complete() {
        if (dependsOn == null) { //нет зависимостей - завершить
        this.complete = true;
        }
        else {                   //проверка каждой зависимости на завершенность
            for (int i = 0; i < dependsOn.length; i++) {
                if (dependsOn[i].isCompleted()) continue;
               else return;
            } this.complete = true;
        }
    }

    public UserStory[] getDependencies() {
        return dependsOn.clone();
    }

    @Override
    public String toString() {
        return "[US " + this.id + "] " + this.name;
    }
}
