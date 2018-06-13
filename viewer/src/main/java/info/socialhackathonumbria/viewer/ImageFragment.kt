package info.socialhackathonumbria.viewer

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


private const val ARG_INDEX = "index"

class ImageFragment : Fragment() {
    private var index: Int? = null

    private var listener: OnImageFragmentListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            index = it.getInt(ARG_INDEX)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_image, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnImageFragmentListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnImageFragmentListener {
        fun onImageShow(index: Int)
    }

    companion object {
        @JvmStatic
        fun newInstance(index: Int) =
                ImageFragment().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_INDEX, index)
                    }
                }

    }
}
