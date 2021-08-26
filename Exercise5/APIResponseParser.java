package Exercise5;
public class APIResponseParser {
    
    /**
	 * Parses the input text and returns a Book instance containing
	 * the parsed data. 
	 * @param response text to be parsed
	 * @return Book instance containing parsed data
	 */
    public static Book parse(String response) {
       Book book = new Book();
       //title
		String endRule = "</title>";		
		String startRule = "<title>";		
		String title = parse(response, startRule, endRule); 
	    book.setTitle(title);
		
		// Your code
	    //author
	    startRule = "<name>";
	    endRule = "</name>";
	    String author = parse(response, startRule, endRule); 
	    book.setAuthor(author);
	    
	    //author
	    startRule = "<original_publication_year type=\"integer\">";
	    endRule = "</original_publication_year>";
	    String year = parse(response, startRule, endRule); 
	    book.setPublicationYear(Integer.parseInt(year));
	
	  //average rating 
	    startRule = "<average_rating>";
	    endRule = "</average_rating>";
	    double averageRating = Double.parseDouble(parse(response, startRule, endRule)); 
	    book.setAverageRating(averageRating);
	    
	  //ratings count
	    startRule = "<ratings_count type=\"integer\">";
	    endRule = "</ratings_count>";
	    String ratingsCount = parse(response, startRule, endRule); 
	    String[] count= ratingsCount.split(",");
	    StringBuilder builder = new StringBuilder();
	     for(String s : count) {
	         builder.append(s);
	     }
	     String str = builder.toString();
	    book.setRatingsCount(Integer.parseInt(str));
	    
	    //imageUrl
	    startRule = "<image_url>";
	    endRule = "</image_url>";
	    String imageUrl = parse(response, startRule, endRule); 
	    book.setImageUrl(imageUrl);
	    
		return book;
    }
    
    
    // write overloaded parse method with the 3 parameters response, startRule, endRule
   private static String parse(String response, String startRule, String endRule) {
   	 String feature = response.substring(response.indexOf(startRule)+startRule.length(),response.indexOf(endRule));
   	 System.out.println(feature);
   	 return feature;
   	 }
    
    public static void main(String[] args) {
		String response = "<work>" + 
	                            "<id type=\"integer\">2361393</id>" +
	                            "<books_count type=\"integer\">813</books_count>" +
	                            "<ratings_count type=\"integer\">1,16,315</ratings_count>" + 
	                            "<text_reviews_count type=\"integer\">3439</text_reviews_count>" +
	                            "<original_publication_year type=\"integer\">1854</original_publication_year>" +
								"<original_publication_month type=\"integer\" nil=\"true\"/>" +
								"<original_publication_day type=\"integer\" nil=\"true\"/>" +
								"<average_rating>3.79</average_rating>" +
								"<best_book type=\"Book\">" +
									"<id type=\"integer\">16902</id>" +
									"<title>Walden</title>" + 
									"<author>" +
										"<id type=\"integer\">10264</id>" + 
										"<name>Henry David Thoreau</name>" + 
									"</author>" +
									"<image_url>" + 
										"http://images.gr-assets.com/books/1465675526m/16902.jpg" +
									"</image_url>" +
									"<small_image_url>" + 
										"http://images.gr-assets.com/books/1465675526s/16902.jpg" +
									"</small_image_url>" +
								"</best_book>" +
							"</work>";
		
		APIResponseParser.parse(response);
		//System.out.println(parse(response).getAuthor());
	}
}