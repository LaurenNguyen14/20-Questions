package tester;
import stackutils.ParenthesesChecker;

import static org.junit.Assert.*;

import org.junit.Test;



/**
 * Class that checks ParenthesesChecker
 * 
 * @author LN
 *
 */
public class CheckerTest {

	@Test
	public void test_1() {
		assertTrue(ParenthesesChecker.checkParentheses("[ { ( ) [ ] } ]"));
	}

	@Test
	public void test_2() {
		assertFalse(ParenthesesChecker.checkParentheses("{ [ } ]"));
	}

	@Test
	public void test_3() {
		assertFalse(ParenthesesChecker.checkParentheses("( ( { { } ] ) )"));
	}

	@Test
	public void test_4() {
		assertFalse(ParenthesesChecker.checkParentheses("{ ( ) } ]"));
	}

	@Test
	public void test_5() {
		assertTrue(ParenthesesChecker
				.checkParentheses("( ( { { [ ] ( ) } ( ) } ) { [ ] } )"));
	}

	@Test
	public void test_6() {
		assertTrue(ParenthesesChecker.checkParentheses(""));
	}

}
