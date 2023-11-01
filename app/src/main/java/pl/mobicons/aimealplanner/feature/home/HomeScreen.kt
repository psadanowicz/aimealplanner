package pl.mobicons.aimealplanner.feature.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import pl.mobicons.aimealplanner.ui.theme.MainTheme

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    val viewState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            when (viewState) {
                is HomeUiState.Loading -> HomeLoadingContent()
                is HomeUiState.Success -> HomeSuccessContent()
            }
        }
    }
}

@Composable
fun BoxScope.HomeLoadingContent() {
    CircularProgressIndicator(
        Modifier.align(Alignment.Center)
    )
}

@Composable
fun HomeSuccessContent() {
    Text(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentHeight(),
        text = "Success",
        textAlign = TextAlign.Center
    )
}

@Composable
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun HomeScreenPreview() {
    MainTheme {
        Surface {
            HomeScreen()
        }
    }
}