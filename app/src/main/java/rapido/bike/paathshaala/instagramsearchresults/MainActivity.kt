package rapido.bike.paathshaala.instagramsearchresults

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import rapido.bike.paathshaala.instagramsearchresults.ui.theme.InstagramSearchResultsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstagramSearchResultsTheme {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp(itemCount: Int = 7){
    Column{
        for(i in 1..itemCount){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp, horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceAround,
            ) {
                StoryImage(imageUrl = "https://assets.vogue.in/photos/5ce42add89be365f3c7cfef8/2:3/w_2560%2Cc_limit/Virat-Kohli-Brand-Ambassador-Tissot-India-at-the-launch-of-the-TISSOT-CHRONO-XL-CLASSIC-VIRAT-KOHLI-2018-special-edition_3.jpg")
                NameCard()
            }
//            Divider()

        }

    }
}

@Composable
fun NameCard() {
    Box( modifier = Modifier.padding(15.dp)){
        Column {
            Text("virat.kohli", fontSize = 20.sp, fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth())
            Text("Virat Kohli", fontSize = 20.sp,
                modifier = Modifier.fillMaxWidth().alpha(0.5f))
        }
    }    
}

@Composable
fun StoryImage(imageUrl: String) {
    val shape = CircleShape
    Box(
        modifier = Modifier.diagonalGradientBorder(
                colors = listOf(
                    Color(0xFFd71069),
                    Color(0xFFe25d6a),
                    Color(0xFFe9ad55),
                ),
                shape = shape,
            )
    ) {
        Box(
            modifier = Modifier
                .size(90.dp)
                .padding(6.dp)
                .background(color = Color.LightGray, shape = shape)
                .clip(shape)
        ) {
//            Image(
//                painter = rememberAsyncImagePainter(imageUrl),
//                contentDescription = null,
//                modifier = Modifier
//                    .wrapContentSize()
//                    .wrapContentHeight()
//                    .wrapContentWidth()
//            )
            Text("Hello")
        }
    }
}

@SuppressLint("UnnecessaryComposedModifier")
fun Modifier.diagonalGradientBorder(
    colors: List<Color>,
    borderSize: Dp = 3.dp,
    shape: Shape,
    isFromRight: Boolean = false
) = composed {
    val (start, end) = if (isFromRight) {
        Pair(
            Offset(100f, 0.0f),
            Offset(0.0f, 100.0f)
        )
    } else {
        Pair(Offset.Zero, Offset.Infinite)
    }
    border(
        width = borderSize,
        brush = Brush.linearGradient(colors = colors, start = start, end = end),
        shape = shape
    )
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    InstagramSearchResultsTheme {
        Surface(
            color = MaterialTheme.colors.background
        ) {
            MyApp()
        }
    }
}
