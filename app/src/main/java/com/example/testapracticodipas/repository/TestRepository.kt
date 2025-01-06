package com.example.testapracticodipas.repository

import com.example.testapracticodipas.TestApplication
import com.example.testapracticodipas.data.Apis
import com.example.testapracticodipas.model.GamesList
import com.example.testapracticodipas.model.Test
import com.example.testapracticodipas.room.TestDatabaseDao
import com.example.testapracticodipas.util.AppUtils
import javax.inject.Inject

class TestRepository @Inject constructor(private val api: Apis, private val dao: TestDatabaseDao) {

    suspend fun getGames(): List<GamesList>?{

        if( AppUtils.isOnline( TestApplication.getAppContext()!! ) ){
            val response = api.getGames()
            if( response.isSuccessful ){

                if ( response.body()?.results != null ){
                    dao.deleteAll()
                    dao.insertAll( response.body()?.results!!.asDomainModel() )
                }

                return response.body()?.results
            }
        }
        else{
            val response = dao.getGames().asDomainModelTG()
            if ( response != null ){
                return dao.getGames().asDomainModelTG()
            }
        }

        return null
    }

    @JvmName("toolListMethod")
    fun List<Test>.asDomainModelTG(): List<GamesList> {
        return map {
            GamesList(
                id = 0, name = it.name, slug = it.desc, background_image = it.image
            )
        }
    }

    @JvmName("groupedToolListMethod")
    fun List<GamesList>.asDomainModel(): List<Test> {
        return map {
            Test(
                id = 0, name = it.name, desc = it.slug, image = it.background_image
            )
        }
    }

}