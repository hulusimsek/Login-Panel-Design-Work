package com.hulusimsek.a2_loginuygulama

import android.os.Bundle
import android.util.Log
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hulusimsek.a2_loginuygulama.ui.theme._2_LoginUygulamaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _2_LoginUygulamaTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) { innerPadding ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding), // Scaffold içeriğini korur
                        color = MaterialTheme.colorScheme.primary // Surface arka plan rengini ayarlama
                    ) {
                        Sayfa()
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Sayfa() {
    val tfKullaniciAdi = remember { mutableStateOf("") }
    val tfSifre = remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.primary // Surface arka plan rengini ayarlama
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.drawable.logo), contentDescription = "")
            TextField(
                value = tfKullaniciAdi.value,
                onValueChange = { tfKullaniciAdi.value = it },
                label = { Text(text = "Kullanıcı Adı") },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedTextColor = Color.Black, // Metin rengi
                    unfocusedTextColor = Color.Black,
                    focusedIndicatorColor = Color.Blue, // Odaklanmış durumdaki alt çizgi rengi
                    unfocusedIndicatorColor = Color.Gray, // Odaklanmamış durumdaki alt çizgi rengi
                    cursorColor = Color.Red // İmleç rengi
                )
            )
            TextField(
                value = tfSifre.value,
                onValueChange = { tfSifre.value = it },
                label = { Text(text = "Şifre") },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedTextColor = Color.Black, // Metin rengi
                    unfocusedTextColor = Color.Black,
                    focusedIndicatorColor = Color.Blue, // Odaklanmış durumdaki alt çizgi rengi
                    unfocusedIndicatorColor = Color.Gray, // Odaklanmamış durumdaki alt çizgi rengi
                    cursorColor = Color.Red // İmleç rengi
                )
            )
            Button(
                onClick = {
                    Log.e("Button", "Giriş Yapıldı")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,
                    contentColor = Color.White
                ),
                modifier = Modifier.size(250.dp,50.dp)
            ) {
                Text(text = "Giriş Yap")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _2_LoginUygulamaTheme {
        Sayfa()
    }
}