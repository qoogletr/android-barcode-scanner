import android.app.Application
import com.example.barcodescanner.settings.SettingsManager

class BarcodeApp : Application() {
    override fun onCreate() {
        super.onCreate()
        SettingsManager.init(this)
    }
}