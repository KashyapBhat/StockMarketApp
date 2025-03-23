package kashyap.learning.stocktrading.core.presentation

import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

// Helps UI layer not worry about the source of the text
// Later we can add more types of text sources like from a remote server
sealed interface UiText {
    data class DynamicString(val value: String): UiText
    class StringResourceId(
        val id: StringResource,
        val args: Array<Any> = arrayOf()
    ): UiText

    @Composable
    fun asString(): String {
        return when(this) {
            is DynamicString -> value
            is StringResourceId -> stringResource(resource = id, formatArgs = args)
        }
    }
}