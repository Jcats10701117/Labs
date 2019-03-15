package by.bntu.fitr.povt.jcats.javalabs.lab10.tests;

import by.bntu.fitr.povt.jcats.javalabs.lab10.models.ApplicationPart;
import org.junit.Test;

import static org.junit.Assert.*;

public class ApplicationPartTest {

    @Test
    public void isComplete() {
        ApplicationPart appPart = new ApplicationPart("Part");

        appPart.complete(1);

        assertTrue(appPart.isComplete());
    }


}