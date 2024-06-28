package com.eritlab.jexmon.presentation.screens.favourite_screen.component

import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.navigation.NavController
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.eritlab.jexmon.R
import com.eritlab.jexmon.presentation.common.CustomDefaultBtn
import com.eritlab.jexmon.presentation.common.CustomTextField
import com.eritlab.jexmon.presentation.common.CustomTextField2
import com.eritlab.jexmon.presentation.common.component.ErrorSuggestion
import com.eritlab.jexmon.presentation.graphs.auth_graph.AuthScreen
import com.eritlab.jexmon.presentation.ui.theme.PrimaryColor

@Composable
fun FavouriteScreen(navController: NavController) {
    var productName by remember { mutableStateOf("") }
    var produk by remember { mutableStateOf(TextFieldValue("")) }
    var harga by remember { mutableStateOf(TextFieldValue("")) }
    var deskripsi by remember { mutableStateOf(TextFieldValue("")) }
    var productDescription by remember { mutableStateOf("") }
    var quantity by remember { mutableStateOf(1) }
    val produkErrorState = remember { mutableStateOf(false) }
    val hargaErrorState = remember { mutableStateOf(false) }
    val deskripsiErrorState = remember { mutableStateOf(false) }
    val animate = remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Add New Item", style = MaterialTheme.typography.h5)

        // Image picker placeholder
        Button(
            onClick = { /* TODO: Implement image picker logic */ },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.PrimaryColor,
                contentColor = Color.White
            )) {
            Text("Insert Image")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Product Name
        CustomTextField2(
            placeholder = "Masukkan nama produk",
            label = "Nama produk",
            errorState = produkErrorState,
            keyboardType = KeyboardType.Text,
            visualTransformation = VisualTransformation.None,
            onChanged = { newProduk ->
                produk = newProduk
            }
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Product Price
        CustomTextField2(
            placeholder = "Masukkan harga produk",
            label = "Harga produk",
            errorState = hargaErrorState,
            keyboardType = KeyboardType.Number,
            visualTransformation = VisualTransformation.None,
            onChanged = { newHarga ->
                harga = newHarga
            }
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Product Description
        CustomTextField2(
            placeholder = "Masukkan deskripsi produk",
            label = "Deskripsi",
            errorState = deskripsiErrorState,
            keyboardType = KeyboardType.Number,
            visualTransformation = VisualTransformation.None,
            onChanged = { newDeskripsi ->
                deskripsi = newDeskripsi
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Quantity Selector
        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(
                onClick = { if (quantity > 0) quantity-- },
                enabled = quantity > 0
            ) {
                Text("-")
            }

            Text(
                text = quantity.toString(),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.h6
            )

            Button(onClick = { quantity++ }) {
                Text("+")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (hargaErrorState.value) {
            ErrorSuggestion("Masukkan harga produk")
        }
        if (produkErrorState.value) {
            ErrorSuggestion("Masukkan nama produk")
        }
        if (deskripsiErrorState.value) {
            ErrorSuggestion("Masukkan deskripsi produk")
        }

        CustomDefaultBtn(shapeSize = 50f, btnText = "Tambah Produk") {
            //email pattern
            val pattern = Patterns.EMAIL_ADDRESS
            val isProdukValid = produk.text.isEmpty()
            val isHargaValid = harga.text.isEmpty()
            val isDeskripsiValid = harga.text.isEmpty()
            hargaErrorState.value = !isHargaValid
            produkErrorState.value = !isProdukValid
            deskripsiErrorState.value = !isDeskripsiValid
            if (!isProdukValid && !isDeskripsiValid && !isHargaValid) {
                navController.navigate(AuthScreen.SignInSuccess.route)
                animate.value = !animate.value
            }
        }
    }
}


