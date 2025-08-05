package top.leetech.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
    var artImage = R.drawable.pexels_valeriiamiller
    var artDesc = R.string.title_laura
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(Color.hsl(0f, 0f, 0.95f))
                .clip(RoundedCornerShape(5.dp))
                .padding(25.dp)
        ) {
            Image(
                painter = painterResource(artImage),
                contentDescription = stringResource(artDesc),
                modifier = modifier
                    .clip(
                        RoundedCornerShape(5.dp)
                    )
                    .shadow(5.dp)
            )
        }
        Spacer(modifier = modifier.height(40.dp))
        Column(modifier = modifier.background(Color.hsl(0f, 0f, 0.95f)).padding(16.dp, 12.dp)) {
            Text(
                text = stringResource(R.string.title_laura),
                modifier = modifier.padding(bottom=4.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Text(
                text = stringResource(R.string.artist_laura),
                modifier = modifier.padding(bottom=8.dp)
            )
            Text(
                text = stringResource(R.string.year_laura),
                modifier = modifier,
                fontSize = 14.sp,
                fontStyle = FontStyle.Italic
            )
        }
        Spacer(modifier = modifier.height(40.dp))
        Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            Button(onClick = {}, modifier = modifier.width(160.dp)) {
                Text(
                    text = "Previous",
                    modifier = modifier
                )
            }
            Button(onClick = {}, modifier = modifier.width(160.dp)) {
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