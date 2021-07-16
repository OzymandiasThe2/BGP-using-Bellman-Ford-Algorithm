// Storing information into array
data class EdgeToCalc(var Start:String, var Stop:String, var Weight:Int, var E:Int)
{
    var startArray  = Array(E){ Start}
    var stopArray   = Array(E){ Stop}
    var weightArray  = Array(E){ Weight}
}

// Constructing edges from array
data class Graph(var Vertex:Int, var Edge: Int)
{
    var edg = EdgeToCalc("","",0,Edge)
}
// Creating graph from edges
fun create( V:Int , E:Int):Graph                                      
{
    val g = Graph(V,E)
    g.edg =  EdgeToCalc("No","Yes",9999,E)

    return g
}
// Bellman-Ford algorithm
fun bellmanFord(graph:Graph, Stv:String)                                 
{
    val vertex = graph.copy().Vertex
    val edge = graph.copy().Edge

    val arr = mutableMapOf<String, Int>()

    arr[Stv] = 0
    var startingVertex: String
    var destinationVertex :String
    var weight : Int

    for (i in 0 until vertex-1)
        for (j in 0 until edge) {
            startingVertex = graph.edg.startArray[j]
            destinationVertex = graph.edg.stopArray[j]
            weight = graph.edg.weightArray[j]
            if (arr[startingVertex] != null  && (arr[startingVertex]?:9999)+ weight < (arr[destinationVertex]?:9999))
                arr[destinationVertex] = (arr[startingVertex]?:9999) + weight
        }
    print(arr)
}
// Displaying graph information
fun input(ver: Int, edges: Map<Pair<String, String>,Int>)                                                           
{

    var startingVertex : String
    var destinationVertex : String
    var weight : Int

    println("Total network vertices")
    val vertex : Int = ver
    println(vertex)

    println("Total network edges")
    val edge : Int = edges.size
    println(edge)


    val g : Graph = create(vertex,edge)

    edges.entries.forEachIndexed { i, it ->
        startingVertex = it.key.first
        destinationVertex = it.key.second
        weight = it.value

    g.edg.startArray[i] = startingVertex
    g.edg.stopArray[i]  = destinationVertex
    g.edg.weightArray[i] = weight
}

// Vertex Selection i.e. pick starting city | User Input //
    print("From the listed unique cities, please choose 1 as your starting vertex: ")
    val startingCity = readLine()!!
    bellmanFord(g,startingCity)


}

