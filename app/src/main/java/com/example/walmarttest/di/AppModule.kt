package com.example.walmarttest.di

import com.example.walmarttest.data.api.ApiService
import com.example.walmarttest.data.repository.CountryRepositoryImpl
import com.example.walmarttest.domain.repository.CountryRespository
import com.example.walmarttest.domain.usecase.CountryUsecase
import com.example.walmarttest.domain.usecase.GetCountries
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(ApiService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService{
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideCountryRepository(apiService: ApiService): CountryRespository{
        return CountryRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideCountryUsecase(countryRespository: CountryRespository): CountryUsecase{
        return CountryUsecase(
            getCountries = GetCountries(countryRespository)
        )
    }
}