package model.people

import model.animals.Cat
import java.util.*

open class Person(
    val id: String = UUID.randomUUID().toString(),
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val email: String,
    val cats: MutableSet<Cat> = mutableSetOf()
) {
    val fullName
        get() = "$firstName $lastName"
}