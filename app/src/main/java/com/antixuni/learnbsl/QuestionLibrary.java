package com.antixuni.learnbsl;

public class QuestionLibrary {

    private String mQuestions [] = {
            "What does this sign mean?",
            "What does this sign mean?",
            "What does this sign mean?",
            "What does this sign mean?",
            "What does this sign mean?",
            "What does this sign mean?",
            "What does this sign mean?",
            "What does this sign mean?",

    };

    private String mChoices [][] = {
            {"Dog", "Cat", "Elephant"},
            {"Giraffe", "Fish", "Dog"},
            {"Cat", "Fish", "Elephant"},
            {"Bull", "Cow", "Fish"},
            {"Bunny","Chicken","Crocodile"},
            {"Alligator","Fish","Duck"},
            {"Cat","Chicken","Elephant"},
            {"Chicken","Bunny","Deer"}
    };

    private String mCorrectAnswers[] = {"Elephant", "Giraffe", "Fish", "Cow","Bunny",
            "Alligator","Cat","Deer"};

    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }


    public String getChoice1(int a) {
        String choice0 = mChoices[a][0];
        return choice0;
    }

    public String getChoice2(int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getChoice3(int a) {
        String choice2 = mChoices[a][2];
        return choice2;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }

    public int getLength() {
        return mQuestions.length;
    }
}
