package helper

import model.animals.Cat
import model.caffe.Cafe
import model.caffe.Product
import model.people.Person
import model.shelter.Shelter

class CafeController {

    private val cafe = Cafe()

    private val shelters = mutableSetOf<Shelter>()
    private val shelterToCat = mutableMapOf<Shelter, MutableSet<Cat>>()

    fun adoptCat(catId: String, person: Person) {
        val catInShelter = shelterToCat.entries.firstOrNull { (_, catsInShelter) ->
            catsInShelter.any { it.id == catId }
        }

        if (catInShelter != null) {
            val cat = catInShelter.value.first { cat -> cat.id == catId } // find the cat for that ID again
            catInShelter.value.remove(cat)
            person.cats.add(cat)
        }
    }

    fun sellItems(items: List<Product>, customerId: String, tax: Double, tip: Double) {
        val receipt = cafe.getReceipt(items, customerId, tax, tip)
    }

    fun getNumberOfAdoptionsPerShelter(): Map<String, Int> {
        val allAdopters = cafe.getAdopters()
        return emptyMap()
    }

    fun getUnadoptedCats(): Set<Cat> {
        val cats = mutableSetOf<Cat>()
        for (cat in shelterToCat.values) {
            cats.addAll(cat)
        }
        return cats
    }
}
