package jlin2.examples.localtesting

import org.junit.Assert.assertTrue
import org.junit.Assert.assertFalse
import org.junit.Test

class EmailValidatorTest {

    @Test
    fun testEmailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("123@abc.com"))
    }

    @Test
    fun testEmailValidator_CorrectEmailSubDomain_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("123@abc.co.ca"))
    }

    @Test
    fun testEmailValidator_InvalidEmailNoDomain_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("123@abc"))
    }

    @Test
    fun testEmailValidator_InvalidEmailDoubleDots_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("123@abc..com"))
    }


  @Test
    fun testEmailValidator_InvalidEmailNoUsername_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("@abc.com"))
    }

    @Test
    fun testEmailValidator_InvalidEmailNoAtSymbol_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("testing123"))
    }


    @Test
    fun testEmailValidator_EmptyString_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(""))
    }

    @Test
    fun testEmailValidator_Null_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(null))
    }

}
