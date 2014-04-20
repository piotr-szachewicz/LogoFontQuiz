package pl.szachewicz.logofontquiz.utils;

import pl.szachewicz.logofontquiz.R;
import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class SoundEffectPlayer {

	private SoundPool soundPool;
	private int successSoundId;
	private int failureSoundId;

	public SoundEffectPlayer(Context context) {
		soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);

		successSoundId = soundPool.load(context, R.raw.success, 1);
		failureSoundId = soundPool.load(context, R.raw.failure, 1);
	}

	protected void playSound(int soundId) {
		soundPool.play(soundId, 100, 100, 1, 0, 1.0f);
	}

	public void playSuccess() {
		playSound(successSoundId);
	}

	public void playFailure() {
		playSound(failureSoundId);
	}

}
