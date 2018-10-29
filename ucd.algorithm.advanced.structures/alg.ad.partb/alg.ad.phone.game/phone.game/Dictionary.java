
// import com.sun.jmx.snmp.SnmpVarBindList;
import dsai.core.Iterator;
import dsai.core.List;
import dsai.core.Position;
import dsai.impl.LinkedList;
import dsai.impl.ListIterator;
import dsaii.core.Map;
import dsaii.core.Tree;
import dsaii.impl.ChainMap;
import dsaii.impl.LinkedTree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class implements the dictionary component of the predictive text
 * module of our mobile phone demonstrator. Underlying the implementation
 * is a tree data structure in which each node contains:
 *
 * <ul>
 *   <li> an integer value representing the current keystroke
 *   <li> a list of strings that contains the word fragments that correspond to
 *        the sequence of keystrokes in the path from the root node to that
 *        node.
 * </ul>
 *
 * This node data is modelled through the inner Keystroke class.
 *
 * @author remcollier
 */

public class Dictionary {

    /**
     * This class represents the contents of each node in the tree-based
     * implementation of the dictionary. Each node basically represents
     * a single keystroke, this class associates that keystroke with a list
     * of words the sequence of keystrokes corresponding to the path from the
     * root node to this node.
     */

    private class Keystroke {
        int key;
        private List<String> words;

        /**
         * Constructor for the Keystroke class, that takes an integer (the
         * keystroke) as a parameter.
         *
         * @param key
         */

        public Keystroke(int key) {
            this.key = key;
            words = new LinkedList<String>();
        }

        /**
         * Add another word to this node (this means that the word is a
         * potential word for the combination of keystrokes that matches
         * the path from the root node to this node).
         *
         * @param word
         */

        public void addWord(String word) {
            words.insertLast(word);
            // TODO: This method must be implemented in answer to question A1
        }

        /**
         * Return the list of words that is associated with this
         * keystroke. The current implementation does not impose any
         * ordering on the list (it is built based on the order in
         * which words are inserted into the node). In part B of the
         * assignment, you will need to modify this method to return
         * an ordered list of words.
         *
         * @return a list of words
         */
        public List<String> getWords() {


            return words;
        }




        /**
         * Generate a string representation of the node data for outputing
         * of the state of the tree during testing.
         *
         * @return
         */

        @Override
        public String toString() {
            StringBuffer buf = new StringBuffer();
            buf.append(key);
            buf.append(":");
            Iterator<String> it = new ListIterator<String>(words);
            while(it.hasNext()) {
                buf.append(" ");
                buf.append(it.next());
            }
            return buf.toString();
        }
    }

    /**
     * This map associates characters with keystrokes and is used by the
     * insertion algorithm to work out how to add words to the tree.
     */

    private static Map<Character, Integer> characterMap;

    /**
     * Initialization block for the characterMap
     */

    static {
        characterMap = new ChainMap<Character, Integer>();
        characterMap.put('a',2);
        characterMap.put('b',2);
        characterMap.put('c',2);
        characterMap.put('d',3);
        characterMap.put('e',3);
        characterMap.put('f',3);
        characterMap.put('g',4);
        characterMap.put('h',4);
        characterMap.put('i',4);
        characterMap.put('j',5);
        characterMap.put('k',5);
        characterMap.put('l',5);
        characterMap.put('m',6);
        characterMap.put('n',6);
        characterMap.put('o',6);
        characterMap.put('p',7);
        characterMap.put('q',7);
        characterMap.put('r',7);
        characterMap.put('s',7);
        characterMap.put('t',8);
        characterMap.put('u',8);
        characterMap.put('v',8);
        characterMap.put('w',9);
        characterMap.put('x',9);
        characterMap.put('y',9);
        characterMap.put('z',9);
    }

    /**
     * The tree
     */

    private Tree<Keystroke> tree;

    /**
     * Default Constructor that creates an empty dictionary.
     */

    public Dictionary() {
        tree = new LinkedTree<Keystroke>();
        tree.addRoot(new Keystroke(-1));
    }

    /**
     * Load the specified dictionary file. Each word in the file must
     * be inserted into the dictionary.
     *
     * @param filename the dictionary file to be loaded
     */

    public void load(String filename) {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(filename));// buffer reader reads any external files (memory buffer from which you can read)
        } catch (FileNotFoundException ex) {
            System.out.println("No Such File: " + filename);
        }
        try {
            String line = in.readLine(); // reads a line from the file or returns
            // null if there is no more to read
            while(line != null) { // there is no work than add line
                insert(line);
                line = in.readLine();
            }
        } catch (IOException ioe) {
            System.out.println("Error reading from: " + filename);
        }
        try {
            in.close(); // closes the file
        } catch (IOException ioe) {
            System.out.println("Error closing: " + filename);
        }
        // TODO: This method must be completed for question A4
    }

    /**
     * Insert the word into the dictionary. This algorithm loops through the
     * characters in the word, and uses the character map to work out what
     * keystroke should be used to select that character (e.g. a,b,c would
     * be selected by pressing the 2 key).
     *
     * For each sequence of keystrokes, the substring that corresponds to that
     * sequence is stored at the corresponding node so that
     *
     * @param word
     */

    public void insert(String word) {

        Position<Keystroke> crawl = tree.root(); // gives you the root from the tree
        for (char c : word.toCharArray()) {
            Keystroke keyStroke = new Keystroke(characterMap.get(c)); // Create a key stroke from the character in the word
            crawl = tree.addChild(crawl, keyStroke); // Add this key stroke to the tree and crawl to that child we just added
            // so we can add next time
            // getting the child back every time
        }
        // TODO add a special key stroke which is not there in the keyboard to denote that a word ends here.
        // crawl.addChild(crawl, new Keystroke(-1));
        // TODO: Thisdmethod must be completed for question A2
    }

        /**
         * Output the state of the dictionary (via delegation to the underlying
         * tree implementation).
         *
         * @return
         */

    @Override
    public String toString() {
        return tree.toString();
    }

    /**
     * Find the list of words that corresponds to the given sequence of
     * keystrokes.
     *
     * @param keystrokes a sequence of keystrokes
     *
     * @return a list of words
     */

    public List<String> findWords(List<Integer> keystrokes) {
        // TODO: This method must be completed for question A3
        Position<Integer> i = keystrokes.first();
        Position<Keystroke> crawl = tree.root();

        Position<Keystroke> child = null;

        while(!keystrokes.isEmpty()){
            Iterator<Position<Keystroke>> children = tree.children(crawl);
            boolean found = false;
            while(children.hasNext()){
                child = children.next();
                if(child.element().key == i.element()) // tree >> data >> element in the node
                {
                    found = true;
                    break;
                }
            }
            if(!found){
                return null;
            }
            i = keystrokes.next(i);
        }
        return child.element().words;

        /**
         * The default null response will cause the invoking method to
         * create a default word based on the sequence of keystrokes (i.e.
         * the same behaviour as if there was not entry in the dictionary
         * for the sequence of keystrokes).
         */
        // return null;

    }



    public List<String> sorter(List<String> words, int position) {

        for (String word : words) {

            key = word.splitAt(position);
            value = word.splitAt(position);
            (key -> value);
        }
    };
}
