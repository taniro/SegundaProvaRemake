package tads.eaj.ufrn.segundaprova

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import tads.eaj.ufrn.segundaprova.databinding.FragmentAlteraBinding

class AlteraFragment : Fragment() {

    lateinit var viewModel:AlteraFragmentViewModel
    lateinit var binding:FragmentAlteraBinding

    val args: AlteraFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View {

        val viewModelFactory = AlteraFragmentViewModel.AlteraFragmentViewModelFactory(args.id, requireActivity().application)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_altera, container, false)
        viewModel = ViewModelProvider(this, viewModelFactory).get(AlteraFragmentViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        setHasOptionsMenu(true)

        binding.alteraButton.setOnClickListener {
            viewModel.alteraPessoa()
            Navigation.findNavController(it).navigate(AlteraFragmentDirections.actionAlteraFragmentToHomeFragment())
        }


        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.ajuda){
            val dialog = AjudaDialogFragment(R.layout.ajuda_altera)
            dialog.show(requireActivity().supportFragmentManager, "AlteraFragment")
        }
        return super.onOptionsItemSelected(item)
    }
}