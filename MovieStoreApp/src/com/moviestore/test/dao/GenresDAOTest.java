package com.moviestore.test.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.moviestore.dao.GenresDAO;
import com.moviestore.model.Genres;

public class GenresDAOTest {

	private static GenresDAO genresDAOtest;
	private static List<Genres> genresListTest;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		genresDAOtest = new GenresDAO();
		genresListTest = new ArrayList<Genres>();
		genresListTest.add(new Genres("Action"));
		genresListTest.add(new Genres("Adventure"));
		genresListTest.add(new Genres("Thriller"));
	}

	@After
	public void tearDown() throws Exception {
	}

	/*
	 * @Test public final void testSetUpBeforeClass() { fail("Not yet implemented");
	 * // TODO }
	 * 
	 * @Test public final void testTearDownAfterClass() {
	 * fail("Not yet implemented"); // TODO }
	 * 
	 * @Test public final void testSetUp() { fail("Not yet implemented"); // TODO }
	 * 
	 * @Test public final void testTearDown() { fail("Not yet implemented"); // TODO
	 * }
	 */
	@Test
	public final void testGetGenres() {

		assertArrayEquals("check", genresListTest, genresDAOtest.getGenres(1));
	}
	/*
	 * @Test public final void testObject() { fail("Not yet implemented"); // TODO }
	 * 
	 * @Test public final void testGetClass() { fail("Not yet implemented"); // TODO
	 * }
	 * 
	 * @Test public final void testHashCode() { fail("Not yet implemented"); // TODO
	 * }
	 * 
	 * @Test public final void testEquals() { fail("Not yet implemented"); // TODO }
	 * 
	 * @Test public final void testClone() { fail("Not yet implemented"); // TODO }
	 * 
	 * @Test public final void testToString() { fail("Not yet implemented"); // TODO
	 * }
	 * 
	 * @Test public final void testNotify() { fail("Not yet implemented"); // TODO }
	 * 
	 * @Test public final void testNotifyAll() { fail("Not yet implemented"); //
	 * TODO }
	 * 
	 * @Test public final void testWaitLong() { fail("Not yet implemented"); // TODO
	 * }
	 * 
	 * @Test public final void testWaitLongInt() { fail("Not yet implemented"); //
	 * TODO }
	 * 
	 * @Test public final void testWait() { fail("Not yet implemented"); // TODO }
	 * 
	 * @Test public final void testFinalize() { fail("Not yet implemented"); // TODO
	 * }
	 */

	private void assertArrayEquals(String string, List<Genres> genresListTest2, List<Genres> genres) {
		// TODO Auto-generated method stub
		for(int i=0; i<genres.size(); i++) {
			assertTrue(genresListTest2.get(i).getGenres().equals(genres.get(i).getGenres()));
			
		}
	}
}
