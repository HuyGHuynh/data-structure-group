package question1;

public interface Iterator<E> {
	boolean hasNext();
	E next();
	void remove();
}
