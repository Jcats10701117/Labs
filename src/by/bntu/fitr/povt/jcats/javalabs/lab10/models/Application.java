package by.bntu.fitr.povt.jcats.javalabs.lab10.models;
import java.util.Iterator;

public class Application {
    public HandMadeList<ApplicationPart> parts;

    public final String name;

    public Application(String name, HandMadeList<ApplicationPart> parts){
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
