package top.leetech.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeGestures
import androidx.compose.foundation.layout.systemGestures
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import top.leetech.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Surface {
                    ArtSpace()
                }
            }
        }
    }
}

@Composable
fun ArtSpace(modifier: Modifier = Modifier) {
    var artImage by remember { mutableIntStateOf(R.drawable.pexels_leefinvrede) }
    var artist by remember { mutableIntStateOf(R.string.artist_laura) }
    var artTitle by remember { mutableIntStateOf(R.string.title_laura) }
    var artYear by remember { mutableIntStateOf(R.string.year_laura) }
    var count by remember { mutableIntStateOf(1) }

    artImage = when (count) {
        2 -> R.drawable.pexels_leefinvrede
        3 -> R.drawable.pexels_francesco_ungaro
        4 -> R.drawable.pexels_golboo_maghooli
        5 -> R.drawable.pexels_tim_martin_klement
        else -> R.drawable.pexels_valeriiamiller // Also the first image
    }
    artTitle = when (count) {
        2 -> R.string.title_laura
        3 -> R.string.title_francesco
        4 -> R.string.title_golboo
        5 -> R.string.title_tim_martin
        else -> R.string.title_valeriia // no. 1
    }
    artist = when (count) {
        2 -> R.string.artist_laura
        3 -> R.string.artist_francesco
        4 -> R.string.artist_golboo
        5 -> R.string.artist_tim_martin
        else -> R.string.artist_valeriia // no. 1
    }
    artYear = when (count) {
        2 -> R.string.year_laura
        3 -> R.string.year_francesco
        4 -> R.string.year_golboo
        5 -> R.string.year_tim_martin
        else -> R.string.year_valeriia // no. 1
    }

    val countUpdate: (Boolean) -> Unit = {
        if (it) { // next
            if (count == 5) count = 1 else count++
        } else { // prev
            if (count == 1) count = 5 else count--
        }
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize().verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,

    ) {
        Row(
            modifier = modifier
                .fillMaxWidth().height(500.dp)
                .background(Color.hsl(0f, 0f, 0.95f))
                .clip(RoundedCornerShape(5.dp))
                .padding(25.dp), horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(artImage),
                contentDescription = stringResource(artTitle),
                modifier = modifier
                    .clip(
                        RoundedCornerShape(5.dp)
                    )
                    .shadow(5.dp)

            )
        }
        Spacer(modifier = modifier.height(40.dp))
        Column(
            modifier = modifier
                .background(Color.hsl(0f, 0f, 0.95f))
                .padding(16.dp, 12.dp)
        ) {
            Text(
                text = stringResource(artTitle),
                modifier = modifier.padding(bottom = 4.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Text(
                text = stringResource(artist),
                modifier = modifier.padding(bottom = 8.dp)
            )
            Text(
                text = stringResource(artYear),
                modifier = modifier,
                fontSize = 14.sp,
                fontStyle = FontStyle.Italic
            )
        }
        Spacer(modifier = modifier.height(40.dp))
        Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            Button(onClick = { countUpdate(false) }, modifier = modifier.width(160.dp)) {
                Text(
                    text = "Previous",
                    modifier = modifier
                )
            }
            Button(onClick = { countUpdate(true) }, modifier = modifier.width(160.dp)) {
                Text(
                    text = "Next",
                    modifier = modifier
                )
            }
        }
    }
}

@Preview(showBackground = true, apiLevel = 35)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpace(modifier = Modifier)
    }
}