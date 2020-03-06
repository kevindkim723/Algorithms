import java.io.*;
import java.util.*;

public class HiveBuilder1 {
	public static void main(String[] args) throws Exception
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Level: ");
		Random r = new Random();
		int l = s.nextInt();
		System.out.println("Honey Pool: ");
		int w = s.nextInt();
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bees.in")));
        StringBuilder st = new StringBuilder(l+"\n");
        for (int i = 0; i < l; i++)
        {
        	for (int j = 0; j < i+1; j++)
        	{
        		st.append((j!=i) ? r.nextInt(w)+1 + "," : r.nextInt(w)+1);
        	}
        	st.append("\n");
        }
        out.print(st.toString());
        out.close();
	}
}
