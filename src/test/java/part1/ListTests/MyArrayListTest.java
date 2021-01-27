package part1.ListTests;

import part1.collections.list.MyList;
import part1.collections.list.arraylist.MyArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyArrayListTest {
    //try to use Interface but not class
    MyList<Integer> arrayList;
    int sizeBefore;

    @Before // = @BeforeEach;   @BeforeAll=@BeforeClass
    public void init(){
        arrayList = new MyArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        sizeBefore = arrayList.size();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    // expected - for Exceptions; timeout - for operation available time
    public void testIndexOutOf(){
        arrayList.get(5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveElement(){
        arrayList.remove(0);
        arrayList.remove(-1);
        Assert.assertNotEquals(sizeBefore,arrayList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testNegativeIndexOutOf(){
        arrayList.get(-1);
    }

    @Test
    public void testGetElement(){
        Assert.assertEquals(1,(int) arrayList.get(0));
    }

    @Test
    public void testAddElement(){
        Assert.assertEquals(1, (int) arrayList.get(0));
        arrayList.add(0,100);
        Assert.assertNotEquals(1, (int) arrayList.get(0));
        Assert.assertNotEquals(sizeBefore,arrayList.size());
    }

    @Test
    public void testSetElement(){
        Assert.assertEquals(1, (int) arrayList.get(0));
        arrayList.set(0,100);
        Assert.assertNotEquals(1, (int) arrayList.get(0));
        Assert.assertEquals(sizeBefore,arrayList.size());
    }

    @Test
    public void testIndexOfElement(){
        Assert.assertEquals(0,arrayList.indexOf(1));
        arrayList.remove(0);
        Assert.assertEquals(-1,arrayList.indexOf(1));
    }

    @Test
    public void testEnsureCapacity(){
        int element = 10;
        for (int i = 0; i < element; i++) {
            arrayList.add(i);
        }
        Assert.assertEquals(sizeBefore + element, arrayList.size());
    }

}
