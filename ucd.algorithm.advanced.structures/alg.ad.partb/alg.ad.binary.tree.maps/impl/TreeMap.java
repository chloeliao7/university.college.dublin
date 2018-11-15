package impl;
//Part 2 
import java.util.Iterator;

import core.Position;
import impl.AbstractBinaryTree.Node;
import impl.TreeMap.TreeEntry;
import core.Entry;
import core.List;
import core.Map;
import core.Visitor;

import impl.AbstractBinaryTree;
import core.BinaryTree;
import core.List;
import core.Position;
import core.Visitor;

@SuppressWarnings("rawtypes")
public class TreeMap<K,V> implements Comparable, Map<K, V> {
	
	//PART 2 QUESTION A
	@SuppressWarnings("hiding")
	class TreeEntry<K,V> implements Comparable<TreeEntry<K,V>>{
		  K key; //key of every entry in the map
		  V value; //value of entry in map

		  //store all entries in TreeEntry Class, Part B
		 
		  //Implementing comparable interface - used for placing
		  //Value in correct place in Map
    	@Override
    	public int compareTo(TreeEntry<K, V> o) {
    		return ((Comparable) this.key).compareTo(o.key);
    	}
        
        public TreeEntry(K key, V value) {

            this.key = key;
            this.value = value;
           
        }
        public void addEntry(TreeEntry e) {
        	allEntries.insertLast(e);
        	
        }
        
        //Might not always have a value
        public TreeEntry(K key) {
            this(key, null);
        }
        
        
        @Override
        public String toString() {
            return "{<" + key + ">,<" + value + ">}";
        }

		public K key() {
			
			return this.key;
		}
		public V value() {
			return this.value;
		}

	} //end of TreeEntry Class
	
	

	//PART 2 QUESTION B - size, empty, toString and put, get and remove operations
	
	 /**
    * The number of entries stored in map
    * 
    * @return
    */
	@Override
   public int size() {
       return size;
   }

	@Override
	public boolean isEmpty() {
		
		return size == 0;
	}
	
	public String toString() {
		return bst.toString();
	}
	
	//size of Map
	private int size = 0;
	TreeEntry<K,V> valAfter; //Store entry after operations such as put to see if new element added
	boolean extraCheck = true; //Needed for iterator class
	//Question 2 (a) states to store entries in TreeEntry class, used in the add Entry method of TreeEntry
	private  List<TreeEntry<K,V>> allEntries = new LinkedList<TreeEntry<K,V>>();
	
	//Create BST to implement Map interface
	BinarySearchTree<TreeEntry<K,V>> bst = new BinarySearchTree<TreeEntry<K,V>>();
	
	
	//No-args constructor
	public TreeMap() {
		bst = new BinarySearchTree<TreeEntry<K, V>>();
	}
	//-------------------------------------------------------------------------------------
	//If value is in the tree already, then null is returned
	public V put(K k, V v) {
		TreeEntry<K, V> entry = new TreeEntry<K, V>(k, v);		
		valAfter = bst.insert(entry);
		if(valAfter == null) { //new element just added
			entry.addEntry(entry); size++; //send to entry method to track local change and increase size
		}
			return (V) valAfter; //return value after put operation
	}
	
	@Override
	public V get(K k) {
		TreeEntry<K, V> entry = new TreeEntry<K, V>(k);
		TreeEntry<K,V> value = bst.find(entry);
		if(value == null)System.out.println("Key does not exist");
		return (V)value;		
	}

	@Override
	public V remove(K k) {
		TreeEntry<K, V> entry = new TreeEntry<K, V>(k);
		entry.value =  (V) bst.remove(entry);
		if(entry.value != null) {
		size--;removeEntry(entry); //send to entry method to track local change and increase size
		}
		return (V) entry;
	}
	
	public void removeEntry(TreeEntry<K,V> entry) {      
		List<TreeEntry<K,V>> temp = new LinkedList<TreeEntry<K,V>>();
    	Position<TreeEntry<K, V>> current = allEntries.first(); //capture first before iterating through to find one to delete
    	for(int i = 0; i < allEntries.size(); i++) {
			
			if(current.element().key != entry.key) //If the entry has not be removed, then add it to temp list
				temp.insertLast(current.element());
				
			current = allEntries.next(current);
		}
    	allEntries = temp; //allEntries will now be up-to-date and local entries changed to reflect remove operation
    }
	
	
	
	//PART 2 QUESTION C - Iterator Class implementing entries, keys and values methods
	
	class ListIterator<T> implements Iterator<T> {
	    private Position<TreeEntry<K, V>> position; 
	    private List<TreeEntry<K, V>> list;

	    public ListIterator(List<T> list) {
	        this.list =  (List<TreeMap<K, V>.TreeEntry<K, V>>) list;
	    }
	    public boolean hasNext() {
	    	
	    		
	        if (position == null) {
	        	
	            return !list.isEmpty();
	        } else {
	            try {
	            	
	                list.next(position);
	            } catch (RuntimeException e) {
	            	
	                return false;
	            }
	        }
	       
	        return true;
	    }
	    public String toString() { //prints iterator to string
	    	return this.list.toString();
	    }

	    public T next() {
	        if (position == null) {
	            position = list.first();
	        } else {
	            position = list.next(position);
	        }
	        
	        if(position == null) {
	        	extraCheck = false; //to stop going one over in certain cases
	        	return null;
	        } else
	        	 return (T) position.element();
	    }
	} //end of iterator class

	 /**
	    * The number of entries stored in map is returned 
	    * Override Map interface method entries()
	    * Using Iterator, cycle through all entries and insert in List of type TreeEntry called actualList
	    * return constructed ListIterator full of TreeEntry objects
	    * @return ListIterator<K>(temp); - A list iterator storing entries of the map
	    */
	@Override
	public Iterator<Entry<K, V>> entries() { 

		List<TreeEntry<K,V>> actualList = new LinkedList<TreeEntry<K,V>>(); 
		List<TreeEntry<K,V>> tempList = new LinkedList<TreeEntry<K,V>>(); //hold all the treeEntries
		Position<TreeEntry<K, V>> a = allEntries.first(); //capture first before iterating through
		for(int i = 0; i < allEntries.size(); i++) {
			tempList.insertLast((TreeEntry<K, V>) a.element());
			a = allEntries.next(a);
		}
		ListIterator it = new ListIterator(tempList);		
				while(it.hasNext() && extraCheck) {
					TreeEntry<K, V> temp = ((TreeEntry<K,V>) it.next());
					if(temp != null)
					actualList.insertLast(temp);
				}		
				System.out.println("entries are : " + actualList);
				return new ListIterator(actualList);	
	}
	 /**
	    * The number of Keys stored in map is returned 
	    * Override Map interface method keys()
	    * First, call Entries method to gather up all Key/Value pairs (TreeEntrys) in the map to make keys()  methods smaller
	    *  temp will store all the keys from the iterator as it iterates through all Entrys
	    *  Create ListIterator<K> from temp list and return
	    * @return ListIterator<K>(temp); - A list iterator storing Keys of the map
	    */
	
	@Override
	public Iterator<K> keys() {
	LinkedList<K> temp = new LinkedList<K>();
	Iterator iterator = entries();
	while(iterator.hasNext()) {
		
		try {
			temp.insertLast( (((TreeEntry<K,V>) iterator.next()).key));
		} catch(NullPointerException npe) {
			break;
		}
		}
	System.out.println("Keys are:  " + temp);
	return new ListIterator<K>(temp);
}
	/**
	    * The number of Values stored in map is returned 
	    * Override Map interface method values()
	    * First, call Entries method to gather up all Key/Value pairs (TreeEntrys) in the map to make values() methods smaller
	    * temp will store all the values from the iterator as it iterates through all Entrys
	    * Catch RunTimeException just in case calling .value() on a null value if iterates on too many at the end
	    *  Create ListIterator<V> from temp list and return
	    * @return ListIterator<V>(temp); - A list iterator storing Values of the map
	    */
	@Override
		public Iterator<V> values() {
		LinkedList<V> temp = new LinkedList<V>();
		Iterator iterator = entries();
		while(iterator.hasNext()) {
			try {
				temp.insertLast( (((TreeEntry<K,V>) iterator.next()).value()));
			} catch(NullPointerException npe) {
				break;
			}
			}
		System.out.println("Values are:  " + temp); //toString prints all values in map
		return new ListIterator<V>(temp);
	}
	//Override method does not need to be implemented for this TreeMap class as TreeEntry used its compareTo() method
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//After using put and remove operation, print our is same as BST.java class
	public static void main(String [] args) {
		TreeMap<Integer,String> map = new TreeMap<Integer,String>(); //Create Tree map
		map.put(24, "");
		map.put(12, "");
		map.put(36, "");
		map.put(5, "");
		map.put(7, "");
		map.put(2, "");
		map.put(76, "");
		map.remove(24);
		map.put(18,"");
		map.put(24, "");
		map.keys(); //print all keys in map can also use map.values(); - to print all the "" stored in each entry
		System.out.println("map is " + map); //Calling map's toString method
	}
}