package com.eritlab.jexmon.presentation.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eritlab.jexmon.presentation.ui.theme.PrimaryColor

@Composable
fun CustomDefaultBtn(
    shapeSize: Float,
    btnText: String,
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 10.dp)
            .height(55.dp)
            .clip(RoundedCornerShape(shapeSize.dp)),
        onClick = {
            onClick()
        },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.PrimaryColor,
            contentColor = Color.White
        ),
    ) {
        Text(text = btnText, fontSize = 16.sp)
    }
}

@Composable
fun CustomDefaultBtn2(
    btnText: String,
    shapeSize: Float,
    backgroundColor: Color = MaterialTheme.colors.PrimaryColor,
    onClick: () -> Unit)
{
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 10.dp)
            .height(55.dp)
            .clip(RoundedCornerShape(shapeSize.dp)),
        onClick = onClick,
        shape = RoundedCornerShape(shapeSize.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
            contentColor = Color.White
        )
    ) {
        Text(text = btnText, fontSize = 16.sp)
    }
}