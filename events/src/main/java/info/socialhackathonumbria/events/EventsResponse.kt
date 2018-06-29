package info.socialhackathonumbria.events

import com.squareup.moshi.Json

/**
 * This class is part of Codelab project.
 * Created by riccardopizzoni on 29/06/18.
 * Copyright © 2018 INDAPP
 * info@indapp.it
 */
data class EventsResponse(
        val tipo: String,
        val lingua: String,
        val contenuto: List<Event>
)

data class Event(
        val titolo: String,
        @Json(name = "immagine-copertina") val immagine: String,
        @Json(name = "titolo-testo") val descrizione: String
)