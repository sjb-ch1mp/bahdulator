package ch1mp.bahdulator.util;

import java.util.*;
import java.io.*;

/**
 * This is a temporary upload to Git in order to
 * xfer this class to my PC...
 */

public class Formatter{


	public static void main(String[] args){
		
		ArrayList<String[]> file = new ArrayList<>(0);

		try(BufferedReader br = new BufferedReader(new FileReader(args[0]))){
			String line = br.readLine();//skip first line
			while((line = br.readLine()) != null){
				file.add(line.split(","));
			}
		}catch(Exception e){
			e.printStackTrace();
		}

		for(String[] line : file){
			System.out.println(line[0] + " " + line[1] + " " + line[line.length - 1]);
		}

		try(BufferedWriter bw = new BufferedWriter(new FileWriter(args[0] + "_conv"))){
			for(String[] line : file){
				bw.write("super.addValue(" + line[0].trim() + 
					", new Value(\"" + line[1].trim() + 
					"\", \"" + line[line.length - 1].trim() + "\"));\n");
			}
		}catch(Exception e){
			e.printStackTrace();
		}

	}
}