package com.example.laba5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.laba5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), TaskCallbacks {

    private val verticalLinearLayoutManager: LinearLayoutManager=
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    companion object{
//        const val  PROGRESS_IS_SHOWING = "PROGRESS_IS_SHOWING"
        const val  RESULT = "RESULT"
    }

    private lateinit var binding: ActivityMainBinding
    private var fragment: MyFragment? = null
    private var myResult: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        savedInstanceState?.getBoolean(PROGRESS_IS_SHOWING)?.let {
//            showProgress(it)
//        }
        savedInstanceState?.getInt(RESULT)?.let {
            Log.d("MY_TAG", "RESTORE STATE = $it")
        }

        val fm = supportFragmentManager         //создаем или вытаскиваем фрагмент (если он уже создавался)
        val oldFragment = fm.findFragmentByTag(MyFragment.TAG)
        if (oldFragment == null) {
            fragment = MyFragment()
            fm
                .beginTransaction()
                .add(fragment!!, MyFragment.TAG)
                .commit()
        } else {
            fragment = oldFragment as MyFragment
        }

        fragment?.startTask()       //первый вызов startTask()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
//        outState.putBoolean(PROGRESS_IS_SHOWING, binding.progress.isVisible)
        outState.putInt(RESULT, myResult!!)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        fragment?.cancelTask()
    }

    override fun onPreExecute() {
    }

    override fun onCancelled() {
        Log.d("TAG_CANCELLED", "CANCELLED")
    }

    override fun onPostExecute(i: Int) {
        myResult = i
        Log.d("TAG_POST_EX", "MESSAGE = $i")
        updateRecycleView(i)
    }

    private fun updateRecycleView(i: Int){
        binding.list.layoutManager = verticalLinearLayoutManager
        binding.list.adapter = Adapter(Holder.createItemList(i))
    }
}