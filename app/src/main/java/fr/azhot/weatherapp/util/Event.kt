package fr.azhot.weatherapp.util

/**
 * Used as a wrapper for data that is exposed via a LiveData that represents an event.
 */
class Event<T>(private val content: T) {

    var hasBeenHandled = false
        private set // Allow external read but not write

    companion object {

        // we don't want an event if there's no data
        fun <T> dataEvent(data: T?): Event<T>? {
            data?.let {
                return Event(it)
            }
            return null
        }

        // we don't want an event if there is no message
        fun messageEvent(message: String?): Event<String>? {
            message?.let {
                return Event(message)
            }
            return null
        }
    }

    override fun toString(): String {
        return "Event(content=$content,hasBeenHandled=$hasBeenHandled)"
    }

    /**
     * Returns the content and prevents its use again.
     */
    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

    /**
     * Returns the content, even if it's already been handled.
     */
    fun peekContent(): T = content
}