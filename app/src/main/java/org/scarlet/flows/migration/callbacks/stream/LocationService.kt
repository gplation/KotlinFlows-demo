package org.scarlet.flows.migration.callbacks.stream

import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import org.scarlet.util.log

interface LocationCallback {
    fun onLocation(location: Location)
    fun onFailure(ex: Throwable)
}

data class Location(val x: Double, val y: Double)

data class LocationRequest(
    val location: String,
    val timeMs: Long
)

interface LocationService {
    @Deprecated(
        "Obsolete API - use requestLocationFlow instead",
        replaceWith = ReplaceWith("requestLocationFlow(location, timeMs)")
    )
    fun requestLocationUpdates(request: LocationRequest, callback: LocationCallback)
    fun removeLocationUpdates(callback: LocationCallback)
}


fun LocationService.requestLocationUpdatesFlow(request: LocationRequest): Flow<Location?> = TODO()

