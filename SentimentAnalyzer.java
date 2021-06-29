import java.util.Arrays;

public class SentimentAnalyzer {
    // Tip: labeled continue can be used when iterating featureSet + convert review to lower-case
	public static int[] detectProsAndCons(String review, String[][] featureSet, String[] posOpinionWords,
			String[] negOpinionWords) {
		int[] featureOpinions = new int[featureSet.length]; // output
        
        // your code ~ you will be invoking getOpinionOnFeature	
		int index=0;
		 for(String[] features:featureSet) {
			
			//System.out.println("begin"+index);
		   for(String feature:features) {
			  if (review.contains(feature)){
				 // System.out.println(feature);
				 featureOpinions[index]= getOpinionOnFeature(review, feature, posOpinionWords, negOpinionWords);
				 break;
			  } 
		  }   
		  
		   index++;
		}
		return featureOpinions;
	}

	// First invoke checkForWasPhrasePattern and 
	// if it cannot find an opinion only then invoke checkForOpinionFirstPattern
	private static int getOpinionOnFeature(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
		
		// your code
		int opinion=checkForWasPhrasePattern(review,feature, posOpinionWords,negOpinionWords);
		if(opinion!=0) {
			return opinion;
		}
		else {
			return checkForOpinionFirstPattern(review,feature,posOpinionWords, negOpinionWords);
		}
	}	

	// Tip: Look at String API doc. Methods like indexOf, length, substring(beginIndex), startsWith can come into play
	// Return 1 if positive opinion found, -1 for negative opinion, 0 for no opinion
	// You can first look for positive opinion. If not found, only then you can look for negative opinion
	private static int checkForWasPhrasePattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
		int opinion = 0;
		String pattern = feature + " was ";

		// your code
		if(review.contains(pattern)) {
			String words =review.substring(review.indexOf(pattern)+pattern.length());
		
		
		//System.out.println(words);
		String[] word= words.split("!|\\s+|,");
		//System.out.println(word[0]);
		for(String posOpinion:posOpinionWords) {
			if(posOpinion.equals(word[0])) {;
				return opinion=1;
			}
		}
		for(String negOpinion:negOpinionWords) {
			if(negOpinion.equals(word[0])) {
				//System.out.println(word[0]);
				return opinion=-1;
			}		
		}
		}
		return opinion; 	
	}
	
	// You can first look for positive opinion. If not found, only then you can look for negative opinion
	private static int checkForOpinionFirstPattern(String review, String feature, String[] posOpinionWords,
			String[] negOpinionWords) {
		// Extract sentences as feature might appear multiple times. 
		// split() takes a regular expression and "." is a special character 
		// for regular expression. So, escape it to make it work!!
		String[] sentences = review.split("\\.");
		int opinion = 0;
		
		// your code for processing each sentence. You can return if opinion is found in a sentence (no need to process subsequent ones)		
        for(String sentence:sentences) {
        	if(sentence.contains(feature)) {
        		String[] words=sentence.toLowerCase().split("\\s|,|!");
        		for(int i=0;i<words.length;i++) {
        			if(words[i].equals(feature)) {
        				for(String posOpinion:posOpinionWords) {
        					if(posOpinion.equals(words[i-1])) {
                				return opinion=1;			
                			}
        				}
        			}
        		}
        		
        		for(String negOpinion:negOpinionWords) {
        			if(sentence.toLowerCase().contains(negOpinion)) {
        				//System.out.println(opinion);
        				return opinion=-1;
        				
        			}
        		}
        	}
        }
		return opinion;
	}

	public static void main(String[] args) {
		//String review = "Haven't been here in years! Fantastic service and the food was delicious! Definetly will be a frequent flyer! Francisco was very attentive";
		
	    //String review = "Sorry OG, but you just lost some loyal customers. Horrible service, no smile or greeting just attitude. The breadsticks were stale and burnt, appetizer was cold and the food came out before the salad.";
		String review = "Not only was their food delicious, but I must say that the stars are more for the excellent service!";
		//String review = "I chose two items from the new menu, the shrimp scampi and shrimp and chicken carbonara, both with my favourite soup and some warm breaksticks. The soup was amazing, as always.";
		
		String[][] featureSet = { 
		        { "ambiance", "ambience", "atmosphere", "decor" },
				{ "dessert", "ice cream", "desert" }, 
				{ "food" }, 
				{ "soup" },
				{ "service", "management", "waiter", "waitress", "bartender", "staff", "server" } };
		String[] posOpinionWords = { "good", "fantastic", "friendly", "great", "excellent", "amazing", "awesome",
				"delicious" };
		String[] negOpinionWords = { "slow", "bad", "horrible", "awful", "unprofessional", "poor" };

		int[] featureOpinions = detectProsAndCons(review, featureSet, posOpinionWords, negOpinionWords);
		System.out.println("Opinions on Features: " + Arrays.toString(featureOpinions));
	
        
	}
}