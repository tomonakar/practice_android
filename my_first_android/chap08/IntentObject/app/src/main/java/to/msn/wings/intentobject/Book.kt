package to.msn.wings.intentobject

import java.io.Serializable

data class Book (val title: String, val publish: String, val price: String):
    Serializable {

    override fun toString(): String {
        return """
               書名：${title}
               出版社：${publish}
               価格：${price}
               """.trimIndent()
    }
}