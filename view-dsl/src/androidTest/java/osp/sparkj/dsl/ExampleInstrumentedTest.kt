package osp.sparkj.dsl

@DslMarker
@Target(AnnotationTarget.FUNCTION,AnnotationTarget.TYPE, AnnotationTarget.CLASS)
annotation class HtmlDsl

@HtmlDsl
class Html {
    private val elements = mutableListOf<Body>()

    fun body(init:Body.() -> Unit) {
        val body = Body().apply(init)
        elements.add(body)
    }

    override fun toString() = elements.joinToString(separator = "\n") { it.toString() }
}

@HtmlDsl
class Body {
    private val elements = mutableListOf<P>()

    fun p(init: P.() -> Unit) {
        val p = P().apply(init)
        elements.add(p)
    }

    override fun toString() = elements.joinToString(separator = "\n") { it.toString() }
}

@HtmlDsl
class P {
    var text: String = ""

    override fun toString() = "<p>$text</p>"
}

fun html(init: Html.() -> Unit): Html {
    return Html().apply(init)
}

fun main() {
    val document = html {
        body {
            p {
                text = "Hello, world!"
//                body {} // 这将被编译器限制
            }

            // 如果没有@DslMarker，这里可以意外地调用外层Html的方法
//             body {} // 这将被编译器限制
        }
    }
    println(document)
}