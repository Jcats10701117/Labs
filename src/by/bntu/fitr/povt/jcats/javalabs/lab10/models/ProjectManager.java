package by.bntu.fitr.povt.jcats.javalabs.lab10.models;

public class ProjectManager {
    public final Person person;
    private Team currentTeam;
    private Project currentProject;

    public ProjectManager(Person person) {
        this.person = person;
    }

    public Team getCurrentTeam() { return currentTeam; }

    public void setCurrentTeam(Team team) { currentTeam = team; }

    public void setCurrentProject(Project project) {
        currentProject = project;
    }

    public Project getCurrentProject() {
        return currentProject;
    }

    public void startWorkDay() {
        if (currentTeam == null) {
            return;
        }
        for (var teammate: currentTeam.getTeammates()) {
            teammate.completeWork(currentProject.application);
        }
    }
}
