import java.util.Scanner;

/**
 * A simple class to run our chatbot teams.
 * @author Brooklyn Tech CS Department
 * @version September 2018
 */
public class ChatBotRunner {

	/**
	 * Create instances of each chatbot, give it user input, and print its replies. Switch chatbot responses based on which chatbot the user is speaking too.
	 */
	public static void main(String[] args) {
		ChatBot1 Noodle = new ChatBot1();
		ChatBot2 chatbot2 = new ChatBot2();
		ChatBot3 chatbot3 = new ChatBot3();
		ChatBot4 chatbot4 = new ChatBot4();


		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to the the Gorillaz Chatbox. Pick which band member you'd like to talk to. Type a for Noodle. Type b for Russel. Type c for Murdoc. Type d 2-D.");
		String picker = in.nextLine();
		String statement = "";

		while (!statement.equals("Bye")) {
			if (picker.equals("a") || (picker.equals("A"))) {
				Noodle.chatLoop(statement);
				statement = in.nextLine();
				System.out.println(Noodle.getResponse(statement));
			}
			if (picker.equals("b") || picker.equals("B")) {
				chatbot2.chatLoop(statement);
				statement = in.nextLine();
			}
			if (picker.equals("c") || picker.equals("C")) {
				chatbot3.chatLoop(statement);
				statement = in.nextLine();
			}
			if (picker.equals("d") || picker.equals("D")) {
				chatbot4.chatLoop(statement);
				statement = in.nextLine();
			} else {
				System.out.println("That's not a valid response. Type a for Noodle, b for Russel, c for Murdoc,d for 2-D");
				picker = in.nextLine();
			}
		}
	}
}
