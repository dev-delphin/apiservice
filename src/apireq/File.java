package apireq;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

public class File {
	public static void files() throws IOException, ParseException {
        Scanner scanner = new Scanner(Main.file);
        PrintWriter writer = new PrintWriter(Main.jsonfile);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            String newLine = "";
            for (int i = 0; i < line.length(); i++){
                if (line.charAt(i) != '[' && line.charAt(i) != ']') {
                    newLine += line.charAt(i);
                    System.out.println(newLine);
                }
            }
            writer.println(newLine);
        }
        scanner.close();
        writer.close();
        Json.json();
	}
}
