/**
 * @author Alexander Koby
 * @version 2017.12.02
 * This class is used to create objects that will each hold a word, total value, number of occurences, and average
 */
public class Index implements Comparable<Index>{
    /**
     * instance variables
     */
    private String word;
    private int totalValue;
    private int numberOfOccurences;
    
    
    /**
     * Constructor
     * @param word is the you're creating an object for
     * 
     * sets the class word equal to the word parameter
     * sets the totalValue, numberOfOccurences equal to 0
     * O(1)
     */
    public Index(String word){
        this.word = word;
        this.numberOfOccurences = 0;
        this.totalValue = 0;
    }
    
    /**
     * returns the word of the index
     * @return returns the word of the object
     * O(1)
     */
    public String getWord(){
        return this.word;
    }
    
    /**
     * Sets the word of the index
     * @param word is the word you want to change the word to
     * O(1)
     */
    public void setWord(String word){
        this.word = word;
    }
    /**
     * returns the total value of the index
     * @return returns the total value associated with the index
     * O(1)
     */
    public int getTotalValue(){
        return this.totalValue;
    }
    /**
     * Sets the totalValue of the index
     * @param value is the new value you want associated with the index
     * O(1)
     */
    public void setTotalValue(int value){
        this.totalValue = value;
    }
    
    /**
     * returns the number of occurences of the index
     * @return returns the number of occurences of the index
     * O(1)
     */
    public int getNumberOfOccurences(){
        return this.numberOfOccurences;
    }
    /**
     * Sets the numberOfOccurences of the index
     * @param numberOfOccurences is the new number of occurences you want associated with the index
     * O(1)
     */
    public void setNumberOfOccurences(int numberOfOccurences){
        this.numberOfOccurences = numberOfOccurences;
    }
    /**
     * returns the averageValue of the index
     * @return returns the average value associated with the index
     * O(1)
     */
    public double getAverage(){
        if(this.getNumberOfOccurences() == 0){
            return 0;
        }
        else {
        return this.getTotalValue()/(double)this.getNumberOfOccurences();
        }
    }
    

    @Override
    /**
     * Compares two indexes
     * 
     * @param arg0 is the word index you're comparing to
     * @return returns a positive one if the word is bigger than arg0, negative one if it's less, 0 if equal
     * O(n), where n is the number of characters in the index's data field String
     */
    public int compareTo(Index arg0) {
        if(this.getWord().compareTo(arg0.getWord())>0){
            return 1;
        }
        else if (this.getWord().compareTo(arg0.getWord())<0){
            return -1;
        }
        else {
            return 0;
        }
    }
    }

