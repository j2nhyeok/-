import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main7 {

	public static void main(String[] args) {
		BufferedReader bf = null;
		BufferedWriter bw = null;
		
		List<Integer> list = new ArrayList<>();
	
		try {
			bf = new BufferedReader(new FileReader(new File("d:\\filetest\\numbers.txt")));

			String line;
			
			while((line = bf.readLine()) != null) {
				list.add(Integer.parseInt(line));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bf != null) {
				try {
					bf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		try {
			Collections.sort(list);
			bw = new BufferedWriter(new FileWriter(new File("d:\\filetest\\numbers2.txt")));
			
			for(int i = 0; i < list.size(); i++) {
				bw.write(String.valueOf(list.get(i)));
				bw.write("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
