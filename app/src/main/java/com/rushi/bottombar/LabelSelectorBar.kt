package com.rushi.bottombar

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
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
fun LabelSelectorBar(
	labelItems: List<String> = listOf(),
	// 1. LabelSelectorBar Customization Parameters
	barHeight: Dp =  56.dp,
	horizontalPadding: Dp = 8.dp,
	distanceBetweenItems: Dp = 0.dp,
	// 2. LabelUi Customization Parameters
	labelTextStyle: TextStyle = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 16.sp),
	backgroundColor: Color = Color.White,
	selectedBackgroundColor: Color = Color.Black,
	textColor: Color = Color.Black,
	selectedTextColor: Color = Color.White,
	roundedCornerShapeSize: Dp = 8.dp,
	labelHorizontalPadding: Dp = 16.dp,
	labelVerticalPadding: Dp = 8.dp,
) {
	// 3. Stateful Selection Management:
	val selectedLabel = rememberSaveable { mutableStateOf(labelItems.firstOrNull() ?: "") }
	LazyRow(
		verticalAlignment = Alignment.CenterVertically,
		modifier = Modifier.height(barHeight)
	) {
		item { Spacer(modifier = Modifier.width(horizontalPadding)) }
		// 4. Interactive Label Identification
		items(labelItems) { label ->
			LabelUi(
				text = label,
				selected = label == selectedLabel.value,
				labelTextStyle = labelTextStyle,
				backgroundColor = backgroundColor,
				selectedBackgroundColor = selectedBackgroundColor,
				textColor = textColor,
				selectedTextColor = selectedTextColor,
				roundedCornerShapeSize = roundedCornerShapeSize,
				horizontalPadding = labelHorizontalPadding,
				verticalPadding = labelVerticalPadding
			) {
				selectedLabel.value = label
			}
			Spacer(modifier = Modifier.width(distanceBetweenItems))
		}
		item { Spacer(modifier = Modifier.width(horizontalPadding)) }
	}
}



@Preview
@Composable
fun LabelSelectorBarPreview() {
	LabelSelectorBar(labelItems = listOf("All", "Pop", "Rock", "Jazz", "Hip Hop", "Classical"))
}