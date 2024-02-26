package com.app.rickandmorty.presentation

import com.app.rickandmorty.domain.exception.Error
import com.app.rickandmorty.presentation.ErrorMessage.NetworkMessage

/**
 * Converts exceptions into a standardized [ErrorMessage] model.
 *
 * This class provides a centralized way to convert various exceptions into a common
 * [ErrorMessage] model for consistent error handling and reporting.
 */
open class ErrorConverter {

    /**
     * Converts the given exception into an [ErrorMessage] model.
     *
     * @param error The exception to be converted.
     * @return An instance of [ErrorMessage] representing the converted error information.
     */
    open fun convert(error: Exception): ErrorMessage = when (error) {
        Error.NetworkError.NoInternetConnection -> NetworkMessage.NoInternetMessage
        Error.NetworkError.NotFoundError -> NetworkMessage.NotFoundMessage
        Error.NetworkError.ServiceUnavailable -> NetworkMessage.ServiceUnavailableMessage
        else -> ErrorMessage.UnknownMessage
    }
}
