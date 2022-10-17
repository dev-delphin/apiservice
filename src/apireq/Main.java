package apireq;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;


public class Main {
	
	public static int CONNECTION_TIMEOUT = 15000;
	public static String contents = "";
	public static File file = new File("./tmp.txt");
	public static File jsonfile = new File("./tmp.json");
	
	public static void main(String[] args) throws IOException {
		Api.api(CONNECTION_TIMEOUT);
	}

}
