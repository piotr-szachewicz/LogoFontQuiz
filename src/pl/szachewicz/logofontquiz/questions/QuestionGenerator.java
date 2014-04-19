package pl.szachewicz.logofontquiz.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.text.format.Time;

import pl.szachewicz.logofontquiz.R;

public class QuestionGenerator {

	private Random random = new Random(new Time().toMillis(false));
	private List<Question> questions = new ArrayList<Question>();

	public QuestionGenerator() {
		int images[] = new int[] {
			R.drawable.cnn, R.drawable.cola, R.drawable.cos,
			R.drawable.ferrari, R.drawable.for_dummies, R.drawable.hallmark,
			R.drawable.la_conchita, R.drawable.nivea, R.drawable.sally,
			R.drawable.yahoo
		};
		
		String answers[] = new String[] {
			"CNN", "Coca-cola", "Cos", "Ferrari", "For dummies",
			"Hallmark", "La Conchita", "Nivea", "Sally", "Yahoo"
		};
		
		for (int i = 0; i < images.length; i++) {
			questions.add(new Question(images[i], answers[i]));
		}
	}

	public Question getQuestion(Question previousQuestion) {
		Question question;
		int i = 0;
		do {
			int index = random.nextInt(questions.size());
			question = questions.get(index);
			i++;
		} while (question == previousQuestion || i > 100);
		return question;
	}
}
