import java.io.File

fun main(args: Array<String>): List<Pair<String, Int>> {
    val ordListe = readFile(args[0]).split(" ", "\r\n")
    val stopOrd = readFile("./src/main/resource/stopWords.txt").split(",")

    val result = mutableMapOf<String, Int>()
    ordListe
        .map {it.trim(',', '.', '\"', ':', ';', ' ')}
        .map { it.lowercase() }
        .filter { it.length > 0 && !stopOrd.contains(it)}
        .forEach {
            if (result.containsKey(it)) {
                result.replace(it, result.get(it)!!.plus(1))
            } else {
                result.put(it, 1)
            }
        }

    val sorted = result.toList().sortedByDescending { (_, value) -> value}
    sorted.forEachIndexed { index, pair ->
        println("${pair.first} ${pair.second}")
        if (index == args[1].toInt()) {
            return sorted.subList(0, args[1].toInt())
        }
    }
    return emptyList()
}


fun readFile(fileName: String)
        = File(fileName).readText(charset("UTF-8"))

