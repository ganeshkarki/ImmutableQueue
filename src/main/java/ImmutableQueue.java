import java.util.ArrayDeque;

/**
 * Immutable implementation of {@link Queue} interface. It uses {@link ArrayDeque}
 * to store the queue elements. For <tt>enQueue</tt> and <tt>deQueue</tt> operation,
 * it reuses the <tt>elementData</tt> property applies modification and return new
 * ImmutableQueue instance.
 *
 * @param <T> the type of elements held in the Queue
 * @author Karki Ganesh
 */
public class ImmutableQueue<T> implements Queue<T> {

    private final ArrayDeque<T> elementData;

    public ImmutableQueue() {
        elementData = new ArrayDeque<T>();
    }

    private ImmutableQueue(ArrayDeque<T> elementData) {
        this.elementData = elementData;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Queue enQueue(T t) {
        ArrayDeque<T> newElementData = elementData.clone();
        newElementData.addLast(t);
        return new ImmutableQueue(newElementData);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Queue deQueue() {
        ArrayDeque<T> newElementData = elementData.clone();
        newElementData.removeFirst();
        return new ImmutableQueue(newElementData);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T head() {
        return elementData.getFirst();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return elementData.isEmpty();
    }
}
