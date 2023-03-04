package com.bignerdranch.android.diplomaproject

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bignerdranch.android.diplomaproject.databinding.FragmentCreateDocumentBinding
import com.bignerdranch.android.diplomaproject.databinding.FragmentDocumentListBinding

class CreateDocument: Fragment() {
    private lateinit var binding: FragmentCreateDocumentBinding

    private val args: CreateDocumentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateDocumentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imageView.setImageBitmap(BitmapFactory.decodeFile(args.photo))


    }
}