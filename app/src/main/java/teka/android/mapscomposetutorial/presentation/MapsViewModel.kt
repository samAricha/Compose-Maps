package teka.android.mapscomposetutorial.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.model.MapStyleOptions

class MapsViewModel: ViewModel() {
    var state by mutableStateOf(MapState())

    fun onEvent(event: MapEvent){
        when(event){
            is MapEvent.ToggleFalloutMap -> {
                //basically toggling the state of falloutMap between true and false
                state = state.copy(
                    properties = state.properties.copy(
                        mapStyleOptions = if(state.isFalloutMap){
                                                null
                                            }else MapStyleOptions(MapStyle.json)

                    ),
                    isFalloutMap = !state.isFalloutMap
                )
            }
        }

    }
}