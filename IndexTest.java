import student.TestCase;
/**
 * 
 * @author Alexander Koby
 * @version 2017.12.02
 * A class that ensures all the methods in the Index class work properly
 *
 */
public class IndexTest extends TestCase{

    /**
     * Class Variables
     */
    private Index ind1;
    
    /**
     * Creates a new index before every test method is executed
     */
    public void setUp(){
        ind1 = new Index("pizza");
    }
    /**
     * Ensures the getWord method in the Index class works properly
     */
    public void testGetWord(){
        assertTrue(ind1.getWord().equals("pizza"));
    }
    /**
     * Ensures the setWord method in the Index class works properly
     */
    public void testSetWord(){
        assertTrue(ind1.getWord().equals("pizza"));
        
        ind1.setWord("cotton candy");
        assertTrue(ind1.getWord().equals("cotton candy"));
    }
    /**
     * Ensures the getTotalValue method in the Index class works properly
     */
    public void testGetTotalValue(){
        assertEquals(ind1.getTotalValue(), 0);
        
        ind1.setTotalValue(45);
        assertEquals(ind1.getTotalValue(), 45);
    }
    /**
     * Ensures the setTotalValue method in the Index class works properly
     */
    public void setTotalValue(){
        assertEquals(ind1.getTotalValue(), 0);
        
        ind1.setTotalValue(45);
        assertEquals(ind1.getTotalValue(), 45);
    }
    /**
     * Ensures the getNumberOfOccurences method in the Index class works properly
     */
    public void testGetNumberOfOccurences(){

        assertEquals(ind1.getNumberOfOccurences(), 0);
        
        ind1.setNumberOfOccurences(45);
        assertEquals(ind1.getNumberOfOccurences(), 45);
    }
    /**
     * Ensures the setNumberOfOccurences method in the Index class works properly
     */
    public void testSetNumberOfOccurences(){
        assertEquals(ind1.getNumberOfOccurences(), 0);
        
        ind1.setNumberOfOccurences(45);
        assertEquals(ind1.getNumberOfOccurences(), 45);
    }
    /**
     * Ensures the getAverage method in the Index class works properly
     */
    public void testGetAverage(){
        assertEquals(ind1.getAverage(), 0, .01);
        
        ind1.setTotalValue(500);
        ind1.setNumberOfOccurences(200);
        assertEquals(ind1.getAverage(), 2.50, .01);
    }

    /**
     * Ensures the compareTo method in the the Index class works properly
     */
    public void testCompareTo(){//ind1 = "pizza"
        Index ind2 = new Index("popcorn");
        assertEquals(ind1.compareTo(ind2), -1);
        
        Index ind3 = new Index("pizza");
        ind3.setNumberOfOccurences(3);
        ind3.setTotalValue(52);
        assertEquals(ind1.compareTo(ind3), 0);
        
        ind3.setWord("alphabet");
        assertEquals(ind1.compareTo(ind3), 1);
    }
    
}
