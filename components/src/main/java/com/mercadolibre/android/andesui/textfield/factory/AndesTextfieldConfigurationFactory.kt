package com.mercadolibre.android.andesui.textfield.factory

import android.content.Context
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import com.mercadolibre.android.andesui.R
import com.mercadolibre.android.andesui.color.AndesColor
import com.mercadolibre.android.andesui.textfield.state.AndesTextfieldStateInterface
import com.mercadolibre.android.andesui.typeface.getFontOrDefault

internal data class AndesTextfieldConfiguration(
        val background: Drawable?,
        val helperColor : AndesColor,
        val helperText: String? = null,
        val helperSize: Float,
        val helperTypeface: Typeface,
        val labelColor : AndesColor,
        val labelText: String? = null,
        val labelSize: Float,
        val counterColor : AndesColor,
        val counterSize: Float,
        val counterMinLength: Int?,
        val counterMaxLength: Int?,
        val placeHolderColor : AndesColor,
        val placeHolderText : String? = null,
        val placeHolderSize : Float,
        val typeface: Typeface,
        val icon: Drawable?
        )

internal object AndesTextfieldConfigurationFactory {

    fun create(context: Context, andesTextfieldAttrs: AndesTextfieldAttrs): AndesTextfieldConfiguration {
        val state = andesTextfieldAttrs.state.state

        return with(andesTextfieldAttrs) {

            AndesTextfieldConfiguration(
                    background = resolveBackground(context, state),
                    helperColor = resolveHelperTextColor(state),
                    helperText = helper,
                    helperSize = resolveHelperSize(context),
                    helperTypeface = resolveHelperTypeface(state, context),
                    labelColor = resolveLabelTextColor(state),
                    labelText = label,
                    labelSize = resolveLabelSize(context),
                    counterColor = resolveCounterTextColor(state),
                    counterSize = resolveCounterSize(context),
                    counterMinLength = counter!!.minLength,
                    counterMaxLength = counter!!.maxLength,
                    placeHolderText = placeholder,
                    placeHolderColor = resolvePlaceHolderColor(state, context),
                    placeHolderSize = resolvePlaceHolderSize(context),
                    typeface = resolveTypeface(context),
                    icon = resolveIcon(context, state)
            )
        }
    }

    private fun resolveBackground(context: Context, state: AndesTextfieldStateInterface) : Drawable? = state.backgroundColor(context)
    private fun resolveHelperTextColor(state: AndesTextfieldStateInterface): AndesColor = state.textColor()
    private fun resolveHelperSize(context: Context) : Float = context.resources.getDimension(R.dimen.andes_textfield_helper_textSize)
    private fun resolveHelperTypeface(state: AndesTextfieldStateInterface, context: Context) = state.typeFace(context)
    private fun resolveLabelTextColor(state: AndesTextfieldStateInterface) : AndesColor = state.textColor()
    private fun resolveLabelSize(context: Context) : Float = context.resources.getDimension(R.dimen.andes_textfield_label_textSize)
    private fun resolveCounterTextColor(state: AndesTextfieldStateInterface) : AndesColor = state.textColor()
    private fun resolveCounterSize(context: Context) : Float = context.resources.getDimension(R.dimen.andes_textfield_counter_textSize)
    private fun resolveTypeface(context: Context) =  context.getFontOrDefault(R.font.andes_font_regular)
    private fun resolveIcon(context: Context, state: AndesTextfieldStateInterface) : Drawable? = state.icon(context)
    private fun resolvePlaceHolderColor(state: AndesTextfieldStateInterface, context: Context) : AndesColor = state.hintColor()
    private fun resolvePlaceHolderSize(context: Context) : Float = context.resources.getDimension(R.dimen.andes_textfield_placeholder_textSize)
}
