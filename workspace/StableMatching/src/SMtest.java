import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;

import java.io.*;

public class SMtest {
//	private final static String TESTDATA_DIR = "C:\\Users\\Shintai\\Desktop\\edaf05\\algdes-labs-master\\matching\\data";
	private static String TESTDATA_DIR = "C:" + File.separator + "Users" + File.separator + "Shintai" + File.separator + "Desktop" + File.separator + "edaf05" + File.separator + "algdes-labs-master" + File.separator + "matching" + File.separator + "data";
	private final static char SC = File.separatorChar;

	/**
	 * Method to run an actual test case.
	 * 
	 * @param testname
	 *            Name of test data to be used, e.g. "stable-marriage-friends".
	 */
	private void runTestCase(String testname) {
		System.out.println("Running test: " + testname);
		String infile = TESTDATA_DIR + SC + testname + "-in.txt";
		String outfile = TESTDATA_DIR + SC + testname + "-out.txt";

		/*
		 * Divert stdout to buffer
		 */
		PrintStream oldOut = System.out;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);

		String[] args = new String[1];
		args[0] = infile;
		StableTest.main(args); // FIXME: Change GS to your own class!

		/*
		 * Restore stdout
		 */
		System.setOut(oldOut);

		/*
		 * Compare program output with .out file
		 */
		try {
			StringBuilder sb = new StringBuilder();
			FileInputStream is = new FileInputStream(new File(outfile));
			byte buffer[] = new byte[1024];

			while (is.available() != 0) {
				int i = is.read(buffer);
				sb.append(new String(buffer, 0, i));
			}

			assertEquals(sb.toString(), baos.toString());
		} catch (FileNotFoundException e) {
			fail("File " + outfile + " not found.");
		} catch (IOException e) {
			fail("Error reading " + outfile);
		}
	}

	/**
	 * Simple test case for the 'friends' test data.
	 */
//	 @Test
//	 public void testFriends() {
//	 runTestCase("sm-bbt");
//	 }
//	
//	 /**
//	 * Test case that will use all test data it can find in TESTDATA_DIR.
//	 *
//	 * You may want to comment this out until you think your program works, as
//	 * this test can take some time to execute.
//	 */
	@Test
	public void testAll() {
		File dir = new File(TESTDATA_DIR);

		for (File f : dir.listFiles()) {
			if (f.isFile() && f.toString().endsWith("-out.txt")) {
				String s = f.toString();
				s = s.substring(s.lastIndexOf(SC) + 1);
				s = s.substring(0, s.lastIndexOf("-out.txt"));

				runTestCase(s);
			}
		}
	}

}