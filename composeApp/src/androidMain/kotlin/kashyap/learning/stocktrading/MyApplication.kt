package kashyap.learning.stocktrading

import android.app.Application
import kashyap.learning.stocktrading.di.initKoin
import org.koin.android.ext.koin.androidContext

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@MyApplication)
        }
    }
}