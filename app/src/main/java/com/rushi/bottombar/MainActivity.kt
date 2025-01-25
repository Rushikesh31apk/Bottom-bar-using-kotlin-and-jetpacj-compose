package com.rushi.bottombar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rushi.bottombar.ui.theme.BottomBarTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			BottomBarTheme {
				Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
					// 1. Managing Selected Item State
					LabelSelectorBar(
						labelItems = listOf(
							"All", "Pop", "Rock", "Jazz", "Hip Hop", "Classical"
						),
						barHeight = 80.dp,
						horizontalPadding = 12.dp,
						distanceBetweenItems = 8.dp,
						backgroundColor = Color(0xFFB2F0AD),
						selectedBackgroundColor = Color(0xFF294D16),
						textColor = Color(0xFF333333),
						selectedTextColor = Color(0xFFD8D1D1),
						roundedCornerShapeSize = 24.dp,
						labelVerticalPadding = 14.dp,
						labelHorizontalPadding = 18.dp,
					)

				}
			}
		}
	}
}
@Composable
fun app(){
	val selectedBottomBarItem =
		remember {
			mutableStateOf(
				BottomBarItemData(
					1,
					"Home",
					R.drawable.ic_home
				)
			)
		}
	Box(modifier = Modifier.fillMaxSize()) {
		Text(
			text = "Selected: ${selectedBottomBarItem.value.title}",
			modifier = Modifier.align(Alignment.Center),
			fontSize = 20.sp
		)
		BottomBar(
			selectedBottomBarItem = selectedBottomBarItem,
			bottomBarItems = listOf(
				BottomBarItemData(1, "Home", R.drawable.ic_home),
				BottomBarItemData(2, "Search", R.drawable.ic_search),
				BottomBarItemData(3, "Library", R.drawable.ic_music_library),
				BottomBarItemData(4, "Settings", R.drawable.ic_settings)
			),
			primaryColor = Color(0xFF3F51B5),
			secondaryColor = Color(0xFFC4CBF5),
			// 2. Bottom Bar Layout and Alignment
			modifier = Modifier
				.align(Alignment.BottomStart)
				.fillMaxWidth()
		)
	}
}