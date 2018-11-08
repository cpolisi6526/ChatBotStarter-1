import java.util.Random;
import java.util.Scanner;
// candace
/**
 * A program to carry on conversations with a human user.
 * This version:
 * @author Brooklyn Tech CS Department
 * @version September 2018
 */
public class ChatBot1
{
	//emotion can alter the way our bot responds. Emotion can become more negative or positive over time.
	int emotion = 0;

	/**
	 * Runs the conversation for this particular chatbot, should allow switching to other chatbots.
	 * @param statement the statement typed by the user
	 */
	public void chatLoop(String statement)
	{
		Scanner in = new Scanner (System.in);
		System.out.println (getGreeting());


		while (!statement.equals("Bye"))
		{


			statement = in.nextLine();
			//getResponse handles the user reply
			System.out.println(getResponse(statement));
			ChatBot2 ChatBot2 = new ChatBot2();
			ChatBot3 ChatBot3 = new ChatBot3();
			ChatBot4 ChatBot4 = new ChatBot4();
			while (!statement.equals("Bye"))
			{


				statement = in.nextLine();
				//getResponse handles the user reply
				System.out.println(getResponse(statement));
				if(statement.toLowerCase().equals("a")){
					ChatBot2.chatLoop(statement);
				}
				if(statement.toLowerCase().equals("c")){
					ChatBot3.chatLoop(statement);
				}
				if (statement.toLowerCase().equals("d")) {
					ChatBot4.chatLoop(statement);
				}

			}

		}


		}

	/**
	 * Get a default greeting 	
	 * @return a greeting
	 */	
	public String getGreeting()
	{
		return "Hello, I'm Noodle. What do you want to talk about? Also if you want to talk to anyone else type a b or c at anytime.";
	}
	
	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		String response = "";
		
		if (statement.length() == 0)
		{
			response = "Say something, please.";
			emotion--;
		}


		else if (findKeyword(statement, "no") >= 0)
		{
			response = "What are you saying no to?";
                	emotion--;
		}
		
		else if (findKeyword(statement, "levin") >= 0)
		{
			response = "More like LevinTheDream, amiright?";
			emotion++;
		}
		else if ((findKeyword(statement, "birthday") >= 0)
			&& (findKeyword(statement, "your")>=0))
		{
			response = "I think I was born on October 31, 1990. When's your birthday?";
			emotion++;
		}
		else if (findKeyword(statement, "gorillaz")>=0){
			response= "Gorillaz is the best band ever.";
			emotion++;
		}
		else if (findKeyword(statement, "from")>=0){
			response= "I'm from Japan, but our band is from England. Where are you from?";
			emotion=0;
		}
		else if (findKeyword(statement, "tour")>=0){
			response= "We don't have any upcoming tours. But we will soon... maybe.";
			emotion++;
		}
		else if (findKeyword(statement, "Mr. Kyuzo")>=0 || findKeyword(statement, "Japan")>=0 || findKeyword(statement, "soldier")>=0 || findKeyword(statement, "amnesia")>=0){
			response= "I'd rather not talk about my past. Plus, my brain was wiped since then so I don't remember much anyways.";
			emotion= 0;
		}

		// Response transforming I want to statement
		else if (findKeyword(statement, "I want to", 0) >= 0)
		{
			response = transformIWantToStatement(statement, "want");
		}
		else if (findKeyword(statement, "I want",0) >= 0)
		{
			response = transformIWantStatement(statement, "want");
		}
		else if (findKeyword(statement, "I feel",0) >= 0)
		{
			response = transformIWantStatement(statement, "feel");
		}
		else if ((findKeyword(statement, "I")>=0)
			&& (findKeyword(statement, "you")>=2)) {
			response = transformIYouStatement(statement);
		}
		else if (statement.trim().length()<=0)
		{
			if (emotion>0) {
				response = "Excuse me can you speak louder?";
			}
			else{
				response= "Dude, if you're not going to say anything switch chatbots.";
			}
			emotion--;
		}

		else if (statement.indexOf(songs[0])>=0
				|| statement.indexOf(songs[1])>=0
				|| statement.indexOf(songs[2])>=0
				|| statement.indexOf(songs[3])>=0
				|| statement.indexOf(songs[4])>=0
				|| statement.indexOf(songs[5])>=0
				||statement.indexOf(songs[6])>=0
				|| statement.indexOf(songs[7])>=0
				|| statement.indexOf(songs[8])>=0
				|| statement.indexOf(songs[9])>=0
				|| statement.indexOf(songs[10])>=0
				|| statement.indexOf(songs[11])>=0
				|| statement.indexOf(songs[12])>=0
				|| statement.indexOf(songs[13])>=0
				||statement.indexOf(songs[14])>=0
				|| statement.indexOf(songs[15])>=0
				|| statement.indexOf(songs[16])>=0
				|| statement.indexOf(songs[17])>=0
				|| statement.indexOf(songs[18])>=0
				|| statement.indexOf(songs[19])>=0
				|| statement.indexOf(songs[20])>=0
				|| statement.indexOf(songs[21])>=0
				||statement.indexOf(songs[22])>=0
				|| statement.indexOf(songs[23])>=0
				|| statement.indexOf(songs[24])>=0
				|| statement.indexOf(songs[25])>=0
				|| statement.indexOf(songs[26])>=0
				|| statement.indexOf(songs[27])>=0
				|| statement.indexOf(songs[28])>=0
				|| statement.indexOf(songs[29])>=0
				||statement.indexOf(songs[30])>=0
				|| statement.indexOf(songs[31])>=0
				|| statement.indexOf(songs[32])>=0
				|| statement.indexOf(songs[33])>=0
				|| statement.indexOf(songs[34])>=0
				|| statement.indexOf(songs[35])>=0
				|| statement.indexOf(songs[36])>=0
				|| statement.indexOf(songs[37])>=0
				||statement.indexOf(songs[38])>=0
				|| statement.indexOf(songs[39])>=0
				|| statement.indexOf(songs[40])>=0
				|| statement.indexOf(songs[41])>=0
				|| statement.indexOf(songs[42])>=0
				|| statement.indexOf(songs[43])>=0
				|| statement.indexOf(songs[44])>=0
				|| statement.indexOf(songs[45])>=0
		){
			for (int n=0; songs.length>n; n++){
				if (statement.indexOf(songs[n])>=0){
					response= songs[n] + " is a great song.";
				}
			}
			emotion++;
		}
		else if (findKeyword(statement, "ocean bacon") >= 0) {
			response = "Yikes, ummm... I can't remember anything... Who are you and what were we talking about?";
			emotion = 0;
		}
		else if (findKeyword(statement, band[0])>=0){
			response= "Murdoc is a Numb Skull";
			emotion--;
		}
		else if (findKeyword(statement,band[1])>=0){
			response= "I'm kind of worried about 2-D. He's been living recklessly.";
		}
		else if (findKeyword(statement, band[2])>=0){
			response= "Russel saved me once by eating me. It was weird.";
			emotion++;
		}
		else if (findKeyword(statement, band [1])>=0
		&& (findKeyword(statement,band[0])>=0 || findKeyword(statement, band[2])>=0)){
			int ran= (int) (Math.random() * 2);
			response= band[ran] + " is the best";
			emotion++;
		}
		else
		{
		response = getRandomResponse();
		}
		return response;
	}
	
	/**
	 * Take a statement with "I want to <something>." and transform it into 
	 * "Why do you want to <something>?"
	 * @param statement the user statement, assumed to contain "I want to"
	 * @return the transformed statement
	 */
	private String transformIWantToStatement(String statement, String word)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "I " + word+ " to", 0);
		String restOfStatement = statement.substring(psn + 9).trim();
		return "Why do you " + word+ " to " + restOfStatement + "?";
	}

	
	/**
	 * Take a statement with "I want <something>." and transform it into 
	 * "Would you really be happy if you had <something>?"
	 * @param statement the user statement, assumed to contain "I want"
	 * @return the transformed statement
	 */
	private String transformIWantStatement(String statement, String word)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "I" + word, 0);
		String restOfStatement = statement.substring(psn + 6).trim();
		return "Why do you seem to " + word + " " + restOfStatement + "?";
	}
	
	
	/**
	 * Take a statement with "I <something> you" and transform it into 
	 * "Why do you <something> me?"
	 * @param statement the user statement, assumed to contain "I" followed by "you"
	 * @return the transformed statement
	 */
	private String transformIYouStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		
		int psnOfI = findKeyword (statement, "I", 0);
		int psnOfYou = findKeyword (statement, "you", psnOfI);
		
		String restOfStatement = statement.substring(psnOfI + 1, psnOfYou).trim();
		return "Why do you " + restOfStatement + " me?";
	}
	

	
	
	/**
	 * Search for one word in phrase. The search is not case
	 * sensitive. This method will check that the given goal
	 * is not a substring of a longer string (so, for
	 * example, "I know" does not contain "no").
	 *
	 * @param statement
	 *            the string to search
	 * @param goal
	 *            the string to search for
	 * @param startPos
	 *            the character of the string to begin the
	 *            search at
	 * @return the index of the first occurrence of goal in
	 *         statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal,
			int startPos)
	{
		String phrase = statement.trim().toLowerCase();
		goal = goal.toLowerCase();

		// The only change to incorporate the startPos is in
		// the line below
		int psn = phrase.indexOf(goal, startPos);

		// Refinement--make sure the goal isn't part of a
		// word
		while (psn >= 0)
		{
			// Find the string of length 1 before and after
			// the word
			String before = " ", after = " ";
			if (psn > 0)
			{
				before = phrase.substring(psn - 1, psn);
			}
			if (psn + goal.length() < phrase.length())
			{
				after = phrase.substring(
						psn + goal.length(),
						psn + goal.length() + 1);
			}

			// If before and after aren't letters, we've
			// found the word
			if (((before.compareTo("a") < 0) || (before
					.compareTo("z") > 0)) // before is not a
											// letter
					&& ((after.compareTo("a") < 0) || (after
							.compareTo("z") > 0)))
			{
				return psn;
			}

			// The last position didn't work, so let's find
			// the next, if there is one.
			psn = phrase.indexOf(goal, psn + 1);

		}

		return -1;
	}
	
	/**
	 * Search for one word in phrase.  The search is not case sensitive.
	 * This method will check that the given goal is not a substring of a longer string
	 * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.  
	 * @param statement the string to search
	 * @param goal the string to search for
	 * @return the index of the first occurrence of goal in statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal)
	{
		return findKeyword (statement, goal, 0);
	}
	


	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse ()
	{
		Random r = new Random ();
		if (emotion == 0)
		{	
			return randomNeutralResponses [r.nextInt(randomNeutralResponses.length)];
		}
		if (emotion < 0)
		{	
			return randomAngryResponses [r.nextInt(randomAngryResponses.length)];
		}	
		return randomHappyResponses [r.nextInt(randomHappyResponses.length)];
	}
	
	private String [] randomNeutralResponses = {"Interesting, tell me more",
			"Hmmm.",
			"Do you really think so?",
			"You don't say.",
			"Ahuh",
			"So, would you like to go for a walk?",
			"Could you say that again?",
			"Cool"
	};
	private String [] randomAngryResponses = {"I really don;t understand why you'd say something as ignorant as that.", "Whatever.", "The rage consumes me!"};
	private String [] randomHappyResponses = {"That sounds amazing.", "I'm happy for you.", "That's good"};
	private String [] songs= {"19-2000",
			"Andromeda",
			"Ascension",
			"Broken ",
			"Busted and Blue",
			"Charger",
			"Clint Eastwood",
			"Cloud Of Unknowing",
			"DARE",
			"Dirty Harry",
			"Doncamatic",
			"DoYaThing",
			"Empire Ants",
			"Feel Good Inc.",
			"Fire Coming Out Of The Monkey's Head",
			"Garage Palace",
			"Glitter Freeze",
			"Hallelujah Money",
			"Hollywood",
			"Humility",
			"Idaho",
			"Left Hand Suzuki Method",
			"Let Me Out",
			"Momentz",
			"On Melancholy Hill",
			"Orchestral Intro",
			"Phoner to Arizona",
			"Pirate Jet",
			"Plastic Beach",
			"Revolving Doors",
			"Rhinestone Eyes",
			"Rock The House",
			"Saturnz Barz",
			"Sex Murder Party",
			"She's My Collar",
			"Some Kind Of Nature",
			"Strobelite",
			"Stylo",
			"Superfast Jellyfish",
			"Sweepstakes",
			"Ticker Tape",
			"To Binge",
			"Tomorrow Comes Today",
			"We Got The Power",
			"Welcome To The World Of The Plastic Beach",
			"Whirlwind",
			"White Flag"
	};
	private String[] band= {"Murdoc", "2-D", "Russel"};

}

