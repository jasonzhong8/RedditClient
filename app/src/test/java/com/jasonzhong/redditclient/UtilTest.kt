package com.jasonzhong.redditclient

import com.jasonzhong.redditclient.util.Util

import org.junit.Test

import org.junit.Assert.*

class UtilTest {

    @Test
    fun testRemoveLastChar() {
        val actualSt = Util.removeLastChar("http://www.google.com/")

        val expectedSt = "http://www.google.com"

        assertEquals(expectedSt, actualSt)
    }
}