package tads.eaj.ufrn.segundaprova.ui.cadastra

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import tads.eaj.ufrn.segundaprova.SegundaProvaApplication
import tads.eaj.ufrn.segundaprova.R
import tads.eaj.ufrn.segundaprova.databinding.FragmentCadastraBinding
import tads.eaj.ufrn.segundaprova.ui.dialog.AjudaDialogFragment
import tads.eaj.ufrn.segundaprova.util.hideSoftKeyboard

class CadastraFragment : Fragment() {

    lateinit var viewModel: CadastraFragmentViewModel
    lateinit var binding: FragmentCadastraBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cadastra, container, false)
        val viewModelFactory = CadastraFragmentViewModel.Factory((requireActivity().application as SegundaProvaApplication).pessoaRepository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(CadastraFragmentViewModel::class.java)
        binding.viewModel = viewModel

        binding.lifecycleOwner = this

        setHasOptionsMenu(true)

        viewModel.eventCadastroPessoa.observe(viewLifecycleOwner, { hasChanged ->
            if (hasChanged){
                Navigation.findNavController(requireView()).navigate(CadastraFragmentDirections.actionCadastraFragmentToHomeFragment())
                hideSoftKeyboard(requireActivity())
                viewModel.onCadastroPessoaComplete()
            }
        })

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.ajuda){
            val dialog = AjudaDialogFragment(R.layout.ajuda_cadastra)
            dialog.show(requireActivity().supportFragmentManager, "CadastraFragment")
        }
        return super.onOptionsItemSelected(item)
    }
}