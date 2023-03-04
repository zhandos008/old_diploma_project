package com.bignerdranch.android.diplomaproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.diplomaproject.databinding.ActivityMainPageBinding
import com.bignerdranch.android.diplomaproject.databinding.ListItemDocumentBinding

class DocumentsAdapter(
    private val documents: List<Document>
): RecyclerView.Adapter<DocumentsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DocumentsHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemDocumentBinding.inflate(inflater, parent, false)
        return DocumentsHolder(binding)
    }

    override fun getItemCount(): Int = documents.size

    override fun onBindViewHolder(holder: DocumentsHolder, position: Int) {
        val document = documents[position]
        holder.bind(document)
    }
}


class DocumentsHolder(
    private val binding: ListItemDocumentBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bind(document: Document) {
        binding.itemName.text = document.name
    }
}