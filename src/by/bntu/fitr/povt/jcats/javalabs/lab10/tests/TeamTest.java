package by.bntu.fitr.povt.jcats.javalabs.lab10.tests;

import by.bntu.fitr.povt.jcats.javalabs.lab10.models.Employee;
import by.bntu.fitr.povt.jcats.javalabs.lab10.models.Job;
import by.bntu.fitr.povt.jcats.javalabs.lab10.models.Person;
import by.bntu.fitr.povt.jcats.javalabs.lab10.models.Team;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeamTest {

    @Test
    public void canAddTeammate() {
        Team team = new Team();
        Employee employee1 = new Employee(new Person("SomeName1", 20), new Job("Design", 2000), 0.9);
        Employee employee2 = new Employee(new Person("SomeName2", 20), new Job("Mobile", 2000), 0.9);

        team.addTeammate(employee1);
        team.addTeammate(employee2);

        Employee[] expected = { employee1, employee2 };
        var actual = team.getTeammates();

        assertArrayEquals(actual, expected);
    }

    @Test
    public void canRemoveTeammate() {
        Team team = new Team();
        Employee employee1 = new Employee(new Person("SomeName1", 21), new Job("Design", 2000), 0.9);
        Employee employee2 = new Employee(new Person("SomeName2", 21), new Job("Mobile", 2000), 0.9);

        team.addTeammate(employee1);
        team.addTeammate(employee2);

        Employee[] expected = {employee1};

        team.removeTeammate(employee2);

        var actual = team.getTeammates();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void canGetTeammates() {
        Team team = new Team();
        Employee employee1 = new Employee(new Person("SomeName11", 21), new Job("Design", 2000), 0.9);
        Employee employee2 = new Employee(new Person("SomeName22", 21), new Job("Mobile", 2000), 0.9);

        team.addTeammate(employee1);
        team.addTeammate(employee2);

        team.removeTeammate(employee2);

        Employee[] expected = { employee1 };
        var actual = team.getTeammates();

        assertArrayEquals(expected, actual);
    }
}