package com.androidproj.met4lic.moitest

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import com.androidproj.met4lic.moitest.MoiTestFunctions

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val urlText = findViewById<View>(R.id.url) as EditText

        val fab = findViewById<View>(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            val url: String = urlText.getText().toString()
            val mtf = MoiTestFunctions()
            var response = mtf.sendStartSignal(url)
            var i = 0
            while(i < 10) {
                var parsedResponse :Any? = mtf.parseResponse(response)
                if(parsedResponse is Operation) {
                    var answer: String = ""
                    //operationの処理
                    when(parsedResponse.operation) {
                        "count" -> {
                            answer = mtf.countMoi(parsedResponse.string).toString()
                        }
                        "replace" -> {
                            answer = mtf.replaceMoi(parsedResponse.string)
                        }
                        "reverse" -> {
                            answer = mtf.reverseMoi(parsedResponse.string)
                        }
                        "cut" -> {
                            answer = mtf.cutMoi(parsedResponse.string)
                        }
                    }
                    //sendAnswer
                    response = mtf.sendAnswer(url, answer)
                }
                else if(parsedResponse is Result) {
                    //結果をポップアップ表示
                    AlertDialog.Builder(this).apply {
                        setTitle("Result")
                        setMessage(messageBuilder(
                                parsedResponse.result,
                                parsedResponse.score,
                                parsedResponse.message
                        ))
                        show()
                    }
                    break
                }
                else {
                    break
                }
                i++
            }
        }
    }

    fun messageBuilder(result: String, score: Int, message: String): String {
        var messageContent: String = ""
        messageContent += "result: " + result + "\n"
        messageContent += "score: " + score.toString() + "\n"
        messageContent += "message: " + message
        return messageContent
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }
}
