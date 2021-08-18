import java.io.File

fun main(args: Array<String>) {
    countTermFrequency(args[0], args[1].toInt())
}

fun countTermFrequency(filename: String, count: Int): List<Pair<String, Int>>? {
    val ordListe = readFile(filename).split(Regex("[^a-zA-Z0-9]+"))
    val stopOrd = readFile("./src/main/resource/stopWords.txt").split(",")

    val result = mutableMapOf<String, Int>()
    ordListe
        .map { it.lowercase() }
        .filter { it.length > 1 && !stopOrd.contains(it)}
        .forEach {
            if (result.containsKey(it)) {
                result.replace(it, result.get(it)!!.plus(1))
            } else {
                result[it] = 1
            }
        }

    val sorted = result.toList().sortedByDescending { (_, value) -> value}

    sorted.forEachIndexed { index, pair ->
        println("${pair.first} ${pair.second}")
        if (index == count) {
            return sorted.subList(0, count)
        }
    }
    return null
}


fun readFile(fileName: String)
        = File(fileName).readText(charset("UTF-8"))

