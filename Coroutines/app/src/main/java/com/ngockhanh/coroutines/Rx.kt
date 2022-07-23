package com.ngockhanh.coroutines

import android.util.Log
import io.reactivex.rxjava3.core.Observable

class Rx {
    companion object {
        const val TAG = "MainActivity"
    }
    private fun foo() {
        var list = listOf(5, 7, 20, 80, 123, 7, 20)
//      val observable = Observable.fromArray(list)
//      val observable = Observable.fromIterable(list).skip(2) todo next 2 subscribe
//      val observable = Observable.fromIterable(list).repeat(2)
//      val observable = Observable.fromIterable(list).distinct() todo delete subscribe = subscribe
//        val observable = Observable.fromIterable(list).buffer(3)  todo merge
        val observable = Observable.range(1,10).map { it * 2 }

        observable.subscribe(
            { t ->
                Log.i(MainActivity.TAG, "onNext: $t")
            },
            { e ->
                Log.i(MainActivity.TAG, "onError")
            }
        )

    }


//    private fun foo(){
//        val array = Observable.just(5,7,20,80,123)
//
//        val observer = object : Observer<Int>{
//            override fun onSubscribe(d: Disposable) {
//                Log.i(TAG,"onSubscribe")
//            }
//            override fun onNext(t: Int) {
//                Log.i(TAG,"onNext: $t" )
//            }
//            override fun onError(e: Throwable) {
//                Log.i(TAG,"onError")
//            }
//            override fun onComplete() {
//                Log.i(TAG, "onComplete")
//            }
//        }
//        array.subscribe(observer)
//    }

//    private fun foo() {
//        var sad = 5
//        sad = 7
//        sad = 20
//        sad = 80
//        sad = 123
//
//        Log.d(TAG,sad.toString())
//    }
}