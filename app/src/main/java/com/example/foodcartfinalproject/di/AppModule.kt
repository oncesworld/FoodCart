package com.example.foodcartfinalproject.di

import com.example.foodcartfinalproject.data.datasource.FoodsDataSource
import com.example.foodcartfinalproject.data.repo.FoodsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
        fun provideFoodsRepository(fds:FoodsDataSource) : FoodsRepository{
        return FoodsRepository(fds)
    }

    @Provides
    @Singleton
    fun provideFoodsDataSource() : FoodsDataSource{
        return FoodsDataSource()
    }

}