package teka.android.mapscomposetutorial.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ToggleOff
import androidx.compose.material.icons.filled.ToggleOn
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MapScreen( viewModel: MapsViewModel = viewModel() ){
    val scaffoldState = rememberScaffoldState()
    val uiSettings = remember{
        MapUiSettings(zoomControlsEnabled = false)
    }


    Scaffold(
        scaffoldState = scaffoldState,
        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModel.onEvent(MapEvent.ToggleFalloutMap)
            }){

                Icon(
                    imageVector = if (viewModel.state.isFalloutMap) {
                        Icons.Default.ToggleOff
                    } else Icons.Default.ToggleOn,
                    contentDescription = "Toggle Fallout map"
                )

            }
        }
    ){
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            properties = viewModel.state.properties,
            uiSettings = uiSettings,
            onMapLongClick = {

            }
        )

    }
}