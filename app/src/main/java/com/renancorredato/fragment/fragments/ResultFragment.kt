package com.renancorredato.fragment.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.core.content.ContextCompat
import androidx.core.view.MenuProvider
import androidx.fragment.app.*
import androidx.lifecycle.Lifecycle
import com.renancorredato.fragment.R
import com.renancorredato.fragment.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding
    private lateinit var user: User
//    private lateinit var name: String
//    private lateinit var age: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // val arguments = requireArguments()

//        this.user = arguments.getSerializable("USER") as User
//        this.age = arguments.getString("USER_AGE","0")

//        this.name = arguments.getString("USER_NAME","")
//        this.age = arguments.getString("USER_AGE","0")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        setupMenu()
        setupMenuToolbar()
        setFragmentResultListener("REGISTER_RESULT") { _, bundle ->
            val user = bundle.getSerializable("USER") as User
            binding.textView2.text = "Nome: ${user.name} - Idade: ${user.age}"
        }

//        binding.textView2.text = "Nome: ${user.name} - Idade: ${user.age}"
        binding.btnRegister.setOnClickListener {

            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace<RegisterFragment>(R.id.fragmentContainerView)
                addToBackStack(null)
            }

        }


    }

    fun setupMenu() {

        val activity = requireActivity()
        activity.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_home, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
//                Log.i("Renan",menuItem.title.toString())
                when (menuItem.itemId) {


//                    R.id.action_salve -> {
////                        save()
//                        Log.i("Renan",menuItem.title.toString())
//                    }

                    R.id.action_setting -> {
                        menuItem.isCheckable = !menuItem.isCheckable
                        Log.i("Renan",menuItem.title.toString())
                        Log.i("Renan","Configuração")
                    }
                }

                return true
            }

        },viewLifecycleOwner,Lifecycle.State.RESUMED) // dizendo que e o dono, respeitando o clico de vida
    }

    private fun setupMenuToolbar() {
        binding.toolbar.inflateMenu(R.menu.menu_home)
        binding.toolbar.title = "Renan"
        binding.toolbar.subtitle ="Programador Android"
        binding.toolbar.setTitleTextColor(ContextCompat.getColor(requireContext(),R.color.white))
        binding.toolbar.setSubtitleTextColor(ContextCompat.getColor(requireContext(),R.color.white))
 //       binding.toolbar.menu.clear() // limpar o menu do fragement
        binding.toolbar.setOnMenuItemClickListener { menu ->

           when(menu.itemId) {
               R.id.action_setting ->{
                   Log.i("Renan","Configuração setupMenuToolbar")
                   menu.isCheckable = !menu.isCheckable
                   true
               }
               else -> false
           }
        }
    }
}