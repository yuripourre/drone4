package br.com.drone4.loader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.etyllica.linear.Point3D;

public class ASCIIDEMLoader {

	public static List<Point3D> loadDEM(String path) {
		
		List<Point3D> points = new ArrayList<Point3D>();
		
		BufferedReader br = null;
		 
		try {
 
			String currentLine;
 
			br = new BufferedReader(new FileReader(path));
			
			while ((currentLine = br.readLine()) != null) {
				
				String text = currentLine.trim().replaceAll("�", "");
				
				String[] parts = text.split(",");
				
				//System.out.println(parts[0]);
				
				double x = Double.parseDouble(parts[0]);
				double y = Double.parseDouble(parts[1]);
				double z = Double.parseDouble(parts[2]);
				
				Point3D point = new Point3D(x, y, z);
				points.add(point);
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		return points;
	}
	
}
