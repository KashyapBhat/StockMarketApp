package kashyap.learning.stocktrading

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform