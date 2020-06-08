package model.caffe

import java.util.*

// TODO add data, such as ID, list of products, and maybe an optional set of cats adopted/sponsored!

class Receipt(
    val id: String = UUID.randomUUID().toString(),
    val customerId: String,
    val items: MutableList<Product> = mutableListOf(),
    val tax: Double,
    val tip: Double

) {
    val totalReceipt: Double
        get() {
            var subTotal = 0.0
            var total = 0.0
            items.forEach {
                subTotal += it.price
            }
            total = tax + tip + subTotal
            return total
        }

}