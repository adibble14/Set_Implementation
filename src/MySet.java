/**
 * A MySet class that behaves like a mathematical set.
 *
 * @author Andrew Dibble
 * @version January 17, 2022
 */
public class MySet {
    private Object[] elements;  // the elements of this MySet
    private int numActive;      // number of active elements
    private static int initialCapacity = 4; // size of the array

    /**
     * the default constructor for MySet, takes no parameters and initiates an Object array with a size of 0
     */
    public MySet(){ //constructor
        elements = new Object[initialCapacity];
        numActive = 0;
    }

    /**
     * another constructor for MySet, takes one parameter: the initial capacity and creates the array with that capacity
     */
    public MySet(int initialCapacity){
        elements = new Object[initialCapacity];
        numActive = 0;
    }

    /**
     * the main method, calls the test method
     * @param args
     */
    public static void main(String[] args){
        test();
    }

    /**
     * testing the methods
     */
    public static void test() {
        MySet testSet = new MySet();

        if (!testSet.isEmpty()) {
            System.out.println("Something is wrong 1.");
        }
        System.out.println("Inserting Andy ...");
        testSet.insert("Andy");
        if (testSet.isEmpty()) {
            System.out.println("Something is wrong 2.");
        }
        System.out.println("Inserting Belinda ...");
        testSet.insert("Belinda");
        testSet.printAll();

        // test isPresent
        if (!testSet.isPresent("Andy")) {
            System.out.println("Something is wrong 3.");
        }
        if (!testSet.isPresent("Belinda")) {
            System.out.println("Something is wrong 4.");
        }
        if (testSet.isPresent("Charlie")) {
            System.out.println("Something is wrong 5.");
        }
        System.out.println("Removing Andy ...");
        testSet.remove("Andy");
        if (testSet.isPresent("Andy")) {
            System.out.println("Something is wrong 6.");
        }
        testSet.printAll();

        // test insert -- when Gerald is inserted, the capacity
        // of the array should double
        System.out.println("Inserting Danielle ...");
        testSet.insert("Danielle");
        System.out.println("Inserting Ed ...");
        testSet.insert("Ed");
        System.out.println("Inserting Francine ...");
        testSet.insert("Francine");
        System.out.println("Inserting Gerald ...");
        testSet.insert("Gerald");
        testSet.printAll();

        // test remove
        System.out.println("Removing Danielle ...");
        testSet.remove("Danielle");
        testSet.printAll();

        // remove the item at the end of the array
        System.out.println("Removing Francine ...");
        testSet.remove("Francine");
        testSet.printAll();

        // test makeEmpty
        System.out.println("Making empty ...");
        testSet.makeEmpty();
        if (!testSet.isEmpty()) {
            System.out.println("Something is wrong 8.");
        }

        // try removing when there is nothing in the array
        System.out.println("Removing Belinda ...");
        testSet.remove("Belinda");
        testSet.printAll();
    }

    /**
     * prints all the elements of the Object array
     */
    public void printAll(){
        for (Object element : elements) {
            System.out.print(element + ", ");
        }
        System.out.println();
    }

    /**
     * isEmpty checks to see if array has no elements
     * @return true is the size is 0, false otherwise
     */
    public boolean isEmpty(){
        for(Object obj: elements){
            if(obj != null)
                return false;
        }
        return true;
    }

    /**
     * removes all the elements from the array
     */
    public void makeEmpty(){
        for(int i = 0; i<numActive;i++){
            elements[i] = null;
        }
    }

    /**
     * returns the size of the Object array
     * @return the number of elements in the array
     */
    public int size(){
        return numActive;
    }

    /**
     * add the specified object to the array if it is not already there and is not null
     * @param o the object to be added
     */
    public void insert(Object o){
        if(o == null){  //if null does nothing
            return;
        }
        for(int i = 0; i < numActive; i++){ //checking if the object is unique
            if(elements[i].equals(o)){
                return;
            }
        }
        for(int i = 0; i< elements.length;i++){  //if room for the object, insert it
            if(elements[i]==null){
                elements[i] = o;
                numActive++;
                return;
            }
        }

        Object[] elements2 = new Object[numActive*2];  //creating a new array with double the size

        System.arraycopy(elements, 0, elements2, 0, numActive);  //copying elements into the new array

        elements2[numActive] = o;  //adding the new element into the new array
        numActive++;

        elements = elements2;  //having elements point to new array

    }

    /**
     * removes an item from the array
     * @param o the object to be removed
     */
    public void remove(Object o){
        for(int i = 0; i < numActive; i++){
            if(o.equals(elements[i])){
                elements[i] = elements[numActive-1];  //switches the right most active element into positive with item to be removed
                elements[numActive-1] = null;  //sets the right most active to null
                numActive--;
            }
        }
    }

    /**
     * checks if an object is in the array
     * @param o the object in question
     * @return true if the object is in the array, false otherwise
     */
    public boolean isPresent(Object o){
        for(int i = 0; i < numActive; i++){
            if(elements[i].equals(o)){
                return true;
            }
        }
        return false;
    }

    /**
     * checks if two objects are equal
     * @param obj one of the objects to compare
     * @return true if the two objects are equals, false otherwise
     */
    @Override
    public boolean equals(Object obj){
        return (this == obj);
    }


}