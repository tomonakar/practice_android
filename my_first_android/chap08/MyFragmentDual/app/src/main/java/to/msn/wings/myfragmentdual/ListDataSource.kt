package to.msn.wings.myfragmentdual

class ListDataSource {
    companion object Factory {
        private val data = listOf(
            mapOf("name" to "胡椒", "alias" to "pepper",
                "info" to "コショウ科コショウ属でつる性植物です。黒胡椒、白胡椒、青胡椒、赤胡椒などがあります。"),
            mapOf("name" to "ターメリック", "alias" to "turmeric",
                "info" to "ショウガ科ウコン属で多年草です。「ウコン」とも呼ばれます。"),
            mapOf("name" to "コリアンダー", "alias" to "coriander",
                "info" to "セリ科の一年草です。「パクチー」「香菜（シャンツァイ）」「中国パセリ」とも呼ばれます。"),
            mapOf("name" to "生姜", "alias" to "ginger",
                "info" to "ショウガ科の多年草です。野菜として料理に使ったり、薬としても使用されます。"),
            mapOf("name" to "ニンニク", "alias" to "garlic",
                "info" to "ヒガンバナ科ネギ属の多年草です。日本では、2月29日がニンニクの日です。"),
            mapOf("name" to "サフラン", "alias" to "saffron",
                "info" to "アヤメ科の多年草です。めしべを乾燥させた香辛料を、パエリアなどの料理で使います。"),
        )

        fun getAllNames(): List<String> {
            val result = mutableListOf<String>()
            data.forEach {
                result.add(it["name"] ?: "")
            }
            return result
        }

        fun getAll(): List<Map<String, String>> {
            return data
        }

        fun getInfoByName(key: String?): Map<String, String> {
            return data.find { it["name"] == key } ?: mapOf()
        }
    }
}