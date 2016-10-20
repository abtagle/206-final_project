package voxSpell.quiz;

import voxSpell.GUI.QuizScreen;

/**
 * Class representing the backing implementation of a new quiz, using the format provided in Quiz 
 * abstract class. Written by Aimee Tagle for Softeng 206 Assignment 2.
 * @author atag549
 * Last Modified: 21 October, 2016
 *
 */
public class NewQuiz extends Quiz {
	public NewQuiz(QuizScreen screen) {
		super(screen, false);
	}

	/**
	 * Hook method implementation from when Review was based on the quiz structure in previous assignments
	 */
	@Override
	protected void spellAloud(String word) {
		sayPhrase("Incorrect.");
		
		_wordNumberInt++;
		_attemptNumber = 1;
		updateWordNumberInGUI();
		quizQuestion();
	}

}
