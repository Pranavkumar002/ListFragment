package com.pranavkumar.listfragment

import android.R
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Adapter
import android.widget.ArrayAdapter
import androidx.core.content.ContentProviderCompat.requireContext
import com.pranavkumar.listfragment.databinding.FragmentArrayListBinding
import com.pranavkumar.listfragment.databinding.NewAddLayoutBinding
import com.pranavkumar.listfragment.databinding.UpdateLayoutBinding
import java.lang.reflect.Array

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Arraylist.newInstance] factory method to
 * create an instance of this fragment.
 */
class Arraylist : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var arrayList: ArrayList<String> = ArrayList()
    lateinit var binding: FragmentArrayListBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentArrayListBinding.inflate(layoutInflater)
        var adapter = ArrayAdapter(requireContext(), R.layout.simple_list_item_1, arrayList)
        var dialog = Dialog(requireContext())
        arrayList.add("Pranav")
        arrayList.add("Subal")
        arrayList.add("Ayush")
        binding.list.adapter = adapter

        binding.fabAdd.setOnClickListener {
            var dialogBinding = NewAddLayoutBinding.inflate(layoutInflater)
            var dialog = Dialog(requireContext())
            dialog.setContentView(dialogBinding.root)
            dialog.window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)

            dialogBinding.btnAddItem.setOnClickListener {
                if (dialogBinding.etAmount.text.toString().isNullOrEmpty()) {
                    dialogBinding.etAmount.setError("Enter New Item")
                } else {
                    arrayList.add(dialogBinding.etAmount.text.toString())
                    dialog.dismiss()
                }

            }
            dialog.show()
        }




    binding.list.setOnItemClickListener { adapterView, view, i, l ->
        var dialogBinding = UpdateLayoutBinding.inflate(layoutInflater)
        var dialog = Dialog(requireContext())
        dialog.setContentView(dialogBinding.root)
        dialog.window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dialogBinding.etUpdate.setText(arrayList[i])
        dialogBinding.btnUpdateItem.setOnClickListener {
            if (dialogBinding.etUpdate.text.toString().isNullOrEmpty()) {
                dialogBinding.etUpdate.setError("Enter Update Item")
            } else {
                arrayList.set(i, dialogBinding.etUpdate.text.toString())
                dialog.dismiss()
            }
        }
        dialog.show()
    }

    return binding.root
}



companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Arraylist.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Arraylist().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}

