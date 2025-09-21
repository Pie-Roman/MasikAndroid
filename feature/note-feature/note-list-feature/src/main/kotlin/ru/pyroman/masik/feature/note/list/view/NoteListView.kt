package ru.pyroman.masik.feature.note.list.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.pyroman.masik.domain.note.common.model.Note
import ru.pyroman.masik.domain.note.list.intent.NoteListIntent
import ru.pyroman.masik.domain.note.list.model.NoteList
import ru.pyroman.masik.feature.note.list.state.NoteListState
import ru.pyroman.masik.feature.note.list.viewmodel.NoteListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteListView(
    viewModel: NoteListViewModel = viewModel(),
) {

    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.subscribeToIntents()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Что надо сделать") },
                actions = {
                    IconButton(onClick = {

                    }) {
                        Icon(Icons.Default.Add, contentDescription = "Add")
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            NoteListTabsView(
                onTabTapAction = { tag ->
                    if (tag != null) {
                        viewModel.send(NoteListIntent.LoadForTag(tag.id))
                    } else {
                        viewModel.send(NoteListIntent.Load)
                    }
                }
            ) {
                when (val s = state) {
                    is NoteListState.Idle -> NoteListIdleView {
                        viewModel.send(NoteListIntent.Launch)
                    }
                    is NoteListState.Loading -> NoteListLoadingView()
                    is NoteListState.Loaded -> NoteListLoadedView(
                        noteList = s.noteList,
                        onUpdate = { note ->

                        },
                    )

                    is NoteListState.Error -> NoteListErrorView(
                        message = s.message,
                        onRetry = { viewModel.send(NoteListIntent.Load) }
                    )
                }
            }
        }
    }
}

@Composable
private fun NoteListIdleView(
    onAppear: () -> Unit
) {
    LaunchedEffect(Unit) {
        onAppear()
    }
}

@Composable
private fun NoteListLoadingView() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
private fun NoteListLoadedView(
    noteList: NoteList,
    onUpdate: (Note) -> Unit,
) {
    if (noteList.items.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Список дел пуст", color = Color.Gray, style = MaterialTheme.typography.titleMedium)
        }
    } else {
        Row(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(top = 8.dp)
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                noteList.items.withIndex()
                    .filter { it.index % 2 == 0 }
                    .forEach { (index, note) ->
                        NoteListItemView(
                            note = note,
                            heightOffset = index % 3,
                            onUpdateTap = { onUpdate(note) },
                        )
                    }
            }
            Spacer(Modifier.width(12.dp))
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                noteList.items.withIndex()
                    .filter { it.index % 2 != 0 }
                    .forEach { (index, note) ->
                        NoteListItemView(
                            note = note,
                            heightOffset = index % 3,
                            onUpdateTap = { onUpdate(note) },
                        )
                    }
            }
        }
    }
}

@Composable
private fun NoteListErrorView(
    message: String,
    onRetry: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(Icons.Default.Warning, contentDescription = null, tint = Color.Red, modifier = Modifier.size(48.dp))
        Spacer(Modifier.height(8.dp))
        Text("Ошибка", style = MaterialTheme.typography.titleLarge)
        Text(message, color = Color.Red)
        Spacer(Modifier.height(16.dp))
        Button(onClick = onRetry) {
            Text("Попробовать снова")
        }
    }
}