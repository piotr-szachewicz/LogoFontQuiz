package pl.szachewicz.logofontquiz;

import pl.szachewicz.logofontquiz.R;
import pl.szachewicz.logofontquiz.questions.Question;
import pl.szachewicz.logofontquiz.questions.QuestionGenerator;
import pl.szachewicz.logofontquiz.utils.SoundEffectPlayer;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class GameActivity extends Activity implements OnClickListener {

	private ImageView quizImageView;
	private EditText answerEditText;
	private Button submitAnswerButton;
	private QuestionGenerator questionGenerator = new QuestionGenerator();
	private Question currentQuestion;

	private SoundEffectPlayer soundEffectPlayer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);

		quizImageView = (ImageView) findViewById(R.id.quizImage);
		answerEditText = (EditText) findViewById(R.id.answerEditText);
		submitAnswerButton = (Button) findViewById(R.id.submitAnswerButton);
		submitAnswerButton.setOnClickListener(this);

		soundEffectPlayer = new SoundEffectPlayer(getApplicationContext());
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		showNextQuestion();
	}

	@Override
	public void onClick(View view) {
		checkAnswer();
		showNextQuestion();
	}
	
	protected void checkAnswer() {
		String response = answerEditText.getText().toString();

		String toastText;
		if(response.equalsIgnoreCase(currentQuestion.getAnswer())) {
			toastText = getResources().getString(R.string.positive_feedback);
			soundEffectPlayer.playSuccess();
		} else {
			toastText = getResources().getString(R.string.negative_feedback, currentQuestion.getAnswer());
			soundEffectPlayer.playFailure();
		}
		Toast toast = Toast.makeText(getApplicationContext(), toastText, Toast.LENGTH_SHORT);
		toast.show();
	}

	protected void showNextQuestion() {
		currentQuestion = questionGenerator.getQuestion(currentQuestion);
		quizImageView.setImageResource(currentQuestion.getImageId());
		answerEditText.setText("");
	}

}
