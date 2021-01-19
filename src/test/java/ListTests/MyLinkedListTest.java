package ListTests;

import collections.list.linkedlist.MyLinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyLinkedListTest {
    MyLinkedList<Integer> linkedList;
    int sizeBefore;

    @Before // = @BeforeEach;   @BeforeAll=@BeforeClass
    public void init(){
        linkedList = new MyLinkedList<Integer>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        sizeBefore = linkedList.size();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    // expected - for Exceptions; timeout - for operation available time
    public void testIndexOutOfList(){
        linkedList.get(3);
        linkedList.remove(3);
        linkedList.get(3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetNegativeIndex(){
        linkedList.get(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDelete(){
        linkedList.remove(0);
        linkedList.remove(-1);
        Assert.assertNotEquals(sizeBefore,linkedList.size());
    }

    @Test
    public void testAddLast(){
        linkedList.add(5);
        Assert.assertEquals(4, (int) linkedList.indexOf(5));
        Assert.assertNotEquals(sizeBefore,linkedList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddByIndex(){
        Assert.assertEquals(1, (int) linkedList.get(0));
        linkedList.add(-1,100);
        linkedList.add(0,100);
        Assert.assertNotEquals(1, (int) linkedList.get(0));
        Assert.assertNotEquals(sizeBefore,linkedList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSet(){
        Assert.assertEquals(1, (int) linkedList.get(0));
        linkedList.set(-1,100);
        linkedList.set(0,100);
        Assert.assertNotEquals(1, (int) linkedList.get(0));
        Assert.assertEquals(sizeBefore,linkedList.size());
    }

    @Test
    public void testIndexOf(){
        Assert.assertEquals(0,linkedList.indexOf(1));
        linkedList.remove(0);
        Assert.assertEquals(-1,linkedList.indexOf(1));
    }

    @Test
    public void testAddFirst(){
        Assert.assertEquals(0,linkedList.indexOf(1));
        linkedList.addFirst(100);
        Assert.assertEquals(0,linkedList.indexOf(100));
        Assert.assertNotEquals(sizeBefore,linkedList.size());
    }

    @Test
    public void testDeleteFirst(){
        Assert.assertEquals(0,linkedList.indexOf(1));
        linkedList.deleteFirst();
        Assert.assertEquals(-1,linkedList.indexOf(1));
        Assert.assertEquals(0,linkedList.indexOf(2));
        Assert.assertNotEquals(sizeBefore,linkedList.size());
    }

    @Test
    public void testDeleteLast(){
        Assert.assertEquals(3,linkedList.indexOf(4));
        linkedList.deleteLast();
        Assert.assertEquals(-1,linkedList.indexOf(4));
        Assert.assertNotEquals(sizeBefore,linkedList.size());
    }

}
