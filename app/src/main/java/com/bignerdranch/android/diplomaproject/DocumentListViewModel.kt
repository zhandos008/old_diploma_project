package com.bignerdranch.android.diplomaproject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DocumentListViewModel: ViewModel() {
    private val documentRepository = DocumentRepository.get()

    private val _document: MutableStateFlow<Document?> = MutableStateFlow(null)
    val document: StateFlow<Document?> = _document.asStateFlow()

    private val _documents: MutableStateFlow<List<Document>> = MutableStateFlow(emptyList())
    val documents: StateFlow<List<Document>>
        get() = _documents.asStateFlow()

    init {
        viewModelScope.launch {
            documentRepository.getDocuments().collect() {
                _documents.value = it
            }
        }
    }


}