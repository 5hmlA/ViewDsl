package osp.sparkj.dsl

import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        Regex("""\d+""").findAll("你好12世界23").forEach { result ->
            println("${result.value} > ${result.range.first}, ${result.range.last}")
        }
    }
}