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
import androidx.compose.ui.tooling.preview.Preview
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
                .background(Color(15, 23, 42))
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            ProfileCard {
                ProfileHeader()

                Spacer(
                    modifier = Modifier.size(18.dp)
                )

                Text(
                    text = "Mahasiswa Teknik Informatika",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color(226, 232, 240)
                )

                Text(
                    text = "Institut Teknologi Sumatera",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(148, 163, 184)
                )

                Spacer(
                    modifier = Modifier.size(24.dp)
                )

                InfoItem(
                    label = "Email",
                    value = "mrifat.124140138@student.itera.ac.id"
                )

                InfoItem(
                    label = "Phone",
                    value = "+62 8969-0544-925"
                )

                InfoItem(
                    label = "Location",
                    value = "Lampung, Indonesia"
                )

                Spacer(
                    modifier = Modifier.size(18.dp)
                )

                Button(
                    onClick = {
                        showMessage = !showMessage
                    },
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (showMessage) {
                            Color(51, 65, 85)
                        } else {
                            Color(59, 130, 246)
                        },
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        text = if (showMessage) {
                            "Following"
                        } else {
                            "Follow +"
                        },
                        style = MaterialTheme.typography.labelLarge
                    )
                }

                if (showMessage) {
                    Text(
                        text = "Follow successful.",
                        modifier = Modifier.padding(top = 10.dp),
                        color = Color(74, 222, 128),
                        style = MaterialTheme.typography.bodyMedium
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
                    .size(135.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(
                modifier = Modifier.height(14.dp)
            )

            Text(
                text = "M. Rif'at Syauki",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White
            )

            Text(
                text = "Informatics Engineering",
                style = MaterialTheme.typography.bodyMedium,
                color = Color(148, 163, 184)
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
            .padding(vertical = 7.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium,
                color = Color(96, 165, 250)
            )

            Text(
                text = value,
                style = MaterialTheme.typography.bodyLarge,
                color = Color(226, 232, 240)
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
        shape = RoundedCornerShape(22.dp)
    ) {
        Column(
            modifier = Modifier
                .background(Color(30, 41, 59))
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            content()
        }
    }
}
