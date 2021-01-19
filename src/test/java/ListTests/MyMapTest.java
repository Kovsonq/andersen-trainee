package ListTests;

import collections.MyMap.MyMap;
import org.junit.Assert;
import org.junit.Test;

public class MyMapTest {
    MyMap<Integer, String> myMap = new MyMap<>();

    @Test
    public void testPutPair() {
        for (int i = 0; i < 10; i++) {
            myMap.put(1, String.valueOf(i));
        }
        Assert.assertEquals("9", myMap.get(1));
        Assert.assertEquals(1, myMap.size());
    }

    @Test
    public void testGetValue() {
        for (int i = 0; i < 10; i++) {
            myMap.put(i, String.valueOf(i));
        }
        Assert.assertEquals("5", myMap.get(5));
        Assert.assertEquals("1", myMap.get(1));
        Assert.assertEquals(10, myMap.size());
    }

    @Test
    public void testEnsureCapacity() {
        for (int i = 0; i < 17; i++) {
            myMap.put(i, String.valueOf(i));
        }
        Assert.assertEquals(17, myMap.size());
    }

    @Test
    public void testRemoveElement() {
        for (int i = 0; i < 10; i++) {
            myMap.put(i, String.valueOf(i));
        }
        Assert.assertEquals("0", myMap.get(0));
        Assert.assertEquals(10, myMap.size());
        myMap.remove(0);
        Assert.assertNull(myMap.get(0));
        Assert.assertEquals(9, myMap.size());
    }

    @Test
    public void testContainsKey() {
        for (int i = 0; i < 10; i++) {
            myMap.put(i, String.valueOf(i));
        }
        Assert.assertTrue(myMap.containsKey(0));
        myMap.remove(0);
        Assert.assertFalse(myMap.containsKey(0));
    }

    @Test
    public void testContainsValue() {
        for (int i = 0; i < 10; i++) {
            myMap.put(i, String.valueOf(i));
        }
        Assert.assertTrue(myMap.containsValue("0"));
        myMap.remove(0);
        Assert.assertFalse(myMap.containsValue("0"));
    }

}
