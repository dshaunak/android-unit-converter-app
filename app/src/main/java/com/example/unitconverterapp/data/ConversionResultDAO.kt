package com.example.unitconverterapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ConversionResultDAO {

    @Insert
    suspend fun insert(conversionResult : ConversionResult)

    @Query("SELECT * FROM conversion_table")
    suspend fun getAll() : Flow<List<ConversionResult>>

    @Delete
    suspend fun deleteConversion(conversion : ConversionResult)

    @Query("DELETE FROM conversion_table")
    suspend fun deleteAll()
}