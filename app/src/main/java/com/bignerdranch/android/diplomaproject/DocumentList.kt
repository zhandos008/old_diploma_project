package com.bignerdranch.android.diplomaproject


import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController

import androidx.recyclerview.widget.LinearLayoutManager
import com.bignerdranch.android.diplomaproject.databinding.FragmentDocumentListBinding


import kotlinx.coroutines.launch
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat

import java.util.*

class DocumentList : Fragment() {

    private val documentListViewModel: DocumentListViewModel by viewModels()

    private var _binding: FragmentDocumentListBinding? = null

    private val binding: FragmentDocumentListBinding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }

    private var photoName: String? = null

    private lateinit var outputDirectory: File




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDocumentListBinding.inflate(layoutInflater, container, false)

        binding.listRecyclerView.layoutManager = LinearLayoutManager(context)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                documentListViewModel.documents.collect{
                    binding.listRecyclerView.adapter = DocumentsAdapter(it)
                 }
            }
        }

        binding.takePhotoFor.setOnClickListener {
            dispatchTakePictureIntent()
        }

    }

    private val takePicture = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {

            val photoFile = File(outputDirectory, "${System.currentTimeMillis()}.jpg")
            val action = DocumentListDirections.takePhotoCamera(photoFile.absolutePath)
            findNavController().navigate(action)
        }
    }



    private fun dispatchTakePictureIntent() {
        val photoFile: File? = try {
            createImageFile()
        } catch (ex: IOException) {

            null
        }
        photoFile?.also {
            val photoUri: Uri = FileProvider.getUriForFile(
                requireContext(),
                "com.binderdranch.android.diplomaproject.fileprovider",
                it
            )
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply {
                putExtra(MediaStore.EXTRA_OUTPUT, photoUri)
            }
            takePicture.launch(intent)
        }
    }


    @Throws(IOException::class)
    private fun createImageFile(): File {

        outputDirectory = requireContext().getFilesDir()
        if (!outputDirectory.exists()) {
            outputDirectory.mkdirs()
        }
        return File.createTempFile(
            "JPEG_${System.currentTimeMillis()}_",
            ".jpg",
            outputDirectory
        )
    }





}
