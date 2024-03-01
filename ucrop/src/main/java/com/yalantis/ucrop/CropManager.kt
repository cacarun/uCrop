package com.yalantis.ucrop

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.activity.result.ActivityResultLauncher
import com.yalantis.ucrop.util.dp2px
import java.io.File

/**
 * 裁剪功能的入口封装类
 *
 *         val options = UCrop.Options()
 *         //设置toolbar颜色
 *         options.setToolbarColor(ActivityCompat.getColor(context, R.color.ucrop_color_black))
 *         //设置状态栏颜色
 *         options.setStatusBarColor(ActivityCompat.getColor(context, R.color.ucrop_color_black))
 *         //设置标题
 *         options.setToolbarTitle("Edit")
 *
 *         //设置裁剪图片可操作的手势
 *         options.setAllowedGestures(UCropActivity.SCALE, UCropActivity.NONE, UCropActivity.NONE)
 *         //设置隐藏底部容器，默认显示
 *         options.setHideBottomControls(true)
 *         //设置最大缩放比例
 *         options.setMaxScaleMultiplier(5f)
 *         //设置裁剪的图片质量，取值0-100
 *         options.setCompressionQuality(100)
 *         //设置图片在切换比例时的动画
 *         //options.setImageToCropBoundsAnimDuration(666)
 *
 *         //设置是否展示矩形裁剪框
 *         options.setShowCropFrame(true)
 *         //设置是否展示圆形遮罩
 *         options.setCircleDimmedLayer(false)
 *         //遮罩的描边颜色
 *         options.setDimmedLayerStrokeColor(Color.WHITE)
 *         //遮罩的描边宽度
 *         options.setDimmedLayerStrokeWidth(dp2px(1f, context))
 *
 *         //设置自由控制裁剪框（裁剪框可以移动缩小放大）
 *         //options.setFreeStyleCropEnabled(false)
 *
 *         //设置是否显示裁剪网格
 *         options.setShowCropGrid(false)
 *         //设置竖线的数量
 *         //options.setCropGridColumnCount(2)
 *         //设置横线的数量
 *         //options.setCropGridRowCount(2)
 *         //设置裁剪框的宽度
 *         //options.setCropFrameStrokeWidth(2)
 *         //设置裁剪框横竖线的宽度
 *         //options.setCropGridStrokeWidth(1)
 *         //设置裁剪框横竖线的颜色
 *         //options.setCropGridColor(Color.GREEN)
 *         //遮罩背景色
 *         //options.setDimmedLayerColor(Color.GRAY)
 *
 *         UCrop.of(fromUri, destinationUri)
 *             .withAspectRatio(1f, 1f) // 设置裁剪框的宽高比例
 *             .withMaxResultSize(1000, 1000)
 *             .withOptions(options)
 *             .start(context, cropActivityResultLauncher)
 */
object CropManager {

    /**
     * 圆形裁剪框
     */
    fun startCircleCrop(
        context: Context,
        fromUri: Uri,
        destinationFilePath: String,
        cropActivityResultLauncher: ActivityResultLauncher<Intent>
    ) {
        val destinationUri = Uri.fromFile(File(destinationFilePath))

        val options = UCrop.Options().apply {
            setToolbarTitle("Edit Avatar")
            setHideBottomControls(true)
            setShowCropFrame(false)
            setCircleDimmedLayer(true)
            setDimmedLayerStrokeColor(Color.WHITE)
            setDimmedLayerStrokeWidth(dp2px(1f, context))
            setShowCropGrid(false)
            setCompressionQuality(100)
        }

        UCrop.of(fromUri, destinationUri)
            .withAspectRatio(1f, 1f)
            .withMaxResultSize(1000, 1000)
            .withOptions(options)
            .start(context, cropActivityResultLauncher)
    }

    /**
     * 圆形裁剪框 -带边距
     */
    fun startCircleCropWithHorizontalPadding(
        context: Context,
        fromUri: Uri,
        destinationFilePath: String,
        cropActivityResultLauncher: ActivityResultLauncher<Intent>
    ) {
        val destinationUri = Uri.fromFile(File(destinationFilePath))

        val options = UCrop.Options().apply {
            setToolbarTitle("Edit Avatar")
            setHideBottomControls(true)
            setShowCropFrame(false)
            setCircleDimmedLayer(true)
            setDimmedLayerStrokeColor(Color.WHITE)
            setDimmedLayerStrokeWidth(dp2px(1f, context))
            setShowCropGrid(false)
            setCompressionQuality(100)
            setHorizontalPadding(dp2px(100f, context))
        }

        UCrop.of(fromUri, destinationUri)
            .withAspectRatio(1f, 1f)
            .withMaxResultSize(1000, 1000)
            .withOptions(options)
            .start(context, cropActivityResultLauncher)
    }

    /**
     * 矩形裁剪框
     */
    fun startRectCrop(
        context: Context,
        fromUri: Uri,
        destinationFilePath: String,
        cropActivityResultLauncher: ActivityResultLauncher<Intent>
    ) {
        val destinationUri = Uri.fromFile(File(destinationFilePath))

        val options = UCrop.Options().apply {
            setToolbarTitle("Edit Avatar")
            setHideBottomControls(true)
            setShowCropFrame(true)
            setCropFrameColor(Color.WHITE)
            setCropFrameStrokeWidth(dp2px(1f, context))
            setShowCropGrid(false)
            setCompressionQuality(100)
        }

        UCrop.of(fromUri, destinationUri)
            .withAspectRatio(1f, 1f)
            .withMaxResultSize(1000, 1000)
            .withOptions(options)
            .start(context, cropActivityResultLauncher)
    }

    /**
     * 矩形裁剪框 -有网格线
     */
    fun startRectGridCrop(
        context: Context,
        fromUri: Uri,
        destinationFilePath: String,
        cropActivityResultLauncher: ActivityResultLauncher<Intent>
    ) {
        val destinationUri = Uri.fromFile(File(destinationFilePath))

        val options = UCrop.Options().apply {
            setToolbarTitle("Edit Avatar")
            setHideBottomControls(true)
            setShowCropFrame(true)
            setCropFrameColor(Color.WHITE)
            setCropFrameStrokeWidth(dp2px(1f, context))
            setShowCropGrid(true)
            //setCropGridColumnCount(2)
            //setCropGridRowCount(2)
            //设置裁剪框横竖线的宽度
            //setCropGridStrokeWidth(1)
            //设置裁剪框横竖线的颜色
            //setCropGridColor(Color.GREEN)
            setCompressionQuality(100)
        }

        UCrop.of(fromUri, destinationUri)
            .withAspectRatio(1f, 1f)
            .withMaxResultSize(1000, 1000)
            .withOptions(options)
            .start(context, cropActivityResultLauncher)
    }

    /**
     * 矩形裁剪框 -带边距
     */
    fun startRectCropWithHorizontalPadding(
        context: Context,
        fromUri: Uri,
        destinationFilePath: String,
        cropActivityResultLauncher: ActivityResultLauncher<Intent>
    ) {
        val destinationUri = Uri.fromFile(File(destinationFilePath))

        val options = UCrop.Options().apply {
            setToolbarTitle("Edit Avatar")
            setHideBottomControls(true)
            setShowCropFrame(true)
            setCropFrameColor(Color.WHITE)
            setCropFrameStrokeWidth(dp2px(1f, context))
            setShowCropGrid(false)
            setCompressionQuality(100)
            setHorizontalPadding(dp2px(100f, context))
        }

        UCrop.of(fromUri, destinationUri)
            .withAspectRatio(1f, 1f)
            .withMaxResultSize(1000, 1000)
            .withOptions(options)
            .start(context, cropActivityResultLauncher)
    }

    /**
     * 圆形裁剪框 -自由模式（裁剪框也支持放大、缩小、移动）
     */
    fun startFreeStyleCircleCrop(
        context: Context,
        fromUri: Uri,
        destinationFilePath: String,
        cropActivityResultLauncher: ActivityResultLauncher<Intent>
    ) {
        val destinationUri = Uri.fromFile(File(destinationFilePath))

        val options = UCrop.Options().apply {
            setToolbarTitle("Edit Avatar")
            setHideBottomControls(true)
            setShowCropFrame(false)
            setCircleDimmedLayer(true)
            setDimmedLayerStrokeColor(Color.WHITE)
            setDimmedLayerStrokeWidth(dp2px(1f, context))
            setShowCropGrid(false)
            setCompressionQuality(100)
            setFreeStyleCropEnabled(true)
        }

        UCrop.of(fromUri, destinationUri)
            .withAspectRatio(1f, 1f)
            .withMaxResultSize(1000, 1000)
            .withOptions(options)
            .start(context, cropActivityResultLauncher)
    }

    /**
     * 矩形裁剪框 -自由模式（裁剪框也支持放大、缩小、移动）
     */
    fun startFreeStyleRectCrop(
        context: Context,
        fromUri: Uri,
        destinationFilePath: String,
        cropActivityResultLauncher: ActivityResultLauncher<Intent>
    ) {
        val destinationUri = Uri.fromFile(File(destinationFilePath))

        val options = UCrop.Options().apply {
            setToolbarTitle("Edit Avatar")
            setHideBottomControls(true)
            setShowCropFrame(true)
            setShowCropGrid(false)
            setCompressionQuality(100)
            setFreeStyleCropEnabled(true)
        }

        UCrop.of(fromUri, destinationUri)
            .withAspectRatio(1f, 1f)
            .withMaxResultSize(1000, 1000)
            .withOptions(options)
            .start(context, cropActivityResultLauncher)
    }
}