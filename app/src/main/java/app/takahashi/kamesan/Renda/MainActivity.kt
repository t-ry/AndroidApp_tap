package app.takahashi.kamesan.Renda

import android.content.IntentSender
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import app.takahashi.kamesan.Renda.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //バインディングクラスの変数
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply{ setContentView(this.root)}

        // tapを数える変数の準備
        var tapCount: Int = 0

        var second: Int = 10

        val timer: CountDownTimer = object : CountDownTimer(10000,1000){
            //タイマーが終了するときに呼びだす
            override fun onFinish(){
                binding.startButton.isVisible = true
                binding.tapButton.backgroundTintList =
                    ContextCompat.getColorStateList(this@MainActivity, R.color.gray)
                second = 10
                tapCount = 0
            }

            //1秒ごとに呼びだす
            override fun onTick(millisUntilFinished: Long){
                binding.tapButton.backgroundTintList =
                    ContextCompat.getColorStateList(this@MainActivity, R.color.skyblue)
                second -= 1
                binding.secondText.text = second.toString()
            }
        }
        //スタートボタンWがタップされたときの処理
        binding.startButton.setOnClickListener{
            binding.countText.text = tapCount.toString()
            binding.startButton.isVisible = false
            timer.start()
        }
        // buttonがタップされたときの処理
        binding.tapButton.setOnClickListener{
            if(second < 10){
                tapCount++
                binding.countText.text = tapCount.toString()
            }

        }
    }
}