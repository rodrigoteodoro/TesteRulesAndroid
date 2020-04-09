package br.com.rteodoro.testerulesandroid.database

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import org.json.JSONArray
import org.json.JSONObject

class DatabaseDAO(
    context: Context,
    factory: SQLiteDatabase.CursorFactory?
) : DatabaseBasic(context = context, factory = factory) {

    companion object {
        private val TAG = DatabaseDAO::class.java.simpleName
    }

    fun query(query: String): JSONArray {
        var retorno = JSONArray()
        var db: SQLiteDatabase? = null
        try {
            db = this.readableDatabase
            var cursor = db.rawQuery(query, null)
            cursor!!.moveToFirst()
            if (cursor.count > 0) {
                do {
                    Log.d(TAG, cursor.position.toString())
                    var obj = JSONObject()
                    for (col in cursor.columnNames) {
                        var tipo = cursor.getType(cursor.getColumnIndex(col))
                        var valor : Any? = null
                        when (tipo) {
                            Cursor.FIELD_TYPE_STRING -> valor = cursor.getString(cursor.getColumnIndex(col))
                            Cursor.FIELD_TYPE_FLOAT -> valor = cursor.getFloat(cursor.getColumnIndex(col))
                            Cursor.FIELD_TYPE_INTEGER -> valor = cursor.getInt(cursor.getColumnIndex(col))
                            Cursor.FIELD_TYPE_NULL -> valor = null
                        }
                        obj.putOpt(col, valor)
                    }
                    retorno.put(obj)
                } while ((cursor.moveToNext()))
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            db?.close()
        }
        return retorno
    }


}