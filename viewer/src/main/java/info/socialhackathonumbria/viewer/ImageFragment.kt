package info.socialhackathonumbria.viewer

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import info.socialhackathonumbria.images.setImageURL
import kotlinx.android.synthetic.main.fragment_image.view.*


private const val ARG_INDEX = "index"
private const val ARG_URLSTRING = "urlstring"

class ImageFragment : Fragment() {

    private var urlstring: String? = null
    private var index: Int? = null

    private var listener: OnImageFragmentListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        arguments?.let {
            index = it.getInt(ARG_INDEX)
            urlstring =  it.getString(ARG_URLSTRING)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_image, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.imageView.setImageURL(urlstring) {
            view.progressBar.visibility = View.GONE
        }
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser)
            index?.let { listener?.onImageShow(it) }
        //listener?.onImageShow(index)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnImageFragmentListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnImageFragmentListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.menu_image, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.action_share -> {
                listener?.onShareImageUrl(urlstring)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    interface OnImageFragmentListener {
        fun onImageShow(index: Int)
        fun onShareImageUrl(url: String?)
    }

    companion object {
        @JvmStatic
        fun newInstance(index: Int, urlstring: String?) =
                ImageFragment().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_INDEX, index)
                        putString(ARG_URLSTRING, urlstring)
                    }
                }

    }
}
