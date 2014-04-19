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
			R.drawable.cnn, R.drawable.cocacola, R.drawable.braun,
			R.drawable.ferrari, R.drawable.for_dummies, R.drawable.hallmark,
			R.drawable.la_conchita, R.drawable.nivea, R.drawable.sega,
			R.drawable.yahoo, R.drawable.compaq, R.drawable.disc,
			R.drawable.eurobusiness, R.drawable.heineken, R.drawable.ibm,
			R.drawable.instagram, R.drawable.la_conchita, R.drawable.nec,
			R.drawable.nickelodeon, R.drawable.nintendo, R.drawable.pacman,
			R.drawable.pepsi, R.drawable.puma, R.drawable.snickers,
			R.drawable.the_beatles, R.drawable.twitter, R.drawable.ubuntu,
			R.drawable.vespa, R.drawable.vimeo, R.drawable.walt_disney,
			R.drawable.hollywood, R.drawable.playstation,
		};

		String answers[] = new String[] {
			"CNN", "Coca-cola", "Braun", "Ferrari", "For dummies", "Hallmark",
			"La Conchita", "Nivea", "Sega", "Yahoo", "Compaq", "Disc",
			"Eurobusiness", "Heineken", "IBM", "Instagram", "La Conchita", "Nec",
			"Nickelodeon", "Nintendo", "Pacman", "Pepsi", "Puma", "Snickers",
			"The Beatles", "Twitter", "Ubuntu", "Vespa", "Vimeo", "Walt Disney",
			"Hollywood", "Playstation"
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
