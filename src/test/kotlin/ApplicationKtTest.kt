import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class ApplicationKtTest {

    @Test
    fun main() {
        val result = main(arrayOf("./src/test/resource/input.txt", "6"))
        assertTrue { result.size == 6 }
        assertTrue(result.get(0).first == "live")
        assertTrue(result.get(0).second == 2)
        assertTrue(result.get(1).first == "mostly")
        assertTrue(result.get(1).second == 2)
    }
}