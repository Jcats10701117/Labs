package by.bntu.fitr.povt.jcats.javalabs.lab10.tests;

import by.bntu.fitr.povt.jcats.javalabs.lab10.models.Application;
import by.bntu.fitr.povt.jcats.javalabs.lab10.models.ApplicationPart;
import by.bntu.fitr.povt.jcats.javalabs.lab10.models.HandMadeList;
import org.junit.Test;

import static org.junit.Assert.*;

public class ApplicationTest {


    @Test
    public void canAppComplete() {
        HandMadeList<ApplicationPart> appPartsList =
                new HandMadeList<>();

        appPartsList.add(new ApplicationPart("Design"));
        appPartsList.add(new ApplicationPart("Mobile"));

        Application app = new Application("Part", appPartsList );

        for (ApplicationPart part: app.parts) {
            part.complete(1);
        }

        assertTrue(app.isComplete());
    }
}
