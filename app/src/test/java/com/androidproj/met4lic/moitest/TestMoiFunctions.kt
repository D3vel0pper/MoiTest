package com.androidproj.met4lic.moitest

import org.junit.Assert
import org.junit.Test
import com.androidproj.met4lic.moitest.MoiTestFunctions as funcs

/**
 * Created by D3vel0pper on 2019/06/22.
 */
class TestMoiFunctions {
    @Test
    fun testCountMoi() {
        val pattern = "moiABCDmoiEFgmoi"
        val funcs = funcs()
        Assert.assertEquals(3, funcs.countMoi(pattern))
    }

    @Test
    fun testReplaceMoi() {
        val pattern = "moiABCDmoiEFgmoi"
        val expected = "MOIABCDMOIEFgMOI"
        val funcs = funcs()
        Assert.assertEquals(expected, funcs.replaceMoi(pattern))
    }

    @Test
    fun testReverseMoi() {
        val pattern = "123moi45moi6789"
        val expected = "9876moi54moi321"
        val funcs = funcs()
        Assert.assertEquals(expected, funcs.reverseMoi(pattern))
    }

    @Test
    fun testCutMoi() {
        var pattern = "moiABCDmoiEFGHIJKLMNmoiOPmoiQRST"
        var expected = "moiABCDmoiEFGLMNmoiOPmoiQRS"
        val funcs = funcs()
        Assert.assertEquals(expected, funcs.cutMoi(pattern))

        pattern = "ABCDEFG"
        expected = ""
        Assert.assertEquals(expected, funcs.cutMoi(pattern))
    }

    @Test
    fun testStartSignal() {

    }
}