package com.example.unitconverterapp.data

import kotlinx.coroutines.flow.Flow

class ConverterRepositoryImpl(private val dao : ConversionResultDAO) : ConverterRepository {
    override suspend fun insertResult(result: ConversionResult) {
        dao.insert(result)
    }

    override suspend fun deleteResult(result: ConversionResult) {
        dao.deleteConversion(result)
    }

    override suspend fun deleteAllResults() {
        dao.deleteAll()
    }

    override fun getSavedResults(): Flow<List<ConversionResult>> {
        return dao.getAll()
    }
}