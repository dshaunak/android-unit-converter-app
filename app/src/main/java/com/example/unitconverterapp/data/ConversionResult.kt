package com.example.unitconverterapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "conversion_table")
data class ConversionResult(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_column")
    val id: Int,
    @ColumnInfo(name = "input_column")
    val input : String,
    @ColumnInfo(name = "result_column")
    val result : String
)
