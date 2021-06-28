import java.io.File

/// Debug Lines for troubleshooting
//val networkConnections = mutableMapOf<String, Int>()
//val uniqueCities = mutableListOf<String>()
//const val fileBGPNetwork = "src/main/information/network-final.txt"
//val fileLines = File(fileBGPNetwork).readLines()
//val totalNetworkEdges = fileLines.size
//val totalNetworkVertexes = uniqueCities.distinct().size

fun main() {
    val networkConnections = mutableMapOf<Pair<String, String>, Int>()
    val uniqueCities = mutableListOf<String>()
    val fileBGPNetwork = "src/main/information/network-final.txt"
    val fileLines = File(fileBGPNetwork).readLines()
    println("Reading file in $fileBGPNetwork")


    for (lines in fileLines) {
        val line = lines.split(" ")
        val firstWord = line[0]
        val secondWord = line[1]
        val fullConnection = firstWord to secondWord
        val weight = line[2]
        networkConnections[fullConnection] = weight.toInt()
        uniqueCities.add(firstWord)
        uniqueCities.add(secondWord)
    }
    val totalNetworkVertexes = uniqueCities.distinct().size
    val listOfUniqueCities = uniqueCities.distinct()

    println(networkConnections)

    if (fileLines.isNotEmpty())
        println("There are only ${fileLines.size} lines in the file")

    println("Number of unique cities are: $totalNetworkVertexes")
    println("The unique cities are:  $listOfUniqueCities ")

    input(totalNetworkVertexes, networkConnections)

}

