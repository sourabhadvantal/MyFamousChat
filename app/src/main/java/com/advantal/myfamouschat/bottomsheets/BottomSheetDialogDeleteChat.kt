package com.advantal.myfamouschat.bottomsheets

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.FrameLayout
import androidx.fragment.app.DialogFragment
import com.advantal.myfamouschat.R
import com.advantal.myfamouschat.databinding.BottomSheetDeleteChatsBinding
import com.advantal.myfamouschat.utils.Helper
//import com.advantal.myfamous.R
//import com.advantal.myfamous.databinding.BottomSheetDeleteChatsBinding
//import com.advantal.myfamous.utilities.Helper
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetDialogDeleteChat : BottomSheetDialogFragment() {
    private var onCompleteListener: OnCompleteListener? = null
    private var mgr: InputMethodManager? = null
    private var _binding: BottomSheetDeleteChatsBinding? = null
    var mContext: Context? = null
    private val binding get() = _binding!!

    /**
     * On create view
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.AppBottomSheetDialogTheme)
        _binding = BottomSheetDeleteChatsBinding.inflate(inflater, container, false)

        return binding.root
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        Helper.convertStatusBarAndBottomBarWithColor(requireActivity() ,-1 ,R.color.ic_chat_list_back_color)
        setStyle(STYLE_NORMAL, R.style.BottomSheetDialogTheme)
        val dialog =
            super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        dialog.setOnShowListener { dialog ->
            val d = dialog as BottomSheetDialog
            val bottomSheet =
                d.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout?
            val verificationSheet = BottomSheetBehavior.from<FrameLayout?>(bottomSheet!!)
            verificationSheet.setState(BottomSheetBehavior.STATE_EXPANDED)
        }
        _binding?.caCancelDialog?.setOnClickListener {
            dismiss()
        }

        return dialog
    }

    /**
     * On view created
     *
     * @param view
     * @param savedInstanceState
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mgr = mContext?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

    }

    /**
     * On destroy view
     *
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /**
     * On complete listener
     *
     * @constructor Create empty On complete listener
     */
    interface OnCompleteListener {
        /**
         * On cancel tap
         *
         * @param pos
         */
        fun OnCancelTap(pos : Int)

        /**
         * On option tap
         *
         * @param pos
         */
        fun OnOptionTap(pos : Int)

    }

    /**
     * Set on complete listener
     *
     * @param onCompleteListener
     */
    fun setOnCompleteListener(onCompleteListener: OnCompleteListener) {
        this.onCompleteListener = onCompleteListener
    }

}