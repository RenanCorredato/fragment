package com.renancorredato.fragment.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.core.os.bundleOf
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.fragment.app.setFragmentResult
import com.renancorredato.fragment.R
import com.renancorredato.fragment.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        setupMenu()

        binding.btnSubmit.setOnClickListener {

            val name = binding.edtName.text.toString()
            val age = binding.edtAge.text.toString()

            submitInfoToFragment(name, age)
        }
    }

    private fun setupMenu() {

        val activity = requireActivity()
        activity.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_register, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
//                Log.i("Renan",menuItem.title.toString())
                when (menuItem.itemId) {


                    R.id.action_salve -> {
//                        save()
                        Log.i("Renan", menuItem.title.toString())
                        Log.i("Renan","salvar")
                    }

//                    R.id.action_setting -> {
//                        menuItem.isCheckable = !menuItem.isCheckable
//                        Log.i("Renan",menuItem.title.toString())
//                    }
                }

                return true
            }

        })
    }


    private fun submitInfoToFragment(name: String, age: String) {
//        val bundle = bundleOf(
//            "USER_NAME" to name,
//            "USER_AGE" to age
//        )

        val bundle = bundleOf(
            "USER" to User(
                name,
                age
            )

        )

        setFragmentResult("REGISTER_RESULT", bundle)
        parentFragmentManager.popBackStack()

//        parentFragmentManager.commit {
//            setReorderingAllowed(true)
//            replace<ResultFragment>(R.id.fragmentContainerView, args = bundle)
//            addToBackStack(null)
//        }



    }

}