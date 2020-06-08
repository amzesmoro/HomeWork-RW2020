package model.people

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Employee(
    id: String,
    firstName: String,
    lastName: String,
    email: String,
    phoneNumber: String,
    val salary: Double,
    val socialSecurityNumber: String,
    val hireDate: String
) : Person(id = id, firstName = firstName, lastName = lastName, email = email, phoneNumber = phoneNumber) {

    override fun toString(): String {
        return "$firstName $lastName was hired on: $hireDate. You want to contact her/him on Email: $email or " +
                "Phone Number: $phoneNumber"
    }

    fun clockIn(employee: Employee): String {
        val dateTime = LocalDateTime.now()
        val dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
        val currentTime = dateTime.format(dateTimeFormatter)
        return "${employee.fullName} clock in: $currentTime"
    }

    fun clockOut(employee: Employee): String {
        val dateTime = LocalDateTime.now()
        val dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
        val currentTime = dateTime.format(dateTimeFormatter)
        return "${employee.fullName} clock out: $currentTime"
    }
}