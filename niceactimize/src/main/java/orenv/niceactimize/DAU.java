package orenv.niceactimize;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class DAU implements DAUService {
	private HashMap<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();
	

	public HashMap<String, HashSet<String>> getMap() {
		return map;
	}

	public void setMap(HashMap<String, HashSet<String>> map) {
		this.map = map;
	}

	public void initDau(String fileName) {//Reading the file and arranging the data in map by date as a key
		try {
			File file = new File(fileName);
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String[] line = scanner.nextLine().split(",");
				String date = line[1].split(" ")[0];
				if (!map.containsKey(date)) {
					HashSet<String> set = new HashSet<String>();
					set.add(line[0]);
					map.put(date, set);
				} else {
					map.get(date).add(line[0]);
				}

			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.err.println("File not found!");
			e.printStackTrace();
		}
		map.entrySet().forEach(entry -> {// printing the entire map
			System.out.println(entry.getKey() + " " + entry.getValue());
		});

	}

	public int countDauByDate(String date) {//Given a specific date, bringing its number of DAU
		if (date.trim().isEmpty() || date == null)
			try {
				throw new Exception("invalid date!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		if (!map.containsKey(date.trim())) {
			try {
				throw new Exception("the required input does not exist!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return map.get(date.trim()).size();

	}

}
