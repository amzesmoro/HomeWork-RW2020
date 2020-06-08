package model.caffe

import model.animals.Cat
import model.people.Employee
import model.people.Person
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.*

class Cafe {

    private val receiptsByDay = mutableMapOf(
        "Monday" to mutableSetOf<Receipt>(),
        "Tuesday" to mutableSetOf<Receipt>(),
        "Wednesday" to mutableSetOf<Receipt>(),
        "Thursday" to mutableSetOf<Receipt>(),
        "Friday" to mutableSetOf<Receipt>(),
        "Saturday" to mutableSetOf<Receipt>(),
        "Sunday" to mutableSetOf<Receipt>()
    )

    private val employees = mutableSetOf<Employee>(

    )
    private val customers = mutableSetOf<Person>()

    private val sponsorships = mutableSetOf<Sponsorship>()

    fun checkInEmployee(employee: Employee) {
        employee.clockIn(employee)
        employees.add(employee)
    }

    fun checkOutEmployee(employee: Employee) {
        employee.clockOut(employee)
        employees.add(employee)
    }

    fun showNumberOfReceiptsForDay(day: String) {
        val receiptForDay = receiptsByDay[day] ?: return
        println("On $day you made ${receiptsByDay.size} transactions!")
    }

    fun getReceipt(items: List<Product>, customerId: String, tax: Double, tip: Double): Receipt {
        val day = LocalDate.now().dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH)
        val receipt = Receipt(customerId = customerId, items = items.toMutableList(), tax = tax, tip = tip)
        receiptsByDay[day]?.add(receipt)
        return receipt
    }

    fun addSponsorship(catId: String, personId: String) {
        sponsorships.add(Sponsorship(personId, catId))
    }

    fun getWorkingEmployees(): Set<Employee> = employees

    fun getAdoptedCats(): Set<Cat> {
        return setOf()
    }

    fun getSponsoredCats(): Set<Cat> {
        return setOf()
    }

    fun getMostPopularCats(): Set<Cat> {
        return setOf()
    }

    fun getTopSellingItems(): Set<Product> {
        return setOf()
    }

    fun getAdopters(): List<Person> {
        return (employees + customers).filter { it.cats.isNotEmpty() }
    }
}