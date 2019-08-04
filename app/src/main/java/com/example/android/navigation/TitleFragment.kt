package com.example.android.navigation


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding


class TitleFragment : Fragment() {

    lateinit var navigationController: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        val fragmentBinding: FragmentTitleBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false);

        navigationController = findNavController()

        fragmentBinding.playButton.setOnClickListener { view ->
            //view.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)
            navigationController.navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment())
        }

        //can also do navigation this way
        /*fragmentBinding.playButton.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_gameFragment)
        )*/

        setHasOptionsMenu(true)

        return fragmentBinding.root
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!, navigationController) || super.onOptionsItemSelected(item)
    }

}
