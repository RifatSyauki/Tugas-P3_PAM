package com.example.newsfeedsimulator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.async

@Composable
fun App() {
    val newsState = remember { NewsState() }
    var newsItems by remember {
        mutableStateOf<List<News>>(emptyList())
    }
    val readCount by newsState.readCount.collectAsState()

    LaunchedEffect(Unit) {
        newsFlow()
            .filter { news ->
                news.category == "Teknologi"
            }
            .map { news ->
                News(
                    id = news.id,
                    title = "📰 ${news.title}",
                    category = news.category,
                    description = news.description
                )
            }
            .take(3)
            .collect { news ->

                val detail = async {
                    fetchNewsDetail(news)
                }.await()
                newsItems = newsItems + news.copy(
                    description = detail
                )
                newsState.markAsRead()
            }
    }

    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "News Feed Simulator",
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = "Berita dibaca: $readCount",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(vertical = 12.dp)
            )
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(newsItems) { news ->
                    Card(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                text = news.title,
                                style = MaterialTheme.typography.titleLarge
                            )
                            Text(
                                text = "Kategori: ${news.category}",
                                style = MaterialTheme.typography.bodyMedium
                            )
                            Text(
                                text = news.description,
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(top = 8.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}