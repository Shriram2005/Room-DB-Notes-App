package com.shriram.roomdbpractice.data

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {
    private val noteDao = NoteDatabase.getDatabase(application).noteDao()
    private val _sortOrder = MutableStateFlow(SortOrder.DATE)
    val isSearchVisible = mutableStateOf(false)
    
    val allNotes: StateFlow<List<Note>> = combine(
        noteDao.getAllNotes(),
        _sortOrder
    ) { notes, sortOrder ->
        when (sortOrder) {
            SortOrder.TITLE -> notes.sortedBy { it.title }
            SortOrder.DATE -> notes
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    fun addNote(title: String, content: String) {
        viewModelScope.launch {
            noteDao.insertNote(Note(title = title, content = content))
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            noteDao.deleteNote(note)
        }
    }

    fun toggleSearchBar() {
        isSearchVisible.value = !isSearchVisible.value
    }

    fun sortByTitle() {
        _sortOrder.value = SortOrder.TITLE
    }

    fun sortByDate() {
        _sortOrder.value = SortOrder.DATE
    }
}

enum class SortOrder {
    TITLE,
    DATE
}
