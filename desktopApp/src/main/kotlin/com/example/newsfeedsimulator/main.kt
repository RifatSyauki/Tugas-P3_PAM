package com.example.newsfeedsimulator

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

data class News(
    val id: Int,
    val title: String,
    val category: String,
    val description: String
)

val newsList = listOf(
    News(
        1,
        "Kotlin 2.0 Resmi Dirilis",
        "Teknologi",
        "Kotlin menghadirkan berbagai peningkatan untuk pengembangan aplikasi."
    ),

    News(
        2,
        "Tim Indonesia Raih Prestasi Internasional",
        "Olahraga",
        "Tim Indonesia berhasil meraih prestasi dalam kompetisi internasional."
    ),

    News(
        3,
        "Perkembangan AI Semakin Pesat",
        "Teknologi",
        "Artificial Intelligence terus berkembang di berbagai bidang."
    ),

    News(
        4,
        "Tips Menjaga Kesehatan di Era Digital",
        "Kesehatan",
        "Penggunaan perangkat digital perlu diimbangi dengan pola hidup sehat."
    ),

    News(
        5,
        "Smartphone Generasi Terbaru Diluncurkan",
        "Teknologi",
        "Perangkat terbaru menawarkan peningkatan performa."
    )
)

fun newsFlow(): Flow<News> = flow {
    var index = 0
    while (true) {
        delay(2000L)
        val news = newsList[index % newsList.size]
        emit(news)
        index++
    }
}
class NewsState {
    private val _readCount = MutableStateFlow(0)
    val readCount: StateFlow<Int> = _readCount.asStateFlow()
    fun markAsRead() {
        _readCount.value++
    }
}

fun main() = runBlocking {

    val selectedCategory = "Teknologi"

    val newsState = NewsState()

    // Mengamati perubahan StateFlow
    val stateJob = launch {
        newsState.readCount.collect { count ->
            println("[StateFlow] Jumlah berita dibaca: $count")
        }
    }

    newsFlow()
        .filter { news ->
            news.category == selectedCategory
        }
        .onEach {
            println("\n[Flow] Berita teknologi ditemukan!")
        }
        .map { news ->
            """
            📰 ${news.title}
            Kategori: ${news.category}
            Deskripsi: ${news.description}
            """.trimIndent()
        }
        .take(3)
        .collect { news ->
            println(news)
            println()
            newsState.markAsRead()
        }
    stateJob.cancel()
}