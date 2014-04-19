package pl.szachewicz.logofontquiz.questions;

public class Question {

	private int imageId;
	private String answer;

	public Question(int imageId, String answer) {
		super();
		this.imageId = imageId;
		this.answer = answer;
	}

	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
