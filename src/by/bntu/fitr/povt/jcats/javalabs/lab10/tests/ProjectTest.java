package by.bntu.fitr.povt.jcats.javalabs.lab10.tests;

import by.bntu.fitr.povt.jcats.javalabs.lab10.models.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProjectTest {

    @Test
    public void isComplete() {

        HandMadeList<ApplicationPart> appPartsList =
                new HandMadeList<>();

        appPartsList.add(new ApplicationPart("Design"));
        appPartsList.add(new ApplicationPart("Mobile"));

        Application app1 = new Application("Part ", appPartsList );

        for (ApplicationPart part: app1.parts) {
            part.complete(1);
        }

        assertTrue(app1.isComplete());
    }
}