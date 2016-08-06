package com.raychen518.study.java.collections;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Deque;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.PriorityQueue;
import java.util.Properties;
import java.util.Queue;
import java.util.Random;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

import com.raychen518.study.java._util.Utils;

/**
 * <pre>
 * This class introduces the collections framework.
 * 
 * Contents
 * =========================================================
 * - Overview
 * - Collection Hierarchy
 * - Class/Interface Summary
 * - Class/Interface Details
 *   - java.util.Collection<E>
 *   - java.util.List<E>
 *   - java.util.ArrayList<E>
 *   - java.util.LinkedList<E>
 *   - java.util.Vector<E>
 *   - java.util.Stack<E>
 *   - java.util.Set<E>
 *   - java.util.HashSet<E>
 *   - java.util.SortedSet<E>
 *   - java.util.NavigableSet<E>
 *   - java.util.TreeSet<E>
 *   - java.util.Queue<E>
 *   - java.util.PriorityQueue<E>
 *   - java.util.Deque<E>
 *   - java.util.ArrayDeque<E>
 *   - java.util.Map<K, V>
 *   - java.util.HashMap<K, V>
 *   - java.util.Hashtable<K, V>
 *   - java.util.Properties
 *   - java.util.SortedMap<K, V>
 *   - java.util.NavigableMap<K, V>
 *   - java.util.TreeMap<K, V>
 *   - java.lang.Iterable<E>
 *   - java.util.Iterator<E>
 *   - java.util.ListIterator<E>
 *   - java.util.Enumeration<E>
 *   - java.util.RandomAccess
 *   - java.util.AbstractCollection<E>
 *   - java.util.AbstractList<E>
 *   - java.util.AbstractSequentialList<E>
 *   - java.util.AbstractSet<E>
 *   - java.util.AbstractQueue<E>
 *   - java.util.AbstractMap<K, V>
 *   - java.util.Dictionary<K, V>
 *   - java.util.Collections
 * - Misc
 *   - Ways to Iterate over the Collection
 *     - Using the Iterator Object
 *     - Using the forEach Statement (Recommended)
 *     - Using the Enumeration Object
 *   - Bulk Operations
 *     - Find the Intersection
 *     - Remove Parts
 *     - Use Views
 *   - Conversion between Arrays and Collections
 * =========================================================
 * 
 * - Overview
 *   - A collection represents a group of objects, known as its elements.
 *   - Some collections are ordered and others are unordered. 
 *   - Some collections allow duplicate elements and others do not.
 * 
 * - Collection Hierarchy
 *   Note: The sign "~" here means the corresponding interface/class is indirectly implementing/extending its supertype here.
 * 
 * 								--------- java.lang.Iterable<E>						java.util.Iterator<E>		java.util.AbstractCollection<E>
 * 								|													java.util.ListIterator<E>	java.util.AbstractList<E>
 * 						java.util.Collection<E>										java.util.Enumeration<E>	java.util.AbstractSequentialList<E>
 * 							|			|											java.util.RandomAccess		java.util.AbstractSet<E>
 * 					---------			-----------------------------------------								java.util.AbstractQueue<E>
 * 					|								|							|
 * 			java.util.List<E>				java.util.Set<E>			java.util.Queue<E>
 * 					|-----------|-------|			|---------------|			|-------------------------------|
 * 		java.util.ArrayList<E>	|		|	java.util.HashSet<E>	|	java.util.PriorityQueue<E> ~	java.util.Deque<E>
 * 								|		|							|						|-------------------|----------------|
 * 				java.util.LinkedList<E>	|				java.util.SortedSet<E>		java.util.LinkedList<E>				java.util.ArrayDeque<E>
 * 										|							|
 * 								java.util.Vector<E>		java.util.NavigableSet<E>
 * 										|							|
 * 								java.util.Stack<E>			java.util.TreeSet<E>
 * 
 * 																					java.util.Collections
 * 
 * 		++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * 
 * 						java.util.Map<K, V>																		java.util.AbstractMap<K, V>
 * 				|---------------|---------------|-------------------------------|								java.util.Dictionary<K, V>
 * 		java.util.HashMap<K, V>		java.util.Hashtable<K, V>		java.util.SortedMap<K, V>
 * 												|								|
 * 										java.util.Properties		java.util.NavigableMap<K, V>
 * 																				|
 * 																		java.util.TreeMap<K, V>
 * 
 * - Class/Interface Summary
 *   Class/Interface					Brief
 *   -------------------------------------------------------------------------------------------------------------------
 *   java.util.Collection<E>			The root interface in the collection hierarchy.
 * 
 *   java.util.List<E>					An interface that represents an ordered collection.
 *   java.util.ArrayList<E>				A class that represents a resizable-array implementation of the java.util.List<E> interface (unsynchronized).
 *   java.util.LinkedList<E>			A class that represents a doubly-linked list implementation of the java.util.List<E> and java.util.Deque<E> interfaces.
 *   java.util.Vector<E>				A class that represents a resizable-array implementation of the java.util.List<E> interface (synchronized).
 *   java.util.Stack<E>					A class that represents a LIFO stack implementation extending the java.util.Vector<E> class.
 * 
 *   java.util.Set<E>					An interface that represents a collection containing no duplicate elements.
 *   java.util.HashSet<E>				A class that represents a hash table implementation of the java.util.Set<E> interface.
 *   java.util.SortedSet<E>				An interface that represents a set collection further providing a total ordering on its elements.
 *   java.util.NavigableSet<E>			An interface that represents a sorted set collection with navigation methods returning the closest matches for given search targets.
 *   java.util.TreeSet<E>				A class that represents an implementation of the java.util.NavigableSet<E> interface, based on the java.util.TreeMap<K, V> class.
 * 
 *   java.util.Queue<E>					An interface that represents a collection designed for holding elements prior to processing.
 *   java.util.PriorityQueue<E>			A class that represents an implementation of the java.util.Queue<E> interface, unbounded and based on a priority heap.
 *   java.util.Deque<E>					An interface that represents a queue collection being linear and supporting element insertion and removal at both ends.
 *   java.util.LinkedList<E>			<See Above>
 *   java.util.ArrayDeque<E>			A class that represents a resizable-array implementation of the java.util.Deque<E> interface.
 * 
 *   java.util.Map<K, V>				An interface that represents an object mapping keys to values.
 * 
 *   java.util.HashMap<K, V>			A class that represents a hash table implementation of the java.util.Map<K, V> interface (unsynchronized and permitting null values).
 *   java.util.Hashtable<K, V>			A class that represents a hash table implementation of the java.util.Map<K, V> interface (synchronized and not permitting null values).
 *   java.util.Properties				A class that represents a persistent set of properties implementation extending the java.util.Hashtable<K, V> class.
 *   java.util.SortedMap<K, V>			An interface that represents a map further providing a total ordering on its keys.
 *   java.util.NavigableMap<K, V>		An interface that represents a sorted map with navigation methods returning the closest matches for given search targets.
 *   java.util.TreeMap<K, V>			A class that represents a Red-Black tree implementation of the java.util.NavigableMap<E> interface.
 * 
 *   java.lang.Iterable<E>				An interface that allows any object implementing it to use the forEach statement.
 *   java.util.Iterator<E>				An interface used to iterate over the collections, which takes the place of the java.util.Enumeration<E> interface.
 *   java.util.ListIterator<E>			An interface used to iterate over the list collections.
 *   java.util.Enumeration<E>			An interface used to iterate over the collections.
 *   java.util.RandomAccess				An interface used to mark whether a list implementation supports fast random access.
 * 
 *   java.util.AbstractCollection<E>	An abstract class providing a skeletal implementation of the java.util.Collection<E> interface.
 *   java.util.AbstractList<E>			An abstract class providing a skeletal implementation of the java.util.List<E> interface (for random access data).
 *   java.util.AbstractSequentialList<E>
 *   									An abstract class providing a skeletal implementation of the java.util.List<E> interface (for sequential access data).
 *   java.util.AbstractSet<E>			An abstract class providing a skeletal implementation of the java.util.Set<E> interface.
 *   java.util.AbstractQueue<E>			An abstract class providing skeletal implementations of some queue operations.
 *   java.util.AbstractMap<K, V>		An abstract class providing a skeletal implementation of the java.util.Map<K, V> interface.
 *   java.util.Dictionary<K, V>			An obsolete abstract class providing a skeletal implementation of some mapping-keys-to-values operations.
 * 
 *   java.util.Collections				A class that consists exclusively of static methods operating on or returning collections.
 * 
 * - Class/Interface Details
 *   - java.util.Collection<E>
 *     java.util.Collection<E> is the root interface in the collection hierarchy.
 *     It implements the java.lang.Iterable<E> interface thus all kinds of collections can use the forEach statement.
 *     It has main public methods as follows.
 *     Signature							Description
 *     -------------------------------------------------------------------------------------------------------------------
 *     int size();							Return the number of elements in this collection.
 *     boolean isEmpty();					Return whether this collection contains no elements.
 *     boolean contains(Object element);	Return whether this collection contains the specified element.
 *     boolean containsAll(Collection<?> collection);
 *     										Return whether this collection contains all of the elements in the specified collection.
 *     Iterator<E> iterator();				Return an iterator over the elements in this collection.
 *     Object[] toArray();					Return an array containing all of the elements in this collection.
 *     <T> T[] toArray(T[] array);			Return an array containing all of the elements in this collection, with the element type specified.
 *     boolean add(E element);				Add the specified element into this collection.
 *     boolean addAll(Collection<? extends E> collection);
 *     										Add all of the elements in the specified collection to this collection.
 *     boolean remove(Object element);		Remove the specified element from this collection.
 *     boolean removeAll(Collection<?> collection);
 *     										Remove all of the elements in the specified collection from this collection.
 *     boolean retainAll(Collection<?> collection);
 *     										Retain all of the elements in the specified collection in this collection.
 *     void clear();						Clear this collection.
 *     boolean equals(Object object);		Compare the specified object with this collection for equality.
 * 
 *   - java.util.List<E>
 *     java.util.List<E> is an interface that represents an ordered collection (AKA a sequence).
 *     It has specific features as follows.
 *     - Elements are ordered.
 *     - Elements can be accessed by their integer indexes.
 *     - Elements can be searched.
 *     - Elements can be duplicate.
 *     - Position of the inserting element can be controlled.
 *     It has main public methods as follows, besides the inherited methods.
 *     Signature							Description
 *     -------------------------------------------------------------------------------------------------------------------
 *     E get(int index);					Return the element at the specified position in this list.
 *     E set(int index, E element);			Replace the element at the specified position in this list with the specified element.
 *     void add(int index, E element);		Insert the specified element at the specified position in this list.
 *     boolean addAll(int index, Collection<? extends E> collection);
 *     										Insert all of the elements in the specified collection into this list at the specified position.
 *     E remove(int index);					Remove the element at the specified position in this list.
 *     default void sort(Comparator<? super E> comparator) {...}
 *     										Sort this list according to the order induced by the specified comparator.
 *     int indexOf(Object object);			Return the index of the first occurrence of the specified element in this list.
 *     int lastIndexOf(Object object);		Return the index of the last occurrence of the specified element in this list.
 *     ListIterator<E> listIterator();		Return a list iterator over the elements in this list.
 *     ListIterator<E> listIterator(int index);
 *     										Return a list iterator over the elements in this list, starting at the specified position in the list.
 *     List<E> subList(int fromIndex, int toIndex);
 *     										Return a view of the portion of this list between the specified fromIndex (inclusive) and toIndex (exclusive). 
 * 
 *   - java.util.ArrayList<E>
 *     java.util.ArrayList<E> is a class that represents a resizable-array implementation of the java.util.List<E> interface.
 *     It is roughly equivalent to the java.util.Vector class, except that it is unsynchronized.
 *     It has specific features as follows.
 *     - It is resizable.
 *     - It permits null elements.
 *     - It is not synchronized.
 *     It has main public methods as follows, besides the inherited methods.
 *     Signature							Description
 *     -------------------------------------------------------------------------------------------------------------------
 *     public void trimToSize() {...}		Trim the capacity of this list to its current size.
 *     public void ensureCapacity(int minCapacity) {...}
 *     										Increase the capacity of this list, if necessary, to ensure the specified minimum capacity.
 * 
 *   - java.util.LinkedList<E>
 *     java.util.LinkedList<E> is a class that represents a doubly-linked list implementation of the java.util.List<E> and java.util.Deque<E> interfaces.
 *     It is roughly equivalent to the java.util.Vector class, except that it is unsynchronized.
 *     It has specific features as follows.
 *     - It is doubly-linked.
 *     - It is not synchronized.
 *     It has main public methods as follows, besides the inherited methods.
 *     Signature							Description
 *     -------------------------------------------------------------------------------------------------------------------
 *     <None>
 * 
 *   - java.util.Vector<E>
 *     java.util.Vector<E> is a class that represents a resizable-array implementation of the java.util.List<E> interface.
 *     It is synchronized, thus much time may be spent on synchronized operations.
 *     If a thread-safe implementation is not needed, it is recommended to use the java.util.ArrayList<E> class in place of the java.util.Vector<E> class.
 *     It has main public methods as follows, besides the inherited methods.
 *     Signature							Description
 *     -------------------------------------------------------------------------------------------------------------------
 *     public synchronized void addElement(E object) {...}
 *     										Add the specified element to this vector.
 *     public synchronized int capacity() {...}
 *     										Return the current capacity of this vector.
 *     public synchronized void copyInto(Object[] array) {...}
 *     										Copy the elements of this vector into the specified array.
 *     public synchronized E elementAt(int index) {...}
 *     										Return the element at the specified index in this vector.
 *     public Enumeration<E> elements() {...}
 *     										Return an enumeration of the elements of this vector.
 *     public synchronized void ensureCapacity(int minCapacity) {...} 
 *     										Increase the capacity of this list, if necessary, to ensure the specified minimum capacity.
 *     public synchronized E firstElement() {...}
 *     										Return the first element of this vector.
 *     public synchronized int indexOf(Object object, int index) {...}
 *     										Return the index of the first occurrence of the specified element in this vector, searching forwards from the specified index.
 *     public synchronized void insertElementAt(E object, int index) {...}
 *     										Insert the specified element in this vector at the specified index.
 *     public synchronized E lastElement() {...}
 *     										Return the last element of this vector.
 *     public synchronized int lastIndexOf(Object object, int index) {...}
 *     										Return the index of the last occurrence of the specified element in this vector, searching backwards from the specified index.
 *     public synchronized void removeAllElements() {...}
 *     										Remove all elements from this vector.
 *     public synchronized boolean removeElement(Object object) {...}
 *     										Remove the first occurrence of the specified element from this vector.
 *     public synchronized void removeElementAt(int index) {...}
 *     										Delete the element at the specified index in this vector.
 *     public synchronized void setElementAt(E object, int index) {...}
 *     										Set the element at the specified index of this vector to be the specified element.
 *     public synchronized void setSize(int size) {...}
 *     										Set the size of this vector.
 *     public synchronized void trimToSize() {...}
 *     										Trim the capacity of this vector to its current size.
 * 
 *   - java.util.Stack<E>
 *     java.util.Stack<E> is a class that represents a LIFO stack implementation extending the java.util.Vector<E> class.
 *     A more complete and consistent set of LIFO stack operations is provided by the java.util.Deque<E> interface and its implementations,
 *     which should be used in preference to this class.
 *     It has main public methods as follows, besides the inherited methods.
 *     Signature							Description
 *     -------------------------------------------------------------------------------------------------------------------
 *     public boolean empty() {...}			Return whether this stack is empty.
 *     public E push(E object) {...}		Push the specified object as an element onto the top of this stack.
 *     public synchronized E pop() {...}	Pop (remove) the element at the top of this stack and return it.
 *     public synchronized E peek() {...}	Return the element at the top of this stack without removing it.
 *     public synchronized int search(Object object) {...}
 *     										Return the 1-based position where the specified object is on this stack.
 * 
 *   - java.util.Set<E>
 *     java.util.Set<E> is an interface that represents a collection containing no duplicate elements.
 *     It has specific features as follows.
 *     - Elements are not duplicate.
 *     It has main public methods as follows, besides the inherited methods.
 *     Signature							Description
 *     -------------------------------------------------------------------------------------------------------------------
 *     <None>
 * 
 *   - java.util.HashSet<E>
 *     java.util.HashSet<E> is a class that represents a hash table implementation of the java.util.Set<E> interface.
 *     It has specific features as follows.
 *     - The iteration order of the elements may be not constant.
 *     - The null element is allowed.
 *     It has main public methods as follows, besides the inherited methods.
 *     Signature							Description
 *     -------------------------------------------------------------------------------------------------------------------
 *     <None>
 * 
 *   - java.util.SortedSet<E>
 *     java.util.SortedSet<E> is an interface that represents a set collection further providing a total ordering on its elements.
 *     It has specific features as follows.
 *     - Its elements have a a total ordering.
 *     It has main public methods as follows, besides the inherited methods.
 *     Signature							Description
 *     -------------------------------------------------------------------------------------------------------------------
 *     Comparator<? super E> comparator();
 *     										Return the comparator used to order the elements in this set.
 *     E first();							Return the first element currently in this set.
 *     E last();							Return the last element currently in this set.
 *     SortedSet<E> headSet(E toElement);	Return a view of the portion of this set whose elements are less than the specified To element.
 *     SortedSet<E> tailSet(E fromElement);
 *     										Return a view of the portion of this set whose elements are greater than or equal to the specified From element.
 *     SortedSet<E> subSet(E fromElement, E toElement);
 *     										Return a view of the portion of this set whose elements range from the specified From element (inclusive) and to the specified To element (exclusive).
 * 
 *   - java.util.NavigableSet<E>
 *     java.util.NavigableSet<E> is an interface that represents a sorted set collection with navigation methods returning the closest matches for given search targets.
 *     It has specific features as follows.
 *     - Navigation methods are provided to get matches per given targets.
 *     It has main public methods as follows, besides the inherited methods.
 *     Signature							Description
 *     -------------------------------------------------------------------------------------------------------------------
 *     E ceiling(E element);				Return the least element in this set greater than or equal to the specified element.
 *     E floor(E element);					Return the greatest element in this set less than or equal to the specified element.
 *     E higher(E element);					Return the least element in this set greater than the specified element.
 *     E lower(E element);					Return the greatest element in this set less than the specified element.
 *     NavigableSet<E> headSet(E toElement, boolean inclusive);
 *     										Return a view of the portion of this set whose elements are less than (or equal to, if the specified Inclusive flag is true) the specified To element.
 *     NavigableSet<E> tailSet(E fromElement, boolean inclusive);
 *     										Return a view of the portion of this set whose elements are greater than (or equal to, if the specified Inclusive flag is true) the specified From element
 *     NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive);
 *     										Return a view of the portion of this set whose elements range from the specified From element (inclusive if the specified From Inclusive flag is true) to the specified To element (inclusive if the specified To Inclusive flag is true).
 *     Iterator<E> descendingIterator();	Return an iterator over the elements in this set, in descending order.
 *     NavigableSet<E> descendingSet();		Return a reverse order view of the elements contained in this set.
 *     E pollFirst();						Retrieve and remove the first element in this set.
 *     E pollLast();						Retrieve and remove the last element in this set.
 * 
 *   - java.util.TreeSet<E>
 *     java.util.TreeSet<E> is a class that represents an implementation of the java.util.NavigableSet<E> interface, based on the java.util.TreeMap<K, V> class.
 *     It has specific features as follows.
 *     - <None>
 *     It has main public methods as follows, besides the inherited methods.
 *     Signature							Description
 *     -------------------------------------------------------------------------------------------------------------------
 *     <None>
 * 
 *   - java.util.Queue<E>
 *     java.util.Queue<E> is an interface that represents a collection designed for holding elements prior to processing.
 *     It has specific features as follows.
 *     - Elements are typically ordered by the FIFO (first-in-first-out) manner.
 *       In other cases, the LIFO (last-in-first-out) manner, the elements' natural ordering or the specified comparator is used.
 *     It has main public methods as follows, besides the inherited methods.
 *     Signature							Description
 *     -------------------------------------------------------------------------------------------------------------------
 *     E element();							Retrieve the head of this queue (throw an exception if this queue is empty).
 *     E peek();							Retrieve the head of this queue (return null if this queue is empty).
 *     E remove();							Retrieve and remove the head of this queue (throw an exception if this queue is empty).
 *     E poll();							Retrieve and remove the head of this queue (return null if this queue is empty).
 *     boolean offer(E element);			Insert the specified element into this queue.
 * 
 *   - java.util.PriorityQueue<E>
 *     java.util.PriorityQueue<E> is a class that represents an implementation of the java.util.Queue<E> interface, unbounded and based on a priority heap.
 *     It has specific features as follows.
 *     - The queue is unbounded.
 *     - The elements are ordered according to their natural ordering, or by the specified comparator.
 *     - The null elements are not permitted.
 *     - This implementation is not synchronized.
 *     It has main public methods as follows, besides the inherited methods.
 *     Signature							Description
 *     -------------------------------------------------------------------------------------------------------------------
 *     public Comparator<? super E> comparator() {...}
 *     										Return the comparator used to order the elements in this queue.
 * 
 *   - java.util.Deque<E>
 *     java.util.Deque<E> is an interface that represents a queue collection being linear and supporting element insertion and removal at both ends.
 *     It has specific features as follows.
 *     - It is linear.
 *     - Its elements can be inserted and removed at both ends.
 *     It has main public methods as follows, besides the inherited methods.
 *     Signature							Description
 *     -------------------------------------------------------------------------------------------------------------------
 *     E getFirst();						Retrieve the first element of this deque (throw an exception if this deque is empty).
 *     E getLast();							Retrieve the last element of this deque (throw an exception if this deque is empty).
 *     E peekFirst();						Retrieve the first element of this deque (return null if this deque is empty).
 *     E peekLast();						Retrieve the last element of this deque (return null if this deque is empty).
 *     void addFirst(E element);			Insert the specified element at the front of this deque (throw an exception when failed).
 *     void addLast(E element);				Insert the specified element at the end of this deque (throw an exception when failed).
 *     boolean offerFirst(E element);		Insert the specified element at the front of this deque (return false when failed).
 *     boolean offerLast(E element);		Insert the specified element at the end of this deque (return false when failed).
 *     E removeFirst();						Retrieve and remove the first element of this deque (throw an exception if this deque is empty).
 *     E removeLast();						Retrieve and remove the last element of this deque (throw an exception if this deque is empty).
 *     E pollFirst();						Retrieve and remove the first element of this deque (return null if this deque is empty).
 *     E pollLast();						Retrieve and remove the last element of this deque (return null if this deque is empty).
 *     boolean removeFirstOccurrence(Object object);
 *     										Remove the first occurrence of the specified element from this deque.
 *     boolean removeLastOccurrence(Object object);
 *     										Remove the last occurrence of the specified element from this deque.
 *     E pop();								Pop an element from the stack represented by this deque.
 *     void push(E element);				Push an element onto the stack represented by this deque.
 *     Iterator<E> descendingIterator();	Return an iterator over the elements in this deque in reverse sequential order.
 * 
 *   - java.util.ArrayDeque<E>
 *     java.util.ArrayDeque<E> is a class that represents a resizable-array implementation of the java.util.Deque<E> interface.
 *     It has specific features as follows.
 *     - It is not thread-safe.
 *     - It cannot contain null elements.
 *     - It can be used as a queue (faster than the java.util.LinkedList<E> class) and a stack (faster than the java.util.Stack<E> class).
 *     It has main public methods as follows, besides the inherited methods.
 *     Signature							Description
 *     -------------------------------------------------------------------------------------------------------------------
 *     <None>
 * 
 *   - java.util.Map<K, V>
 *     java.util.Map<K, V> is an interface that represents an object mapping keys to values.
 *     It has specific features as follows.
 *     - It cannot contain duplicate keys.
 *     - One of its keys can map to at most one value.
 *     It provides 3 collection views - a set collection of keys, a collection of values and a set collection of key-value mappings (or say entries).
 *     It has main public methods as follows, besides the inherited methods.
 *     Signature							Description
 *     -------------------------------------------------------------------------------------------------------------------
 *     boolean isEmpty();					Return whether this map contains no mappings.
 *     int size();							Return the number of mappings in this map.
 *     boolean containsKey(Object key);		Return whether this map contains a mapping for the specified key.
 *     boolean containsValue(Object value);	Return whether this map maps one or more keys to the specified value.
 *     Set<K> keySet();						Return a set collection view of the keys contained in this map.
 *     Collection<V> values();				Return a collection view of the values contained in this map. 
 *     Set<Map.Entry<K, V>> entrySet();		Return a set collection view of the mappings contained in this map.
 *     V get(Object key);					Return the value to which the specified key is mapped.
 *     default V getOrDefault(Object key, V defaultValue) {...}
 *     										Return the value to which the specified key is mapped, or the specified default value if this map contains no mapping for the specified key.
 *     boolean equals(Object object);		Compare the specified object with this map for equality.
 *     int hashCode();						Return the hash code value for this map.
 *     V put(K key, V value);				Associate the specified value with the specified key in this map.
 *     void putAll(Map<? extends K, ? extends V> map);
 *     										Copy all of the mappings from the specified map to this map.
 *     default V putIfAbsent(K key, V value) {...}
 *     										Associate the specified value with the specified key in this map, if the specified key is not associated with a non-null value .
 *     V remove(Object key);				Remove the mapping for a key from this map.
 *     default boolean remove(Object key, Object value) {...}
 *     										Remove the mapping for the specified key only if it is currently mapped to the specified value.
 *     default V replace(K key, V value) {...}
 *     										Replace the mapping for the specified key using the specified value, only if it is currently mapped to some value.
 *     default boolean replace(K key, V oldValue, V ewValue) {...}
 *     										Replace the mapping for the specified key using the specified new value, only if it is currently mapped to the specified old value.
 *     void clear();						Remove all of the mappings from this map.
 * 
 *   - java.util.HashMap<K, V>
 *     java.util.HashMap<K, V> is a class that represents a hash table implementation of the java.util.Map<K, V> interface (unsynchronized and permitting null values).
 *     It has specific features as follows.
 *     - It permits the null key and the null values.
 *     - It is unsynchronized.
 *     - It does not guarantee that the order of its entries will remain constant over time.
 *     It has main public methods as follows, besides the inherited methods.
 *     Signature							Description
 *     -------------------------------------------------------------------------------------------------------------------
 *     <None>
 * 
 *   - java.util.Hashtable<K, V>
 *     java.util.Hashtable<K, V> is a class that represents a hash table implementation of the java.util.Map<K, V> interface (synchronized and not permitting null values).
 *     It has specific features as follows.
 *     - It does not permit the null key and the null values.
 *     - It is synchronized.
 *     It has main public methods as follows, besides the inherited methods.
 *     Signature							Description
 *     -------------------------------------------------------------------------------------------------------------------
 *     <None>
 * 
 *   - java.util.Properties
 *     java.util.Properties is a class that represents a persistent set of properties implementation extending the java.util.Hashtable<K, V> class.
 *     All properties in one of its objects can be saved to a stream or loaded from a stream.
 *     It has specific features as follows.
 *     - Each key or value of one of its properties is a string. 
 *     It has main public methods as follows, besides the inherited methods.
 *     Signature							Description
 *     -------------------------------------------------------------------------------------------------------------------
 *     public String getProperty(String key) {...}
 *     										Get the property value with the specified property key from this property list or the default property list.
 *     public String getProperty(String key, String defaultValue) {...}
 *     										Get the property value with the specified property key from this property list, the default property list or the specified default property.
 *     public void list(PrintStream outputStream) {...}
 *     										List this property list out to the specified output stream (as the PrintSteam object).
 *     public void list(PrintWriter outputStream) {...}
 *     										List this property list out to the specified output stream (as the PrintWriter object).
 *     public synchronized void load(InputStream inputStream) throws IOException {...}
 *     										Read a property list from the specified input stream (byte).
 *     public synchronized void load(Reader reader) {...}
 *     										Read a property list from the specified input stream (character).
 *     public synchronized void loadFromXML(InputStream inputStream) {...}
 *     										Read a property list represented by the XML document on the specified input stream.
 *     public Enumeration<?> propertyNames() {...}
 *     										Return an enumeration of all keys in this property list (and the default property list).
 *     public Set<String> stringPropertyNames() {...}
 *     										Return a set of all keys in this property list (and the default property list).
 *     public synchronized Object setProperty(String key, String value) {...}
 *     										Set the specified property key into this property list.
 *     public void save(OutputStream outputStream, String comment) {...}
 *     										<Deprecated>
 *     										Write this property list to the specified output stream with the specified comment.
 *     public void store(OutputStream outputStream, String comment) {...}
 *     										Write this property list to the specified output stream with the specified comment.
 *     public void store(Writer writer, String comment) {...}
 *     										Write this property list to the specified output stream (character) with the specified comment.
 *     public void storeToXML(OutputStream outputStream, String comment) {...}
 *     										Write this property list to the specified output stream (as XML document) with the specified comment.
 *     public void storeToXML(OutputStream outputStream, String comment, String encoding) {...}
 *     										Write this property list to the specified output stream (as XML document) with the specified comment, using the specified encoding.
 * 
 *   - java.util.SortedMap<K, V>
 *     java.util.SortedMap<K, V> is an interface that represents a map further providing a total ordering on its keys.
 *     It has specific features as follows.
 *     - It is ordered according to the natural ordering of its keys, or by a comparator provided at its creation time.
 *     It has main public methods as follows, besides the inherited methods.
 *     Signature							Description
 *     -------------------------------------------------------------------------------------------------------------------
 *     Comparator<? super K> comparator();	Return the comparator used to order the keys in this map.
 *     K firstKey();						Return the first key currently in this map.
 *     K lastKey();							Return the last key currently in this map.
 *     SortedMap<K,V> headMap(K toKey);		Return a view of the portion of this map whose keys are strictly less than the specified key.
 *     SortedMap<K,V> tailMap(K fromKey);	Return a view of the portion of this map whose keys are greater than or equal to the specified key.
 *     SortedMap<K,V> subMap(K fromKey, K toKey);
 *     										Return a view of the portion of this map whose keys range from the specified From key (inclusive) to the specified To key (exclusive). 
 * 
 *   - java.util.NavigableMap<K, V>
 *     java.util.NavigableMap<K, V> is an interface that represents a sorted map with navigation methods returning the closest matches for given search targets.
 *     It has specific features as follows.
 *     - <None>
 *     It has main public methods as follows, besides the inherited methods.
 *     Signature							Description
 *     -------------------------------------------------------------------------------------------------------------------
 *     Map.Entry<K,V> firstEntry();			Return a mapping associated with the least key in this map.
 *     Map.Entry<K,V> lastEntry();			Return a mapping associated with the greatest key in this map.
 *     Map.Entry<K,V> ceilingEntry(K key);	Return a mapping associated with the least key greater than or equal to the specified key.
 *     Map.Entry<K,V> floorEntry(K key);	Return a mapping associated with the greatest key less than or equal to the specified key.
 *     Map.Entry<K,V> higherEntry(K key);	Return a mapping associated with the least key greater than the specified key.
 *     Map.Entry<K,V> lowerEntry(K key);	Return a mapping associated with the greatest key less than the specified key.
 *     K ceilingKey(K key);					Return the least key greater than or equal to the specified key.
 *     K floorKey(K key);					Return the greatest key less than or equal to the specified key.
 *     K higherKey(K key);					Return the least key greater than the specified key.
 *     K lowerKey(K key);					Return the greatest key less than the specified key.
 *     NavigableSet<K> navigableKeySet();	Return a navigable set view of the keys contained in this map.
 *     NavigableSet<K> descendingKeySet();	Return a reverse order navigable set view of the keys contained in this map.
 *     NavigableMap<K,V> descendingMap();	Return a reverse order view of the mappings contained in this map.
 *     NavigableMap<K,V> headMap(K toKey, boolean inclusive);
 *     										Return a view of the portion of this map whose keys are less than (or equal to, if the specified Inclusive flag is true) the specified To key.
 *     NavigableMap<K,V> tailMap(K fromKey, boolean inclusive);
 *     										Return a view of the portion of this map whose keys are greater than (or equal to, if the specified Inclusive flag is true) the specified From key.
 *     NavigableMap<K,V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive);
 *     										Return a view of the portion of this map whose keys range from the specified From key (inclusive if the specified From Inclusive flag is true) to the specified To key (inclusive if the specified To Inclusive flag is true).
 *     Map.Entry<K,V> pollFirstEntry();		Remove and return a mapping associated with the least key in this map.
 *     Map.Entry<K,V> pollLastEntry();		Remove and return a mapping associated with the greatest key in this map.
 * 
 *   - java.util.TreeMap<K, V>
 *     java.util.TreeMap<K, V> is a class that represents a Red-Black tree implementation of the java.util.NavigableMap<E> interface.
 *     It has specific features as follows.
 *     - It is unsynchronized.
 *     It has main public methods as follows, besides the inherited methods.
 *     Signature							Description
 *     -------------------------------------------------------------------------------------------------------------------
 *     <None>
 * 
 *   - java.lang.Iterable<E>
 *     java.lang.Iterable<E> is an interface that allows any object implementing it to use the forEach statement.
 *     It has main public methods as follows.
 *     Signature							Description
 *     -------------------------------------------------------------------------------------------------------------------
 *     Iterator<T> iterator();				Return an iterator over the elements in the object.
 * 
 *   - java.util.Iterator<E>
 *     java.util.Iterator<E> is an interface used to iterate over the collections.
 *     It takes the place of the java.util.Enumeration<E> interface in the Java Collections Framework.
 *     It has main public methods as follows.
 *     Signature							Description
 *     -------------------------------------------------------------------------------------------------------------------
 *     boolean hasNext();					Return whether the iteration has more elements.
 *     E next();							Return the next element in the iteration.
 *     default void remove() {...}			Remove from the underlying collection the last element returned by this iterator.
 * 
 *   - java.util.ListIterator<E>
 *     java.util.ListIterator<E> is an interface used to iterate over the list collections.
 *     It has main public methods as follows, besides the inherited methods.
 *     Signature							Description
 *     -------------------------------------------------------------------------------------------------------------------
 *     boolean hasPrevious();				Return whether the previous element exists.
 *     E previous();						Return the previous element.
 *     int previousIndex();					Return the index of the previous element.
 *     int nextIndex();						Return the index of the next element.
 *     void add(E element);					Insert the specified element into the list.
 *     void set(E element);					Replace the last returned element with the specified element.
 * 
 *   - java.util.Enumeration<E>
 *     java.util.Enumeration<E> is an interface used to iterate over the collections.
 *     It has been taken the place in the Java Collections Framework by the java.util.Iterator<E> interface,
 *     because the latter adds an remove operation and has improved method names.
 *     It has main public methods as follows.
 *     Signature							Description
 *     -------------------------------------------------------------------------------------------------------------------
 *     boolean hasMoreElements();			Return whether the enumeration has more elements.
 *     E nextElement();						Return the next element in the enumeration.
 * 
 *   - java.util.RandomAccess
 *     java.util.RandomAccess is an interface used to mark whether a list implementation supports fast random access.
 *     Its primary purpose is to allow generic algorithms to alter their behavior
 *     to provide good performance when applied to either random or sequential access lists.
 *     It has no any methods.
 * 
 *   - java.util.AbstractCollection<E>
 *     java.util.AbstractCollection<E> is an abstract class providing a skeletal implementation of the java.util.Collection<E> interface.
 * 
 *   - java.util.AbstractList<E>
 *     java.util.AbstractList<E> is an abstract class providing a skeletal implementation of the java.util.List<E> interface (for random access data).
 * 
 *   - java.util.AbstractSequentialList<E>
 *     java.util.AbstractSequentialList<E> is an abstract class providing a skeletal implementation of the java.util.List<E> interface (for sequential access data).
 * 
 *   - java.util.AbstractSet<E>
 *     java.util.AbstractSet<E> is an abstract class providing a skeletal implementation of the java.util.Set<E> interface.
 * 
 *   - java.util.AbstractQueue<E>
 *     java.util.AbstractQueue<E> is an abstract class providing skeletal implementations of some queue operations.
 * 
 *   - java.util.AbstractMap<K, V>
 *     java.util.AbstractMap<K, V> is an abstract class providing a skeletal implementation of the java.util.Map<K, V> interface.
 * 
 *   - java.util.Dictionary<K, V>
 *     java.util.Dictionary<K, V> is an obsolete abstract class providing a skeletal implementation of some mapping-keys-to-values operations.
 * 
 *   - java.util.Collections
 *     java.util.Collections is a class that consists exclusively of static methods operating on or returning collections.
 *     It has main public methods as follows.
 *     Signature							Description
 *     -------------------------------------------------------------------------------------------------------------------
 *     public static <T> int binarySearch(List<? extends Comparable<? super T>> list, T key) {...}
 *     										Search the specified list for the specified object using the binary search algorithm.
 *     public static <T> int binarySearch(List<? extends T> list, T key, Comparator<? super T> comparator) {...}
 *     										Search the specified list for the specified object using the binary search algorithm (the specified list should be sorted by the specified comparator before invoking this method).
 *     public static boolean disjoint(Collection<?> collection1, Collection<?> collection2) {...}
 *     										Return whether the two specified collections have no elements in common.
 *     public static int frequency(Collection<?> collection, Object object) {...}
 *     										Return the number of elements in the specified collection equal to the specified object.
 *     public static int indexOfSubList(List<?> source, List<?> target) {...}
 *     										Return the starting position of the first occurrence of the specified target list within the specified source list.
 *     public static int lastIndexOfSubList(List<?> source, List<?> target) {...}
 *     										Return the starting position of the last occurrence of the specified target list within the specified source list.
 *     public static <T extends Object & Comparable<? super T>> T min(Collection<? extends T> collection) {...}
 *     										Return the minimum element of the specified collection, according to the natural ordering of its elements.
 *     public static <T> T min(Collection<? extends T> collection, Comparator<? super T> comparator) {...}
 *     										Return the minimum element of the specified collection, according to the order induced by the specified comparator.
 *     public static <T extends Object & Comparable<? super T>> T max(Collection<? extends T> collection) {...}
 *     										Return the maximum element of the specified collection, according to the natural ordering of its elements.
 *     public static <T> T max(Collection<? extends T> collection, Comparator<? super T> comparator) {...}
 *     										Return the maximum element of the specified collection, according to the order induced by the specified comparator.
 *     public static <T> ArrayList<T> list(Enumeration<T> enumeration) {...}
 *     										Return an array list containing the elements returned by the specified enumeration.
 *     public static <T> Enumeration<T> enumeration(final Collection<T> collection) {...}
 *     										Return an enumeration over the specified collection.
 *     public static <T> boolean addAll(Collection<? super T> collection, T... elements) {...}
 *     										Add all of the specified elements to the specified collection.
 *     public static <T> boolean replaceAll(List<T> list, T oldValue, T newValue) {...}
 *     										Replace all occurrences of the specified Old value in the specified list with the specified New value.
 *     public static <T> void copy(List<? super T> destination, List<? extends T> source) {...}
 *     										Copy all of the elements from the specified Source list into the specified Destination list.
 *     public static <T> void fill(List<? super T> list, T object) {...}
 *     										Replace all of the elements of the specified list with the specified object.
 *     public static <T> List<T> nCopies(int number, T object) {...}
 *     										Return an immutable list consisting of the specified number of copies of the specified object.
 *     public static void shuffle(List<?> list) {...}
 *     										Randomly permute the specified list using a default source of randomness.
 *     public static void shuffle(List<?> list, Random random) {...}
 *     										Randomly permute the specified list using the specified source of randomness.
 *     public static <T extends Comparable<? super T>> void sort(List<T> list) {...}
 *     										Sort the specified list into the ascending order, according to the natural ordering of its elements.
 *     public static <T> void sort(List<T> list, Comparator<? super T> comparator) {...}
 *     										Sort the specified list according to the order induced by the specified comparator.
 *     public static void reverse(List<?> list) {...}
 *     										Reverse the order of the elements in the specified list.
 *     public static <T> Comparator<T> reverseOrder() {...}
 *     										Return a comparator that imposes the reverse of the natural ordering on a collection.
 *     public static <T> Comparator<T> reverseOrder(Comparator<T> comparator) {...}
 *     										Return a comparator that imposes the reverse of the specified comparator's ordering on a collection.
 *     public static void swap(List<?> list, int i, int j) {...}
 *     										Swap 2 elements at the specified positions in the specified list.
 *     public static void rotate(List<?> list, int distance) {...}
 *     										Rotate the elements in the specified list by the specified distance.
 *     public static <E> Xxx<E> checkedXxx(Xxx<E> xxx, Class<E> type) {...}
 *     										Return a dynamically typesafe view of the specified xxx, which elements' types are constrained to be the specified type. (xxx is a collection type)
 *     public static <K, V> Xxx<K, V> checkedXxx(Xxx<K, V> xxx, Class<K> keyType, Class<V> valueType) {...}
 *     										Return a dynamically typesafe view of the specified xxx, which entries' keys and values are constrained to be the specified key type and value type. (xxx is a map type).
 *     public static final <T> Xxx<T> emptyXxx() {...}
 *     										Return an empty xxx (immutable and serializable). (xxx is a collection type)
 *     public static final <K,V> Xxx<K,V> emptyXxx() {...}
 *     										Return an empty xxx (immutable and serializable). (xxx is a map type)
 *     public static <T> Xxx<T> emptyXxx() {...}
 *     										Return a xxx that has no elements. (xxx is an iterator, list iterator or enumeration)
 *     public static <T> Xxx<T> synchronizedXxx(Xxx<T> xxx) {...}
 *     										Return a synchronized (thread-safe) xxx backed by the specified xxx. (xxx is a collection type)
 *     public static <K,V> Xxx<K,V> synchronizedXxx(Xxx<K,V> xxx) {...}
 *     										Return a synchronized (thread-safe) xxx backed by the specified xxx. (xxx is a map type)
 *     public static <T> Xxx<T> unmodifiableXxx(Xxx<? extends T> xxx) {...}
 *     										Return an unmodifiable view of the specified xxx. (xxx is a collection type)
 *     public static <K,V> Xxx<K,V> unmodifiableXxx(Xxx<? extends K, ? extends V> xxx) {...}
 *     										Return an unmodifiable view of the specified xxx. (xxx is a map type)
 * 
 *   - xxx.xxx.Xxx
 *     xxx.xxx.Xxx is xxx.
 *     It has specific features as follows.
 *     - Xxx xxx xxx.
 *     - Xxx xxx xxx.
 *     It has main public methods as follows, besides the inherited methods.
 *     Signature							Description
 *     -------------------------------------------------------------------------------------------------------------------
 *     xxx									Xxx xxx xxx.
 *     xxx									Xxx xxx xxx.
 * 
 * - Misc
 *   - Ways to Iterate over the Collection
 *     - Using the Iterator Object
 *     	Example
 *     	====================================================
 *     	Collection<String> collection = ...;
 *     	for (Iterator<String> iterator = collection.iterator(); iterator.hasNext();) {
 *     		String element = iterator.next();
 *     		// Process the element...
 *     	}
 *   
 *     	<OR>
 *   
 *     	Collection<String> collection = ...;
 *     	Iterator<String> iterator = collection.iterator();
 *     	while (iterator.hasNext()) {
 *     		String element = iterator.next();
 *     		// Process the element...
 *     	}
 *     	====================================================
 *   
 *     - Using the forEach Statement (Recommended)
 *     	- A forEach statement is more elegant thus better than using the Iterator object on iterating over the collection.
 *     	- Any object implementing the java.lang.Iterable<T> interface can use the forEach statement.
 *     	Example
 *     	====================================================
 *     	Collection<String> collection = ...;
 *     	for (String element : collection) {
 *     		// Process the element...
 *     	}
 *     	====================================================
 *   
 *     - Using the Enumeration Object
 *     	Example
 *     	====================================================
 *     	Vector<String> collection = ...;
 *     	for (Enumeration<String> elements = collection.elements(); elements.hasMoreElements();) {
 *     		String element = elements.nextElement();
 *     		// Process the element...
 *     	}
 *     	====================================================
 * 
 *   - Bulk Operations
 *     Iterators are used to iterate all elements in the collections one by one.
 *     To avoid use the iterators frequently, bulk operations can be used.
 * 
 *     - Find the Intersection
 *     	<See Examples Below>
 * 
 *     - Remove Parts
 *     	<See Examples Below>
 * 
 *     - Use Views
 *     	<See Examples Below>
 * 
 *   - Conversion between Arrays and Collections
 *     - The java.util.Arrays.asList(T...) method is used to convert an array to a collection (java.util.List<T>).
 *     - The java.util.Collection.toArray(T[]) method is used to convert a collection to an array.
 * </pre>
 */
public class Introduction {

	private static int getArrayListCapacity(ArrayList<?> arrayList) throws Exception {
		Field elementDataField = ArrayList.class.getDeclaredField("elementData");
		elementDataField.setAccessible(true);
		return ((Object[]) elementDataField.get(arrayList)).length;
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Testing the java.util.Collection<E> Interface
		// +++++++++++++++++++++++++++++++++++++++++++++++++
		{
			Collection<String> collection = new ArrayList<>();

			// int size();
			// boolean isEmpty();
			System.out.println("collection.isEmpty(): " + collection.isEmpty());
			System.out.println("collection.size(): " + collection.size());
			System.out.println();

			collection.add("abc");
			collection.add("def");
			collection.add("ghi");
			collection.add("jkl");
			collection.add("mno");

			System.out.println("collection.isEmpty(): " + collection.isEmpty());
			System.out.println("collection.size(): " + collection.size());
			System.out.println();

			// boolean equals(Object object);
			System.out.println("collection.equals(new Object()): " + collection.equals(new Object()));
			Collection<String> anotherCollection = Arrays.asList("abc", "def", "ghi", "jkl", "mno");
			System.out.println("collection.equals(anotherCollection): " + collection.equals(anotherCollection));
			System.out.println();

			// boolean contains(Object element);
			// boolean containsAll(Collection<?> collection);
			System.out.println("collection.contains(\"def\"): " + collection.contains("def"));
			System.out.println("collection.contains(\"deg\"): " + collection.contains("deg"));
			System.out.println("collection.containsAll(Arrays.asList(\"def\", \"ghi\", \"jkl\"): "
					+ collection.containsAll(Arrays.asList("def", "ghi", "jkl")));
			System.out.println("collection.containsAll(Arrays.asList(\"def\", \"ghi\", \"jkm\"): "
					+ collection.containsAll(Arrays.asList("def", "ghi", "jkm")));
			System.out.println();

			// Iterator<E> iterator();
			Iterator<String> iterator = collection.iterator();
			while (iterator.hasNext()) {
				String element = iterator.next();
				System.out.print(element + " | ");
			}
			System.out.println();
			System.out.println();

			// Object[] toArray();
			// <T> T[] toArray(T[] array);
			System.out.println("Arrays.toString(collection.toArray()): " + Arrays.toString(collection.toArray()));
			System.out.println("Arrays.toString(collection.toArray(new String[0])): "
					+ Arrays.toString(collection.toArray(new String[0])));
			System.out.println();

			// boolean add(E element);
			// boolean addAll(Collection<? extends E> collection);
			System.out.println("collection.add(\"pqr\"): " + collection.add("pqr"));
			System.out.println("Arrays.toString(collection.toArray()): " + Arrays.toString(collection.toArray()));
			System.out.println("collection.addAll(Arrays.asList(\"stu\", \"vwx\", \"yz\")): "
					+ collection.addAll(Arrays.asList("stu", "vwx", "yz")));
			System.out.println("Arrays.toString(collection.toArray()): " + Arrays.toString(collection.toArray()));
			System.out.println();

			// boolean remove(Object element);
			// boolean removeAll(Collection<?> collection);
			System.out.println("collection.remove(\"ghi\"): " + collection.remove("ghi"));
			System.out.println("Arrays.toString(collection.toArray()): " + Arrays.toString(collection.toArray()));
			System.out.println("collection.remove(\"abd\"): " + collection.remove("abd"));
			System.out.println("Arrays.toString(collection.toArray()): " + Arrays.toString(collection.toArray()));
			System.out.println("collection.removeAll(Arrays.asList(\"mno\", \"vwx\", \"yz\")): "
					+ collection.removeAll(Arrays.asList("mno", "vwx", "yz")));
			System.out.println("Arrays.toString(collection.toArray()): " + Arrays.toString(collection.toArray()));
			System.out.println();

			// boolean retainAll(Collection<?> collection);
			System.out.println("collection.retainAll(Arrays.asList(\"abc\", \"def\", \"pqr\")): "
					+ collection.retainAll(Arrays.asList("abc", "def", "pqr")));
			System.out.println("Arrays.toString(collection.toArray()): " + Arrays.toString(collection.toArray()));
			System.out.println();

			// void clear();
			collection.clear();
			System.out.println("Arrays.toString(collection.toArray()): " + Arrays.toString(collection.toArray()));
		}

		Utils.printDelimiterLine1();

		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Testing the java.util.List<E> Interface
		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Note: Only non-inherited methods of this interface are tested here.
		{
			List<String> list = new ArrayList<>();

			list.add("abc");
			list.add("def");
			list.add("ghi");
			list.add("jkl");
			list.add("mno");

			System.out.println("Arrays.toString(list.toArray()): " + Arrays.toString(list.toArray()));
			System.out.println();

			// E get(int index);
			System.out.println("list.get(2): " + list.get(2));
			System.out.println();

			// E set(int index, E element);
			System.out.println("Arrays.toString(list.toArray()): " + Arrays.toString(list.toArray()));
			list.set(3, "stu");
			System.out.println("Arrays.toString(list.toArray()): " + Arrays.toString(list.toArray()));
			System.out.println();

			// void add(int index, E element);
			// boolean addAll(int index, Collection<? extends E> c);
			System.out.println("Arrays.toString(list.toArray()): " + Arrays.toString(list.toArray()));
			list.add(1, "pqr");
			System.out.println("Arrays.toString(list.toArray()): " + Arrays.toString(list.toArray()));
			System.out.println("list.addAll(4, Arrays.asList(\"ghi_1\", \"ghi_2\", \"ghi_3\")): "
					+ list.addAll(4, Arrays.asList("ghi_1", "ghi_2", "ghi_3")));
			System.out.println("Arrays.toString(list.toArray()): " + Arrays.toString(list.toArray()));
			System.out.println();

			// E remove(int index);
			System.out.println("Arrays.toString(list.toArray()): " + Arrays.toString(list.toArray()));
			list.remove(5);
			System.out.println("Arrays.toString(list.toArray()): " + Arrays.toString(list.toArray()));
			System.out.println();

			// default void sort(Comparator<? super E> comparator) {...}
			System.out.println("Arrays.toString(list.toArray()): " + Arrays.toString(list.toArray()));
			list.sort(new Comparator<String>() {

				@Override
				public int compare(String object1, String object2) {
					int result = 0;

					if (object1 == null || object2 == null) {
						if (object1 == null) {
							if (object2 == null) {
								result = 0;
							} else {
								result = -1;
							}
						} else {
							result = 1;
						}
					} else {
						result = object1.compareTo(object2);
					}

					return result;
				}

			});
			System.out.println("Arrays.toString(list.toArray()): " + Arrays.toString(list.toArray()));
			System.out.println();

			// int indexOf(Object object);
			// int lastIndexOf(Object object);
			list.add(1, "xxx");
			list.add(list.size() - 1, "xxx");
			System.out.println("Arrays.toString(list.toArray()): " + Arrays.toString(list.toArray()));
			System.out.println("list.indexOf(\"xxx\"): " + list.indexOf("xxx"));
			System.out.println("list.lastIndexOf(\"xxx\"): " + list.lastIndexOf("xxx"));
			System.out.println("list.indexOf(\"zzz\"): " + list.indexOf("zzz"));
			System.out.println();

			// ListIterator<E> listIterator();
			// ListIterator<E> listIterator(int index);
			ListIterator<String> listIterator = list.listIterator();
			while (listIterator.hasNext()) {
				// The "previous()" method also exists.
				String element = (String) listIterator.next();
				String elementInfo = "";
				elementInfo += element + "\t(";
				elementInfo += "Having Previous: " + listIterator.hasPrevious() + ", ";
				elementInfo += "Having Next: " + listIterator.hasNext() + ", ";
				elementInfo += "Previous Index: " + listIterator.previousIndex() + ", ";
				elementInfo += "Next Index: " + listIterator.nextIndex() + ")";
				System.out.println(elementInfo);
			}
			System.out.println();
			ListIterator<String> listIterator2 = list.listIterator(2);
			while (listIterator2.hasNext()) {
				System.out.print(listIterator2.next() + " | ");
			}
			System.out.println();
			System.out.println();

			// List<E> subList(int fromIndex, int toIndex);
			List<String> sublist = list.subList(2, 8);
			System.out.println("Arrays.toString(list.toArray()): " + Arrays.toString(list.toArray()));
			System.out.println("Arrays.toString(sublist.toArray()): " + Arrays.toString(sublist.toArray()));
			sublist.set(sublist.size() - 2, "zzz");
			System.out.println("Arrays.toString(sublist.toArray()): " + Arrays.toString(sublist.toArray()));
			System.out.println("Arrays.toString(list.toArray()): " + Arrays.toString(list.toArray()));
		}

		Utils.printDelimiterLine1();

		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Testing the java.util.ArrayList<E> Class
		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Note: Only non-inherited methods of this class are tested here.
		{
			ArrayList<String> arrayList = new ArrayList<>();

			arrayList.add("abc");
			arrayList.add("def");
			arrayList.add("ghi");

			// public void ensureCapacity(int minCapacity) {...}
			System.out.println("getArrayListCapacity(arrayList): " + getArrayListCapacity(arrayList));
			arrayList.ensureCapacity(5);
			System.out.println("getArrayListCapacity(arrayList): " + getArrayListCapacity(arrayList));
			arrayList.ensureCapacity(15);
			System.out.println("getArrayListCapacity(arrayList): " + getArrayListCapacity(arrayList));
			System.out.println();

			// public void trimToSize() {...}
			arrayList.trimToSize();
			System.out.println("getArrayListCapacity(arrayList): " + getArrayListCapacity(arrayList));
		}

		Utils.printDelimiterLine1();

		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Testing the java.util.LinkedList<E> Class
		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Note: Only non-inherited methods of this class are tested here.
		{
			LinkedList<String> linkedList = new LinkedList<>();

			linkedList.add("abc");
			linkedList.add("def");
			linkedList.add("ghi");

			System.out.println("Arrays.toString(linkedList.toArray()): " + Arrays.toString(linkedList.toArray()));
			System.out.println();

			// Node<E> node(int index) {...}
			// <This method cannot be tested here because t only has the
			// package visibility>

			// void linkBefore(E element, Node<E> node) {...}
			// <This method cannot be tested here because it only has the
			// package visibility>

			// void linkLast(E element) {...}
			// <This method cannot be tested here because it only has the
			// package visibility>

			// E unlink(Node<E> x) {...}
			// <This method cannot be tested here because it only has the
			// package visibility>

			// DO NOT use any method that accesses elements by the index on a
			// linked list, because the linked list cannot quickly access a
			// element by index.
			// Try to use an array or an array list instead in that case.

			// NG: The java.util.LinkedList.get(int) has a low efficiency.
			System.out.println("linkedList.get(1): " + linkedList.get(1));
			System.out.println();

			// NG: The java.util.LinkedList.get(int) has a low efficiency.
			for (int i = 0; i < linkedList.size(); i++) {
				System.out.println("linkedList.get(" + i + "): " + linkedList.get(i));
			}
			System.out.println();
		}

		Utils.printDelimiterLine1();

		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Testing the java.util.Vector<E> Class
		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Note: Only non-inherited methods of this class are tested here.
		{
			Vector<String> vector = new Vector<>();

			vector.add("abc");
			vector.add("def");
			vector.add("ghi");

			System.out.println("Arrays.toString(vector.toArray()): " + Arrays.toString(vector.toArray()));
			System.out.println();

			// public synchronized void addElement(E object) {...}
			vector.addElement("jkl");
			System.out.println("Arrays.toString(vector.toArray()): " + Arrays.toString(vector.toArray()));
			System.out.println();

			// public synchronized int capacity() {...}
			System.out.println("vector.size(): " + vector.size());
			System.out.println("vector.capacity(): " + vector.capacity());
			System.out.println();

			// public synchronized void copyInto(Object[] array) {...}
			String[] stringArray = new String[7];
			System.out.println("Arrays.toString(stringArray): " + Arrays.toString(stringArray));
			vector.copyInto(stringArray);
			System.out.println("Arrays.toString(stringArray): " + Arrays.toString(stringArray));
			System.out.println();

			// public synchronized E elementAt(int index) {...}
			System.out.println("vector.elementAt(1): " + vector.elementAt(1));
			System.out.println();

			// public Enumeration<E> elements() {...}
			for (Enumeration<String> elements = vector.elements(); elements.hasMoreElements();) {
				String element = elements.nextElement();
				System.out.print(element + " | ");
			}
			System.out.println();

			// public synchronized void ensureCapacity(int minCapacity) {...}
			System.out.println("vector.capacity(): " + vector.capacity());
			vector.ensureCapacity(5);
			System.out.println("vector.capacity(): " + vector.capacity());
			vector.ensureCapacity(15);
			System.out.println("vector.capacity(): " + vector.capacity());
			System.out.println();

			// public synchronized E firstElement() {...}
			// public synchronized E lastElement() {...}
			System.out.println("vector.firstElement(): " + vector.firstElement());
			System.out.println("vector.lastElement(): " + vector.lastElement());
			System.out.println();

			// public synchronized int indexOf(Object object, int index) {...}
			// public synchronized int lastIndexOf(Object object, int index)
			// {...}
			vector.add("ghi");
			vector.add("def");
			vector.add("abc");
			System.out.println("Arrays.toString(vector.toArray()): " + Arrays.toString(vector.toArray()));
			System.out.println("vector.indexOf(\"abc\"): " + vector.indexOf("abc"));
			System.out.println("vector.indexOf(\"xxx\", 1): " + vector.indexOf("xxx", 1));
			System.out.println("vector.indexOf(\"abc\", 1): " + vector.indexOf("abc", 1));
			System.out.println("vector.lastIndexOf(\"abc\"): " + vector.lastIndexOf("abc"));
			System.out.println(
					"vector.lastIndexOf(\"xxx\", vector.size() - 2): " + vector.lastIndexOf("xxx", vector.size() - 2));
			System.out.println(
					"vector.lastIndexOf(\"abc\", vector.size() - 2): " + vector.lastIndexOf("abc", vector.size() - 2));
			System.out.println();

			// public synchronized void insertElementAt(E object, int index)
			// {...}
			System.out.println("Arrays.toString(vector.toArray()): " + Arrays.toString(vector.toArray()));
			vector.insertElementAt("jkl", 3);
			vector.insertElementAt("xxx", Math.round(vector.size() / 2));
			System.out.println("Arrays.toString(vector.toArray()): " + Arrays.toString(vector.toArray()));
			System.out.println();

			// public synchronized void removeElementAt(int index) {...}
			// public synchronized boolean removeElement(Object object) {...}
			// public synchronized void removeAllElements() {...}
			System.out.println("Arrays.toString(vector.toArray()): " + Arrays.toString(vector.toArray()));
			vector.removeElementAt(1);
			System.out.println("Arrays.toString(vector.toArray()): " + Arrays.toString(vector.toArray()));
			System.out.println("vector.removeElement(\"def\"): " + vector.removeElement("def"));
			System.out.println("Arrays.toString(vector.toArray()): " + Arrays.toString(vector.toArray()));
			vector.removeAllElements();
			System.out.println("Arrays.toString(vector.toArray()): " + Arrays.toString(vector.toArray()));
			System.out.println();

			vector.add("abc");
			vector.add("def");
			vector.add("ghi");

			System.out.println("Arrays.toString(vector.toArray()): " + Arrays.toString(vector.toArray()));
			System.out.println();

			// public synchronized void setElementAt(E object, int index) {...}
			vector.setElementAt("xxx", 1);
			System.out.println("Arrays.toString(vector.toArray()): " + Arrays.toString(vector.toArray()));
			System.out.println();

			// public synchronized void trimToSize() {...}
			System.out.println("vector.capacity(): " + vector.capacity());
			vector.trimToSize();
			System.out.println("vector.capacity(): " + vector.capacity());
			System.out.println();

			// public synchronized void setSize(int size) {...}
			System.out.println("Arrays.toString(vector.toArray()): " + Arrays.toString(vector.toArray()));
			System.out.println("vector.size(): " + vector.size());
			vector.setSize(15);
			System.out.println("Arrays.toString(vector.toArray()): " + Arrays.toString(vector.toArray()));
			System.out.println("vector.size(): " + vector.size());
		}

		Utils.printDelimiterLine1();

		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Testing the java.util.Stack<E> Class
		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Note: Only non-inherited methods of this class are tested here.
		{
			Stack<String> stack = new Stack<>();

			// public boolean empty() {...}
			System.out.println("stack.empty(): " + stack.empty());
			stack.add("item1");
			System.out.println("stack.empty(): " + stack.empty());
			System.out.println();

			// public E push(E object) {...}
			System.out.println("stack: " + stack);
			stack.push("item2");
			System.out.println("stack: " + stack);
			stack.push("item3");
			stack.push("item4");
			stack.push("item5");
			System.out.println("stack: " + stack);
			System.out.println();

			// public synchronized E pop() {...}
			System.out.println("stack.pop(): " + stack.pop());
			System.out.println("stack: " + stack);
			System.out.println("stack.pop(): " + stack.pop());
			System.out.println("stack: " + stack);
			System.out.println();

			// public synchronized E peek() {...}
			System.out.println("stack.peek(): " + stack.peek());
			System.out.println("stack: " + stack);
			System.out.println();

			// public synchronized int search(Object object) {...}
			System.out.println("stack.search(\"item4\"): " + stack.search("item4"));
			System.out.println("stack.search(\"item2\"): " + stack.search("item2"));
		}

		Utils.printDelimiterLine1();

		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Testing the java.util.Set<E> Interface
		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Note: Basically, only non-inherited methods of this interface are
		// tested here.
		{
			Set<String> set = new HashSet<>();

			set.add("abc");
			set.add("def");
			set.add("ghi");

			// Test: An existing element cannot be added.
			System.out.println("Arrays.toString(set.toArray()): " + Arrays.toString(set.toArray()));
			set.add("jkl");
			System.out.println("Arrays.toString(set.toArray()): " + Arrays.toString(set.toArray()));
			set.add("def");
			System.out.println("Arrays.toString(set.toArray()): " + Arrays.toString(set.toArray()));
			System.out.println();

			// Test: A null element can be added.
			set.add(null);
			System.out.println("Arrays.toString(set.toArray()): " + Arrays.toString(set.toArray()));
		}

		Utils.printDelimiterLine1();

		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Testing the java.util.HashSet<E> Class
		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Note: Basically, only non-inherited methods of this class are tested
		// here.
		{
			// ...
		}

		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Testing the java.util.SortedSet<E> Interface
		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Note: Only non-inherited methods of this interface are tested here.
		{
			SortedSet<String> sortedSet = new TreeSet<>();

			sortedSet.add("bx3");
			sortedSet.add("ax1");
			sortedSet.add("ex4");
			sortedSet.add("dx2");
			sortedSet.add("cx5");

			System.out.println("Arrays.toString(sortedSet.toArray()): " + Arrays.toString(sortedSet.toArray()));
			System.out.println();

			// Comparator<? super E> comparator();
			System.out.println("sortedSet.comparator(): " + sortedSet.comparator());
			System.out.println();

			// E first();
			// E last();
			System.out.println("sortedSet.first(): " + sortedSet.first());
			System.out.println("sortedSet.last(): " + sortedSet.last());
			System.out.println();

			// SortedSet<E> headSet(E toElement);
			// SortedSet<E> tailSet(E fromElement);
			// SortedSet<E> subSet(E fromElement, E toElement);
			System.out.println("sortedSet.headSet(\"dx2\"): " + sortedSet.headSet("dx2"));
			System.out.println("sortedSet.tailSet(\"cx5\"): " + sortedSet.tailSet("cx5"));
			System.out.println("sortedSet.subSet(\"bx3\", \"ex4\"): " + sortedSet.subSet("bx3", "ex4"));
		}

		Utils.printDelimiterLine1();

		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Testing the java.util.NavigableSet<E> Interface
		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Note: Only non-inherited methods of this interface are tested here.
		{
			NavigableSet<String> navigableSet = new TreeSet<>();

			navigableSet.add("axx");
			navigableSet.add("bxx");
			navigableSet.add("cxx");
			navigableSet.add("dxx");
			navigableSet.add("exx");

			System.out.println("Arrays.toString(navigableSet.toArray()): " + Arrays.toString(navigableSet.toArray()));
			System.out.println();

			// E ceiling(E element);
			// E floor(E element);
			// E higher(E element);
			// E lower(E element);
			System.out.println("navigableSet.ceiling(\"dxx\"): " + navigableSet.ceiling("dxx"));
			System.out.println("navigableSet.floor(\"bxx\"): " + navigableSet.floor("bxx"));
			System.out.println("navigableSet.higher(\"dxx\"): " + navigableSet.higher("dxx"));
			System.out.println("navigableSet.lower(\"bxx\"): " + navigableSet.lower("bxx"));
			System.out.println();

			// NavigableSet<E> headSet(E toElement, boolean inclusive);
			// NavigableSet<E> tailSet(E fromElement, boolean inclusive);
			// NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E
			// toElement, boolean toInclusive);
			System.out.println("navigableSet.headSet(\"cxx\", false): " + navigableSet.headSet("cxx", false));
			System.out.println("navigableSet.headSet(\"cxx\", true): " + navigableSet.headSet("cxx", true));
			System.out.println("navigableSet.tailSet(\"cxx\", false): " + navigableSet.tailSet("cxx", false));
			System.out.println("navigableSet.tailSet(\"cxx\", true): " + navigableSet.tailSet("cxx", true));
			System.out.println("navigableSet.subSet(\"bxx\", false, \"dxx\", false): "
					+ navigableSet.subSet("bxx", false, "dxx", false));
			System.out.println("navigableSet.subSet(\"bxx\", false, \"dxx\", true): "
					+ navigableSet.subSet("bxx", false, "dxx", true));
			System.out.println("navigableSet.subSet(\"bxx\", true, \"dxx\", false): "
					+ navigableSet.subSet("bxx", true, "dxx", false));
			System.out.println("navigableSet.subSet(\"bxx\", true, \"dxx\", true): "
					+ navigableSet.subSet("bxx", true, "dxx", true));
			System.out.println();

			// Iterator<E> descendingIterator();
			for (Iterator<String> iterator = navigableSet.descendingIterator(); iterator.hasNext();) {
				System.out.print(iterator.next() + " | ");
			}
			System.out.println();
			System.out.println();

			// NavigableSet<E> descendingSet();
			System.out.println("Arrays.toString(navigableSet.descendingSet().toArray()): "
					+ Arrays.toString(navigableSet.descendingSet().toArray()));
			System.out.println();

			// E pollFirst();
			// E pollLast();
			System.out.println("Arrays.toString(navigableSet.toArray()): " + Arrays.toString(navigableSet.toArray()));
			System.out.println("navigableSet.pollFirst(): " + navigableSet.pollFirst());
			System.out.println("Arrays.toString(navigableSet.toArray()): " + Arrays.toString(navigableSet.toArray()));
			System.out.println("navigableSet.pollLast(): " + navigableSet.pollLast());
			System.out.println("Arrays.toString(navigableSet.toArray()): " + Arrays.toString(navigableSet.toArray()));
		}

		Utils.printDelimiterLine1();

		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Testing the java.util.TreeSet<E> Class
		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Note: Basically, only non-inherited methods of this class are tested
		// here.
		{
			String[] array = new String[] { "cx4", "ax3", "ex2", "bx5", "dx1" };
			System.out.println(Arrays.toString(array));

			// The elements are ordered using their natural ordering.
			// Here, to be specific, the ordering is String Ascending of the
			// string.
			TreeSet<String> treeSet1 = new TreeSet<>(Arrays.asList(array));
			System.out.println(Arrays.toString(treeSet1.toArray()));

			// The elements are ordered using the ordering per the specified
			// comparator.
			// Here, to be specific, the ordering is Number Ascending of the 3rd
			// letter of the string (as an integer).
			Comparator<String> treeSet2Comparator = new Comparator<String>() {

				@Override
				public int compare(String object1, String object2) {
					int number1 = Integer.parseInt(String.valueOf(object1.charAt(2)));
					int number2 = Integer.parseInt(String.valueOf(object2.charAt(2)));
					return Integer.compare(number1, number2);
				}

			};
			TreeSet<String> treeSet2 = new TreeSet<>(treeSet2Comparator);
			treeSet2.addAll(Arrays.asList(array));
			System.out.println(Arrays.toString(treeSet2.toArray()));
		}

		Utils.printDelimiterLine1();

		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Testing the java.util.Queue<E> Interface
		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Note: Only non-inherited methods of this interface are tested here.
		{
			Queue<String> queue = new LinkedList<>();

			queue.add("abc");
			queue.add("def");
			queue.add("ghi");

			System.out.println("Arrays.toString(queue.toArray()): " + Arrays.toString(queue.toArray()));
			System.out.println();

			// E element();
			// E peek();
			System.out.println("queue.element(): " + queue.element());
			System.out.println("queue.peek(): " + queue.peek());
			queue.clear();
			try {
				System.out.println("queue.element(): " + queue.element());
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("queue.peek(): " + queue.peek());
			System.out.println();

			queue.add("abc");
			queue.add("def");
			queue.add("ghi");

			// E remove();
			// E poll();
			System.out.println("queue.remove(): " + queue.remove());
			System.out.println("Arrays.toString(queue.toArray()): " + Arrays.toString(queue.toArray()));
			System.out.println("queue.poll(): " + queue.poll());
			System.out.println("Arrays.toString(queue.toArray()): " + Arrays.toString(queue.toArray()));
			queue.clear();
			try {
				System.out.println("queue.remove(): " + queue.remove());
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("queue.poll(): " + queue.poll());
			System.out.println();

			// boolean offer(E element);
			System.out.println("Arrays.toString(queue.toArray()): " + Arrays.toString(queue.toArray()));
			System.out.println("queue.offer(\"jkl\"): " + queue.offer("jkl"));
			System.out.println("Arrays.toString(queue.toArray()): " + Arrays.toString(queue.toArray()));
		}

		Utils.printDelimiterLine1();

		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Testing the java.util.PriorityQueue<E> Class
		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Note: Only non-inherited methods of this class are tested here.
		{
			PriorityQueue<String> priorityQueue1 = new PriorityQueue<>();

			priorityQueue1.add("axx");
			priorityQueue1.add("bxx");
			priorityQueue1.add("cxx");

			System.out
					.println("Arrays.toString(priorityQueue1.toArray()): " + Arrays.toString(priorityQueue1.toArray()));
			System.out.println();

			PriorityQueue<String> priorityQueue2 = new PriorityQueue<>(new Comparator<String>() {

				@Override
				public int compare(String object1, String object2) {
					int number1 = Integer.parseInt(String.valueOf(object1.charAt(2)));
					int number2 = Integer.parseInt(String.valueOf(object2.charAt(2)));
					return Integer.compare(number1, number2);
				}

			});

			priorityQueue2.add("dx3");
			priorityQueue2.add("ex2");
			priorityQueue2.add("fx1");

			System.out
					.println("Arrays.toString(priorityQueue2.toArray()): " + Arrays.toString(priorityQueue2.toArray()));
			System.out.println();

			// public Comparator<? super E> comparator() {...}
			System.out.println("priorityQueue1.comparator(): " + priorityQueue1.comparator());
			System.out.println("priorityQueue2.comparator(): " + priorityQueue2.comparator());
		}

		Utils.printDelimiterLine1();

		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Testing the java.util.Deque<E> Interface
		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Note: Only non-inherited methods of this interface are tested here.
		{

			Deque<String> deque = new LinkedList<>();

			deque.add("axx");
			deque.add("bxx");
			deque.add("cxx");

			System.out.println("Arrays.toString(deque.toArray()): " + Arrays.toString(deque.toArray()));
			System.out.println();

			Deque<String> emptyDeque = new LinkedList<>();

			// E getFirst();
			// E getLast();
			// E peekFirst();
			// E peekLast();
			System.out.println("deque.getFirst(): " + deque.getFirst());
			System.out.println("deque.getLast(): " + deque.getLast());

			System.out.println("deque.peekFirst(): " + deque.peekFirst());
			System.out.println("deque.peekLast(): " + deque.peekLast());

			try {
				System.out.println("emptyDeque.getFirst(): " + emptyDeque.getFirst());
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				System.out.println("emptyDeque.getLast(): " + emptyDeque.getLast());
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println("emptyDeque.peekFirst(): " + emptyDeque.peekFirst());
			System.out.println("emptyDeque.peekLast(): " + emptyDeque.peekLast());

			System.out.println();

			// void addFirst(E element);
			// void addLast(E element);
			// boolean offerFirst(E element);
			// boolean offerLast(E element);
			deque.addFirst("first_1");
			System.out.println("Arrays.toString(deque.toArray()): " + Arrays.toString(deque.toArray()));

			deque.addLast("last_1");
			System.out.println("Arrays.toString(deque.toArray()): " + Arrays.toString(deque.toArray()));

			System.out.println("deque.offerFirst(\"first_2\"): " + deque.offerFirst("first_2"));
			System.out.println("Arrays.toString(deque.toArray()): " + Arrays.toString(deque.toArray()));

			System.out.println("deque.offerLast(\"last_2\"): " + deque.offerLast("last_2"));
			System.out.println("Arrays.toString(deque.toArray()): " + Arrays.toString(deque.toArray()));

			System.out.println();

			// E removeFirst();
			// E removeLast();
			// E pollFirst();
			// E pollLast();
			System.out.println("deque.removeFirst(): " + deque.removeFirst());
			System.out.println("Arrays.toString(deque.toArray()): " + Arrays.toString(deque.toArray()));

			System.out.println("deque.removeLast(): " + deque.removeLast());
			System.out.println("Arrays.toString(deque.toArray()): " + Arrays.toString(deque.toArray()));

			System.out.println("deque.pollFirst(): " + deque.pollFirst());
			System.out.println("Arrays.toString(deque.toArray()): " + Arrays.toString(deque.toArray()));

			System.out.println("deque.pollLast(): " + deque.pollLast());
			System.out.println("Arrays.toString(deque.toArray()): " + Arrays.toString(deque.toArray()));

			try {
				System.out.println("emptyDeque.removeFirst(): " + emptyDeque.removeFirst());
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				System.out.println("emptyDeque.removeLast(): " + emptyDeque.removeLast());
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println("emptyDeque.pollFirst(): " + emptyDeque.pollFirst());
			System.out.println("emptyDeque.pollLast(): " + emptyDeque.pollLast());

			System.out.println();

			// boolean removeFirstOccurrence(Object object);
			// boolean removeLastOccurrence(Object object);
			deque.addFirst("YYY");
			deque.addFirst("XXX");
			deque.addLast("YYY");
			deque.addLast("XXX");
			System.out.println("Arrays.toString(deque.toArray()): " + Arrays.toString(deque.toArray()));
			deque.removeFirstOccurrence("XXX");
			System.out.println("Arrays.toString(deque.toArray()): " + Arrays.toString(deque.toArray()));
			deque.removeLastOccurrence("YYY");
			System.out.println("Arrays.toString(deque.toArray()): " + Arrays.toString(deque.toArray()));
			System.out.println();

			// E pop(); // This method is equivalent to the method
			// removeFirst().
			// void push(E element); // This method is equivalent to the method
			// addFirst().
			System.out.println("deque.pop(): " + deque.pop());
			System.out.println("Arrays.toString(deque.toArray()): " + Arrays.toString(deque.toArray()));
			deque.push("ZZZ");
			System.out.println("Arrays.toString(deque.toArray()): " + Arrays.toString(deque.toArray()));
			System.out.println();

			// Iterator<E> descendingIterator();
			for (Iterator<String> iterator = deque.descendingIterator(); iterator.hasNext();) {
				System.out.print(iterator.next() + " | ");
			}
			System.out.println();
		}

		Utils.printDelimiterLine1();

		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Testing the java.util.ArrayDeque<E> Class
		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Note: Only non-inherited methods of this class are tested here.
		{
			// ...
		}

		Utils.printDelimiterLine1();

		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Testing the java.util.Map<K, V> Interface
		// +++++++++++++++++++++++++++++++++++++++++++++++++
		{
			Map<String, Object> map = new HashMap<>();

			map.put("item1", 123);
			map.put("item2", "abc");
			map.put("item3", true);

			System.out.println("map: " + map);
			System.out.println("new TreeMap<String, Object>(map): " + new TreeMap<String, Object>(map));
			System.out.println();

			// boolean isEmpty();
			// int size();
			// void clear();
			System.out.println("map.isEmpty(): " + map.isEmpty());
			System.out.println("map.size(): " + map.size());
			map.clear();
			System.out.println("map.isEmpty(): " + map.isEmpty());
			System.out.println("map.size(): " + map.size());
			System.out.println();

			map.put("item1", 123);
			map.put("item2", "abc");
			map.put("item3", true);

			// boolean containsKey(Object key);
			System.out.println("map.containsKey(\"item2\"): " + map.containsKey("item2"));
			System.out.println("map.containsKey(\"item4\"): " + map.containsKey("item4"));
			System.out.println();

			// boolean containsValue(Object value);
			System.out.println("map.containsValue(\"abc\"): " + map.containsValue("abc"));
			System.out.println("map.containsValue(\"def\"): " + map.containsValue("def"));
			System.out.println();

			// Set<K> keySet();
			System.out.println("map.keySet(): " + map.keySet());
			System.out.println("new TreeSet<String>(map.keySet()): " + new TreeSet<String>(map.keySet()));
			System.out.println();

			// Collection<V> values();
			System.out.println("map.values(): " + map.values());
			System.out.println();

			// Set<Map.Entry<K, V>> entrySet();
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				System.out.println(entry.getKey() + ": " + entry.getValue() + ": " + entry);
			}
			System.out.println();

			// V get(Object key);
			// default V getOrDefault(Object key, V defaultValue) {...}
			System.out.println("map.get(\"item2\"): " + map.get("item2"));
			System.out.println("map.get(\"item4\"): " + map.get("item4"));
			System.out.println("map.getOrDefault(\"item4\", 123.45): " + map.getOrDefault("item4", 123.45));
			System.out.println();

			// boolean equals(Object object);
			Map<String, Object> anotherMap = new HashMap<>();

			anotherMap.put("item1", 123);
			anotherMap.put("item2", "abc");
			anotherMap.put("item3", true);

			System.out.println("map.equals(anotherMap): " + map.equals(anotherMap));

			anotherMap.put("item1", 456);

			System.out.println("map.equals(anotherMap): " + map.equals(anotherMap));
			System.out.println();

			// int hashCode();
			System.out.println("map.hashCode(): " + map.hashCode());
			map.put("item4", 123.45);
			System.out.println("map.hashCode(): " + map.hashCode());
			System.out.println();

			// V put(K key, V value);
			System.out.println("map: " + map);
			System.out.println("map.put(\"item4\", \"value4\"): " + map.put("item4", "value4"));
			System.out.println("map.put(\"item5\", new Object()): " + map.put("item5", new Object()));
			System.out.println("map.put(\"item6\", null): " + map.put("item6", null));
			System.out.println("map: " + map);
			System.out.println();

			// void putAll(Map<? extends K, ? extends V> map);
			System.out.println("map: " + map);

			Map<String, Object> anotherMap2 = new HashMap<>();

			anotherMap2.put("item5", "value5");
			anotherMap2.put("item6", "value6");
			anotherMap2.put("item7", "value7");
			anotherMap2.put("item8", "value8");

			map.putAll(anotherMap2);
			System.out.println("map: " + map);
			System.out.println();

			// default V putIfAbsent(K key, V value) {...}
			System.out.println("map.get(\"item8\"): " + map.get("item8"));
			System.out.println(
					"map.putIfAbsent(\"item8\", \"specialValue8\"): " + map.putIfAbsent("item8", "specialValue8"));
			System.out.println("map.get(\"item8\"): " + map.get("item8"));
			System.out.println();

			System.out.println("map.get(\"item9\"): " + map.get("item9"));
			System.out.println(
					"map.putIfAbsent(\"item9\", \"specialValue9\"): " + map.putIfAbsent("item9", "specialValue9"));
			System.out.println("map.get(\"item9\"): " + map.get("item9"));
			System.out.println();

			// V remove(Object key);
			// default boolean remove(Object key, Object value) {...}
			System.out.println("map: " + map);
			System.out.println("map.remove(\"item2\"): " + map.remove("item2"));
			System.out.println("map: " + map);
			System.out.println();

			System.out.println("map: " + map);
			System.out.println("map.remove(\"item10\"): " + map.remove("item10"));
			System.out.println("map: " + map);
			System.out.println();

			System.out.println("map: " + map);
			System.out.println("map.remove(\"item5\", \"specialValue5\"): " + map.remove("item5", "specialValue5"));
			System.out.println("map: " + map);
			System.out.println();

			System.out.println("map: " + map);
			System.out.println("map.remove(\"item5\", \"value5\"): " + map.remove("item5", "value5"));
			System.out.println("map: " + map);
			System.out.println();

			// default V replace(K key, V value) {...}
			// default boolean replace(K key, V oldValue, V newValue) {...}
			System.out.println("map: " + map);
			System.out.println("map.replace(\"item7\", \"specialValue7\"): " + map.replace("item7", "specialValue7"));
			System.out.println("map: " + map);
			System.out.println();

			System.out.println("map: " + map);
			System.out.println("map.replace(\"item8\", \"specialValue8\", \"normalValue8\"): "
					+ map.replace("item8", "specialValue8", "normalValue8"));
			System.out.println("map: " + map);
			System.out.println();

			System.out.println("map: " + map);
			System.out.println("map.replace(\"item8\", \"value8\", \"normalValue8\"): "
					+ map.replace("item8", "value8", "normalValue8"));
			System.out.println("map: " + map);
		}

		Utils.printDelimiterLine1();

		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Testing the java.util.HashMap<K, V> Class
		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Note: Only non-inherited methods of this class are tested here.
		{
			HashMap<String, Object> hashMap = new HashMap<>();

			hashMap.put("item1", 123);
			hashMap.put("item2", "abc");
			hashMap.put("item3", true);

			System.out.println("hashMap: " + hashMap);
		}

		Utils.printDelimiterLine1();

		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Testing the java.util.Hashtable<K, V> Class
		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Note: Only non-inherited methods of this class are tested here.
		{
			Hashtable<String, Object> hashTable = new Hashtable<>();

			hashTable.put("item1", 123);
			hashTable.put("item2", "abc");
			hashTable.put("item3", true);

			System.out.println("hashTable: " + hashTable);
		}

		Utils.printDelimiterLine1();

		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Testing the java.util.Properties Class
		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Note: Only non-inherited methods of this class are tested here.
		{
			Properties properties = new Properties();

			// public synchronized Object setProperty(String key, String value)
			// {...}
			properties.setProperty("Key1", "Value1");
			properties.setProperty("Key2", "Value2");
			properties.setProperty("Key3", "Value3");

			System.out.println("properties: " + properties);
			System.out.println();

			// public String getProperty(String key) {...}
			// public String getProperty(String key, String defaultValue) {...}
			System.out.println("properties.getProperty(\"Key2\"): " + properties.getProperty("Key2"));
			System.out.println("properties.getProperty(\"Key4\"): " + properties.getProperty("Key4"));
			System.out.println("properties.getProperty(\"Key4\"): " + properties.getProperty("Key4", "DefaultValue4"));
			System.out.println();

			// public void list(PrintStream outputStream) {...}
			// public void list(PrintWriter outputStream) {...}
			properties.list(new PrintStream(System.out, true));
			System.out.println();

			properties.list(new PrintWriter(System.out, true));
			System.out.println();

			// public synchronized void load(InputStream inputStream) throws
			// IOException {...}
			// public synchronized void load(Reader reader) {...}
			// public synchronized void loadFromXML(InputStream inputStream)
			// {...}
			// <Skip>

			// public Enumeration<?> propertyNames() {...}
			for (Enumeration<?> propertyNames = properties.propertyNames(); propertyNames.hasMoreElements();) {
				System.out.println("propertyNames.nextElement(): " + propertyNames.nextElement());
			}
			System.out.println();

			// public Set<String> stringPropertyNames() {...}
			System.out.println("properties.stringPropertyNames(): " + properties.stringPropertyNames());
			System.out.println();

			// public void save(OutputStream outputStream, String comment) {...}
			// <There is no demo for this method because it is obsolete>
			// <Skip because this method is obsolete>

			// public void store(OutputStream outputStream, String comment)
			// {...}
			{
				String fileName = "usingOutputStream.properties";
				properties.store(new FileOutputStream(fileName),
						"A property list generated by the method - store(OutputStream outputStream, String comment).");
				System.out.println("The property list has been stored to the file - " + System.getProperty("user.dir")
						+ "\\" + fileName + ".");
			}

			System.out.println();

			// public void store(Writer writer, String comment) {...}
			{
				String fileName = "usingPrintWriter.properties";
				properties.store(new PrintWriter(fileName),
						"A property list generated by the method - store(Writer writer, String comment).");
				System.out.println("The property list has been stored to the file - " + System.getProperty("user.dir")
						+ "\\" + fileName + ".");
			}

			// public void storeToXML(OutputStream outputStream, String comment)
			// {...}
			// public void storeToXML(OutputStream outputStream, String comment,
			// String encoding) {...}
			// <Skip>
		}

		Utils.printDelimiterLine1();

		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Testing the java.util.SortedMap<K, V> Interface
		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Note: Only non-inherited methods of this interface are tested here.
		{
			SortedMap<String, Object> sortedMap = new TreeMap<>();

			sortedMap.put("item4_3", "value4_3");
			sortedMap.put("item2_5", "value2_5");
			sortedMap.put("item1_2", "value1_2");
			sortedMap.put("item3_4", "value3_4");
			sortedMap.put("item5_1", "value5_1");

			System.out.println("sortedMap: " + sortedMap);

			SortedMap<String, Object> anotherSortedMap = new TreeMap<>(new Comparator<String>() {

				@Override
				public int compare(String object1, String object2) {
					int finalNumber1 = Integer.parseInt(String.valueOf(object1.charAt(object1.length() - 1)));
					int finalNumber2 = Integer.parseInt(String.valueOf(object2.charAt(object2.length() - 1)));
					return finalNumber1 - finalNumber2;
				}

			});

			anotherSortedMap.put("item4_3", "value4_3");
			anotherSortedMap.put("item2_5", "value2_5");
			anotherSortedMap.put("item1_2", "value1_2");
			anotherSortedMap.put("item3_4", "value3_4");
			anotherSortedMap.put("item5_1", "value5_1");

			System.out.println("anotherSortedMap: " + anotherSortedMap);
			System.out.println();

			// Comparator<? super K> comparator();
			System.out.println("sortedMap.comparator(): " + sortedMap.comparator());
			System.out.println("anotherSortedMap.comparator(): " + anotherSortedMap.comparator());
			System.out.println();

			// K firstKey();
			// K lastKey();
			System.out.println("sortedMap.firstKey(): " + sortedMap.firstKey());
			System.out.println("sortedMap.lastKey(): " + sortedMap.lastKey());
			System.out.println();

			System.out.println("anotherSortedMap.firstKey(): " + anotherSortedMap.firstKey());
			System.out.println("anotherSortedMap.lastKey(): " + anotherSortedMap.lastKey());
			System.out.println();

			// SortedMap<K,V> headMap(K toKey);
			// SortedMap<K,V> tailMap(K fromKey);
			// SortedMap<K,V> subMap(K fromKey, K toKey);
			System.out.println("sortedMap: " + sortedMap);
			System.out.println("sortedMap.headMap(\"item5_1\"): " + sortedMap.headMap("item5_1"));
			System.out.println("sortedMap.tailMap(\"item2_5\"): " + sortedMap.tailMap("item2_5"));
			System.out.println("sortedMap.subMap(\"item2_5\", \"item5_1\"): " + sortedMap.subMap("item2_5", "item5_1"));
		}

		Utils.printDelimiterLine1();

		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Testing the java.util.NavigableMap<K, V> Interface
		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Note: Only non-inherited methods of this interface are tested here.
		{
			NavigableMap<String, Object> navigableMap = new TreeMap<>();

			navigableMap.put("item3", "value3");
			navigableMap.put("item1", "value1");
			navigableMap.put("item2", "value2");
			navigableMap.put("item5", "value5");
			navigableMap.put("item4", "value4");

			System.out.println("navigableMap: " + navigableMap);
			System.out.println();

			// Map.Entry<K,V> firstEntry();
			// Map.Entry<K,V> lastEntry();
			System.out.println("navigableMap.firstEntry(): " + navigableMap.firstEntry());
			System.out.println("navigableMap.lastEntry(): " + navigableMap.lastEntry());
			System.out.println();

			// Map.Entry<K,V> ceilingEntry(K key);
			// Map.Entry<K,V> floorEntry(K key);
			System.out.println("navigableMap.ceilingEntry(\"item3.5\"): " + navigableMap.ceilingEntry("item3.5"));
			System.out.println("navigableMap.floorEntry(\"item2.5\"): " + navigableMap.floorEntry("item2.5"));
			System.out.println();

			// Map.Entry<K,V> higherEntry(K key);
			// Map.Entry<K,V> lowerEntry(K key);
			System.out.println("navigableMap.higherEntry(\"item3\"): " + navigableMap.higherEntry("item3"));
			System.out.println("navigableMap.lowerEntry(\"item3\"): " + navigableMap.lowerEntry("item3"));
			System.out.println();

			// K ceilingKey(K key);
			// K floorKey(K key);
			System.out.println("navigableMap.ceilingKey(\"item3.5\"): " + navigableMap.ceilingKey("item3.5"));
			System.out.println("navigableMap.floorKey(\"item2.5\"): " + navigableMap.floorKey("item2.5"));
			System.out.println();

			// K higherKey(K key);
			// K lowerKey(K key);
			System.out.println("navigableMap.higherKey(\"item3\"): " + navigableMap.higherKey("item3"));
			System.out.println("navigableMap.lowerKey(\"item3\"): " + navigableMap.lowerKey("item3"));
			System.out.println();

			// NavigableSet<K> navigableKeySet();
			System.out.println("Arrays.toString(navigableMap.navigableKeySet().toArray()): "
					+ Arrays.toString(navigableMap.navigableKeySet().toArray()));
			System.out.println();

			// NavigableSet<K> descendingKeySet();
			System.out.println("Arrays.toString(navigableMap.descendingKeySet().toArray()): "
					+ Arrays.toString(navigableMap.descendingKeySet().toArray()));
			System.out.println();

			// NavigableMap<K,V> descendingMap();
			System.out.println("navigableMap.descendingMap(): " + navigableMap.descendingMap());
			System.out.println();

			// NavigableMap<K,V> headMap(K toKey, boolean inclusive);
			// NavigableMap<K,V> tailMap(K fromKey, boolean inclusive);
			// NavigableMap<K,V> subMap(K fromKey, boolean fromInclusive, K
			// toKey, boolean toInclusive);
			System.out.println("navigableMap.headMap(\"item4\", false): " + navigableMap.headMap("item4", false));
			System.out.println("navigableMap.headMap(\"item4\", true): " + navigableMap.headMap("item4", true));
			System.out.println();

			System.out.println("navigableMap.tailMap(\"item2\", false): " + navigableMap.tailMap("item2", false));
			System.out.println("navigableMap.tailMap(\"item2\", true): " + navigableMap.tailMap("item2", true));
			System.out.println();

			System.out.println("navigableMap.subMap(\"item2\", false, \"item4\", false): "
					+ navigableMap.subMap("item2", false, "item4", false));
			System.out.println("navigableMap.subMap(\"item2\", false, \"item4\", true): "
					+ navigableMap.subMap("item2", false, "item4", true));
			System.out.println("navigableMap.subMap(\"item2\", true, \"item4\", false): "
					+ navigableMap.subMap("item2", true, "item4", false));
			System.out.println("navigableMap.subMap(\"item2\", true, \"item4\", true): "
					+ navigableMap.subMap("item2", true, "item4", true));
			System.out.println();

			// Map.Entry<K,V> pollFirstEntry();
			// Map.Entry<K,V> pollLastEntry();
			System.out.println("navigableMap: " + navigableMap);
			System.out.println("navigableMap.pollFirstEntry(): " + navigableMap.pollFirstEntry());
			System.out.println("navigableMap: " + navigableMap);
			System.out.println("navigableMap.pollLastEntry(): " + navigableMap.pollLastEntry());
			System.out.println("navigableMap: " + navigableMap);
		}

		Utils.printDelimiterLine1();

		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Testing the java.util.TreeMap<K, V> Class
		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Note: Only non-inherited methods of this class are tested here.
		{
			TreeMap<String, Object> treeMap = new TreeMap<>();

			treeMap.put("item3", "value3");
			treeMap.put("item1", "value1");
			treeMap.put("item2", "value2");
			treeMap.put("item5", "value5");
			treeMap.put("item4", "value4");

			System.out.println("treeMap: " + treeMap);
		}

		Utils.printDelimiterLine1();

		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Testing the java.lang.Iterable<E> Interface
		// +++++++++++++++++++++++++++++++++++++++++++++++++
		{
			Iterable<String> iterable = new ArrayList<>();
			System.out.println("iterable.iterator(): " + iterable.iterator());
		}

		Utils.printDelimiterLine1();

		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Testing the java.util.Iterator<E> Interface
		// +++++++++++++++++++++++++++++++++++++++++++++++++
		{
			Collection<String> collection = new ArrayList<>(Arrays.asList("abc", "def", "ghi"));

			System.out.println("Arrays.toString(collection.toArray()): " + Arrays.toString(collection.toArray()));

			for (Iterator<String> iterator = collection.iterator(); iterator.hasNext();) {
				System.out.println("iterator.next(): " + iterator.next());
				iterator.remove();
			}

			System.out.println("Arrays.toString(collection.toArray()): " + Arrays.toString(collection.toArray()));
		}

		Utils.printDelimiterLine1();

		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Testing the java.util.ListIterator<E> Interface
		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Note: Only non-inherited methods of this interface are tested here.
		{
			List<String> list = new ArrayList<>(Arrays.asList("item1", "item2", "item3", "item4", "item5"));

			System.out.println("Arrays.toString(list.toArray()): " + Arrays.toString(list.toArray()));
			System.out.println();

			ListIterator<String> listIterator = list.listIterator();

			// boolean hasPrevious();
			// E previous();
			// int previousIndex();
			// int nextIndex();
			System.out.println("listIterator.hasPrevious(): " + listIterator.hasPrevious());
			System.out.println();

			listIterator.next();
			System.out.println("listIterator.hasPrevious(): " + listIterator.hasPrevious());
			System.out.println("listIterator.previousIndex(): " + listIterator.previousIndex());
			System.out.println("listIterator.nextIndex(): " + listIterator.nextIndex());
			System.out.println("listIterator.previous(): " + listIterator.previous());
			System.out.println();

			listIterator.next();
			listIterator.next();
			System.out.println("listIterator.previousIndex(): " + listIterator.previousIndex());
			System.out.println("listIterator.nextIndex(): " + listIterator.nextIndex());
			System.out.println("listIterator.previous(): " + listIterator.previous());
			System.out.println();

			// void add(E element);
			System.out.println("Arrays.toString(list.toArray()): " + Arrays.toString(list.toArray()));
			listIterator.add("item1.5");
			System.out.println("Arrays.toString(list.toArray()): " + Arrays.toString(list.toArray()));
			System.out.println();

			// void set(E element);
			System.out.println("listIterator.next(): " + listIterator.next());
			listIterator.set("item2_new");
			System.out.println("Arrays.toString(list.toArray()): " + Arrays.toString(list.toArray()));
		}

		Utils.printDelimiterLine1();

		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Testing the java.util.Enumeration<E> Interface
		// +++++++++++++++++++++++++++++++++++++++++++++++++
		{
			Vector<String> vector = new Vector<>(Arrays.asList("abc", "def", "ghi"));
			Enumeration<String> enumeration = vector.elements();
			while (enumeration.hasMoreElements()) {
				System.out.println("enumeration.nextElement(): " + enumeration.nextElement());
			}
		}

		Utils.printDelimiterLine1();

		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Testing the java.util.RandomAccess Interface
		// +++++++++++++++++++++++++++++++++++++++++++++++++
		{
			ArrayList<String> arrayList = new ArrayList<>();
			LinkedList<String> linkedList = new LinkedList<>();
			Vector<String> vector = new Vector<>();

			System.out.println("arrayList instanceof RandomAccess: " + (arrayList instanceof RandomAccess));
			System.out.println("linkedList instanceof RandomAccess: " + (linkedList instanceof RandomAccess));
			System.out.println("vector instanceof RandomAccess: " + (vector instanceof RandomAccess));
			System.out.println();

			List<String> list = new ArrayList<>();
			if (list instanceof RandomAccess) {
				System.out.println(
						"Use random access algorithm since this list implementation supports fast random access.");
			} else {
				System.out.println(
						"Use sequential access algorithm since this list implementation does not support fast random access.");
			}
		}

		Utils.printDelimiterLine1();

		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Testing the java.util.Collections Class
		// +++++++++++++++++++++++++++++++++++++++++++++++++
		{
			// public static <T> int binarySearch(List<? extends Comparable<?
			// super T>> list, T key) {...}
			{
				List<String> list = new ArrayList<>();

				list.add("bxx");
				list.add("axx");
				list.add("exx");
				list.add("dxx");
				list.add("cxx");

				System.out.println("list: " + list);
				// Before invoking the "binarySearch" method, the list must be
				// sorted into ascending order according to the natural ordering
				// of its elements.
				// Invoking the "sort" method with a null comparator makes the
				// list ready for invoking the "binarySearch" method.
				list.sort(null);
				System.out.println("list: " + list);
				System.out.println();

				System.out.println("Collections.binarySearch(list, \"fxx\"): " + Collections.binarySearch(list, "fxx"));
				System.out.println("Collections.binarySearch(list, \"cxx\"): " + Collections.binarySearch(list, "cxx"));
				System.out.println("Collections.binarySearch(list, \"axz\"): " + Collections.binarySearch(list, "axz"));
			}

			Utils.printDelimiterLine2();

			// public static <T> int binarySearch(List<? extends T> list, T key,
			// Comparator<? super T> comparator) {...}
			{
				List<String> list = new ArrayList<>();

				list.add("bx4");
				list.add("ax3");
				list.add("ex1");
				list.add("dx5");
				list.add("cx2");

				Comparator<String> comparator = new Comparator<String>() {

					@Override
					public int compare(String object1, String object2) {
						int number1 = Integer.parseInt(String.valueOf(object1.charAt(2)));
						int number2 = Integer.parseInt(String.valueOf(object2.charAt(2)));
						return Integer.compare(number1, number2);
					}

				};

				System.out.println("list: " + list);
				// Before invoking the "binarySearch" method, the list must be
				// sorted into ascending order according to the specified
				// comparator.
				// Invoking the "sort" method with a null comparator makes the
				// list ready for invoking the "binarySearch" method.
				list.sort(comparator);
				System.out.println("list: " + list);
				System.out.println();

				System.out.println("Collections.binarySearch(list, \"fx6\", comparator): "
						+ Collections.binarySearch(list, "fx6", comparator));
				System.out.println("Collections.binarySearch(list, \"cx2\", comparator): "
						+ Collections.binarySearch(list, "cx2", comparator));
			}

			Utils.printDelimiterLine2();

			// public static boolean disjoint(Collection<?> collection1,
			// Collection<?> collection2) {...}
			{
				Collection<String> collection1 = new ArrayList<>(Arrays.asList("a1", "b2", "c3"));
				Collection<String> collection2 = new ArrayList<>(Arrays.asList("c3", "d4", "e5"));
				Collection<String> collection3 = new ArrayList<>(Arrays.asList("e5", "f6", "g7"));
				Collection<String> collection4 = new TreeSet<>(Arrays.asList("a1", "b1", "c1"));

				System.out.println("collection1: " + collection1);
				System.out.println("collection2: " + collection2);
				System.out.println("collection3: " + collection3);
				System.out.println("collection4: " + collection4);
				System.out.println();

				System.out.println("Collections.disjoint(collection1, collection2): "
						+ Collections.disjoint(collection1, collection2));
				System.out.println("Collections.disjoint(collection1, collection3): "
						+ Collections.disjoint(collection1, collection3));
				System.out.println("Collections.disjoint(collection1, collection4): "
						+ Collections.disjoint(collection1, collection4));
			}

			Utils.printDelimiterLine2();

			// public static int frequency(Collection<?> collection, Object
			// object) {...}
			{
				Collection<String> collection1 = new ArrayList<>(Arrays.asList(null, "a1", "b2"));
				Collection<String> collection2 = new ArrayList<>(Arrays.asList("c3", "d4", "e5"));
				Collection<String> collection3 = new ArrayList<>(Arrays.asList("c3", "c3", "f6"));
				Collection<String> collection4 = new ArrayList<>(Arrays.asList("c3", "c3", "c3"));

				System.out.println("collection1: " + collection1);
				System.out.println("collection2: " + collection2);
				System.out.println("collection3: " + collection3);
				System.out.println("collection4: " + collection4);
				System.out.println();

				System.out.println(
						"Collections.frequency(collection1, \"c3\"): " + Collections.frequency(collection1, "c3"));
				System.out.println(
						"Collections.frequency(collection2, \"c3\"): " + Collections.frequency(collection2, "c3"));
				System.out.println(
						"Collections.frequency(collection3, \"c3\"): " + Collections.frequency(collection3, "c3"));
				System.out.println(
						"Collections.frequency(collection4, \"c3\"): " + Collections.frequency(collection4, "c3"));
				System.out.println(
						"Collections.frequency(collection1, null): " + Collections.frequency(collection1, null));
			}

			Utils.printDelimiterLine2();

			// public static int indexOfSubList(List<?> source, List<?> target)
			// {...}
			// public static int lastIndexOfSubList(List<?> source, List<?>
			// target) {...}
			{
				List<String> list1 = new ArrayList<>(Arrays.asList("xxx", "a1", "b2", "xxx", "a1", "b2", "xxx"));
				List<String> list2 = new ArrayList<>(Arrays.asList("a1", "b2"));
				List<String> list3 = new ArrayList<>(Arrays.asList("a1", "c3"));

				System.out.println("list1: " + list1);
				System.out.println("list2: " + list2);
				System.out.println("list3: " + list3);
				System.out.println();

				System.out.println(
						"Collections.indexOfSubList(list1, list2): " + Collections.indexOfSubList(list1, list2));
				System.out.println(
						"Collections.indexOfSubList(list1, list3): " + Collections.indexOfSubList(list1, list3));
				System.out.println("Collections.lastIndexOfSubList(list1, list2): "
						+ Collections.lastIndexOfSubList(list1, list2));
				System.out.println("Collections.lastIndexOfSubList(list1, list3): "
						+ Collections.lastIndexOfSubList(list1, list3));
			}

			Utils.printDelimiterLine2();

			// public static <T extends Object & Comparable<? super T>> T
			// min(Collection<? extends T> collection) {...}
			// public static <T> T min(Collection<? extends T> collection,
			// Comparator<? super T> comparator) {...}
			// public static <T extends Object & Comparable<? super T>> T
			// max(Collection<? extends T> collection) {...}
			// public static <T> T max(Collection<? extends T> collection,
			// Comparator<? super T> comparator) {...}
			{
				Collection<String> collection = new ArrayList<>(Arrays.asList("bx3", "ex2", "ax4", "cx5", "dx1"));

				System.out.println("collection: " + collection);
				System.out.println();

				Comparator<String> comparator = new Comparator<String>() {

					@Override
					public int compare(String object1, String object2) {
						int number1 = Integer.parseInt(String.valueOf(object1.charAt(2)));
						int number2 = Integer.parseInt(String.valueOf(object2.charAt(2)));
						return Integer.compare(number1, number2);
					}

				};

				System.out.println("Collections.min(collection): " + Collections.min(collection));
				System.out.println("Collections.max(collection): " + Collections.max(collection));
				System.out
						.println("Collections.min(collection, comparator): " + Collections.min(collection, comparator));
				System.out
						.println("Collections.max(collection, comparator): " + Collections.max(collection, comparator));
			}

			Utils.printDelimiterLine2();

			// public static <T> ArrayList<T> list(Enumeration<T> enumeration)
			// {...}
			{
				Vector<String> vector = new Vector<>();

				vector.add("a1");
				vector.add("b2");
				vector.add("c3");

				System.out.println("Arrays.toString(vector.toArray()): " + Arrays.toString(vector.toArray()));
				System.out.println();

				Enumeration<String> enumeration = vector.elements();
				List<String> list = Collections.list(enumeration);
				System.out.println("list: " + list);
			}

			Utils.printDelimiterLine2();

			// public static <T> Enumeration<T> enumeration(final Collection<T>
			// collection) {...}
			{
				Collection<String> collection = new ArrayList<>(Arrays.asList("a1", "b2", "c3"));

				System.out.println("collection: " + collection);
				System.out.println();

				Enumeration<String> enumeration = Collections.enumeration(collection);
				while (enumeration.hasMoreElements()) {
					System.out.println("enumeration.nextElement(): " + enumeration.nextElement());
				}
			}

			Utils.printDelimiterLine2();

			// public static <T> boolean addAll(Collection<? super T>
			// collection, T... elements) {...}
			{
				Collection<String> collection = new ArrayList<>(Arrays.asList("a1", "b2"));

				System.out.println("collection: " + collection);
				System.out.println();

				collection.addAll(Arrays.asList("c3", "d4"));
				System.out.println("collection: " + collection);
				System.out.println();

				// The method Collections.addAll(...) may run significantly
				// faster than other implementation such as the method
				// Collection.addAll(...).
				System.out.println("Collections.addAll(collection, \"e5\", \"f6\"): "
						+ Collections.addAll(collection, "e5", "f6"));
				System.out.println("collection: " + collection);
				System.out.println("Collections.addAll(collection, new String[] {\"g7\", \"h8\"}): "
						+ Collections.addAll(collection, new String[] { "g7", "h8" }));
				System.out.println("collection: " + collection);
			}

			Utils.printDelimiterLine2();

			// public static <T> boolean replaceAll(List<T> list, T oldValue, T
			// newValue) {...}
			{
				List<String> list1 = new ArrayList<>(Arrays.asList("a1", "xxx", "b2", "xxx", "c3", "xxx"));
				List<String> list2 = new ArrayList<>(Arrays.asList("a1", null, "b2", null, "c3", null));

				System.out.println("list1: " + list1);
				System.out.println("list2: " + list2);
				System.out.println();

				System.out.println("Collections.replaceAll(list1, \"xxx\", \"zzz\"): "
						+ Collections.replaceAll(list1, "xxx", "zzz"));
				System.out.println("list1: " + list1);
				System.out.println("Collections.replaceAll(list1, \"yyy\", \"zzz\"): "
						+ Collections.replaceAll(list1, "yyy", "zzz"));
				System.out.println("list1: " + list1);
				System.out.println(
						"Collections.replaceAll(list2, null, \"zzz\"): " + Collections.replaceAll(list2, null, "zzz"));
				System.out.println("list2: " + list2);
			}

			Utils.printDelimiterLine2();

			// public static <T> void copy(List<? super T> destination, List<?
			// extends T> source) {...}
			{
				List<String> list1 = new ArrayList<>(Arrays.asList("item11", "item12", "item13", "item14", "item15"));
				List<String> list2 = new ArrayList<>(Arrays.asList("item21", "item22", "item23"));

				System.out.println("list1: " + list1);
				System.out.println("list2: " + list2);
				System.out.println();

				Collections.copy(list1, list2);
				System.out.println("list1: " + list1);
				System.out.println("list2: " + list2);
			}

			Utils.printDelimiterLine2();

			// public static <T> void fill(List<? super T> list, T object) {...}
			{
				List<String> list = new ArrayList<>(Arrays.asList("item1", "item2", "item3", "item4", "item5"));

				System.out.println("list: " + list);
				System.out.println();

				Collections.fill(list, "xxx");

				System.out.println("list: " + list);
			}

			Utils.printDelimiterLine2();

			// public static <T> List<T> nCopies(int number, T object) {...}
			{
				System.out.println("Collections.nCopies(3, null): " + Collections.nCopies(3, null));
				System.out.println("Collections.nCopies(5, \"xxx\"): " + Collections.nCopies(5, "xxx"));
				System.out.println();

				List<String> list = new ArrayList<>();
				list.add("abc");
				list.add("def");
				list.add("ghi");
				System.out.println("list: " + list);

				System.out.println(
						"list.addAll(Collections.nCopies(3, null)): " + list.addAll(Collections.nCopies(3, null)));
				System.out.println("list: " + list);
			}

			Utils.printDelimiterLine2();

			// public static void shuffle(List<?> list) {...}
			// public static void shuffle(List<?> list, Random random) {...}
			{
				List<String> list = new ArrayList<>(Arrays.asList("item1", "item2", "item3", "item4", "item5"));

				System.out.println("list: " + list);
				System.out.println();

				Collections.shuffle(list);
				System.out.println("list: " + list);
				Collections.shuffle(list);
				System.out.println("list: " + list);
				Collections.shuffle(list);
				System.out.println("list: " + list);
				System.out.println();

				Random random = new Random(12345);
				Collections.shuffle(list, random);
				System.out.println("list: " + list);
				Collections.shuffle(list, random);
				System.out.println("list: " + list);
				Collections.shuffle(list, random);
				System.out.println("list: " + list);
			}

			Utils.printDelimiterLine2();

			// public static <T extends Comparable<? super T>> void sort(List<T>
			// list) {...}
			// public static <T> void sort(List<T> list, Comparator<? super T>
			// comparator) {...}
			{
				List<String> list = new ArrayList<>(Arrays.asList("b3", "d5", "a2", "e1", "c4"));

				System.out.println("list: " + list);
				System.out.println();

				Collections.sort(list);
				System.out.println("list: " + list);

				Comparator<String> comparator = new Comparator<String>() {

					@Override
					public int compare(String object1, String object2) {
						int number1 = Integer.parseInt(String.valueOf(object1.charAt(1)));
						int number2 = Integer.parseInt(String.valueOf(object2.charAt(1)));
						return Integer.compare(number1, number2);
					}

				};
				Collections.sort(list, comparator);
				System.out.println("list: " + list);

				Collections.sort(list, null);
				System.out.println("list: " + list);
			}

			Utils.printDelimiterLine2();

			// public static void reverse(List<?> list) {...}
			{
				List<String> list = new ArrayList<>(Arrays.asList("a1", "b2", "c3", "d4", "e5"));

				System.out.println("list: " + list);
				Collections.reverse(list);
				System.out.println("list: " + list);
			}

			Utils.printDelimiterLine2();

			// public static <T> Comparator<T> reverseOrder() {...}
			// public static <T> Comparator<T> reverseOrder(Comparator<T>
			// comparator) {...}
			{
				List<String> list = new ArrayList<>(Arrays.asList("a3", "b2", "c5", "d1", "e4"));

				System.out.println("list: " + list);
				System.out.println();

				Collections.sort(list, Collections.reverseOrder());
				System.out.println("list: " + list);

				Comparator<String> comparator = new Comparator<String>() {

					@Override
					public int compare(String object1, String object2) {
						int number1 = Integer.parseInt(String.valueOf(object1.charAt(1)));
						int number2 = Integer.parseInt(String.valueOf(object2.charAt(1)));
						return Integer.compare(number1, number2);
					}

				};
				Collections.sort(list, Collections.reverseOrder(comparator));
				System.out.println("list: " + list);
			}

			Utils.printDelimiterLine2();

			// public static void swap(List<?> list, int i, int j) {...}
			{
				List<String> list = new ArrayList<>(Arrays.asList("a1", "b2", "c3", "d4", "e5"));

				System.out.println("list: " + list);
				Collections.swap(list, 1, 3);
				System.out.println("list: " + list);
				Collections.swap(list, 0, 4);
				System.out.println("list: " + list);
			}

			Utils.printDelimiterLine2();

			// public static void rotate(List<?> list, int distance) {...}
			{

				List<String> list1 = new ArrayList<>(Arrays.asList("a1", "b2", "c3", "d4", "e5"));
				List<String> list2 = new ArrayList<>(Arrays.asList("a1", "b2", "c3", "d4", "e5"));
				List<String> list3 = new ArrayList<>(Arrays.asList("a1", "b2", "c3", "d4", "e5"));

				System.out.println("list1: " + list1);
				System.out.println("list2: " + list2);
				System.out.println("list3: " + list3);
				System.out.println();

				Collections.rotate(list1, 1);
				System.out.println("list1: " + list1);

				Collections.rotate(list2, 2);
				System.out.println("list2: " + list2);

				Collections.rotate(list3, 3);
				System.out.println("list3: " + list3);
			}

			Utils.printDelimiterLine2();

			// public static <E> Xxx<E> checkedXxx(Xxx<E> xxx, Class<E> type)
			// {...}
			// public static <K, V> Xxx<K, V> checkedXxx(Xxx<K, V> xxx, Class<K>
			// keyType, Class<V> valueType) {...}
			{
				// -------------------------------------------------------------
				// Sometimes, elements of wrong types may be added into the
				// collections.
				// -------------------------------------------------------------
				List<String> list = new ArrayList<>();

				// A collection can be converted to its Raw version, though
				// warned.
				@SuppressWarnings("rawtypes")
				List rawList = list;

				// Thus, elements of wrong types can be added into the
				// collections, without exceptions but with warnings.
				rawList.add(new Date());

				// ...

				// The java.lang.ClassCastException exception occurs when the
				// added elements of wrong types are being converted.
				try {
					System.out.println("collection.get(0): " + list.get(0));
				} catch (ClassCastException e) {
					System.out.println("Exception #1 Occurs When Accessing Element (NG)");
					e.printStackTrace();
				}
				System.out.println();

				list.clear();

				// A collection can be converted to its Type Safe version,
				// though warned.
				@SuppressWarnings("rawtypes")
				List typeSafeRawList = Collections.checkedList(list, String.class);

				// The java.lang.ClassCastException exception occurs when the
				// elements of wrong types are being added.
				try {
					typeSafeRawList.add(new Date());
				} catch (ClassCastException e) {
					System.out.println("Exception #2 Occurs When Adding Element (OK)");
					e.printStackTrace();
				}
				System.out.println();

				// -------------------------------------------------------------
				// The same issue applies to the map.
				// -------------------------------------------------------------
				Map<String, String> map = new HashMap<>();

				// A map can be converted to its Raw version, though warned.
				@SuppressWarnings("rawtypes")
				Map rawMap = map;

				// Thus, entries of wrong types can be added into the maps,
				// without exceptions but with warnings.
				rawMap.put("someKey", new Date());

				// ...

				// The java.lang.ClassCastException exception occurs when the
				// added entries of wrong types are being converted.
				try {
					System.out.println("map.get(\"someKey\"): " + map.get("someKey"));
				} catch (ClassCastException e) {
					System.out.println("Exception #1 Occurs When Accessing Entry (NG)");
					e.printStackTrace();
				}
				System.out.println();

				map.clear();

				// A map can be converted to its Type Safe version, though
				// warned.
				@SuppressWarnings("rawtypes")
				Map typeSafeMap = Collections.checkedMap(map, String.class, String.class);

				// The java.lang.ClassCastException exception occurs when the
				// entries of wrong types are being added.
				try {
					typeSafeMap.put("someKey", new Date());
				} catch (ClassCastException e) {
					System.out.println("Exception #2 Occurs When Adding Entry (OK)");
					e.printStackTrace();
				}
			}

			// public static final <T> Xxx<T> emptyXxx() {...}
			// public static final <K,V> Xxx<K,V> emptyXxx() {...}
			// public static <T> Xxx<T> emptyXxx() {...}
			{
				// The above methods will not be tested here.
			}

			// public static <T> Xxx<T> synchronizedXxx(Xxx<T> xxx) {...}
			// public static <K,V> Xxx<K,V> synchronizedXxx(Xxx<K,V> xxx) {...}
			{
				// The above methods will not be tested here.
			}

			// public static <T> Xxx<T> unmodifiableXxx(Xxx<? extends T> xxx)
			// {...}
			// public static <K,V> Xxx<K,V> unmodifiableXxx(Xxx<? extends K, ?
			// extends V> xxx) {...}
			{
				// The above methods will not be tested here.
			}
		}

		Utils.printDelimiterLine1();

		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Testing the Ways to Iterate over the Collection
		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// =====================================================================
		// Using the Iterator Object
		// =====================================================================
		{
			Collection<String> collection = new ArrayList<>();

			collection.add("abc");
			collection.add("def");
			collection.add("ghi");

			{
				for (Iterator<String> iterator = collection.iterator(); iterator.hasNext();) {
					String element = iterator.next();
					System.out.println(element);
				}
			}

			System.out.println();

			{
				Iterator<String> iterator = collection.iterator();
				while (iterator.hasNext()) {
					String element = iterator.next();
					System.out.println(element);
				}
			}
		}

		Utils.printDelimiterLine1();

		// =====================================================================
		// Using the forEach Statement (Recommended)
		// =====================================================================
		{
			Collection<String> collection = new ArrayList<>();

			collection.add("abc");
			collection.add("def");
			collection.add("ghi");

			for (String element : collection) {
				System.out.println(element);
			}
		}

		Utils.printDelimiterLine1();

		// =====================================================================
		// Using the Enumeration Object
		// =====================================================================
		{
			Vector<String> collection = new Vector<>();

			collection.add("abc");
			collection.add("def");
			collection.add("ghi");

			for (Enumeration<String> elements = collection.elements(); elements.hasMoreElements();) {
				String element = elements.nextElement();
				System.out.println(element);
			}
		}

		Utils.printDelimiterLine1();

		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Testing the Bulk Operations
		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// =====================================================================
		// Find the Intersection
		// =====================================================================
		{
			Collection<String> collection1 = new ArrayList<>(
					Arrays.asList("xxx", "value1", "xxx", "value2", "xxx", "value3"));
			Collection<String> collection2 = new TreeSet<>(
					Arrays.asList("value1", "value2", "value3", "value4", "value5", "value6"));

			System.out.println("collection1: " + collection1);
			System.out.println("collection2: " + collection2);
			System.out.println();

			Set<String> result = new HashSet<>(collection1);
			result.retainAll(collection2);
			System.out.println("new TreeSet<>(result): " + new TreeSet<>(result));
		}

		Utils.printDelimiterLine1();

		// =====================================================================
		// Remove Parts
		// =====================================================================
		{
			Map<String, String> allEmployees = new HashMap<>();
			allEmployees.put("A001", "Tom");
			allEmployees.put("B032", "Jack");
			allEmployees.put("C101", "Linda");
			allEmployees.put("D257", "Mary");
			allEmployees.put("E094", "Steven");
			System.out.println("new TreeMap<>(allEmployees): " + new TreeMap<>(allEmployees));

			Set<String> terminatedEmployees = new HashSet<>(Arrays.asList("B032", "D257", "E094"));
			System.out.println("new TreeSet<>(terminatedEmployees): " + new TreeSet<>(terminatedEmployees));
			System.out.println();

			allEmployees.keySet().removeAll(terminatedEmployees);
			System.out.println("new TreeMap<>(allEmployees): " + new TreeMap<>(allEmployees));
		}

		Utils.printDelimiterLine1();

		// =====================================================================
		// Use Views
		// =====================================================================
		{
			List<String> collection1 = new ArrayList<>();
			for (int i = 0; i < 9; i++) {
				collection1.add("item" + (i + 1));
			}
			System.out.println("collection1: " + collection1);

			Collection<String> collection2 = new ArrayList<>(Arrays.asList("abc", "def", "ghi"));
			System.out.println("collection2: " + collection2);
			System.out.println();

			Collection<String> someList = collection1.subList(0, 5);
			collection2.addAll(someList);
			System.out.println("collection2: " + collection2);
			System.out.println();

			someList.clear();
			System.out.println("collection1: " + collection1);
			System.out.println("collection2: " + collection2);
		}

		Utils.printDelimiterLine1();

		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// Testing the Conversion between Arrays and Collections
		// +++++++++++++++++++++++++++++++++++++++++++++++++
		// =====================================================================
		// The java.util.Arrays.asList(T...) method is used to convert an array
		// to a collection (java.util.List<T>).
		// =====================================================================
		{
			String[] array = new String[] { "item1", "item2", "item3" };
			System.out.println("Arrays.toString(array): " + Arrays.toString(array));

			Collection<String> collection = Arrays.asList(array);
			System.out.println("collection: " + collection);
		}

		Utils.printDelimiterLine1();

		// =====================================================================
		// The java.util.Collection.toArray(T[]) method is used to convert a
		// collection to an array.
		// =====================================================================
		{
			Collection<String> collection = new ArrayList<>();
			collection.add("item1");
			collection.add("item2");
			collection.add("item3");
			System.out.println("collection: " + collection);

			String[] array = collection.toArray(new String[0]);
			System.out.println("Arrays.toString(array): " + Arrays.toString(array));
		}

		Utils.printDelimiterLine1();
	}

}
