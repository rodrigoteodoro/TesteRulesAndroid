package br.com.rteodoro.testerulesandroid

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import br.com.rteodoro.testerulesandroid.regras.BRules
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.io.File
import java.lang.Exception
import java.util.*

class MainActivity : AppCompatActivity() {

    companion object {

        val TAG = MainActivity::class.java.simpleName

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnRegras.setOnClickListener {
            testarRegras();
        }
    }

    override fun onResume() {
        super.onResume()
        requestForPermission()
        loadFiles()
    }

    val EXTERNAL_PERMS = arrayOf<String>(
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.ACCESS_NETWORK_STATE,
        Manifest.permission.INTERNET
    )

    val EXTERNAL_REQUEST = 138;

    private fun hasPermission(perm: String): Boolean {
        return PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(this, perm)

    }

    private fun canAccessPermissions(): Boolean {
        if (!hasPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE))
            return false
        if (!hasPermission(Manifest.permission.READ_EXTERNAL_STORAGE))
            return false
        return true
    }

    private fun requestForPermission(): Boolean {
        var isPermissionOn = true
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!canAccessPermissions()) {
                isPermissionOn = false
                requestPermissions(EXTERNAL_PERMS, EXTERNAL_REQUEST)
            }
        }

        return isPermissionOn
    }

    fun getRegrasDir(): String {
        val dirP = this.getExternalFilesDir("Regras").toString()
        val dirR = File(dirP)
        if (!dirR.exists()) {
            if (dirR.mkdirs()) {
                Log.d(TAG, "Diretório $dirP criado!")
            } else {
                Log.e(TAG, "ERRO ao criar diretório $dirP")
            }
        }
        return dirP
    }

    fun loadFiles() {

        val inputStream = getResources().openRawResource(R.raw.order)
        val jsonString = Scanner(inputStream).useDelimiter("\\A").next()
        edtOrder.setText(jsonString)

    }
    fun testarRegras() {
        try {
            Log.d(TAG, "TestarRegras")
            val dirRegras = this.getRegrasDir()
            var fact = JSONObject(edtOrder.text.toString().trimIndent())
            val inputStream = getResources().openRawResource(R.raw.rules)
            val jsonString = Scanner(inputStream).useDelimiter("\\A").next()
            var rules = JSONObject(jsonString.trimIndent())
            var b = BRules(fact, rules, this.applicationContext, dirRegras)
            fact = b.calcular()
            Log.d(TAG,fact.toString(2))
            edtOrder.setText(fact.toString(2))
        } catch (e : Exception) {
            Log.e(TAG, e.message)
        }

    }
}
