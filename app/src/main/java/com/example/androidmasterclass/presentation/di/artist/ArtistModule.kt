package com.example.androidmasterclass.presentation.di.artist

import com.example.androidmasterclass.domain.usecase.GetArtistsUseCase
import com.example.androidmasterclass.domain.usecase.UpdateArtistsUseCase
import com.example.androidmasterclass.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(
            getArtistsUseCase,
            updateArtistsUseCase
        )
    }

}