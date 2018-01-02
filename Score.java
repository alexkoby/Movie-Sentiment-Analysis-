import java.io.*; 
import java.util.Scanner;

/**
 * @author Alexander
 * @version 2017.12.02
 * 
 * This class is the driver class
 */
public class Score {

    public static void main (String[]args){
        MovieAnalysis movie1 = new MovieAnalysis();
        
        String filename ="C:\\Users\\Alexander\\workspace\\Final_Project_CSE17\\src\\MovieReviews"; //enter the full path to movieReviews.txt
        try (BufferedReader br = new BufferedReader(new FileReader(filename)))
        {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) //reads a line
            {
              String[] parts =  line.replaceAll("\\p{Punct}","").toLowerCase().split("\\s+");
              //.split("\\s+"); //remove punctuation, change to lowercase and put all words in parts
              int value = Integer.parseInt(parts[0]); //gets the value
              String[] wordsOnly = new String[parts.length-1]; //creates a new array with all the words without the value
              for(int i = 0; i <wordsOnly.length; i++){
                  wordsOnly[i] = parts[i+1];
              }
              movie1.addContents(value, wordsOnly);
            } 
        }
            catch (Exception e)
            {
                    System.out.println("Error" + e);
             }
        
        System.out.println("Enter a review: press return to exit");
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        String [] parts = line.replaceAll("\\p{Punct}", "").toLowerCase().split("\\s+");
        int numberOfWords = 0;
        double totalValue = 0;
        for(int i = 0; i<parts.length; i++){
            if(movie1.retrieveWordSentimentValue(parts[i])!=null){
                numberOfWords++;
                totalValue += movie1.retrieveWordSentimentValue(parts[i]);
            }
        }
        //Sees if entered any real words
        if(numberOfWords > 0){
        //Prints sentiment value
        System.out.println("The sentiment has a total value of: " + totalValue/numberOfWords);
      //Determines whether it is positive, neutral, or negative sentiment
            if(totalValue/numberOfWords > 2){
                System.out.println("Positive Sentiment");
            }
            else if (totalValue/numberOfWords == 2){
        
                System.out.println("Neutral Sentiment");
            }
            else {
                System.out.println("Negative Sentiment");
            }
        }
        else{
            //if no real words entered
            System.out.println("You didn't enter any words in the data set");
        }
        

    }
}