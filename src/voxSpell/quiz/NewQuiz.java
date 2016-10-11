package voxSpell.quiz;

import voxSpell.GUI.QuizScreen;

/**
 * Class representing the backing implementation of a new quiz, using the format provided in Quiz 
 * abstract class. Written by Aimee Tagle for Softeng 206 Assignment 2.
 * @author atag549
 * Last Modified: 22 September, 2016
 *
 */
public class NewQuiz extends Quiz {
	public NewQuiz(QuizScreen screen) {
		super(screen, false);
	}

	@Override
	protected void spellAloud(String word) {
		wrongSound();
		_wordNumberInt++;
		_attemptNumber = 1;
		updateWordNumberInGUI();
		quizQuestion();
	}

}
