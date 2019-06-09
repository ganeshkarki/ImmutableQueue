import java.util.NoSuchElementException;

/**
 * The <code>Queue</code> interface represents a first-in-first-out
 * (FIFO) queue of objects. It is used by <tt>ImmutableQueue</tt>
 * implementation to indicate that the queue is immutable and both
 * <tt>enQueue</tt> and <tt>deQueue</tt> operation returns an immutable
 * {@link ImmutableQueue} object.
 * <p>
 * The <tt>head</tt> operation returns the current element at head
 * position that will get de-queued first.
 * <p>
 * The <tt>isEmpty</tt> operation allows to check if the queue is empty.
 * <p>
 * When a queue is first created, it contains no items.
 *
 * @param <T> the type of elements held in the Queue
 * @author Karki Ganesh
 */
public interface Queue<T> {
    /**
     * Inserts element at the end of a queue
     *
     * @param t the element to add
     * @return {@link Queue} after adding new element
     */
    public Queue<T> enQueue(T t);

    /**
     * Removes element from the head of the queue and returns new {@link Queue} after deleting element
     *
     * @return new {@link Queue} after deleting element
     * @throws NoSuchElementException
     */
    public Queue<T> deQueue() throws NoSuchElementException;

    /**
     * Returns element at the front of queue without removing it
     *
     * @return the object at the front of queue or null if queue is empty
     * @throws NoSuchElementException
     * @// TODO: 2019-06-09   Consider if it should return null instead
     */
    public T head() throws NoSuchElementException;

    /**
     * Checks if queue is empty
     *
     * @return <code>true</code> if queue contains no items; <code>false</code> otherwise.
     */
    public boolean isEmpty();
}