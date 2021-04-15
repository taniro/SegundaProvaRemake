package tads.eaj.ufrn.segundaprova.ui.home

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import tads.eaj.ufrn.segundaprova.util.MyRecyclerViewClickListener
import tads.eaj.ufrn.segundaprova.ui.home.adapter.PessoaAdapter
import tads.eaj.ufrn.segundaprova.R
import tads.eaj.ufrn.segundaprova.databinding.FragmentHomeBinding
import tads.eaj.ufrn.segundaprova.ui.dialog.AjudaDialogFragment


class HomeFragment : Fragment() {

    lateinit var binding:FragmentHomeBinding
    lateinit var viewModel: HomeFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        viewModel = ViewModelProvider(this).get(HomeFragmentViewModel::class.java)

        val adapter = PessoaAdapter()
        binding.recyclerPessoa.adapter = adapter


        viewModel.list.observe(viewLifecycleOwner, Observer {
            //adapter.list = it
            //adapter.notifyDataSetChanged()
            adapter.submitList(it)
        })

        binding.recyclerPessoa.addOnItemTouchListener(MyRecyclerViewClickListener(binding.recyclerPessoa, object :
            MyRecyclerViewClickListener.OnItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                Navigation.findNavController(view).navigate(HomeFragmentDirections.actionHomeFragmentToDetalhesFragment(adapter.currentList[position].id))
            }

            override fun onItemLongClick(view: View, position: Int) {
                Navigation.findNavController(view).navigate(HomeFragmentDirections.actionHomeFragmentToAlteraFragment(adapter.currentList[position].id))
            }

        }))

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.ajuda){
            val dialog = AjudaDialogFragment(R.layout.ajuda_home)
            dialog.show(requireActivity().supportFragmentManager, "HomeFragment")
        }
        return super.onOptionsItemSelected(item)
    }
}