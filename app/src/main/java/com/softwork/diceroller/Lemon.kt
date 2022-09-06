package com.softwork.diceroller

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.softwork.diceroller.ui.theme.DiceRollerTheme

@Composable
fun Lemon () {
    var displayPage by remember { mutableStateOf(1)}
    var clickTimes by remember { mutableStateOf(0)}
    
    when (displayPage) {
        1 -> {Page(textId = R.string.tree, imageId = R.drawable.lemon_tree,
        contentDescriptionId = R.string.tree_image, onImageClick = {displayPage = 2;
                clickTimes = (2..4).random()})}
        
        2 -> {Page(textId = R.string.squeeze, imageId = R.drawable.lemon_squeeze,
            contentDescriptionId = R.string.lemon, onImageClick =
                {
                    clickTimes --
                    if (clickTimes == 0) displayPage = 3
                })}
        
        3 -> {Page(textId = R.string.drink, imageId = R.drawable.lemon_drink,
        contentDescriptionId = R.string.lemonade, onImageClick =
            {displayPage = 4})}
        
        else -> {Page(textId = R.string.remake, imageId = R.drawable.lemon_restart,
            contentDescriptionId = R.string.empty_glass, onImageClick =
            {displayPage = 1})}
    }
}

@Composable
fun Page(textId: Int, imageId: Int, onImageClick: () -> Unit,
modifier: Modifier = Modifier, contentDescriptionId: Int) {
    Column(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)) {
        Text(text = stringResource(id = textId), modifier = Modifier.background(Color.Green))

        Spacer(modifier = Modifier.height(16.dp))

        Image(painter = painterResource(id = imageId),
            contentDescription = stringResource(contentDescriptionId), modifier = Modifier
                .clickable(onClick = onImageClick)
                .border(BorderStroke(2.dp, Color(105, 205, 216)))
                .padding(16.dp))
    }
}

@Composable
@Preview(
    showSystemUi = true,
    showBackground = true
)
fun LemonPreview() {
    DiceRollerTheme() {
        Lemon()
    }
}