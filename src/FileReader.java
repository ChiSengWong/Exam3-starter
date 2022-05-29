import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.Scanner;

public class FileReader {
	
	String filename;
	Comparator comparator;
	DefaultMap<Character, Student> hashMap;
	
	public FileReader(String name) {
		// Constructor for the filereader
		this.filename = name;

		this.comparator = new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				// TODO Auto-generated method stub
				if (s1.marks > s2.marks) { return 1;}
				else if (s1.marks == s2.marks) {return 0; }
				else {return -1; }
			}
			
		};
		this.hashMap = new MyHashMap<>(50, comparator);
	}
	
	public void createHeap() {
        //Method to read input.txt using FileInputStream and putting the student entries to the hashMap
				
		InputStream f;
		Scanner sc;
		try {
			f = new FileInputStream(this.filename);
			sc = new Scanner(f);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				if (line.isEmpty() || line.isBlank()) break;

				String[] studentInfo = line.split(",");
				String name = studentInfo[0];
				Character section = studentInfo[1].charAt(0);
				int marks = Integer.parseInt(studentInfo[2]) ;
				Student student = new Student(name, section, marks);

				hashMap.put(section, student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Student getMaxOfSection(char section) {
		//Method that returns a maximum scoring student's record given the section
		return hashMap.get(section);
	}
	


}
