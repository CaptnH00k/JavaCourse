package onedgame;

import java.util.Stack;

/**
 * A Stack Datastrucute which only holds maxSize entries.
 * If stack is full, first element will be dropped
 * @author Leon Gnädinger
 *
 * @param <T>
 */
public class SizedStack<T> extends Stack<T> {
	private static final long serialVersionUID = 1L;
	private int maxSize;

	/**
	 * Constructor for SizedStack.
	 * maxSize sets how many items this stack should be capable
	 * to hold.
	 * @param maxSize
	 */
    public SizedStack(int maxSize) {
        super();
        this.maxSize = maxSize;
    }

    @Override
    public T push(T object) {
    	// As long as the stack is full, we remove the first element.
    	// Normally we should be done after one iteration, but this will
    	// keep things save.
        while (this.size() >= maxSize) {this.remove(0);}
        return super.push(object);
    }
}