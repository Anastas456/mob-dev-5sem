package com.example.laba5

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import androidx.fragment.app.Fragment
import java.util.concurrent.TimeUnit

interface TaskCallbacks{
    fun onPreExecute()
    fun onCancelled()
    fun onPostExecute(i: Int)
}

class MyFragment : Fragment() {

    companion object{
        const val TAG = "MyFragment"
    }

    private var callbacks: TaskCallbacks? = null
    private var  task: MyTask? = null
    private var  handler: Handler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        startTask()             //второй вызов startTask()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbacks = requireActivity() as TaskCallbacks
    }

    override fun onDetach() {
        super.onDetach()
        callbacks = null
    }

    fun startTask(){
        task = MyTask()
        var handlerCallback: Handler.Callback = object : Handler.Callback{
            override fun handleMessage(msg: Message): Boolean {
                callbacks?.onPostExecute(msg.what)
                return false
            }
        }
        handler = Handler(handlerCallback)
        task?.execute()
    }

    fun cancelTask(){
        if (task == null) return
        task?.cancel(true)
    }

    inner class MyTask: AsyncTask<Unit, Int, Unit>(){
        override fun onPreExecute() {
            callbacks?.onPreExecute()
        }

        override fun doInBackground(vararg params: Unit?) {
            Log.d("TAG_IN_BACK", "start task")
            try{
                for (i in 0..7){
                    publishProgress(i)
                    TimeUnit.SECONDS.sleep(2)
                    if (isCancelled) break
                }
            }
            catch (e: InterruptedException){
                e.printStackTrace()
            }
        }

        override fun onCancelled() {
            callbacks?.onCancelled()
        }

        override fun onPostExecute(result: Unit?) {
//            callbacks?.let {
//                handler?.sendEmptyMessage(1)
//                handler?.sendEmptyMessageDelayed(2, 1500)
//            }
            Log.d("TAG_END", "end of task")
        }

        override fun onProgressUpdate(vararg values: Int?) {
            callbacks?.let{
                handler?.sendEmptyMessage(values[0]!!)
            }
        }

    }

}