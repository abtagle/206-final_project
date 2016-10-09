Welcome to voxSpell- an beta version of the projext application developed by Aimee Tagle for Softeng 206's Assignment 4. There is a tl;dr at the bottom

Last Modified: 09 September, 2016

------------------------------------
RUNNING THE JAR FILE
------------------------------------
This assignment should run correctly in the standard Linux environment on lab computers (with Java 1.7). Before executing the .jar file, ensure that you have the hidden media folder (.Media) in the same directory as your .jar file. This contains all the media needed to experience the whole application.

::::::::::::::::::
BEFORE YOU TRY THINGS OUT
::::::::::::::::::
Cover the words in the buttons of the menu. Can you tell what the icons represent? If you can't (especially with review), please select alternatives. I'm thinking about just doing flashcards, but they may just look like rectangles.
==================================================================
------------------------------------
STARTUP
------------------------------------
Upon executing the executable .jar file, you will be prompted to slect a word list. You may select any word list that is in the format agreed upon in lectures. I have provided one as a sample in the ideal format for my application. 

==================================================================
------------------------------------
MENU OPTIONS
------------------------------------
::::::::::::::::::
NEW QUIZ
::::::::::::::::::
This is almost identical to the corresponding modes in previous assignments. The enter key is set to submit words, and the spell checker continues to not accept non-letter and non-apostrophe characters. Selecting options will present you with a new frame, where you can return to the main menu, change the voice, or view statistics. A screen at the end shows their score for the quiz, and any achievements if any were unlocked during the quiz (I am using an achievement system instead of levels). 

I used an achievement system because a second language learner's primary goal is to, well, learn the language. They would probably go elsewhere for gaming where they get the joy of levelling up.

DO NOT RANDOMLY TYPE AND SUBMIT WORDS WITHOUT WAITING FOR THE SPEECH TO FINISH. THIS WILL BREAK THE CODE. If you have any suggestions, please let me know.

::::::::::::::::::
REVIEW
::::::::::::::::::
This is very different from the previous reviews. This mode mimics the idea of flashcards. Users can choose if they want to review all the words in a level (in order to score better on their quizes), or review all of the words they failed the last time they were quizzed to aid their learning. I will hopefully be able to add key listeners that work at some point. Any advice on that would be appreciated.

::::::::::::::::::
ACHIEVEMENTS
::::::::::::::::::
As previously mentioned, I am using and achievements system instead of a level system to mark user progress through the game. They are based on streaks (words right in a row) and total words right. Each achievement is associated with an award, which comes in the form of a video they can watch. These videos, when all unlocked, can be put together to form a riddle. The answer will help the user unlock a secret reward (which is big_buck_bunny at the moment). If you want to find out what they is, go ahead and edit the .streak file which stores all the streak data (I believe the number order is longest streak, current streak, total attempted, total right, but it should work out with trial and error. Plus, one number will be bigger than the rest).

::::::::::::::::::
STATISTICS
::::::::::::::::::
Literally just the statistics. You should be able to view the statistics by level between sessions. Only levels with statistics associated with them appear in the JComboBox

::::::::::::::::::
SETTINGS
::::::::::::::::::
This is probably even more intuitive. Added the ability to see what some of the words in the list are when you submit/choose a list.
==================================================================
------------------------------------
WHAT I WANT FEEDBACK ON
------------------------------------
-The intended user is a 18-24 second language learner. Is there anything I could easily add to make it suit their needs more? I will be adding a home icon at some point (hopefully)
-Emphasise the quick extra marks thing
-Do you think it would be beneficial to offer a "light" mode (dark purple text on white background)
-Do you have any suggestions on how to refactor the automatically generated windowbuilder code?
-What parts ABSOLUTELY NEED commenting and will make no sense without it?
-Do you like it?
-Is my statistics layout terrible?
-Is there enough warning before the user erases their stats?
-How do I easily add disabling submit while speaking with my implementation.
------------------------------------
WHAT I DO NOT WANT FEEDBACK ON
------------------------------------
-Missing Javadoc commenting
-How little commenting there is if you don't say what needs the commenting (because I already know I need more commenting)

==================================================================
---------------------------------
TL;DR
---------------------------------
Firstly, I put a lot of effort into this README, but I understand you have a lot to do. 

I mostly want to fix New Quiz so that it doesn't break when you keyboard mash words in to check the end screen i.e. disable submit with my implementation.

Review is now flashcards.

I have achievements, not levels.

There is no linear progression through words in my game.

==================================================================
---------------------------------
REFERENCES
---------------------------------
Word List Cred
http://www.manythings.org/vocabulary/lists/a/words.php?f=adjectives_for_people_1

I made my own art in GIMP and FireAlpaca

The button press noise is from http://www.bfxr.net/
