package com.example.fragments_dz

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment


class MainFragment : Fragment(R.layout.main_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val etFirstName: EditText = view.findViewById(R.id.TextInputEditTextFirstName)
        val etSecondName: EditText = view.findViewById(R.id.textInputEditTextSecondName)
        val etEmail: EditText = view.findViewById(R.id.textInputEditTextEmail)
        val btnGoToSecondScreen: Button = view.findViewById(R.id.btnGoToSecondFragment)

        btnGoToSecondScreen.setOnClickListener {
            val secondFragment = SecondFragment.newInstance(
                firstName = etFirstName.text.toString(),
                secondName = etSecondName.text.toString(),
                email = etEmail.text.toString()
            )
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, secondFragment)
                .addToBackStack("main_to_second").commit()

        }
    }
}