import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Test class for {@link ImmutableQueue}
 *
 * @author Karki Ganesh
 */
public class ImmutableQueueTest {

    @Test
    public void enQueue_emptyQueue_insertFirstElement_doesNotMutateQueue() {
        ImmutableQueue q = new ImmutableQueue();
        Queue modifiedQueue = q.enQueue("first_element");
        assertTrue(q.isEmpty());
        assertFalse(modifiedQueue.isEmpty());
        assertThat(modifiedQueue.head(), is("first_element"));
    }

    @Test
    public void enQueue_emptyQueue_insertMultipleElements_doesNotMutates() {
        Queue q = new ImmutableQueue();

        q.enQueue("first_element");
        q.enQueue("second_element");
        q.enQueue("third_element");

        assertTrue(q.isEmpty());
    }

    @Test
    public void enQueue_emptyQueue_insertionOnSubsequentQueues_retainOldQueueElements() {
        ImmutableQueue q = new ImmutableQueue();

        Queue firstQueue = q.enQueue("first_element");
        Queue secondQueue = firstQueue.enQueue("second_element");
        Queue thirdQueue = secondQueue.enQueue("third_element");

        // Does not Mutates
        assertTrue(q.isEmpty());
        assertFalse(firstQueue.isEmpty());
        assertFalse(secondQueue.isEmpty());
        assertFalse(thirdQueue.isEmpty());

        // Subsequent queues contains incremental elements
        assertThat(firstQueue.head(), is("first_element"));
        assertThat(secondQueue.head(), is("first_element"));
        assertThat(thirdQueue.head(), is("first_element"));

        String[] a = new String[]{"first_element", "second_element", "third_element"};
        ImmutableQueue tmpQueue = (ImmutableQueue) thirdQueue;
        for (String s : a) {
            assertThat(tmpQueue.head(), is(s));
            tmpQueue = (ImmutableQueue) tmpQueue.deQueue();
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void deQueue_emptyQueue_throwsException() {
        ImmutableQueue q = new ImmutableQueue();
        q.deQueue();
    }

    @Test
    public void deQueue_returnsQueueWithUpdatedHead() {
        Queue q = new ImmutableQueue()
                .enQueue("first_element")
                .enQueue("second_element");

        Queue q1 = q.deQueue();
        assertThat(q1.head(), is("second_element"));
    }

    @Test
    public void deQueue_doesNotMutates() {
        Queue q = new ImmutableQueue().enQueue("only_element");
        q.deQueue();
        q.deQueue();
        q.deQueue();

        // Does not de-queues on the same instance
        assertThat(q.head(), is("only_element"));
    }

    @Test(expected = NoSuchElementException.class)
    public void head_emptyQueue_throwsException() {
        ImmutableQueue q = new ImmutableQueue();
        q.head();
    }

    @Test
    public void head_returnsHeadElement() {
        String[] elements = new String[]{"first", "second", "third"};
        ImmutableQueue q = (ImmutableQueue) new ImmutableQueue()
                .enQueue("first")
                .enQueue("second")
                .enQueue("third");

        for (String s : elements) {
            assertThat(q.head(), is(s));
            q = (ImmutableQueue) q.deQueue();
        }
    }

    @Test
    public void isEmpty_emptyQueue() {
        ImmutableQueue q = new ImmutableQueue();
        assertTrue(q.isEmpty());
    }

    @Test
    public void isEmpty_notEmptyQueue() {
        ImmutableQueue q = (ImmutableQueue) new ImmutableQueue().enQueue("first");
        assertFalse(q.isEmpty());

        q = (ImmutableQueue) q.deQueue();
        assertTrue(q.isEmpty());
    }
}