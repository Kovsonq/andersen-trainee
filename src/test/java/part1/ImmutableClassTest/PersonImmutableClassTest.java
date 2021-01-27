package part1.ImmutableClassTest;

import part1.immutableclass.PersonImmutableClass;
import org.junit.Assert;
import org.junit.Test;

public class PersonImmutableClassTest {

    @Test
    public void personImmutableTest() {
        int currentAge = 23;
        String currentName = "Alex";
        String[] currentAddress = {"Bedy, 9", "Coolman, 23"};
        String[] forTest = currentAddress.clone();

        PersonImmutableClass person = new PersonImmutableClass(currentAge,currentName,currentAddress);

        currentAge = 55;
        currentName = "Ivan";
        currentAddress[0] = "Pobedy, 2021";

        Assert.assertEquals(23,person.getAge());
        Assert.assertEquals("Alex",person.getName());
        Assert.assertEquals(forTest, person.getAddress());

        //try To Get Reference For The Original Array
        String[] referenceArray  = person.getAddress();
        referenceArray[0] = "Lost, 2020";
        Assert.assertEquals(forTest, person.getAddress());
    }
}
