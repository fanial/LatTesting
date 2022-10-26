package com.fal.lattesting

import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class RegisterTest {

    lateinit var register: Register

    @Before
    fun setUp() {
        register = Register()
    }

    @After
    fun tearDown() {
    }

    @Test
    fun validateRegistrationInput() {
        val result = register.validateRegistrationInput(
            "abcde",
            "abc123",
            "abc123"
        )
        assertEquals("Register Valid", result, true)

    }

    @Test
    fun usernameIsEmptyfalse(){
        val result = register.validateRegistrationInput(
            "",
            "abcde",
            "abcde"
        )
        assertEquals("Username Empty", result, false)
    }

    @Test
    fun passIsEmptyfalse(){
        val result = register.validateRegistrationInput(
            "abcde",
            "",
            "abcde"
        )
        assertEquals("Password Can't Empty", result, false)
    }

    @Test
    fun ConfirmPassIsEmptyfalse(){
        val result = register.validateRegistrationInput(
            "abcde",
            "abc123",
            ""
        )
        assertEquals("Confirmed Password Can't Empty", result, false)
    }

    @Test
    fun usernameWithSymbol(){
        val user = "qwerty?!"
        val result = register.validateRegistrationInput(
            user,
            "abc123",
            "abc123"
        )
        assertEquals("Username Can't with Symbol", result, true)
    }



}