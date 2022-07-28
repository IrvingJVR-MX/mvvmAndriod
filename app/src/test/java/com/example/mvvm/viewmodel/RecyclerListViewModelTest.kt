package com.example.mvvm.viewmodel

import com.example.mvvm.models.RecyclerList
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test


class RecyclerListViewModelTest {
    private lateinit var mainViewModel: RecyclerListViewModel
    @Before
    fun beforeSetup(){
        mainViewModel = RecyclerListViewModel()
    }

    @After
   /* fun afterSetup(){
    }
*/
    @Test
    fun `User input returns true if filled`(){
        val recyclerList =  RecyclerList(1,1,"slobo","slobo@hotmail.com")
        val result = RecyclerListViewModel().validateUserData(
            recyclerList
        )
        Assert.assertEquals(true, result)
        assertThat(result).isFalse()
    }



}