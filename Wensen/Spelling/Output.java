package spelling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Output {

	public static void writeTofile(String outputFilename, String outputStr) {
		// System.out.println(st);

		PrintWriter fout;

		try {
			fout = new PrintWriter(new BufferedWriter(new FileWriter(outputFilename)));

			fout.println(outputStr);

			fout.close();

		} catch (Exception e) {
			System.err.println("output ERROR");
		}

	}
	
}
