package com.example.pokedex

import android.content.Context
import com.example.pokedex.data.AppDatabase
import com.example.pokedex.data.PokemonDao
import com.example.pokedex.data.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) = AppDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun providePokemonDao(db: AppDatabase) = db.pokemonDao()

    @Singleton
    @Provides
    fun provideRepository(localDataSource: PokemonDao) = PokemonRepository(localDataSource)
}