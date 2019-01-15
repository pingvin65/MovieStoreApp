package com.moviestore.test.dao;


import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.moviestore.dao.MediaDAO;

import com.moviestore.model.Media;

public class MediaDAOTest {
	private MediaDAO mediaDAOTest;
	private static List<Media> mediaListTest;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		mediaDAOTest = new MediaDAO();
		mediaListTest = new ArrayList<Media>();
//		3	1	images/movies/missionImpossibleFallout01.jpg
//		3	1	images/movies/Mission-Impossible-FAllout.jpg
//		3	1	images/movies/MI_–_Fallout.jpg
		mediaListTest.add(new Media(3, 1, "images/movies/missionImpossibleFallout01.jpg"));
		mediaListTest.add(new Media(3, 1, "images/movies/Mission-Impossible-FAllout.jpg"));
		mediaListTest.add(new Media(3, 1, "images/movies/MI_–_Fallout.jpg"));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testGetMediaByMoviesID() {
		assertArrayEquals("check", mediaListTest, mediaDAOTest.getMediaByMoviesID(1));

	}

	private void assertArrayEquals(String string, List<Media> mediaTest2, List<Media> mediaByMoviesID) {
		Assert.assertEquals(mediaTest2.size(), mediaByMoviesID.size());
		for (int i = 0; i < mediaByMoviesID.size(); i++) {
			Assert.assertEquals(mediaTest2.get(i).getMediatipID(), mediaByMoviesID.get(i).getMediatipID());
			Assert.assertEquals(mediaTest2.get(i).getMoviesID(), mediaByMoviesID.get(i).getMoviesID());
			assertTrueStrin(mediaTest2.get(i).getMediaPath(), mediaByMoviesID.get(i).getMediaPath());

		}

	}

	private void assertTrueStrin(String mediaPath, String mediaPath2) {
		Assert.assertTrue(mediaPath.equals(mediaPath2));

	}

}
