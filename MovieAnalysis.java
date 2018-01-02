/**
 * A class that adds all words to the BST and retrieves values from the BST
 * @author Alexander Koby
 * @version 2017.12.02
 */
public class MovieAnalysis {
    
    /**
     * Instance Variables
     */
    BinarySearchTree<Index>bst;
    /**
     * initializes the BST
     * O(1)
     */
    public MovieAnalysis(){
        bst = new BinarySearchTree<Index>();
    }
    /**
     * @param value is the value associated with "words"
     * @param words is an array storing each of the words in the phrase
     * 
     * Adds all of the words to the BST
     * 
     * Loops through all the words in the phrase
     * (1)Creates an index with that word
     * (2)Checks to see if the index is in the BST - if indexes match
     * (3)If it isn't in the BST, create/add the index to BST
     * (4)If it is in the BST, increment the value and numberOfOccurences of the Index
     * 
     * O(nlogn)
     */
    public void addContents(int value, String[] words){
        for(int i = 0; i < words.length; i++){
            if(bst.find(new Index(words[i])) == null){
                Index i1 = new Index(words[i]);
                i1.setNumberOfOccurences(1);
                i1.setTotalValue(value);
                bst.insert(i1);
            }
            
            else {
                bst.find(new Index(words[i])).setNumberOfOccurences(bst.find(new Index(words[i])).getNumberOfOccurences() + 1);
                bst.find(new Index(words[i])).setTotalValue(bst.find(new Index(words[i])).getTotalValue() + value);
            }
        }
    }
    /**
     * @param word is the word you're seeking the value for
     * 
     * Creates a new content with the same word
     * Looks for match, if it matches, return the match's total value/#occurences
     * If it doesn't exist, return null
     * @return returns the double value associated with each word or null if the word DNE
     * O(logn)
     */
    public Double retrieveWordSentimentValue(String word){
        if (bst.find(new Index(word))==null){
            return null;
        }
        else{
        
             return bst.find(new Index(word)).getAverage();
        }        
    }
    
    /**
     * Retrieves the BST
     * @return returns the BST
     * O(1)
     */
    public BinarySearchTree<Index> getBST(){
        return this.bst;
    }
}