package com.hyyy.kotlinsamplegame

import android.annotation.SuppressLint
import android.graphics.Typeface
import android.media.AudioAttributes
import android.media.SoundPool
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import kotlinx.android.synthetic.main.activity_main.*


/**
 * launch screen.
 * <p>
 *     小春音アミに50音を喋らせるアプリを作りましょう。
 *
 *     音声データ配布元
 *     http://www14.big.or.jp/~amiami/happy/utau.html>
 *
 * </p>
 */
class MainActivity : AppCompatActivity(), Thread.UncaughtExceptionHandler {

    // ログ出力用タグ
    val TAG = "Kana50withAmi" // tag for log

    // サウンドプール
    lateinit var soundpool: SoundPool

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate start")

        // 音声ファイルの読み込み準備
        val audioAttributes = AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME) // ゲーム用
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION) // ユーザ操作音
                .build()
        soundpool = SoundPool.Builder()
                .setAudioAttributes(audioAttributes)
                .setMaxStreams(1) // 同時再生数は1
                .build()

        // 音声ファイルをロード
        var se_a_a = soundpool.load(this, R.raw.ami_a_a, 1)
        var se_a_i = soundpool.load(this, R.raw.ami_a_i, 1)
        var se_a_u = soundpool.load(this, R.raw.ami_a_u, 1)
        var se_a_e = soundpool.load(this, R.raw.ami_a_e, 1)
        var se_a_o = soundpool.load(this, R.raw.ami_a_o, 1)
        var se_k_a = soundpool.load(this, R.raw.ami_k_a, 1)
        var se_k_i = soundpool.load(this, R.raw.ami_k_i, 1)
        var se_k_u = soundpool.load(this, R.raw.ami_k_u, 1)
        var se_k_e = soundpool.load(this, R.raw.ami_k_e, 1)
        var se_k_o = soundpool.load(this, R.raw.ami_k_o, 1)
        var se_s_a = soundpool.load(this, R.raw.ami_s_a, 1)
        var se_s_i = soundpool.load(this, R.raw.ami_s_i, 1)
        var se_s_u = soundpool.load(this, R.raw.ami_s_u, 1)
        var se_s_e = soundpool.load(this, R.raw.ami_s_e, 1)
        var se_s_o = soundpool.load(this, R.raw.ami_s_o, 1)
        var se_t_a = soundpool.load(this, R.raw.ami_t_a, 1)
        var se_t_i = soundpool.load(this, R.raw.ami_t_i, 1)
        var se_t_u = soundpool.load(this, R.raw.ami_t_u, 1)
        var se_t_e = soundpool.load(this, R.raw.ami_t_e, 1)
        var se_t_o = soundpool.load(this, R.raw.ami_t_o, 1)
        var se_n_a = soundpool.load(this, R.raw.ami_n_a, 1)
        var se_n_i = soundpool.load(this, R.raw.ami_n_i, 1)
        var se_n_u = soundpool.load(this, R.raw.ami_n_u, 1)
        var se_n_e = soundpool.load(this, R.raw.ami_n_e, 1)
        var se_n_o = soundpool.load(this, R.raw.ami_n_o, 1)
        var se_h_a = soundpool.load(this, R.raw.ami_h_a, 1)
        var se_h_i = soundpool.load(this, R.raw.ami_h_i, 1)
        var se_h_u = soundpool.load(this, R.raw.ami_h_u, 1)
        var se_h_e = soundpool.load(this, R.raw.ami_h_e, 1)
        var se_h_o = soundpool.load(this, R.raw.ami_h_o, 1)
        var se_m_a = soundpool.load(this, R.raw.ami_m_a, 1)
        var se_m_i = soundpool.load(this, R.raw.ami_m_i, 1)
        var se_m_u = soundpool.load(this, R.raw.ami_m_u, 1)
        var se_m_e = soundpool.load(this, R.raw.ami_m_e, 1)
        var se_m_o = soundpool.load(this, R.raw.ami_m_o, 1)
        var se_y_a = soundpool.load(this, R.raw.ami_y_a, 1)
        var se_y_u = soundpool.load(this, R.raw.ami_y_u, 1)
        var se_y_o = soundpool.load(this, R.raw.ami_y_o, 1)
        var se_r_a = soundpool.load(this, R.raw.ami_r_a, 1)
        var se_r_i = soundpool.load(this, R.raw.ami_r_i, 1)
        var se_r_u = soundpool.load(this, R.raw.ami_r_u, 1)
        var se_r_e = soundpool.load(this, R.raw.ami_r_e, 1)
        var se_r_o = soundpool.load(this, R.raw.ami_r_o, 1)
        var se_w_a = soundpool.load(this, R.raw.ami_w_a, 1)
        var se_w_i = soundpool.load(this, R.raw.ami_w_i, 1)
        var se_w_u = soundpool.load(this, R.raw.ami_w_u, 1)


        // ロード完了確認
        soundpool.setOnLoadCompleteListener { _, sampleId, status ->
            Log.d(TAG, "onLoadComplete id:$sampleId status:$status") }


        // フォント読み込み
        val face: Typeface = Typeface.createFromAsset(assets, "kodomo_rounded.otf")

        // レイアウト読み込み
        setContentView(R.layout.activity_main)

        // ボタンフォント設定
        button_a_a.typeface = face
        button_a_i.typeface = face
        button_a_u.typeface = face
        button_a_e.typeface = face
        button_a_o.typeface = face
        button_k_a.typeface = face
        button_k_i.typeface = face
        button_k_u.typeface = face
        button_k_e.typeface = face
        button_k_o.typeface = face
        button_s_a.typeface = face
        button_s_i.typeface = face
        button_s_u.typeface = face
        button_s_e.typeface = face
        button_s_o.typeface = face
        button_t_a.typeface = face
        button_t_i.typeface = face
        button_t_u.typeface = face
        button_t_e.typeface = face
        button_t_o.typeface = face
        button_n_a.typeface = face
        button_n_i.typeface = face
        button_n_u.typeface = face
        button_n_e.typeface = face
        button_n_o.typeface = face
        button_h_a.typeface = face
        button_h_i.typeface = face
        button_h_u.typeface = face
        button_h_e.typeface = face
        button_h_o.typeface = face
        button_m_a.typeface = face
        button_m_i.typeface = face
        button_m_u.typeface = face
        button_m_e.typeface = face
        button_m_o.typeface = face
        button_y_a.typeface = face
        button_y_u.typeface = face
        button_y_o.typeface = face
        button_r_a.typeface = face
        button_r_i.typeface = face
        button_r_u.typeface = face
        button_r_e.typeface = face
        button_r_o.typeface = face
        button_w_a.typeface = face
        button_w_i.typeface = face
        button_w_u.typeface = face

        // ボタン押下時の挙動
        button_a_a.setOnClickListener { soundpool.play(se_a_a, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_a_a)}
        button_a_i.setOnClickListener { soundpool.play(se_a_i, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_a_i)}
        button_a_u.setOnClickListener { soundpool.play(se_a_u, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_a_u)}
        button_a_e.setOnClickListener { soundpool.play(se_a_e, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_a_e)}
        button_a_o.setOnClickListener { soundpool.play(se_a_o, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_a_o)}
        button_k_a.setOnClickListener { soundpool.play(se_k_a, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_k_a)}
        button_k_i.setOnClickListener { soundpool.play(se_k_i, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_k_i)}
        button_k_u.setOnClickListener { soundpool.play(se_k_u, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_k_u)}
        button_k_e.setOnClickListener { soundpool.play(se_k_e, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_k_e)}
        button_k_o.setOnClickListener { soundpool.play(se_k_o, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_k_o)}
        button_s_a.setOnClickListener { soundpool.play(se_s_a, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_s_a)}
        button_s_i.setOnClickListener { soundpool.play(se_s_i, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_s_i)}
        button_s_u.setOnClickListener { soundpool.play(se_s_u, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_s_u)}
        button_s_e.setOnClickListener { soundpool.play(se_s_e, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_s_e)}
        button_s_o.setOnClickListener { soundpool.play(se_s_o, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_s_o)}
        button_t_a.setOnClickListener { soundpool.play(se_t_a, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_t_a)}
        button_t_i.setOnClickListener { soundpool.play(se_t_i, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_t_i)}
        button_t_u.setOnClickListener { soundpool.play(se_t_u, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_t_u)}
        button_t_e.setOnClickListener { soundpool.play(se_t_e, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_t_e)}
        button_t_o.setOnClickListener { soundpool.play(se_t_o, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_t_o)}
        button_n_a.setOnClickListener { soundpool.play(se_n_a, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_n_a)}
        button_n_i.setOnClickListener { soundpool.play(se_n_i, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_n_i)}
        button_n_u.setOnClickListener { soundpool.play(se_n_u, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_n_u)}
        button_n_e.setOnClickListener { soundpool.play(se_n_e, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_n_e)}
        button_n_o.setOnClickListener { soundpool.play(se_n_o, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_n_o)}
        button_h_a.setOnClickListener { soundpool.play(se_h_a, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_h_a)}
        button_h_i.setOnClickListener { soundpool.play(se_h_i, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_h_i)}
        button_h_u.setOnClickListener { soundpool.play(se_h_u, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_h_u)}
        button_h_e.setOnClickListener { soundpool.play(se_h_e, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_h_e)}
        button_h_o.setOnClickListener { soundpool.play(se_h_o, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_h_o)}
        button_m_a.setOnClickListener { soundpool.play(se_m_a, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_m_a)}
        button_m_i.setOnClickListener { soundpool.play(se_m_i, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_m_i)}
        button_m_u.setOnClickListener { soundpool.play(se_m_u, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_m_u)}
        button_m_e.setOnClickListener { soundpool.play(se_m_e, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_m_e)}
        button_m_o.setOnClickListener { soundpool.play(se_m_o, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_m_o)}
        button_y_a.setOnClickListener { soundpool.play(se_y_a, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_y_a)}
        button_y_u.setOnClickListener { soundpool.play(se_y_u, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_y_u)}
        button_y_o.setOnClickListener { soundpool.play(se_y_o, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_y_o)}
        button_r_a.setOnClickListener { soundpool.play(se_r_a, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_r_a)}
        button_r_i.setOnClickListener { soundpool.play(se_r_i, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_r_i)}
        button_r_u.setOnClickListener { soundpool.play(se_r_u, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_r_u)}
        button_r_e.setOnClickListener { soundpool.play(se_r_e, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_r_e)}
        button_r_o.setOnClickListener { soundpool.play(se_r_o, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_r_o)}
        button_w_a.setOnClickListener { soundpool.play(se_w_a, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_w_a)}
        button_w_i.setOnClickListener { soundpool.play(se_w_i, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_w_i)}
        button_w_u.setOnClickListener { soundpool.play(se_w_u, 1.0f, 1.0f, 0, 0, 1.0f); startScaling(button_w_u)}


    }


    @SuppressLint("MissingPermission")
    private fun startScaling(targetView: View) {
        // ScaleAnimation(float fromX, float toX, float fromY, float toY, int pivotXType, float pivotXValue, int pivotYType, float pivotYValue)
        val scaleAnimation = ScaleAnimation(
                1.0f, 2.0f, 1.0f, 2.0f,
                Animation.RELATIVE_TO_SELF,
                0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
        // animation時間 msec
        scaleAnimation.duration = 500
        // 繰り返し回数
        scaleAnimation.repeatCount = 0
        // animationが終わった元に戻す
        scaleAnimation.fillAfter = false
        //アニメーションの開始
        targetView.startAnimation(scaleAnimation)

    }

    override fun uncaughtException(thread: Thread?, throwable: Throwable?) {
        Log.w(TAG, "*** UncaughtException ***" + throwable.toString())
    }
}
