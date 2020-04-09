package br.com.rteodoro.testerulesandroid.regras

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.core.net.toUri
import br.com.rteodoro.testerulesandroid.database.DatabaseDAO
import org.json.JSONArray
import org.json.JSONObject
import java.io.File
import java.lang.Exception
import java.lang.reflect.Modifier
import java.nio.charset.Charset
import java.util.*
import kotlin.jvm.functions.FunctionN
import kotlin.reflect.KFunction
import kotlin.reflect.jvm.javaMethod
import kotlin.reflect.jvm.kotlinFunction

class BRules {

    companion object {
        val TAG = BRules::class.java.simpleName
    }

    private var fact: JSONObject
    private var rules: JSONObject
    private var context : Context
    private var dirRegras : String

    constructor(fact: JSONObject, rules: JSONObject, context: Context, dirRegras : String) {
        this.fact = fact
        this.rules = rules
        this.context = context
        this.dirRegras = dirRegras
    }

    fun calculateTotalPrice(fact: JSONObject): JSONObject

    {
        Log.d(TAG, "calculateTotalPrice")
        var totalPrice = 0.0
        if (fact.has("totalPrice")) {
            totalPrice = fact.getDouble("totalPrice")
        }
        var totalDiscount = 0.0
        if (fact["pgtoType"] == 1) {
            totalDiscount = (totalPrice * 0.10)
        }
        fact.put("totalDiscount", totalDiscount.toFloat())
        totalPrice = (totalPrice - totalDiscount)
        fact.put("totalPrice", totalPrice.toFloat())

        return fact
    }

    fun calculateItemPrice(fact: JSONObject): JSONObject {
        Log.d(TAG, "calculateItemPrice")
        var valorTotal = 0.0
        val items = fact.getJSONArray("items")
        val databaseDAO = DatabaseDAO(this.context , null)
        for (i in 0 until items.length()) {
            var item = items.getJSONObject(i)
            val codigo = item["codigo"]
            var query = "SELECT produto, pf0 as preco FROM produto WHERE id=${codigo}"
            Log.d(TAG, query)
            var result = databaseDAO.query(query)
            Log.d(TAG, result.toString())
            val row = result[0] as JSONObject
            val preco = row.getDouble("preco").toFloat()
            item.put("valorUnitario", preco)
            val quantidade = item["quantidade"] as Int
            val valor = preco * quantidade
            item.put("valor", valor)
            val nome = row.getString("produto")
            item.put("nome", nome)
            valorTotal += valor
        }
        val totalItems = valorTotal.toFloat()
        fact.put("totalItems", totalItems)
        fact.put("totalPrice", totalItems)
        return fact
    }

    /**
     * Calcula os campos do pedido
     * @return
     */
    fun calcular(): JSONObject {

        try {
            var funcoes = rules.getJSONArray("rules") as JSONArray
            for (i in 0 until funcoes.length()) {
                val item = funcoes.getJSONObject(i)
                val condicao = item.getString("when")
                val funcao = item.getString("then")
                Log.d(TAG, "Condição: $condicao e Função $funcao")
                if (condicao == "always") {
                    val javaMethod = this::class.java.methods.find { it.name == funcao }
                    val kFunction = javaMethod?.kotlinFunction
                    if (kFunction != null) {
                        Log.d(TAG, "Tem ${funcao}")
                        this.fact = kFunction?.call(this, this.fact) as JSONObject
                    } else {
                        Log.w(TAG, "${funcao} ignorada, não existe na classe!")
                    }
                }
            }

        } catch (e: Exception) {
            Log.e(TAG, e.message)
        }
        return this.fact
    }

}