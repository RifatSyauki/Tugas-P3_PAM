package com.example.newsfeedsimulator

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow

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

    val readCount: StateFlow<Int> =
        _readCount.asStateFlow()

    fun markAsRead() {
        _readCount.value++
    }
}

suspend fun fetchNewsDetail(news: News): String {
    delay(1000L)

    return "Detail: ${news.description}"
}