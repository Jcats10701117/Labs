package by.bntu.fitr.povt.jcats.javalabs.lab10.models;

import java.util.Collection;

public class Team {
    public Team() {
        teammates = new HandMadeList<>();
    }
    private Collection<Employee> teammates;

    public void addTeammate(Employee employee) {
        teammates.add(employee);
    }

    public void removeTeammate(Employee employee) {
        if (teammates.contains(employee)) {
            teammates.remove(employee);
        }
    }

    public Employee[] getTeammates() {
        return (Employee[]) teammates.toArray();
    }
}
