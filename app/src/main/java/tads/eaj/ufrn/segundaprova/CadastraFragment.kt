package tads.eaj.ufrn.segundaprova

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import tads.eaj.ufrn.segundaprova.databinding.FragmentCadastraBinding

class CadastraFragment : Fragment() {

    lateinit var viewModel: CadastraFragmentViewModel
    lateinit var binding: FragmentCadastraBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cadastra, container, false)
        viewModel = ViewModelProvider(this).get(CadastraFragmentViewModel::class.java)
        binding.viewModel = viewModel

        binding.lifecycleOwner = this

        setHasOptionsMenu(true)

        binding.cadastraButton.setOnClickListener {
            viewModel.cadastraPessoa()
            Navigation.findNavController(it).navigate(CadastraFragmentDirections.actionCadastraFragmentToHomeFragment())
        }

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