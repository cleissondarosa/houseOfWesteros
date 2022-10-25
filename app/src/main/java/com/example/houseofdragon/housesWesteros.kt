package com.example.houseofdragon

data class housesWesteros(
    var nome: String? = null,
    var situation: String? = null,
    var urlImg: String? = null,
    var nameHouse: String? = null,
    var imgH: String? = null
) {
    constructor() : this(
        "",
        "",
        "",
        "",
        ""
    )
}
