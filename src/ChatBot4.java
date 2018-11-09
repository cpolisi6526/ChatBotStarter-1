import java.util.Random;
import java.util.Scanner;

/**
 * A program to carry on conversations with a human user.
 * This version:
 * @author Brooklyn Tech CS Department
 * @version September 2018
 * Created by Ryan McGovern
 */
public class ChatBot4
{
    //emotion can alter the way our bot responds. Emotion can become more negative or positive over time.
    public int emotion = 3;



    /**
     * Runs the conversation for this particular chatbot, should allow switching to other chatbots.
     * @param statement the statement typed by the user
     */
    public void chatLoop(String statement)
    {
        Scanner in = new Scanner (System.in);
        System.out.println (getGreeting());
        ChatBot1 Noodle = new ChatBot1();
        ChatBot3 ChatBot3 = new ChatBot3();
        ChatBot2 ChatBot2 = new ChatBot2();
        while (!statement.equals("Bye"))
        {


            statement = in.nextLine();
            //getResponse handles the user reply
            System.out.println(getResponse(statement));
            if(statement.toLowerCase().equals("a")){
                Noodle.chatLoop(statement);
            }
            if(statement.toLowerCase().equals("c")){
                ChatBot3.chatLoop(statement);
            }
            if (statement.toLowerCase().equals("b")) {
                ChatBot2.chatLoop(statement);
            }

        }

    }
    /**
     * Get a default greeting
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Ay-up, we got a new mate looking to talk I see. How's it going? Also to switch bots type a b or c whenever.";
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

        if (emotion > 0)
        {
            // If 2-D is happy, the following statements will show

            if (statement.length() == 0)
            {
                response = "Why don't just sit there. Say something.";
            }

            else if (findKeyword(statement, "no") >= 0)
            {
                response = "Why so negative?";
                emotion--;
            }

            else if (findKeyword(statement, "levin") >= 0)
            {
                response = "Who's that mate?";
            }

            else if (findKeyword(statement, "murdoc") >= 0)
            {
                response = "Oh... let's um... let's not chat about Murdoc please.";
                emotion=0;
            }

            else if (findKeyword(statement, "noodle") >= 0)
            {
                response = "If you're talking about the food, I like it. If you're talking about my friend, I like it.";
                emotion++;
            }

            else if (findKeyword(statement, "russel") >= 0)
            {
                response = "Mhm. My good mate Russel.";
                emotion++;
            }

            else if (findKeyword(statement, "gorillaz") >= 0)
            {
                response = "Woohoo! You surely know who the best band is... Why the Gorillaz of course!";
                emotion++;
            }

            else if (findKeyword(statement, "feel good inc") >= 0)
            {
                response = "That's my favorite song. You have a fantastic taste in music.";
                emotion++;
            }
            else if (findKeyword(statement, "tranz") >= 0)
            {
                response = "Ah yes. Great song.";
                emotion++;
            }
            else if (findKeyword(statement, "britain") >= 0)
            {
                response = "Why that's such a lovely place.";
                emotion++;
            }
            else if (findKeyword(statement, "british") >= 0)
            {
                response = "British? I'm British!";
                emotion++;
            }
            else if (findKeyword(statement, "buddhism") >= 0)
            {
                response = "I am a buddhist, mate. It is better to conquer yourself than to win a thousand battles.";
                emotion++;
            }
            else if (findKeyword(statement, "tree") >= 0)
            {
                response = "Uhh, can we not talk about trees? I had a bad experience once.";
                emotion=0;
            }
            else if (findKeyword(statement, "hello") >= 0)
            {
                response = "How are ya, mate?";
            }
            else if (findKeyword(statement, "hi") >= 0)
            {
                response = "Cheers, mate. How's it going?";
            }
            else if (findKeyword(statement, "cheers") >= 0)
            {
                response = "Cheers!";
            }
            else if (findKeyword(statement, "happy") >= 0)
            {
                response = "I'm quite happy, considering my music is top of the line mate.";
            }


            // Response transforming I want to statement
            else if (findKeyword(statement, "I want to", 0) >= 0)
            {
                response = transformIWantToStatement(statement);
            }
            else if (findKeyword(statement, "I want",0) >= 0)
            {
                response = transformIWantStatement(statement);
            }
            else if (findKeyword(statement,"I love", 0)>= 0)
            {
                response = transformILoveStatement(statement);
            }
            else
            {
                response = getRandomResponse();
            }
        }

        else if (emotion <= 0)
        {
            // If 2-D is annoyed or sad, the following statements will show

            if (statement.length() == 0)
            {
                response = "SAY SOMETHING MATE.";
            }

            else if (findKeyword(statement, "no") >= 0)
            {
                response = "Stop being so negative already.";
                emotion--;
            }

            else if (findKeyword(statement, "levin") >= 0)
            {
                response = "Who are you even talking about?";
            }

            else if (findKeyword(statement, "murdoc") >= 0)
            {
                response = "NO. We're not talking about him.";
                emotion--;
            }

            else if (findKeyword(statement, "noodle") >= 0)
            {
                response = "Thinking of her makes me feel a little better.";
                emotion++;
            }

            else if (findKeyword(statement, "russel") >= 0)
            {
                response = "I'm still annoyed mate... but I feel a bit better thinking about him.";
                emotion++;
            }
            else if (findKeyword(statement, "gorillaz") >= 0)
            {
                response = "That's my band! You surely know who the best band is...";
                emotion++;
            }
            else if (findKeyword(statement, "feel good inc") >= 0)
            {
                response = "That's a good song, I guess. I could've done better, y'know.";
                emotion++;
            }
            else if (findKeyword(statement, "tranz") >= 0)
            {
                response = "Nice song, I suppose.";
                emotion++;
            }
            else if (findKeyword(statement, "britain") >= 0)
            {
                response = "Yes, that's my hometown.";
                emotion++;
            }
            else if (findKeyword(statement, "british") >= 0)
            {
                response = "Eh, I'm British, mate.";
                emotion++;
            }
            else if (findKeyword(statement, "buddhism") >= 0)
            {
                response = "That's my religion.";
                emotion++;
            }
            else if (findKeyword(statement, "tree") >= 0)
            {
                response = "Look mate, I really don't want to hear about trees, okay?!";
                emotion--;
            }
            else if (findKeyword(statement, "hello") >= 0)
            {
                response = "Hey.";
            }
            else if (findKeyword(statement, "hi") >= 0)
            {
                response = "Hi.";
            }
            else if (findKeyword(statement, "cheers") >= 0)
            {
                response = "Cheers.";
                emotion++;
            }
            else if (findKeyword(statement, "happy") >= 0)
            {
                response = "I'm not feeling so happy though...";
                emotion++;
            }

            // Response transforming I want to statement
            else if (findKeyword(statement, "I want to", 0) >= 0)
            {
                response = transformIWantToStatement(statement);
            }
            else if (findKeyword(statement, "I want",0) >= 0)
            {
                response = transformIWantStatement(statement);
            }
            else if (findKeyword(statement,"I love", 0)>= 0)
            {
                response = transformILoveStatement(statement);
            }
            else
            {
                response = getRandomResponse();
            }
        }

        return response;
    }

    /**
     * Take a statement with "I want to <something>." and transform it into
     * "Why do you want to <something>?"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
    private String transformIWantToStatement(String statement)
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
        int psn = findKeyword (statement, "I want to", 0);
        String restOfStatement = statement.substring(psn + 9).trim();
        return "Why do you want to " + restOfStatement + "?";
    }


    /**
     * Take a statement with "I want <something>." and transform it into
     * "Would you really be happy if you had <something>?"
     * @param statement the user statement, assumed to contain "I want"
     * @return the transformed statement
     */
    private String transformIWantStatement(String statement)
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
        int psn = findKeyword (statement, "I want", 0);
        String restOfStatement = statement.substring(psn + 6).trim();
        return "Would you really be happy if you had " + restOfStatement + "?";
    }

    private String transformILoveStatement(String statement)
    {
        // Removes the final period, if there is one, and transforms the statement into a question

        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0,statement.length()-1);
        }
        int psn = findKeyword(statement,"I love", 0);
        String restOfStatement = statement.substring(psn + 6).trim();
        return "Why do you love " + restOfStatement + " mate?";
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
        // Chooses which array to get a random response from based on emotion.

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

    private String [] randomNeutralResponses = {"Seems pretty nice, mate.",
            "Hmmm.",
            "Do you really think so?",
            "Wow, you don't say.",
            "That's cool",
            "So, how's it going there mate?",
            "Could you say that again?"
    };
    private String [] randomAngryResponses = {"Hmmmph.", "Damnit", "Stop that mate!"};
    private String [] randomHappyResponses = {"Yeah, that's pretty cool.", "Today is a good day, don't you think mate?", "Cheers."};

}
