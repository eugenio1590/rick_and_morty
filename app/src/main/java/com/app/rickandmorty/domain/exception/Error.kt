package com.app.rickandmorty.domain.exception

/**
 * Represents a hierarchy of custom exceptions for handling various error scenarios.
 *
 * This sealed class provides a structured way to handle errors in the application.
 *
 * @param message  Optional message of the error.
 */
sealed class Error(override val message: String? = null) : Exception() {

    /**
     * Represents errors related to network operations.
     */
    sealed class NetworkError : Error() {

        /**
         * Indicates that there is no internet connection.
         */
        data object NoInternetConnection : NetworkError()

        /**
         * Indicates that the requested resource was not found.
         */
        data object NotFoundError : NetworkError()

        /**
         * Indicates that the service is temporarily unavailable.
         */
        data object ServiceUnavailable : NetworkError()
    }

    /**
     * Represents an unknown error scenario.
     *
     * @param message Optional message of the error.
     */
    class UnknownError(message: String) : Error(message)
}
