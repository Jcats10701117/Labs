package by.bntu.fitr.povt.jcats.javalabs.lab10.models;

import java.util.Collection;

public class Application {
    public Collection<ApplicationPart> parts;

    public final String name;

    public Application(String name, Collection<ApplicationPart> parts){
        this.parts = parts;
        this.name = name;
    }

    public double getReadiness() {
        double readiness = 0;

        for (ApplicationPart part: parts) {
            readiness += part.getState() / parts.size();
        }

        return readiness;
    }

    public boolean isComplete() {
        return getReadiness() == 1;
    }
}
