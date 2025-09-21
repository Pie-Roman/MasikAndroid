package ru.pyroman.masik.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.pyroman.masik.activity.di.MainActivityComponent
import ru.pyroman.masik.feature.tabs.view.TabsView
import ru.pyroman.masik.activity.ui.theme.MasikTheme
import ru.pyroman.masik.application.MasikApplication

class MainActivity : ComponentActivity() {

    private lateinit var activityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        activityComponent = (applicationContext as MasikApplication)
            .appComponent
            .mainActivityComponentFactory()
            .create()
        activityComponent.inject(this)

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            MasikTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ContentView(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ContentView(modifier: Modifier = Modifier) {
    TabsView(modifier)
}

@Preview(showBackground = true)
@Composable
fun ContentViewPreview() {
    MasikTheme {
        ContentView()
    }
}