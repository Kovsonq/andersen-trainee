package ListTests;

import collections.MyQueue.MyQueue;
import org.junit.Assert;
import org.junit.Test;

public class MyQueueTest {

    @Test(expected = IllegalStateException.class)
    public void testQueueIsFullForAdd(){
        MyQueue<Integer> queue = new MyQueue<>(5);
        for (int i = 0; i < 6; i++) {
            queue.add(i);
        }
    }

    @Test(expected = IllegalStateException.class)
    public void testQueueIsEmptyForRemove(){
        MyQueue<Integer> queue = new MyQueue<>(5);
        queue.remove();
    }

    @Test
    public void testQueueRemove(){
        MyQueue<Integer> queue = new MyQueue<>(5);
        for (int i = 0; i < 5; i++) {
            queue.add(i);
        }
        Assert.assertEquals(0, queue.remove());
        Assert.assertEquals(1, queue.remove());
        queue.add(5);
        Assert.assertEquals(2, queue.remove());
        Assert.assertEquals(3, queue.remove());
        Assert.assertEquals(4, queue.remove());
        Assert.assertEquals(5, queue.remove());
        Assert.assertEquals(0, queue.size());
    }

    @Test
    public void testQueuePollFrontReturnNullIfEmpty(){
        MyQueue<Integer> queue = new MyQueue<>(5);
        Assert.assertNull(queue.pollFront());
        Assert.assertEquals(0, queue.size());
    }

    @Test
    public void testQueuePollFront(){
        MyQueue<Integer> queue = new MyQueue<>(5);
        for (int i = 0; i < 5; i++) {
            queue.add(i);
        }
        Assert.assertEquals(0, queue.pollFront());
        Assert.assertEquals(1, queue.pollFront());
        queue.add(5);
        Assert.assertEquals(2, queue.pollFront());
        Assert.assertEquals(3, queue.pollFront());
        Assert.assertEquals(4, queue.pollFront());
        Assert.assertEquals(5, queue.pollFront());
        Assert.assertEquals(0, queue.size());
    }

    @Test
    public void testQueuePeakFrontReturnNullIfEmpty(){
        MyQueue<Integer> queue = new MyQueue<>(5);
        Assert.assertNull(queue.peekFront());
        Assert.assertEquals(0, queue.size());
    }

    @Test(expected = IllegalStateException.class)
    public void testQueuePeakFront(){
        MyQueue<Integer> queue = new MyQueue<>(5);
        for (int i = 0; i < 5; i++) {
            queue.add(i);
        }
        Assert.assertEquals(0, queue.peekFront());
        Assert.assertEquals(0, queue.peekFront());
        queue.add(5);
    }

}
