import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author Miles Black (mablack01@aol.com)
 *
 */
public class Console {
	
	/**
	 * Fields for the console to run.
	 */
	private static String fileLocation = "./data/input.txt";
	
	/**
	 * The main method that handles the text file input.txt
	 * @param args
	 */
	public static void main(String[] args) {
        File file = new File(fileLocation);
        String line = null;
        int count = 0;
        try {
            FileReader fileReader = new FileReader(new File(fileLocation));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null)
                if (isTriangle(line))
                	count++;
            bufferedReader.close();
            System.out.println("There are " + count + " valid triangles in this file.");
        } catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + file.getName() + "'");
            System.exit(2);
        } catch(IOException ex) {
            System.out.println("Error reading file '"  + file.getName() + "'");
            System.exit(3);
        } catch(StringIndexOutOfBoundsException ex) {
            System.out.println("No input detected in file '"  + file.getName() + "'");
            System.exit(4);
        }
	}
	
	public static boolean isTriangle(String line) {
		String[] strs = line.replace("   ", " ").replace("  ", " ").replace("  ", " ").split(" ");
		int[] sides = new int[3];
		for (int i = 0; i < sides.length; i++)
			sides[i] = Integer.parseInt(strs[i + 1]);
		if (sides[0] + sides[1] > sides[2] &&
				sides[1] + sides[2] > sides[0] && 
				sides[2] + sides[0] > sides[1])
			return true;
		return false;
	}

}
