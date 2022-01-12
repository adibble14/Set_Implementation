/**
 * author: Andrew Dibble
 * Date: 1/9/22
 * Class: Data Structures
 * MySet stores a collection of Objects (in an array) along
 * with the current size of the collection. An instance of MySet should behave just like a
 * set – there is no order associated with the items in the MySet. Furthermore, there
 * should not be two items in the MySet that are .equals() to each other at any time.
 */
public class MySet {
    private Object[] array;
    private int size;

    /**
     * the constructor for MySet, takes no parameters and initiates an Object array with a size of 0
     */
    public MySet(){ //constructor
        size = 0;
        array = new Object[0];
    }

    /**
     * the main method, calls the test method
     * @param args
     */
    public static void main(String[] args){  //main method
        test();
    }

    /**
     * the test method shows the output from all the methods that MySet has to offer
     */
    public static void test(){
        MySet set = new MySet();
        set.insert("string");
        set.insert("string");
        set.insert("food");
        set.insert(68);
        set.insert(901);
        set.insert(78.923);
        set.insert(78.923);
        set.insert('t');

        System.out.print("The elements in the set are: ");
        set.print();System.out.println();System.out.println();

        System.out.println("Is the set empty? " + set.isEmpty());
        System.out.println("Is 78 in the set? " + set.isPresent("78"));
        System.out.println("Is the string \"t\" in the set ?" + set.isPresent("t"));
        System.out.println("Is the character 't' in the set ?" + set.isPresent('t'));
        System.out.println("The size of the set is now: " + set.size());System.out.println();

        set.remove(78.923);
        System.out.println("Removed 78.923");
        set.print();System.out.println();
        System.out.println("The size of the set is now: " + set.size());System.out.println();

        set.makeEmpty();
        System.out.println("Removed all elements");
        System.out.println("Is the set empty? " + set.isEmpty());System.out.println();

        System.out.println("Adding the characters a,b, and c");
        set.insert('a');
        set.insert('b');
        set.insert('c');
        System.out.println("Adding null to the set");
        set.insert(null);

        System.out.println("Is the set empty? " + set.isEmpty());
        set.print();System.out.println();
        System.out.println("Is null in the set? " + set.isPresent(null));

    }

    /**
     * prints the elements of the Object array
     */
    public void print(){
        for(int i = 0; i<size; i++){
            System.out.print(array[i] + " ");
        }
    }

    /**
     * isEmpty checks to see if array has no elements
     * @return true is the size is 0, false otherwise
     */
    public boolean isEmpty(){
        return array.length == 0;
    }

    /**
     * removes all the elements from the array
     */
    public void makeEmpty(){
        array = new Object[0];  //making array point to a new array with no elements
        size = 0;
    }

    /**
     * returns the size of the Object array
     * @return the number of elements in the array
     */
    public int size(){
        return size;
    }

    /**
     * add the specified object to the array if it is not already there and is not null
     * @param o the object to be added
     */
    public void insert(Object o){
        boolean unique = true;
        for(Object obj: array){  //checking if this object is not already in the set
            if(obj.equals(o)){
                unique = false;
                break;
            }
        }
        if(unique && o != null) { //if it is unique, add it to array
            size++;
            Object[] newArray = new Object[size];  //creating a new array to transfer the elements in to
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            newArray[size - 1] = o;  //inserting the last element into the array
            array = newArray;
        }
    }

    /**
     * removes an item from the array
     * @param o the object to be removed
     */
    public void remove(Object o){
        for (Object obj:array) {  //for every object in array
            if(obj.equals(o)){  //if object equals the element to remove
                Object[] newArray = new Object[size-1];   //create a new array to transfer the elements into
                size--;
                for(int i=0, k=0;i<array.length;i++) {
                    if (!(array[i].equals(obj))) {   //if the element in array does not equal the specified object
                        newArray[k] = array[i];  //add it to the new array
                        k++;
                    }
                }
                array = newArray;  //set array equal to newArray
            }
        }
    }

    /**
     * checks if an object is in the array
     * @param o the object in question
     * @return true if the object is in the array, false otherwise
     */
    public boolean isPresent(Object o){
        for(Object obj: array){
            if(obj.equals(o)){
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
