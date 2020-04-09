package br.com.rteodoro.testerulesandroid.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

open class DatabaseBasic(
    context: Context,
    factory: SQLiteDatabase.CursorFactory?
) :
    SQLiteOpenHelper(
        context, "bancoRules.db",
        factory, 1
    ) {

    companion object {
        private val TAG = DatabaseBasic::class.java.simpleName
    }

    override fun onCreate(db: SQLiteDatabase) {
        var query : String
        query =
            ("""
                CREATE TABLE produto (
                	id	integer NOT NULL,
                	substancia	text,
                	cnpj	text,
                	laboratorio	integer,
                	codigoggrem	text,
                	registro	text,
                	ean1	text,
                	ean2	text,
                	ean3	text,
                	produto	text,
                	apresentacao	text,
                	classeterapeutica	integer,
                	tipodeproduto	integer,
                	regimedepreco	integer,
                	pfsemimpostos	text,
                	pf0	real,
                	pf12	real,
                	pf17	real,
                	pf17alc	real,
                	pf17_5	real,
                	pf17_5alc	real,
                	pf18	real,
                	pf18alc	real,
                	pf20	real,
                	pmc0	real,
                	pmc12	real,
                	pmc17	real,
                	pmc17alc	real,
                	pmc17_5	real,
                	pmc17_5alc	real,
                	pmc18	real,
                	pmc18alc	real,
                	pmc20	real,
                	restricaohospitalar	text,
                	cap	text,
                	confaz87	text,
                	icms0	text,
                	analiserecursal	text,
                	listadeconcessaodecreditotributario	text,
                	comercializacao2018	text,
                	tarja	integer,
                	PRIMARY KEY(id)
                );
            """.trimIndent())
        db.execSQL(query)

        val registros = arrayListOf(
            """INSERT INTO "main"."produto" ("id", "substancia", "cnpj", "laboratorio", "codigoggrem", "registro", "ean1", "ean2", "ean3", "produto", "apresentacao", "classeterapeutica", "tipodeproduto", "regimedepreco", "pfsemimpostos", "pf0", "pf12", "pf17", "pf17alc", "pf17_5", "pf17_5alc", "pf18", "pf18alc", "pf20", "pmc0", "pmc12", "pmc17", "pmc17alc", "pmc17_5", "pmc17_5alc", "pmc18", "pmc18alc", "pmc20", "restricaohospitalar", "cap", "confaz87", "icms0", "analiserecursal", "listadeconcessaodecreditotributario", "comercializacao2018", "tarja") VALUES ("1", "CEFALOTINA SÓDICA", "04.301.884/0001-75", "1", "500100106155118", "1516700060050", "7898361881450", "", "", "CEFALOTINA SÓDICA", "1G PÓ P/ SOL INJ CT 50 FA VD INC (EMB HOSP)", "1", "1", "1", "209.28", "209.28", "237.82", "252.15", "252.15", "253.67", "253.67", "255.22", "255.22", "261.6", "", "", "", "", "", "", "", "", "", "sim", "nao", "nao", "nao", "", "positiva", "sim", "1");""",
            """INSERT INTO "main"."produto" ("id", "substancia", "cnpj", "laboratorio", "codigoggrem", "registro", "ean1", "ean2", "ean3", "produto", "apresentacao", "classeterapeutica", "tipodeproduto", "regimedepreco", "pfsemimpostos", "pf0", "pf12", "pf17", "pf17alc", "pf17_5", "pf17_5alc", "pf18", "pf18alc", "pf20", "pmc0", "pmc12", "pmc17", "pmc17alc", "pmc17_5", "pmc17_5alc", "pmc18", "pmc18alc", "pmc20", "restricaohospitalar", "cap", "confaz87", "icms0", "analiserecursal", "listadeconcessaodecreditotributario", "comercializacao2018", "tarja") VALUES ("2", "CEFAZOLINA SÓDICA", "04.301.884/0001-75", "1", "500100204157115", "1516700030038", "7898361881405", "", "", "CEFAZOLINA SÓDICA", "1 G PÓ P/ SOL INJ CT 50 FA VD INC (EMB HOSP)", "1", "1", "1", "413.28", "413.28", "469.64", "497.93", "497.93", "500.95", "500.95", "504.0", "504.0", "516.6", "", "", "", "", "", "", "", "", "", "sim", "nao", "nao", "nao", "", "positiva", "sim", "1");""",
            """INSERT INTO "main"."produto" ("id", "substancia", "cnpj", "laboratorio", "codigoggrem", "registro", "ean1", "ean2", "ean3", "produto", "apresentacao", "classeterapeutica", "tipodeproduto", "regimedepreco", "pfsemimpostos", "pf0", "pf12", "pf17", "pf17alc", "pf17_5", "pf17_5alc", "pf18", "pf18alc", "pf20", "pmc0", "pmc12", "pmc17", "pmc17alc", "pmc17_5", "pmc17_5alc", "pmc18", "pmc18alc", "pmc20", "restricaohospitalar", "cap", "confaz87", "icms0", "analiserecursal", "listadeconcessaodecreditotributario", "comercializacao2018", "tarja") VALUES ("3", "CEFOTAXIMA SÓDICA", "04.301.884/0001-75", "1", "500100310151117", "1516700050063", "7898361881412", "", "", "CEFOTAXIMA SÓDICA", "1 G PÓ P/ SOL INJ CT 50 FA VD INC (EMB HOSP)", "1", "1", "1", "1529.87", "1529.87", "1738.48", "1843.21", "1843.21", "1854.38", "1854.38", "1865.69", "1865.69", "1912.33", "", "", "", "", "", "", "", "", "", "sim", "nao", "nao", "nao", "", "positiva", "sim", "1");""",
            """INSERT INTO "main"."produto" ("id", "substancia", "cnpj", "laboratorio", "codigoggrem", "registro", "ean1", "ean2", "ean3", "produto", "apresentacao", "classeterapeutica", "tipodeproduto", "regimedepreco", "pfsemimpostos", "pf0", "pf12", "pf17", "pf17alc", "pf17_5", "pf17_5alc", "pf18", "pf18alc", "pf20", "pmc0", "pmc12", "pmc17", "pmc17alc", "pmc17_5", "pmc17_5alc", "pmc18", "pmc18alc", "pmc20", "restricaohospitalar", "cap", "confaz87", "icms0", "analiserecursal", "listadeconcessaodecreditotributario", "comercializacao2018", "tarja") VALUES ("4", "CLORIDRATO DE CIPROFLOXACINO MONOIDRATADO", "04.301.884/0001-75", "1", "500100410113111", "1516700070099", "7898361881313", "", "", "CLORIDRATO DE CIPROFLOXACINO", "500 MG COM REV CT 2 BL AL PLAS INC X 07", "2", "1", "1", "21.9", "21.9", "24.89", "26.39", "26.39", "26.55", "26.55", "26.71", "26.71", "27.38", "30.28", "34.41", "36.48", "36.48", "36.7", "36.7", "36.93", "36.93", "37.85", "não", "nao", "sim", "nao", "", "positiva", "sim", "1");""",
            """INSERT INTO "main"."produto" ("id", "substancia", "cnpj", "laboratorio", "codigoggrem", "registro", "ean1", "ean2", "ean3", "produto", "apresentacao", "classeterapeutica", "tipodeproduto", "regimedepreco", "pfsemimpostos", "pf0", "pf12", "pf17", "pf17alc", "pf17_5", "pf17_5alc", "pf18", "pf18alc", "pf20", "pmc0", "pmc12", "pmc17", "pmc17alc", "pmc17_5", "pmc17_5alc", "pmc18", "pmc18alc", "pmc20", "restricaohospitalar", "cap", "confaz87", "icms0", "analiserecursal", "listadeconcessaodecreditotributario", "comercializacao2018", "tarja") VALUES ("5", "CEFALEXINA", "04.301.884/0001-75", "1", "500100801112111", "1516700080035", "7898361880019", "", "", "CEFALEXINA", "500 MG COM REV CT BL AL PVC/PVDC INC X 8", "3", "1", "1", "9.94", "9.94", "11.29", "11.97", "11.97", "12.05", "12.05", "12.12", "12.12", "12.42", "13.74", "15.61", "16.55", "16.55", "16.66", "16.66", "16.76", "16.76", "17.17", "não", "nao", "nao", "nao", "", "positiva", "sim", "1");""",
            """INSERT INTO "main"."produto" ("id", "substancia", "cnpj", "laboratorio", "codigoggrem", "registro", "ean1", "ean2", "ean3", "produto", "apresentacao", "classeterapeutica", "tipodeproduto", "regimedepreco", "pfsemimpostos", "pf0", "pf12", "pf17", "pf17alc", "pf17_5", "pf17_5alc", "pf18", "pf18alc", "pf20", "pmc0", "pmc12", "pmc17", "pmc17alc", "pmc17_5", "pmc17_5alc", "pmc18", "pmc18alc", "pmc20", "restricaohospitalar", "cap", "confaz87", "icms0", "analiserecursal", "listadeconcessaodecreditotributario", "comercializacao2018", "tarja") VALUES ("6", "CEFALEXINA", "04.301.884/0001-75", "1", "500100803115118", "1516700200030", "7898361881788", "", "", "CEFALEXINA", "500 MG CAP GEL DURA CT BL AL PVC/PE/PVDC INC X 100 (EMB HOSP)", "3", "1", "1", "174.09", "174.09", "197.82", "209.74", "209.74", "211.01", "211.01", "212.3", "212.3", "217.61", "", "", "", "", "", "", "", "", "", "sim", "nao", "nao", "nao", "", "positiva", "sim", "1");""",
            """INSERT INTO "main"."produto" ("id", "substancia", "cnpj", "laboratorio", "codigoggrem", "registro", "ean1", "ean2", "ean3", "produto", "apresentacao", "classeterapeutica", "tipodeproduto", "regimedepreco", "pfsemimpostos", "pf0", "pf12", "pf17", "pf17alc", "pf17_5", "pf17_5alc", "pf18", "pf18alc", "pf20", "pmc0", "pmc12", "pmc17", "pmc17alc", "pmc17_5", "pmc17_5alc", "pmc18", "pmc18alc", "pmc20", "restricaohospitalar", "cap", "confaz87", "icms0", "analiserecursal", "listadeconcessaodecreditotributario", "comercializacao2018", "tarja") VALUES ("7", "CEFALEXINA", "04.301.884/0001-75", "1", "500100805118114", "1516700200022", "7898361881764", "", "", "CEFALEXINA", "500 MG CAP GEL DURA CT BL AL PVC/PE/PVDC INC X 8", "3", "1", "1", "9.94", "9.94", "11.29", "11.97", "11.97", "12.05", "12.05", "12.12", "12.12", "12.42", "13.74", "15.61", "16.55", "16.55", "16.66", "16.66", "16.76", "16.76", "17.17", "não", "nao", "nao", "nao", "", "positiva", "não", "1");""",
            """INSERT INTO "main"."produto" ("id", "substancia", "cnpj", "laboratorio", "codigoggrem", "registro", "ean1", "ean2", "ean3", "produto", "apresentacao", "classeterapeutica", "tipodeproduto", "regimedepreco", "pfsemimpostos", "pf0", "pf12", "pf17", "pf17alc", "pf17_5", "pf17_5alc", "pf18", "pf18alc", "pf20", "pmc0", "pmc12", "pmc17", "pmc17alc", "pmc17_5", "pmc17_5alc", "pmc18", "pmc18alc", "pmc20", "restricaohospitalar", "cap", "confaz87", "icms0", "analiserecursal", "listadeconcessaodecreditotributario", "comercializacao2018", "tarja") VALUES ("8", "CEFTAZIDIMA", "04.301.884/0001-75", "1", "500100902156114", "1516700100036", "7898361881375", "", "", "CEFTAZIDIMA", "1 G PO P/ SOL INJ CT 50 FA VD INC", "1", "1", "1", "1207.44", "1207.44", "1372.09", "1454.75", "1454.75", "1463.57", "1463.57", "1472.49", "1472.49", "1509.3", "", "", "", "", "", "", "", "", "", "sim", "nao", "nao", "nao", "", "positiva", "sim", "1");""",
            """INSERT INTO "main"."produto" ("id", "substancia", "cnpj", "laboratorio", "codigoggrem", "registro", "ean1", "ean2", "ean3", "produto", "apresentacao", "classeterapeutica", "tipodeproduto", "regimedepreco", "pfsemimpostos", "pf0", "pf12", "pf17", "pf17alc", "pf17_5", "pf17_5alc", "pf18", "pf18alc", "pf20", "pmc0", "pmc12", "pmc17", "pmc17alc", "pmc17_5", "pmc17_5alc", "pmc18", "pmc18alc", "pmc20", "restricaohospitalar", "cap", "confaz87", "icms0", "analiserecursal", "listadeconcessaodecreditotributario", "comercializacao2018", "tarja") VALUES ("9", "CEFUROXIMA SÓDICA", "04.301.884/0001-75", "1", "500101002159115", "1516700130016", "7898361881511", "", "", "CEFUROXIMA SÓDICA", "750 MG PÓ SOL INJ CT 25 FA VD INC", "1", "1", "1", "556.34", "556.34", "632.2", "670.29", "670.29", "674.35", "674.35", "678.46", "678.46", "695.42", "", "", "", "", "", "", "", "", "", "sim", "nao", "nao", "nao", "", "positiva", "sim", "1");""",
            """INSERT INTO "main"."produto" ("id", "substancia", "cnpj", "laboratorio", "codigoggrem", "registro", "ean1", "ean2", "ean3", "produto", "apresentacao", "classeterapeutica", "tipodeproduto", "regimedepreco", "pfsemimpostos", "pf0", "pf12", "pf17", "pf17alc", "pf17_5", "pf17_5alc", "pf18", "pf18alc", "pf20", "pmc0", "pmc12", "pmc17", "pmc17alc", "pmc17_5", "pmc17_5alc", "pmc18", "pmc18alc", "pmc20", "restricaohospitalar", "cap", "confaz87", "icms0", "analiserecursal", "listadeconcessaodecreditotributario", "comercializacao2018", "tarja") VALUES ("10", "CEFTRIAXONA SÓDICA", "04.301.884/0001-75", "1", "500101103151111", "1516700090103", "7898361881382", "", "", "CEFTRIAXONA SÓDICA", "1 G PÓ P/ SOL INJ  IV CT 50 FA VD INC (EMB HOSP)", "1", "1", "1", "1478.98", "1478.98", "1680.65", "1781.9", "1781.9", "1792.7", "1792.7", "1803.63", "1803.63", "1848.72", "", "", "", "", "", "", "", "", "", "sim", "nao", "nao", "nao", "", "positiva", "sim", "1")""")

        for (item in registros) {
            db.execSQL(item)
        }


    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS produto")
        onCreate(db)
    }

}