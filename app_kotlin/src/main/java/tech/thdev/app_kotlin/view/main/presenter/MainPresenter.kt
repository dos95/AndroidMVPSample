package tech.thdev.app_kotlin.view.main.presenter

import android.content.Context
import tech.thdev.app_kotlin.adapter.contract.ImageAdapterContract
import tech.thdev.app_kotlin.data.ImageData

/**
 * Created by tae-hwan on 12/23/16.
 */

class MainPresenter : MainContract.Presenter {

    lateinit override var view: MainContract.View
    lateinit override var imageData: ImageData

    lateinit override var adapterModel: ImageAdapterContract.Model
    lateinit override var adapterView: ImageAdapterContract.View

    override fun loadItems(context: Context, isClear: Boolean) {
        imageData.getSampleList(context, 10).let {
            if (isClear) {
                adapterModel.clearItem()
            }

            adapterModel.addItems(it)
            adapterView.notifyAdapter()
        }
    }
}