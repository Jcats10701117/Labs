package by.bntu.fitr.povt.jcats.javalabs.lab10.models;

public class Project {
    public final String name;
    public final Application application;

    public Project(Order order) {
        this.name = order.projectName;
        var appParts = new HandMadeList<ApplicationPart>();
        for (var appPartName: order.appPartsNames) {
            appParts.add(new ApplicationPart(appPartName));
        }
        this.application = new Application(order.appName, appParts);
    }

    public boolean isComplete() {
        return application.getReadiness() == 1;
    }
}
