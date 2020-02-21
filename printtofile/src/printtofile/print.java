package printtofile;

import java.io.PrintWriter;

public class print {
	PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
	writer.println("The first line");
	writer.println("The second line");
	writer.close();
}
