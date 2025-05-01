package com.example.biodata.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.biodata.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavController){
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Detail Mahasiswa")
                }
            )
        },
        modifier = Modifier
            .fillMaxSize(),
        
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxSize()
                    .padding(paddingValues),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(
                    painter = painterResource(id = R.drawable.img2),
                    contentDescription = "My Image",
                    modifier = Modifier
                        .size(200.dp)
                )
                Spacer(modifier = Modifier.height(40.dp))
                Field("Nama", "Muhammad Fauzan Ahsani")
                Field("TTL", "Tembilahan, 2 Juli 2005")
                Field("NIM", "2310817310009")
                Field("Universitas", "Universitas Lambung Mangkurat")
                Field("Program Studi", "Teknologi Informasi")
                Field("Angkatan", "2023")
                Field("Semester", "4")
                Field("IPK", "3,82")
                Field("Alamat Email", "2310817310009@mhs.ulm.ac.id")
                Field("Asal", "Barabai, Kalimantan Selatan")
                FieldList("Hobi",
                    listOf(
                        "Competitive programming",
                        "Puzzle game",
                        "Mendengarkan musik",
                        "Ilmu eksakta",
                        "Menggambar",
                        "Dance (KPop)",
                        "Sepakbola (game simulasi seperti FM)",
                        "Bermain game",
                        "Belajar bahasa asing")
                )
                FieldList("Pencapaian",
                    listOf("Peserta OSN-K Bidang IPA tingkat SD 2016",
                        "Peserta OSN-k Bidang Fisika tingkat SMA 2022",
                        "Peserta terbaik Pelatihan TSA - Oracle Academy 2024")
                )
                Spacer(modifier = Modifier.height(30.dp))
                Button(
                    onClick = {
                        navController.navigate("home")
                    },
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                ){
                    Text(
                        text = "Kembali ke Halaman Utama"
                    )
                }
            }
        }
    )
}

@Composable
fun Field(label: String, value: String){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .padding(horizontal = 10.dp)
    ){
        Text(
            text = "$label:",
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
        )
        Text(
            text = value,
            modifier = Modifier.weight(2f),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun FieldList(label: String, values: List<String>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .padding(horizontal = 10.dp)
    ) {
        Text(
            text = "$label:",
            modifier = Modifier
                .weight(1f)
                .align(Alignment.Top),
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
        )

        Column(modifier = Modifier.weight(2f)) {
            values.forEach { item ->
                Text(
                    text = "- $item",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview
@Composable
fun DetailScreenPreview(){
    DetailScreen(navController = rememberNavController())
}