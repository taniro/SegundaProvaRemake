package tads.eaj.ufrn.segundaprova

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import tads.eaj.ufrn.segundaprova.databinding.FragmentDetalhesBinding

class DetalhesFragment : Fragment() {

    lateinit var viewModel:DetalhesFragmentViewModel
    lateinit var binding:FragmentDetalhesBinding

    val args: DetalhesFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detalhes, container, false)
        val viewModelFactory = DetalhesFragmentViewModel.DetalhesFragmentViewModelFactory(args.id, requireActivity().application)
        viewModel = ViewModelProvider(this, viewModelFactory ).get(DetalhesFragmentViewModel::class.java)

        binding.viewModel = viewModel

        binding.lifecycleOwner = this

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.ajuda){
            val dialog = AjudaDialogFragment(R.layout.ajuda_detalhes)
            dialog.show(requireActivity().supportFragmentManager, "DetalhesFragment")
        }
        return super.onOptionsItemSelected(item)
    }
}