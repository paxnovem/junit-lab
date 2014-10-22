package edu.worcester.cs.kwurst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StudentTest {
	private Student student1;
	@Before
	public void setUp() throws Exception {
		student1 = new Student("Jane", "Smith");
	}

	@Test
	public void testGetCurrentEarnedCr() {
		int credits = 45;
		student1.setCurrentEarnedCr(credits);
		assertEquals(credits, student1.getCurrentEarnedCr());
			
	}
	@Test
	public void testAnticipatedEarnedCr(){
		int credits = 45;
		student1.setAnticipatedAdditionalCr(credits);
		assertEquals(credits, student1.getAnticipatedAdditionalCr());
	}
	
	@Test
	public void testReadyToGraduate1()
	{
		student1.setCurrentEarnedCr(120);
		student1.setGpa(2.0);
		student1.setMajorComplete(true);
		student1.setLascComplete(true);
		assertTrue(student1.readyToGraduate());
	}
	
	@Test
	public void testReadyToGraduate2()
	{
		student1.setCurrentEarnedCr(90);
		student1.setGpa(2.0);
		student1.setMajorComplete(true);
		student1.setLascComplete(true);
		assertFalse(student1.readyToGraduate());
	}
	public void testReadyToGraduate3()
	{
		student1.setCurrentEarnedCr(120);
		student1.setGpa(0.1);
		student1.setMajorComplete(true);
		student1.setLascComplete(true);
		assertFalse(student1.readyToGraduate());
	}
	public void testReadyToGraduate4()
	{
		student1.setCurrentEarnedCr(120);
		student1.setGpa(2.0);
		student1.setMajorComplete(false);
		student1.setLascComplete(true);
		assertFalse(student1.readyToGraduate());
	}
	public void testReadyToGraduate5()
	{
		student1.setCurrentEarnedCr(120);
		student1.setGpa(2.0);
		student1.setMajorComplete(true);
		student1.setLascComplete(false);
		assertFalse(student1.readyToGraduate());
	}
	@Test
	public void testReadyToGraduate6()
	{
		student1.setCurrentEarnedCr(200);
		student1.setGpa(2.0);
		student1.setMajorComplete(true);
		student1.setLascComplete(true);
		assertTrue(student1.readyToGraduate());
	}
	
	@Test
	public void testGetCurrentRemainingCrLess() {
		int credits = 40;
		student1.setCurrentEarnedCr(credits);
		assertEquals(80, student1.getCurrentRemainingCr());
			
	}
	@Test
	public void testGetCurrentRemainingCrEqual() {
		int credits = 120;
		student1.setCurrentEarnedCr(credits);
		assertEquals(0, student1.getCurrentRemainingCr());
			
	}
	@Test
	public void testGetCurrentRemainingCrMore() {
		int credits = 200;
		student1.setCurrentEarnedCr(credits);
		assertEquals(0, student1.getCurrentRemainingCr());
			
	}
	
	@Test
	public void testStudentCount() {
		int count = Student.getStudentCount();
		new Student("Joe", "Jones");
		assertEquals(count + 1,Student.getStudentCount());
	}
	
	@Test
	public void testStudentID() {
		int count = Student.getStudentCount();
		Student s2 = new Student("Joe", "Jones");
		assertEquals(String.format("%07d", count+1),s2.getId());
	}
	

}
