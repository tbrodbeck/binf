package blatt06;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * A simple linked list. One may go through this list by {@link #advance()}
 * until the last position ({@link #endpos()}) is reached. One also may
 * {@link #delete()} and {@link #add(Object)} elements. After advancing it is
 * possible to go back to the beginning by {@link #reset()}.
 * 
 * @author Mathias Menninghaus (mathias.menninghaus@uos.de)
 * 
 */
public class MyList<E> implements Cloneable, Iterable<E> {

   /**
    * Reference on the first Entry of this List
    */
   private MyEntry<E> begin;
   /**
    * References before the actual Entry of this List
    */
   private MyEntry<E> pos;

   private int zustand;
   /**
    * Create a new empty List.
    */
   public MyList() {
      pos = begin = new MyEntry<E>();
      zustand = 0;
   }

   /**
    * Determines if this List is empty or not.
    * 
    * @return <code>true</code>, if there are no elements in this List
    */
   public boolean empty() {
      return begin.next == null;
   }

   /**
    * Determines if it is possible to {@link #advance()} in this List. Returns
    * <code>true</code> if the last position of this List has been reached. An
    * {@link #empty()} List will alway deliver <code>true</code>
    * 
    * @return <code>true</code> if the last Entry in this List already has been
    *         reached.
    */
   public boolean endpos() { // true, wenn am Ende
      return pos.next == null;
   }

   /**
    * Returns to the beginning of this List.
    */
   public void reset() {
      pos = begin;
   }

   /**
    * Advances one step in this List.
    * 
    * @throws NoSuchElementException
    *            if the last Entry of this List already has been reached.
    */
   public void advance() {
      if (endpos()) {
         throw new NoSuchElementException("Already at the end of this List");
      }
      pos = pos.next;
   }

   /**
    * Returns the actual element of this List.
    * 
    * @return the actual element
    * 
    * @throws RuntimeException
    *            if the last Entry of this List already has been reached.
    */
   public E elem() {
      if (endpos()) {
         throw new NoSuchElementException("Already at the end of this List");
      }
      return pos.next.o;
   }

   /**
    * Inserts <code>o</code> in this List. It will be placed before the actual
    * element. After insertion the inserted element will become the actual
    * element.
    * 
    * @param x
    *           the element to be inserted
    */
   public void add(E x) {
      MyEntry<E> newone = new MyEntry<E>(x, pos.next);
      pos.next = newone;
      zustand++;
   }

   /**
    * Deletes the actual element of this List. The element after the actual
    * element will become the new actual element.
    * 
    * @throws NoSuchElementException
    *            if the last Entry of this List already has been reached.
    */
   public void delete() {
      if (endpos()) {
         throw new NoSuchElementException("Already at the end of this List");
      }
      pos.next = pos.next.next;
      zustand++;
   }

   /**
    * Clones this MyList. Will create a new independent MyList which actual
    * position lies at the beginning of this MyList. This clone operation also
    * fulfills the optional requirements defined by the {@link Object#clone()}
    * operation. NOTE: Inserted elements will not be cloned, due to the fact,
    * that the {@link Object#clone()} is <code>protected</code>.
    * 
    * @see Object#clone()
    */
   public MyList<E> clone() {
      try {

         MyList<E> clone = (MyList<E>) super.clone();
         clone.begin = this.begin.clone();
         clone.pos = clone.begin;

         return clone;
      } catch (CloneNotSupportedException e) {
         throw new InternalError();
      }
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((begin == null) ? 0 : begin.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      MyList other = (MyList) obj;
      if (!begin.equals(other.begin))
         return false;
      return true;
   }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator(zustand);
    }

    private class Iterator<E> implements java.util.Iterator<E> {

       private int anfangszustand;
       private MyEntry<E> position;
       private MyEntry<E> vorheriger;

       public Iterator(int anfangszustand) {
          this.anfangszustand = anfangszustand;
          position = (MyEntry<E>) begin;
          vorheriger = null;
       }

       public boolean hasNext() {
          return !(position == null);
       }

       public E next() {
          if(anfangszustand!=zustand) throw new java.util.ConcurrentModificationException("die Orignalliste wurde bearbeitet");
          if (!hasNext()) throw new NoSuchElementException("es gibt keine weiteren Elemente");
          vorheriger = position;
          position = position.next;
          return position.o;
       }

       public void remove() {
          if(anfangszustand!=zustand) throw new java.util.ConcurrentModificationException("die Originalliste wurde bearbeitet");
          if(vorheriger == null) throw new IllegalStateException("pro next darf remove nur einmal aufgerufen werden");
          vorheriger.next = position.next; //aus Originalliste löschen
          position = vorheriger;
          vorheriger = null;
          anfangszustand++;
       }
    }
    /**
     * Performs the given action for each element of the {@code Iterable}
     * until all elements have been processed or the action throws an
     * exception.  Unless otherwise specified by the implementing class,
     * actions are performed in the order of iteration (if an iteration order
     * is specified).  Exceptions thrown by the action are relayed to the
     * caller.
     *
     * @param action The action to be performed for each element
     * @throws NullPointerException if the specified action is null
     * @implSpec <p>The default implementation behaves as if:
     * <pre>{@code
     *     for (T t : this)
     *         action.accept(t);
     * }</pre>
     * @since 1.8
     */
    @Override
    public void forEach(Consumer<? super E> action) {

    }

    /**
     * Creates a {@link Spliterator} over the elements described by this
     * {@code Iterable}.
     *
     * @return a {@code Spliterator} over the elements described by this
     * {@code Iterable}.
     * @implSpec The default implementation creates an
     * <em><a href="Spliterator.html#binding">early-binding</a></em>
     * spliterator from the iterable's {@code Iterator}.  The spliterator
     * inherits the <em>fail-fast</em> properties of the iterable's iterator.
     * @implNote The default implementation should usually be overridden.  The
     * spliterator returned by the default implementation has poor splitting
     * capabilities, is unsized, and does not report any spliterator
     * characteristics. Implementing classes can nearly always provide a
     * better implementation.
     * @since 1.8
     */
    @Override
    public Spliterator<E> spliterator() {
        return null;
    }
}