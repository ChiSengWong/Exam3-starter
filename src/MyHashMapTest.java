import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.*;

public class MyHashMapTest {

	private FileReader filereader;
	private DefaultMap<Integer, Student> testMap; // use this for basic tests

	private FileReader myFilereader;
	private FileReader myFilereader2;
	private FileReader myFilereader3;


	@Before
	public void setUp() {
			filereader = new FileReader("src/input.txt");
			filereader.createHeap();



//		myFilereader = new FileReader("/home/chi/Programming/Exam3-starter/myInput.txt");
//		myFilereader.createHeap();
//
//		myFilereader2 = new FileReader("/home/chi/Programming/Exam3-starter/myInput2.txt");
//		myFilereader2.createHeap();

		//myFilereader3 = new FileReader("/home/chi/Programming/Exam3-starter/empty.txt");
		//myFilereader.createHeap();

		//TODO : test heap.remove() Heap

	}


	//Write testcase for checking max score of 2 sections

	@Test
	public void testSectionA() {
        Student maxA = filereader.getMaxOfSection('A');
		assertEquals("James", maxA.name);
	}

	@Test
	public void testSectionB() {
		Student maxB = filereader.getMaxOfSection('B');
		assertEquals("Ria", maxB.name);
	}

	@Test
	public void testSectionC() {
		Student maxC = filereader.getMaxOfSection('C');
		assertEquals("Peter", maxC.name);
	}
}
///////////////////////////////////////////////////////////////////////////
//	@Test
//	public void testMyCase() {
//		Student maxA = myFilereader.getMaxOfSection('A');
//		Student maxB = myFilereader.getMaxOfSection('B');
//		Student maxC = myFilereader.getMaxOfSection('C');
//		assertEquals("Sangeetha", maxA.name);
//		assertEquals("Alex", maxB.name);
//		assertEquals("Peter", maxC.name);
//	}
//}

//	@Test
//	public void testMyCase2() {
//		Student maxA = myFilereader2.getMaxOfSection('A');
//		Student maxB = myFilereader2.getMaxOfSection('B');
//		Student maxC = myFilereader2.getMaxOfSection('C');
//		Student maxD = myFilereader2.getMaxOfSection('D');
//		Student maxJ = myFilereader2.getMaxOfSection('J');
//		Student maxE = myFilereader2.getMaxOfSection('E');
//		Student maxF = myFilereader2.getMaxOfSection('F');
//
//		assertEquals("James", maxA.name);
//		assertEquals("Jas", maxB.name);
//		assertEquals("Peter", maxC.name);
//		assertEquals("Aex", maxD.name);
//		assertEquals("Sas", maxE.name);
//		assertEquals("Per", maxJ.name);
//		assertEquals("Deek", maxF.name);
//	}
   
//
//	@Test
//	public void testHeap() {
//		Comparator comparator = new Comparator<Student>() {
//			@Override
//			public int compare(Student s1, Student s2) {
//				// TODO Auto-generated method stub
//				if (s1.marks > s2.marks) { return 1;}
//				else if (s1.marks == s2.marks) {return 0; }
//				else {return -1; }
//			}
//
//		};
//
//		Student s1 = new Student("mike", 'A', 30);
//		Student s2 = new Student("jason", 'A', 40);
//		Student s3 = new Student("nelson", 'A', 29);
//		Student s4 = new Student("marti", 'A', 10);
//		Student s5 = new Student("odegaad", 'A', 80);
//		Student s6 = new Student("saka", 'A', 85);
//
//
//		MaxHeap heap = new MaxHeap<>(10, comparator);
//
//		heap.add(s1.marks, s1);
//		heap.add(s2.marks, s2);
//		heap.add(s3.marks, s3);
//		heap.add(s4.marks, s4);
//		heap.add(s5.marks, s5);
//		heap.add(s6.marks, s6);
//
//		assertEquals("saka", ((Student)heap.peek().value).name);
//		assertEquals("saka", ((Student)heap.remove().value).name);
//		assertEquals("odegaad", ((Student)heap.remove().value).name);
//		assertEquals("jason", ((Student)heap.remove().value).name);
//		assertEquals("mike", ((Student)heap.remove().value).name);
//		assertEquals("nelson", ((Student)heap.remove().value).name);
//		assertEquals("marti", ((Student)heap.remove().value).name);
//
//	}
//}


/*
Task 3.1 MaxHeap and HashMap

	Calculate the runtime equation and runtime complexity for the [get] and [put] methods

	Compare  runtime for the [MaxHeap case] vs [bucket is arraylist].

	Also consider a situation, where you are supposed to also search for a students record in a bucket in logn complexity. What datastructure will be most apt to represent the bucket? Reason in your video.

Task 3.2 CircularArrayList

	How Circular ArrayList improves your list performance.
	Compare the runtime complexity for circularArrayList vs ArrayList for the [add] and [remove] What do you observe?

	*/