package com.github.glomadrian.grav.generator.point

import android.content.Context
import android.graphics.PointF
import android.util.AttributeSet
import com.github.glomadrian.grav.R
import java.util.*

/**
 * @author Victor Kosenko
 *
 */
class IndentedCircularPointGenerator : CircularPointGenerator() {

    private var padding: Int = 0

    override fun configure(attributeSet: AttributeSet, context: Context) {
        super.configure(attributeSet, context)
        val attributes = context.theme.obtainStyledAttributes(
                attributeSet,
                R.styleable.IndentedCircularPointGenerator,
                0,
                0
        )
        padding = attributes.getDimensionPixelSize(
                R.styleable.IndentedCircularPointGenerator_circular_padding,
                padding
        )
        attributes.recycle()
    }

    override fun generatePoints(width: Int, height: Int): Vector<PointF> {
        val maxWidth = width - padding
        val maxHeight = height - padding
        return Vector(
                super.generatePoints(width, height).filter {
                    it.x > padding && it.y > padding && it.x < maxWidth && it.y < maxHeight
                }
        )
    }
}