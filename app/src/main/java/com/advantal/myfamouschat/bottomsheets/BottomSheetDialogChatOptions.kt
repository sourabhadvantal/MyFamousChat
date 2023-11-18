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
import com.advantal.myfamouschat.databinding.BottomSheetChatOptionsBinding

import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * Bottom sheet dialog chat options
 *
 * @property bot_type
 * @constructor Create empty Bottom sheet dialog chat options
 */
class BottomSheetDialogChatOptions : BottomSheetDialogFragment() {
    private var onCompleteListener: OnCompleteListener? = null
    private var mgr: InputMethodManager? = null
    private var _binding: BottomSheetChatOptionsBinding? = null
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
        _binding = BottomSheetChatOptionsBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
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
        binding.liWallpaperChat.setOnClickListener {
            dismiss()
            onCompleteListener!!.OnOptionTap(2)
        }
        binding.liMedia.setOnClickListener {
            dismiss()
            onCompleteListener!!.OnOptionTap(3)
        }
        binding.liBlock.setOnClickListener {
            dismiss()
            onCompleteListener!!.OnOptionTap(4)
        }
        binding.liClearChat.setOnClickListener {

            onCompleteListener!!.OnOptionTap(5)
            dismiss()
        }

        binding.cdCancel.setOnClickListener {
            dismiss()
//          requireActivity().onBackPressed()
        }


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
         * On shareto person
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