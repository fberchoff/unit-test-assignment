package com.promineotech;

import java.util.Random;

public class TestDemo {
	
	
	int addPositive(int a, int b) {
		
		if (a > 0 && b > 0) {
			return a + b;
		}
		else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}		
	}
	
	/* The following method will take the outcome of a baseball game and determine which
	 * team won the game. Variable team1 is the name of the first team and variable team1Score
	 * is their score.  Variable team2 is the name of the opponent and team2Score is their score.
	 * 
	 * The method returns the name of the winning team.  If the game ended in a tie, the phrase, "tie",
	 * is returned in place of either team's name
	 */
	
	String whichTeamWins(String team1, int team1Score, String team2, int team2Score) {
		
		if (team1Score > team2Score) {
			return team1;
		}
			else if (team2Score > team1Score) {
				return team2;
			}
				else {
					return "Tie";
				}
					
		}
	
	int randomNumberSquared() {
		
		int randomNumber = getRandomInt();
		
		return randomNumber * randomNumber;
	}

	
	int getRandomInt() {
		
		Random random = new Random();
		
		return random.nextInt(10) + 1;
		
	}
}
