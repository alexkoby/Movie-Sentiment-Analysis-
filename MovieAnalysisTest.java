import student.TestCase;
/**
 * 
 * @author Alexander
 * @version 2017.12.02
 * 
 * This class tests to ensure all functions of the MovieAnalysis class
 * works properly
 *
 */
public class MovieAnalysisTest extends student.TestCase {
    /**
     * Class variables
     */
    private MovieAnalysis m1;

    /**
     * Creates a new MovieAnalysis before every test method is run
     */
    public void setUp() {
        m1 = new MovieAnalysis();
    }

    /**
     * Ensures the addContents method in the MovieAnalysis class
     * works properly
     */
    public void testAddContents() { //test for duplicates
        int valueNum1 = 3;
        String [] words1 = {"i", "enjoyed", "the", "movie"};
        
        m1.addContents(valueNum1, words1);
        
        int valueNum2 = 1;
        String [] words2 = {"i", "hated", "the", "show"};
        m1.addContents(valueNum2, words2);
        
       
        
        assertTrue(m1.getBST().find(new Index("i")).getWord().equals("i"));
        
        assertEquals(m1.getBST().find(new Index("i")).getNumberOfOccurences(), 2);
        
        assertEquals(m1.getBST().find(new Index("i")).getTotalValue(), 4);
        
        assertNull(m1.getBST().find(new Index("pork")));

    }

    /**
     * ensures the retrieveWordSentimentValue method in the MovieAnalysis class
     * works properly.
     */
    public void testRetrieveWordSentimentValue() {//don't include word if not in BST
        int valueNum1 = 3;
        String [] words1 = {"i", "enjoyed", "the", "movie"};
        
        m1.addContents(valueNum1, words1);
        
        int valueNum2 = 1;
        String [] words2 = {"i", "hated", "the", "show"};
        m1.addContents(valueNum2, words2);
        
       
        
        assertEquals(m1.retrieveWordSentimentValue("i"), 2, .01);
        
        assertEquals(m1.retrieveWordSentimentValue("enjoyed"), 3, .01);
        
        assertNull(m1.retrieveWordSentimentValue("pizza"));
    }
    
    /**
     * ensures that the getBST method in the MovieAnalysis class works properly
     */
    public void testGetBST() {
        int valueNum2 = 1;
        String [] words2 = {"i", "hated", "the", "show"};
        m1.addContents(valueNum2, words2);
        
        assertEquals(m1.getBST().find(new Index("i")).getTotalValue(), m1.retrieveWordSentimentValue("i"), .01);
        }
}