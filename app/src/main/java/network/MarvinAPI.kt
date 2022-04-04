package network


interface MarvinAPI {
    fun getSearchTags(query: String): Array<Sighting>?
}