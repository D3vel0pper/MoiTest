package com.androidproj.met4lic.moitest

/**
 * Created by D3vel0pper on 2019/06/22.
 */
class MoiTestFunctions {
    fun countMoi(target: String): Int {
        //moiの数は配列に切り分けた時の個数-1個なので
        var array = target.split("moi")
        var count = array.count() - 1
        return count
    }

    fun replaceMoi(target: String): String {
        var ret = target.replace("moi", "MOI")
        return ret
    }

    fun reverseMoi(target: String): String {
        var array = target.split("moi")
        val maxIndex = array.count() - 1
        var index = maxIndex
        var string = ""
        while(index >= 0) {
            string += array[index].reversed()
            if(index != 0) {
                string += "moi"
            }
            index--
        }
        return string
    }

    fun cutMoi(target: String): String {
        var i = 0
        /*
        * indexOfを使わなくても、最初と最後以外は６文字の切り出しだけで対応できる
        * (頭３文字、後ろ３文字)
        * */
        /*
        while(i != -1) {
            i = target.indexOf("moi", i)
        }
        */
        var indexOfMoi = target.indexOf("moi")
        if(indexOfMoi == -1) {
            return ""
        }
        var array = target.split("moi")
        val maxArrayIndex = array.count() - 1
        var string = ""
        for(cutTarget in array) {
            if(i == 0) {
                //頭側３文字抜き出し処理
                var stringCount = cutTarget.count()
                if(stringCount < 3) {
                    string += cutTarget
                }
                else {
                    string += cutTarget.subSequence(stringCount - 3, stringCount)
                }
                string += "moi"
            }
            else if (i == maxArrayIndex) {
                //後ろ側３文字抜き出し処理
                var stringCount = cutTarget.count()
                if(stringCount < 3) {
                    string += cutTarget
                }
                else {
                    string += cutTarget.subSequence(0, 3)
                }
            }
            else {
                //最大頭３文字、後ろ３文字抜き出し処理
                var stringCount = cutTarget.count()
                if(stringCount <= 6) {
                    string += cutTarget
                }
                else {
                    string += cutTarget.subSequence(0, 3)
                    string += cutTarget.subSequence(stringCount - 3, stringCount)
                }
                string += "moi"
            }
            println(string)
            i++
        }
        return string
    }
}
