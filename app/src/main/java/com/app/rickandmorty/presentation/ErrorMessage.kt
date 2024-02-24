package com.app.rickandmorty.presentation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.app.rickandmorty.R

sealed class ErrorMessage(@StringRes val message: Int, @DrawableRes val image: Int) {

    sealed class NetworkMessage(message: Int, image: Int) : ErrorMessage(message, image) {
        data object NoInternetMessage : NetworkMessage(
            message = R.string.no_internet_error_message,
            image = R.drawable.portal
        )

        data object NotFoundMessage : NetworkMessage(
            message = R.string.no_found_error_message,
            image = R.drawable.rupture
        )

        data object ServiceUnavailableMessage : NetworkMessage(
            message = R.string.service_unavailable_error_message,
            image = R.drawable.paper_box
        )
    }

    data object UnknownMessage : ErrorMessage(
        message = R.string.unknown_error_message,
        image = R.drawable.substance
    )
}