package com.rushi.bottombar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LabelUi(
	text: String = "",
	selected: Boolean = false,
	// 1. Layout Customization Parameters
	labelTextStyle: TextStyle = TextStyle(
		fontWeight = FontWeight.SemiBold,
		fontSize = 16.sp
	),
	backgroundColor: Color = Color.White,
	selectedBackgroundColor: Color = Color.Black,
	textColor: Color = Color.Black,
	selectedTextColor: Color = Color.White,
	roundedCornerShapeSize: Dp = 8.dp,
	horizontalPadding: Dp = 16.dp,
	verticalPadding: Dp = 8.dp,
	onClick: () -> Unit = {},
) {
	// 2. Interaction Feedback Removal
	val interactionSource = remember { MutableInteractionSource() }
	Box(
		contentAlignment = Alignment.Center,
		modifier = Modifier
			.clickable(
				interactionSource = interactionSource,
				indication = null,
				onClick = onClick
			)
			.background(
				// 3. Label Color Depending the selected Value
				if (selected) selectedBackgroundColor else backgroundColor,
				RoundedCornerShape(roundedCornerShapeSize)
			)
			.padding(horizontal = horizontalPadding, vertical = verticalPadding)
	) {
		Text(
			text = text,
			// 4. Text Color Depending the selected Value
			color = if (selected) selectedTextColor else textColor,
			style = labelTextStyle
		)
	}
}

@Preview
@Composable
fun LabelUiPreview() {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(Color.White),
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center
	) {
		LabelUi(text = "Label1", selected = true)
		LabelUi(text = "Label2", selected = false, textColor = Color.Blue)
	}
}