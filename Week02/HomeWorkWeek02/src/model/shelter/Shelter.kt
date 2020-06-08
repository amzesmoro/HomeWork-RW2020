package model.shelter

import java.util.*

data class Shelter(
    val id: String = UUID.randomUUID().toString(),
    val shelterAddress: String,
    val shelterPhoneNumber: String
)