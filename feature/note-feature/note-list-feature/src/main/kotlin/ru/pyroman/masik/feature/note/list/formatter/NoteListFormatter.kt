package ru.pyroman.masik.feature.note.list.formatter

import androidx.compose.ui.graphics.Color
import androidx.core.graphics.toColorInt
import ru.pyroman.masik.domain.note.common.model.Note
import ru.pyroman.masik.domain.note.list.model.NoteList
import ru.pyroman.masik.feature.note.list.vo.NoteListItemVo
import ru.pyroman.masik.feature.note.list.vo.NoteListVo
import javax.inject.Inject

internal class NoteListFormatter @Inject constructor() {

    fun format(noteList: NoteList): NoteListVo {
        val tags = noteList.tags
        val leftColumn = noteList.items.withIndex()
            .filter { it.index % 2 == 0 }
            .map { format(it.index, it.value) }
        val rightColumn = noteList.items.withIndex()
            .filter { it.index % 2 != 0 }
            .map { format(it.index, it.value) }

        return NoteListVo(
            tags = tags,
            leftColumn = leftColumn,
            rightColumn = rightColumn,
        )
    }

    private fun format(
        index: Int,
        note: Note,
    ): NoteListItemVo {
        val id = note.id
        val body = note.body
        val heightOffset = index % 3
        val backgroundColor = formatBackgroundColor(note)

        return NoteListItemVo(
            id = id,
            body = body,
            heightOffset = heightOffset,
            backgroundColor = backgroundColor,
        )
    }

    private fun formatBackgroundColor(note: Note): Color {
        val firstTag = note.body.tags.firstOrNull()
        firstTag?.color?.let { hex ->
            return try {
                Color(hex.toColorInt())
            } catch (_: IllegalArgumentException) {
                Color.LightGray
            }
        }

        val colors = listOf(
            Color(0xFFEEE6FF),
            Color(0xFFFFEDF2),
            Color(0xFFFFF7E6),
            Color(0xFFE6FFF2),
            Color(0xFFFFFAE6),
            Color(0xFFD9F2FF)
        )
        return colors.random()
    }
}