package com.example.myprofileapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import myprofileapp.shared.generated.resources.Res
import myprofileapp.shared.generated.resources.compose_multiplatform
import androidx.compose.ui.tooling.preview.Preview
import myprofileapp.shared.generated.resources.FotoRefah
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.graphics.Color

@Composable
@Preview
fun App() {

    var showMessage by remember {
        mutableStateOf(false)
    }

    MaterialTheme {

        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            ProfileCard {
                ProfileHeader()
                Spacer(
                    modifier = Modifier.size(16.dp)
                )
                Text(
                    text = "Mahasiswa Teknik Informatika",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "Institut Teknologi Sumatera",
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(
                    modifier = Modifier.size(20.dp)
                )
                InfoItem(
                    label = "Email",
                    value = "mrifat.124140138@student.itera.ac.id"
                )
                InfoItem(
                    label = "Phone",
                    value = "+62 896-905-44925"
                )
                InfoItem(
                    label = "Location",
                    value = "Lampung, Indonesia"
                )
                Spacer(
                    modifier = Modifier.size(16.dp)
                )
                Button(
                    onClick = {
                        showMessage = !showMessage
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (showMessage) {
                            Color.White
                        } else {
                            MaterialTheme.colorScheme.primary
                        },
                        contentColor = if (showMessage) {
                            Color.Black
                        } else {
                            Color.White
                        }
                    )
                ) {
                    Text(
                        text = if (showMessage) {
                            "Following"
                        } else {
                            "Follow +"
                        }
                    )
                }
                if (showMessage) {
                    Text(
                        text = "Follow successful.",
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }
        }
    }
}
@Composable
fun ProfileHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(
                    Res.drawable.1298033
                ),
                contentDescription = "Foto Profil",
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Spacer(
                modifier = Modifier.height(12.dp)
            )
            Text(
                text = "M. Rif'at Syauki",
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = "Informatics Engineering",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
@Composable
fun InfoItem(
    label: String,
    value: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium
            )
            Text(
                text = value,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
@Composable
fun ProfileCard(
    content: @Composable () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            content()
        }
    }
}
