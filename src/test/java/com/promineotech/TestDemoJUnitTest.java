package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
//import static org.assertj.core.api.Assertions.assertThatThrownBy;
//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {

	private TestDemo testDemo;
	
	@BeforeEach
	void setUp() throws Exception {
		
		testDemo = new TestDemo();
		
	}

	@ParameterizedTest
	@MethodSource("argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		
		if (!expectException) {
//			assertEquals(testDemo.addPositive(a, b), expected);
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		}
		else {
			assertThatThrownBy(()-> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	

	/* The following is a parameterized test of the whichTeamWins method of TestDemo.
	 * 
	 * It will assert that the correct name of the winning team gets returned by the method based on
	 * each team's score.
	 * 
	 * The method, argumentsForwhichTeamWins provides the test cases as a stream of arguments.
	 */
	
	@ParameterizedTest
	@MethodSource("argumentsForwhichTeamWins")
	void assertThattheCorrectTeamWins(String team1, int team1Score, String team2, int team2Score, String expected) {
		
//		assertEquals(testDemo.whichTeamWins(team1, team1Score, team2, team2Score), expected);
		assertThat(testDemo.whichTeamWins(team1, team1Score, team2, team2Score)).isEqualTo(expected);
		
	}

	
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		
//		assertEquals(testDemo.addPositive(4, 5), 9);
//		assertEquals(testDemo.addPositive(40, 50), 90);
//		assertEquals(testDemo.addPositive(35, 8), 43);
//		assertEquals(testDemo.addPositive(10, 300), 310);
//		assertEquals(testDemo.addPositive(1010, 3020), 4030);
		
		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
		assertThat(testDemo.addPositive(35, 8)).isEqualTo(43);
		assertThat(testDemo.addPositive(10, 300)).isEqualTo(310);
		assertThat(testDemo.addPositive(1010, 3020)).isEqualTo(4030);
	}
	
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		
		TestDemo mockDemo = spy(testDemo);
		
		doReturn(5).when(mockDemo).getRandomInt();
		
		int fiveSquared = mockDemo.randomNumberSquared();
		
//		assertEquals(fiveSquared, 25);
		assertThat(fiveSquared).isEqualTo(25);
		
	}
	
	
	/* This parameterized test will test the randomNumberSquared() method using a stream
	 * of arguments.  It will mock the testDemo class to return a "fixed" value for each
	 * call to the getRandomInt() method. The "fixed" value is provided by the randomNumber
	 * argument.  The expected value to be returned by the randomNumberSquared() method is
	 * provided by the expected argument
	 */
	
	@ParameterizedTest
	@MethodSource("argumentsForRandomNumberSquared")
	void assertThatRandomNumberSquaredisCorrect(int randomNumber, int expected) {
		
		TestDemo mockDemo = spy(testDemo);
		
		doReturn(randomNumber).when(mockDemo).getRandomInt();
		
//		assertEquals(mockDemo.randomNumberSquared(), expected);
		assertThat(mockDemo.randomNumberSquared()).isEqualTo(expected);
		
	}
	
	
	private static Stream<Arguments> argumentsForAddPositive() {
		
		return Stream.of(
				Arguments.of(2, 4, 6, false),
				Arguments.of(2, 2, 4, false),
				Arguments.of(3, 0, 3, true),
				Arguments.of(3, 0, 3, true),
				Arguments.of(5, 2, 7, false),
				Arguments.of(21, 63, 84, false),
				Arguments.of(0, 63, 63, true),
				Arguments.of(21, -63, -42, true)
		);
	}
	
	
	/* The following method is used for the parameterized test, assertThattheCorrectTeamWins.
	 * 
	 * It returns a stream of arguments.  Each element in the stream represents a test case 
	 */
	
	private static Stream<Arguments> argumentsForwhichTeamWins() {
		
		return Stream.of(
				Arguments.of("Mets", 4, "Braves", 3, "Mets"),
				Arguments.of("Tigers", 2, "Guardians", 6, "Guardians"),
				Arguments.of("Royals", 0, "Blue Jays", 3, "Blue Jays"),
				Arguments.of("Phillies", 7, "Marlins", 4, "Phillies"),
				Arguments.of("Twins", 5, "Giants", 7, "Giants"),
				Arguments.of("Astros", 4, "Dodgers", 0, "Astros"),
				Arguments.of("Angels", 10, "Mariners", 10, "Tie")
		);
	}
	
	
	/* The following method is used for the parameterized test, assertThatRandomNumberSquaredisCorrect.
	 * 
	 * It returns a stream of arguments.  Each element in the stream represents a test case 
	 */
	
	private static Stream<Arguments> argumentsForRandomNumberSquared() {
		
		return Stream.of(
				Arguments.of(1, 1),
				Arguments.of(3, 9),
				Arguments.of(5, 25),
				Arguments.of(2, 4),
				Arguments.of(15, 225),
				Arguments.of(20, 400),
				Arguments.of(10, 100)
		);
	}
}
